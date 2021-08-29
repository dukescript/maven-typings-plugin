package com.dukescript.libraries.proc;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import static javax.lang.model.SourceVersion.isKeyword;

/*
 * #%L
 * DukeScript Libraries Processor - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

abstract class Generator<L> {
    private Map<Identifier, Type> typeAliases;
    private Map<String,List<String>> classesAndInterfaces;

    protected abstract Writer createSourceFile(String string, L location) throws IOException;
    protected abstract L findType(String fqn);
    protected abstract void note(String message, L e);
    protected abstract void error(String message, L e);
    protected abstract void registerPackages(String... packages) throws IOException;
    /**
     * Name of global module. If non-null, the generated code will use
     * <code>Modules.find</code> to access global symbols in <code>Exports</code>.
     * @return by default returns <code>null</code>
     */
    protected String globalModuleName() {
        return null;
    }

    final Type findType(Type t) {
        if (t == null) {
            return null;
        }
        if (typeAliases != null && t.getKind() == SyntaxKind.FirstTypeNode) {
            Type alt = typeAliases.get(t.getTypeName());
            return alt == null ? t : alt;
        }
        return t;
    }

    final void generateSources(
        final String[] libraryImports,
        final String[] libraryScripts,
        String packageName,
        String libraryTypingsName,
        InputStream libraryTypings,
        L location
    ) throws IOException {
        for (int i = 0; i < libraryScripts.length; i++) {
            if (!libraryScripts[i].startsWith("/")) {
                libraryScripts[i] = "/" + packageName.replace('.', '/') + "/" + libraryScripts[i];
            }
        }

        Parser p = new Parser();
        AST root = p.parse(libraryTypingsName, libraryTypings);

        List<String> packages = new ArrayList<>();
        this.typeAliases = new HashMap<>();
        this.classesAndInterfaces = new HashMap<>();
        findTypesAndAliases(packageName, root);

        root.visitModules(new Visitor<Identifier, AST, Void, Void, Void, Void>() {
            @Override
            public void visit(Identifier a, AST body, Void c, Void d, Void e, Void f) throws IOException {
                String subPackage = packageName + "." + a.getSimpleName();
                packages.add(subPackage);
                findTypesAndAliases(subPackage, body);
            }
        });
        packages.add(packageName);
        processModule(globalModuleName(), root, libraryImports, libraryScripts, packageName, location);
        root.visitModules(new Visitor<Identifier, AST, Void, Void, Void, Void>() {
            @Override
            public void visit(Identifier a, AST body, Void c, Void d, Void e, Void f) throws IOException {
                String subPackage = packageName + "." + a.getSimpleName();

                processModule(a.getSimpleName(), body, libraryImports, libraryScripts, subPackage, location);
            }
        });
        registerPackages(packages.toArray(new String[0]));
    }

    static boolean containsComponent(Collection<String> typeVars, Type type) {
        if (type == null) {
            return false;
        }
        if (typeVars.contains(type.getRawJavaType())) {
            return true;
        }
        for (Type e : type.getElementType()) {
            if (containsComponent(typeVars, e)) {
                return true;
            }
        }
        for (Type e : type.getElementTypes()) {
            if (containsComponent(typeVars, e)) {
                return true;
            }
        }
        return false;
    }

    static boolean containsComponent(String typeVar, Type type) {
        return containsComponent(Collections.singleton(typeVar), type);
    }

    private void processModule(
        String moduleName,
        AST root,
        final String[] libraryImports,
        final String[] libraryScripts,
        String packageName,
        L location
    ) throws IOException {
        Writer typingsFile = createSourceFile(packageName + ".$Typings$", location);

        new Resolver() {
            @Override
            String resolveFQN(String typeFqn) {
                int lastDot = typeFqn.lastIndexOf('.');
                String typeStr = typeFqn.substring(lastDot + 1);

                String coreBase = "net.java.html.lib." + typeStr;
                if (findType(coreBase) != null) {
                    return coreBase;
                }
                switch (typeStr) {
                    case "String":
                    case "Number":
                    case "Boolean":
                        return "java.lang." + typeStr;
                    case "Object":
                        return "net.java.html.lib.Objs";
                }
                if (classesAndInterfaces.containsKey(typeStr)) {
                    List<String> candidates = classesAndInterfaces.get(typeStr);
                    for (String candidate : candidates) {
                        if (candidate.endsWith(typeFqn)) {
                            return candidate;
                        }
                    }
                    return candidates.get(0);
                }
                for (String pkg : libraryImports) {
                    String fullName = pkg + "." + typeStr;
                    if (findType(fullName) != null) {
                        return fullName;
                    }
                }
                return typeStr;
            }
        };

        final Typings typings = new Typings(packageName, typingsFile, libraryScripts);
        StringWriter w = new StringWriter();
        if (dumpExports(w, moduleName, packageName, typings, root)) {
            try (Writer file = createSourceFile(packageName + ".Exports", location)) {
                file.write(w.toString());
            }
        }
        class Interfaces implements Visitor<Identifier, List<AST>, List<AST>, AST, List<Heritage>, Map<String,Set<Type>>> {
            @Override
            public void visit(Identifier a, List<AST> typeParameters, List<AST> members, AST constructor, List<Heritage> heritage, Map<String,Set<Type>> callSigs) throws IOException {
                String name = a.getSimpleName();
                final String fqn = packageName + "." + mangleName(false, name);
                try {
                    generateType(fqn, name, typeParameters, heritage, constructor, a, members, callSigs);
                } catch (RuntimeException ex) {
                    ex.printStackTrace();
                    error("Cannot generate " + fqn + " " + ex.getClass().getSimpleName() + ": " + ex.getMessage(), location);
                }
            }

            private void generateType(
                final String fqn, String name,
                List<AST> typeParameters, List<Heritage> heritage,
                AST constructor, Identifier a, List<AST> members,
                Map<String,Set<Type>> globalCallSignatures
            ) throws IOException {
                L fqnElement = findType(fqn);
                if (fqnElement != null) {
                    note("Not generating " + fqn + " already exists", fqnElement);
                    return;
                }
                Writer w = createSourceFile(fqn, location);
                w.append("package ").append(packageName).append(";\n");
                w.append("public class " + mangleName(false, name));
                if (!typeParameters.isEmpty()) {
                    w.append("<");
                    String sep = "";
                    for (AST type : typeParameters) {
                        assert type.getKind() == SyntaxKind.TypeParameter : "Unexpected type: " + type;
                        w.append(sep).append(type.getName().getSimpleName());
                        sep = ", ";
                    }
                    w.append(">");
                }
                final String objs = mangleName(true, "Object");
                List<Type> typeArguments = new ArrayList<>();
                if (heritage.isEmpty()) {
                    w.append(" extends ").append(objs);
                } else {
                    String typeName = findBestSuperclass(name, heritage, typeArguments);
                    String superClass = mangleName(true, typeName);
                    w.append(" extends " + Resolver.findFQN(superClass));
                    if (!typeArguments.isEmpty()) {
                        w.append("<");
                        String sep = "";
                        for (Type type : typeArguments) {
                            w.append(sep).append(type.getBoxedJavaType());
                            sep = ", ";
                        }
                        w.append(">");
                    }

                }
                w.append(" {\n");
                Set<String> knownTypeVariales = new TreeSet<>();
                for (AST type : typeParameters) {
                    final String typeVar = type.getName().getSimpleName();
                    w.append("  private final Class<?> type_").append(typeVar).append(";\n");
                    knownTypeVariales.add(typeVar);
                }
                w.append("  protected " + name + "(" + objs + ".Constructor<?> c, java.lang.Object js) {\n");
                w.append("    super(c, js");
                for (Type arg : typeArguments) {
                    final String argRawType = arg.getBoxedJavaTypeRaw();
                    if (containsComponent(knownTypeVariales, arg)) {
                        w.append(", java.lang.Object.class");
                    } else {
                        w.append(", ").append(argRawType).append(".class");
                    }
                }
                w.append(");\n");
                for (AST type : typeParameters) {
                    w.append("    this.type_").append(type.getName().getSimpleName()).append(" = java.lang.Object.class;\n");
                }
                w.append("  }\n");
                if (!typeParameters.isEmpty()) {
                    w.append("  protected " + name + "(" + objs + ".Constructor<?> c, java.lang.Object js");
                    for (AST type : typeParameters) {
                        w.append(", Class<?> type_").append(type.getName().getSimpleName());
                    }
                    w.append(") {\n");
                    w.append("    super(c, js");
                    for (Type superArg : typeArguments) {
                        String superName = superArg.getBoxedJavaTypeRaw();
                        if (knownTypeVariales.contains(superName)) {
                            w.append(", type_").append(superName);
                        } else {
                            if (containsComponent(knownTypeVariales, superArg)) {
                                w.append(", java.lang.Object.class");
                            } else {
                                w.append(", ").append(superName).append(".class");
                            }
                        }
                    }
                    w.append(");\n");
                    for (AST type : typeParameters) {
                        w.append("    this.type_").append(type.getName().getSimpleName()).append(" = type_").append(type.getName().getSimpleName()).append(";\n");
                    }
                    w.append("  }\n");
                }
                w.append("  private static final class $Constructor extends " + objs + ".Constructor<" + name + "> {\n");
                w.append("    $Constructor() {\n");
                w.append("      super(" + name + ".class);\n");
                w.append("    }\n");
                w.append("    @Override\n");
                w.append("    public " + name + " create(java.lang.Object obj) {\n");
                w.append("      return obj == null ? null : new " + name + "(this, obj);\n");
                w.append("    }\n");
                w.append("    @Override\n");
                w.append("    public " + name + " create(java.lang.Object obj, java.lang.reflect.Type... typeParameters) {\n");
                w.append("      return obj == null ? null : new " + name + "(this, obj");
                for (int i = 0; i < typeParameters.size(); i++) {
                    w.append(", findType(typeParameters, " + i + ")");
                }
                w.append(");\n");
                w.append("    }\n");
                if (!typeParameters.isEmpty()) {
                    w.append("    private static Class<?> findType(java.lang.reflect.Type[] arr, int index) {\n");
                    w.append("      return arr == null || arr.length <= index || !(arr[index] instanceof Class<?>) ? java.lang.Object.class : (Class<?>)arr[index];\n");
                    w.append("    }\n");
                }
                w.append("  };\n");
                w.append("  private static final $Constructor $AS = new $Constructor();\n");
                w.append("  public static " + name + " $as(java.lang.Object obj) {\n");
                w.append("    return $AS.create(obj);\n");
                w.append("  }\n");
                if (!typeParameters.isEmpty()) {
                    w.append("  public static " + name + " $as(java.lang.Object obj, java.lang.reflect.Type... typeParameters) {\n");
                    w.append("    return $AS.create(obj, typeParameters);\n");
                    w.append("  }\n");
                }
                boolean isStatic = constructor != null && a == constructor.getName();
                if (isStatic) {
                    constructor = null;
                }
                Set<String> generatedFields = new TreeSet<>();
                Functions fn = isStatic ?
                    new Functions(packageName, w, typings, name) : new Functions(packageName, w, typings, true, typeParameters);
                Fields fieldGenerator = new Fields(fn, packageName, w, typings, !isStatic, name, typeParameters);
                Constructors cnstr = new Constructors(w, typings, typeParameters);
                for (AST m : members) {
                    if (
                        m.getKind() == SyntaxKind.MethodSignature ||
                        m.getKind() == SyntaxKind.MethodDeclaration
                    ) {
                        fn.visit(m.getName(), m.getType(), m.getParameters(), m.getTypeParameters(), m.getComment(), null);
                        continue;
                    }
                    if (m.getKind() == SyntaxKind.IndexSignature) {
                        Identifier getter = new Identifier(SyntaxKind.FirstTypeNode, "$get");
                        fn.visit(getter, m.getType(), m.getParameters(), m.getTypeParameters(), m.getComment(), null);
                        continue;
                    }
                    if (m.getKind() == SyntaxKind.CallSignature) {
                        Identifier getter = new Identifier(SyntaxKind.FirstTypeNode, "$apply");
                        fn.visit(getter, m.getType(), m.getParameters(), m.getTypeParameters(), null, null);
                    }
                    if (
                        m.getKind() == SyntaxKind.PropertySignature ||
                        m.getKind() == SyntaxKind.PropertyDeclaration
                    ) {
                        final String fieldName = m.getName().getSimpleName();
                        if (name.equals("Object") && fieldName.equals("constructor")) {
                            continue;
                        }
                        if (generatedFields.add(fieldName)) {
                            Set<Type> callSignatures = new HashSet<>();
                            m.getType().findCalls(globalCallSignatures, callSignatures);
                            fieldGenerator.visit(m.getName(), m.getType(), callSignatures, null, m.getComment(), null);
                        }
                        continue;
                    }
                    if (m.getKind() == SyntaxKind.Constructor) {
                        cnstr.visit(a, m.getType(), m.getParameters(), m.getTypeParameters(), m.getComment(), null);
                        continue;
                    }
                    w.append("  // " + m.getKind() + ": "  + m + "\n");
                }
                fieldGenerator.finish();
                if (constructor != null) {
                    w.append("  // constructor " + constructor.getName().getSimpleName() + "\n");
                    Functions factory = new Functions(packageName, w, typings, name);
                    Fields flds = new Fields(factory, packageName, w, typings, false, name, Collections.emptyList());
                    for (AST m : constructor.getMembers()) {
                        if (m.getKind() == SyntaxKind.MethodSignature) {
                            factory.visit(m.getName(), m.getType(), m.getParameters(), m.getTypeParameters(), m.getComment(), null);
                            continue;
                        }
                        if (m.getKind() == SyntaxKind.CallSignature) {
                            Identifier create = new Identifier(SyntaxKind.FirstTypeNode, "new" + name);
                            factory.visit(create, m.getType(), m.getParameters(), m.getTypeParameters(), m.getComment(), null);
                            continue;
                        }
                        if (m.getKind() == SyntaxKind.PropertySignature) {
                            final String fieldName = m.getName().getSimpleName();
                            if (generatedFields.add(fieldName)) {
                                flds.visit(m.getName(), m.getType(), null, null, m.getComment(), null);
                            }
                            continue;
                        }
                        NO_CONSTRUCTOR: if (m.getKind() == SyntaxKind.ConstructSignature) {
                            cnstr.visit(a, m.getType(), m.getParameters(), m.getTypeParameters(), m.getComment(), null);
                            continue;
                        }
                        w.append("  // " + m.getKind() + ": "  + m + "\n");
                    }
                }
                w.append("}\n");
                w.close();
            }

            private String findBestSuperclass(String name, List<Heritage> heritage, List<Type> typeArguments) {
                AST bestSuperType = null;
                String bestTypeName = null;
                for (AST superType : heritage.get(0).getTypes()) {
                    final String typeName = findTypeName(superType.getExpression());
                    final boolean relatedFromAnotherNamespace = typeName.endsWith('.' + name);
                    if (relatedFromAnotherNamespace || bestTypeName == null) {
                        bestTypeName = typeName;
                        bestSuperType = superType;
                        if (relatedFromAnotherNamespace) {
                            break;
                        }
                    }
                }
                typeArguments.addAll(bestSuperType.getTypeArguments());
                return bestTypeName;
            }

            private String findTypeName(final List<AST> expression) {
                AST expr = expression.get(0);
                String t = expr.getText();
                if (t == null) {
                    if (expr.getExpression().isEmpty()) {
                        return "Object";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(findTypeName(expr.getExpression()));
                    sb.append(".");
                    sb.append(expr.getName().getText());

                    return sb.toString();
                }
                return t;
            }
        }

        root.visitInterfaces(new Interfaces());
        root.visitClasses(new Interfaces());
        typings.close();
    }

    private boolean dumpExports(Writer w, 
        String moduleName, String packageName, final Typings typings, AST root
    ) throws IOException {
        w.append("package ").append(packageName).append(";\n");
        w.append("@java.lang.SuppressWarnings(\"unchecked\")\n");
        w.append("public final class Exports extends " + mangleName(true, "Object") + " {\n");
        w.append("  private Exports() {\n");
        w.append("  }\n");
        if (moduleName != null) {
            w.append("  private static net.java.html.lib.Objs selfModule() {\n");
            w.append("    return net.java.html.lib.Modules.find(\"" + moduleName + "\");\n");
            w.append("  }\n");
        }
        final Functions fn = new Functions(packageName, w, typings, false);
        fn.useModule = moduleName != null;
        root.visitFunctions(fn);
        final Fields fields = new Fields(
            fn, packageName, w, typings, false,
            moduleName != null ? "self$dukescript" : null, 
            Collections.emptyList()
        );
        fields.useModule = moduleName != null;
        root.visitFields(fields);
        fields.finish();
        w.append("}\n");
        w.close();
        return fn.count + fields.count > 0;
    }

    private void findTypesAndAliases(String packageName, AST root) {
        root.findTypeAliases(typeAliases);
        root.findClassesAndInterfaces(packageName, classesAndInterfaces);
    }

    static void typeParameters(Writer w, List<String> parameters) throws IOException {
        if (parameters.isEmpty()) {
            return;
        }
        w.append("<");
        String sep = "";
        for (String p : parameters) {
            w.append(sep);
            w.append(p);
            sep = ", ";
        }
        w.append("> ");
    }

    static boolean isTypeParameter(List<String> parameters, Type type) throws IOException {
        for (String p : parameters) {
            if (type.getKind().isTypeNode() && type.getTypeName() != null) {
                if (p.equals(type.getTypeName().getSimpleName())) {
                    return true;
                }
            }
        }
        return false;
    }

    static String mangleName(String prefix, String name) {
        if (prefix != null && name.equals("Array")) {
            return "net.java.html.lib.Array";
        }
        if (name.equals("Object")) {
            return (prefix != null ? "net.java.html.lib.Objs" : "Objs") ;
        }
        return prefix != null ? prefix + name : name;
    }

    static String mangleName(boolean fqn, String name) {
        return mangleName(fqn ? "" : null, name);
    }

    List<List<Type>> alternativeTypes(List<Parameter> parameters) {
        if (parameters.isEmpty()) {
            return Collections.nCopies(1, new ArrayList<>());
        } else {
            final int last = parameters.size() - 1;
            Parameter p = parameters.get(last);
            List<List<Type>> types = alternativeTypes(parameters.subList(0, last));
            Type type = findType(p.getType());
            List<Type> lastAlternatives = type.getUnionTypes();
            if (lastAlternatives == null) {
                for (List<Type> t : types) {
                    t.add(type);
                }
                return types;
            } else {
                List<List<Type>> res = new ArrayList<>();
                for (Type a : lastAlternatives) {
                    for (List<Type> t : types) {
                        List<Type> copy = new ArrayList<>(t);
                        copy.add(a);
                        res.add(copy);
                    }
                }
                return res;
            }
        }
    }

    static void emitComment(Writer w, String indent, String comment) throws IOException {
        if (comment != null) {
            for (String l : comment.split("\\n")) {
                w.append(indent).append(l.trim()).append("\n");
            }
        }
    }

    static List<String> merge(List<AST> thisTypeParameters, List<AST> providedParameters, List<Type> typeNames) {
        LinkedHashSet<String> all = new LinkedHashSet<>();
        if (thisTypeParameters != null) for (AST p : thisTypeParameters) {
            all.add(p.getName().getSimpleName());
        }
        if (providedParameters != null) for (AST p : providedParameters) {
            all.add(p.getName().getSimpleName());
        }
        if (typeNames != null) for (Type p : typeNames) {
            if (p.getKind() != SyntaxKind.VoidKeyword) {
                String name = p.getTypeName().getSimpleName();
                all.add(name);
            }
        }
        return new ArrayList<>(all);
    }

    static CharSequence toJSParam(Parameter parameter, List<String> typeParamNames) {
        switch (parameter.getType().getKind()) {
            case FunctionType: {
                StringBuilder sb = new StringBuilder();
                sb.append("net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(").append(parameter.getName().getSimpleName());
                boolean first = true;
                for (Parameter p : parameter.getType().getParameters()) {
                    sb.append(", ");
                    if (first) {
                        sb.append("new Class[] {");
                        first = false;
                    }
                    String rawType = p.getType().getBoxedJavaType();
                    int params = rawType.indexOf('<');
                    if (params >= 0) {
                        rawType = rawType.substring(0, params);
                    }
                    if (typeParamNames.contains(rawType) || rawType.contains("[")) {
                        sb.append("null");
                    } else {
                        sb.append(rawType).append(".class");
                    }
                }
                if (!first) {
                    sb.append("}");
                }
                sb.append("))");
                return sb.toString();
            }

            default:
                return parameter.getObjs();
        }
    }

    private static final class MethodKey {
        private final Identifier name;
        private final List<String> parameters;

        public MethodKey(Identifier name, List<Type> parameters, Type returnType) {
            this.name = name;
            List<String> types = new ArrayList<>(parameters.size());
            for (Type t : parameters) {
                if (t.getKind() == SyntaxKind.StringLiteral) {
                    types.add(returnType.getRawJavaType());
                    continue;
                }
                types.add(t.getRawJavaType());
            }
            this.parameters = types;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 79 * hash + Objects.hashCode(this.name);
            hash = 79 * hash + Objects.hashCode(this.parameters);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final MethodKey other = (MethodKey) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            if (!Objects.equals(this.parameters, other.parameters)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "MethodKey{" + "name=" + name + ", parameters=" + parameters + '}';
        }
    }
    private static final class ConstructorKey {
        private final String name;
        private final List<String> parameters;

        public ConstructorKey(String name, List<Type> parameters) {
            this.name = name;
            List<String> types = new ArrayList<>(parameters.size());
            for (Type t : parameters) {

                types.add(t.getRawJavaType());
            }
            this.parameters = types;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 79 * hash + Objects.hashCode(this.name);
            hash = 79 * hash + Objects.hashCode(this.parameters);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ConstructorKey other = (ConstructorKey) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            if (!Objects.equals(this.parameters, other.parameters)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "ConstructorKey{" + "name=" + name + ", parameters=" + parameters + '}';
        }
    }


    class Functions implements Visitor<Identifier, Type, List<Parameter>, List<AST>, String,Void> {
        private final Writer w;
        private final boolean virtual;
        private boolean useModule;
        private final String prefix;
        private final List<AST> typeParameters;
        private final Typings typings;
        private final String packageName;
        private final Set<MethodKey> generated = new HashSet<>();
        int count;

        public Functions(String pn, Writer w, Typings typings, boolean virtual, List<AST> typeParameters) {
            this.packageName = pn;
            this.w = w;
            this.typings = typings;
            this.virtual = virtual;
            this.prefix = null;
            this.typeParameters = typeParameters;
        }

        public Functions(String pn, Writer w, Typings typings, boolean virtual) {
            this(pn, w, typings, virtual, Collections.emptyList());
        }

        public Functions(String pn, Writer w, Typings typings, String staticPrefix) {
            this.packageName = pn;
            this.w = w;
            this.typings = typings;
            this.virtual = false;
            this.prefix = staticPrefix;
            this.typeParameters = Collections.emptyList();
        }

        @Override
        public void visit(Identifier a, Type returnType, List<Parameter> parameters, List<AST> typeParameters, String comment, Void ignore)
        throws IOException {
            count++;
            generateFunctions(a, returnType, parameters, typeParameters, null, comment, ignore);
        }
        public void generateFunctions(Identifier name, Type returnType, List<Parameter> parameters, List<AST> typeParameters, List<Type> typeParameterNames, String comment, Void ignore)
        throws IOException {
            if (name.getSimpleName() == null || isKeyword(name.getSimpleName())) {
                emitComment(w, "  ", comment);
                w.append("  /* cannot generate " + name.getSimpleName() + " */\n");
                return;
            }
            int firstOptional = generateFunction(parameters,typeParameters, typeParameterNames, name, returnType, comment);
            for (int i = firstOptional; i < parameters.size(); i++) {
                final List<Parameter> subParameters = parameters.subList(0, i);
                generateFunction(subParameters, typeParameters, typeParameterNames, name, returnType, comment);
            }
        }

        int generateFunction(
            List<Parameter> parameters, List<AST> typeParameters, List<Type> typeParameterNames,
            Identifier name, Type returnType, String comment
        ) throws IOException {
            if (isInObject(name.getSimpleName(), parameters)) {
                emitComment(w, "  ", comment);
                w.append("  /* cannot generate " + name.getSimpleName() + " */\n");
                return 0;
            }
            returnType = findType(returnType);
            int[] firstOptional = { 0 };
            final List<String> allTypeParams = merge(this.typeParameters, typeParameters, typeParameterNames);
            String implName = typings.generateFunction(virtual || useModule, parameters, allTypeParams,
                name, returnType, prefix, firstOptional
            );
            for (List<Type> types : alternativeTypes(parameters)) {
                final MethodKey fullMethodKey = new MethodKey(name, types, returnType);
                if (!generated.add(fullMethodKey)) {
                    w.append("  // skipping " + fullMethodKey + "\n");
                    continue;
                }
                emitComment(w, "  ", comment);
                if (virtual) {
                    w.append("  public ");
                } else {
                    w.append("  public static ");
                }
                typeParameters(w, merge(null, typeParameters, typeParameterNames));
                String javaReturn;
                String javaReturnPrefix = null;
                String javaReturnPostfix = "";
                String methodName = name.getSimpleName();
                if (methodName == null) methodName = "nullName";
                if (methodName.equals("valueOf")) {
                    javaReturn = returnType.getBoxedJavaType();
                } else {
                    javaReturn = mangleName(true, returnType.getBoxedIntoJavaType());
                    if (javaReturn.equals("java.lang.Void")) {
                        javaReturn = "void";
                    }
                    if (javaReturn.equals("java.lang.Number")) {
                        javaReturn = "double";
                        javaReturnPrefix = "((java.lang.Number)";
                        javaReturnPostfix = ").doubleValue()";
                    }
                }
                w.append(javaReturn);
                w.append(" ").append(methodName).append("(");
                String sep = "";
                for (int i = 0; i < parameters.size(); i++) {
                    Parameter p = parameters.get(i);
                    w.append(sep);
                    final Type t = types.get(i);
                    String type = t.getJavaType();
                    type = mangleName(true, type);
                    if (p.isVararg() && type.endsWith("[]")) {
                        type = type.substring(0, type.length() - 2) + "...";
                    } else if (t.getKind() == SyntaxKind.StringLiteral) {
                        type = returnType.getBoxedIntoJavaType();
                    }
                    w.append(type + " ");
                    w.append(p.getName().getSimpleName());
                    sep = ", ";
                }
                w.append(") {\n");
                boolean wrap =
                    returnType.getKind().isTypeNode() ||
                    returnType.getKind() == SyntaxKind.FunctionType ||
                    returnType.getKind() == SyntaxKind.UnionType;
                if (wrap) {
                    final String javaType = mangleName(true, returnType.getRawJavaType());
                    if (
                        javaType.equals("java.lang.Object") ||
                        isTypeParameter(allTypeParams, returnType)
                    ) {
                        if (javaReturnPrefix == null) {
                            javaReturnPrefix = "(" + javaType + ")";
                        }
                        w.append("    return ").append(javaReturnPrefix);
                        boolean isTypeParam = false;
                        if (this.typeParameters != null) {
                            for (AST p : this.typeParameters) {
                                if (javaType.equals(p.getName().getSimpleName())) {
                                    isTypeParam = true;
                                    break;
                                }
                            }
                        }
                        if (isTypeParam) {
                            w.append("net.java.html.lib.Objs.$as(type_").append(javaType).append(", ");
                            wrap = true;
                        } else {
                            wrap = false;
                        }
                    } else {
                        if (javaReturnPrefix == null) {
                            javaReturnPrefix = "(" + javaReturn + ")";
                        }
                        w.append("    return ").append(javaReturnPrefix);
                        if (returnType.getKind() == SyntaxKind.FunctionType) {
                            w.append("net.java.html.lib.Function.$as(");
                        } else if (!javaType.startsWith("java.lang.")) {
                            if (javaType.indexOf('.') == -1) {
                                w.append(packageName).append('.');
                            }
                            w.append(javaType).append(".$as(");
                        } else {
                            wrap = false;
                        }
                    }
                } else {
                    if (returnType.getKind() == SyntaxKind.VoidKeyword) {
                        w.append("    ");
                    } else if (returnType.getKind() == SyntaxKind.ArrayType) {
                        w.append("    return (").append(returnType.getBoxedIntoJavaType()).append(")");
                        w.append("net.java.html.lib.Array.$as(");
                        wrap = true;
                    } else if (returnType.getKind() == SyntaxKind.AnyKeyword) {
                        w.append("    return net.java.html.lib.Objs.$as(java.lang.Object.class, ");
                        wrap = true;
                    } else {
                        w.append("    return ");
                        if (javaReturnPrefix != null) {
                            w.append(javaReturnPrefix);
                        }
                    }
                }
                w.append("$Typings$.").append(implName);
                if (virtual) {
                    w.append("($js(this)");
                    sep = ", ";
                } else if (useModule) {
                    w.append("($js(selfModule())");
                    sep = ", ";
                } else {
                    w.append("(");
                    sep = "";
                }
                for (Parameter p : parameters) {
                    w.append(sep);
                    w.append(toJSParam(p, allTypeParams));
                    sep = ", ";
                }
                if (wrap) {
                    w.append(')');
                }
                for (Type typeArg : returnType.getTypeArguments()) {
                    String typeName = typeArg.getRawJavaType();
                    if (typeParameters != null) {
                        for (AST tp : typeParameters) {
                            if (containsComponent(tp.getName().getText(), typeArg)) {
                                typeName = null;
                                break;
                            }
                        }
                    }
                    for (String tpn : allTypeParams) {
                        if (containsComponent(tpn, typeArg)) {
                            typeName = null;
                            break;
                        }
                    }
                    if (typeName == null) {
                        w.append(", null");
                    } else {
                        w.append(", ").append(typeName).append(".class");
                    }
                }
                w.append(")").append(javaReturnPostfix).append(";\n");
                w.append("  }\n");
            }
            return firstOptional[0];
        }

        private boolean isInObject(String methodName, List<Parameter> parameters) {
            if (!parameters.isEmpty()) {
                return false;
            }
            try {
                Method method = Object.class.getMethod(methodName);
                return (method.getModifiers() & Modifier.FINAL) != 0 || (method.getReturnType().getModifiers() & Modifier.FINAL) != 0;
            } catch (NoSuchMethodException ex) {
                return false;
            }
        }
    }

    class Constructors implements Visitor<Identifier, Type, List<Parameter>, List<AST>, String, Void> {
        private final Writer w;
        private final List<AST> typeParameters;
        private final Typings typings;
        private final Set<ConstructorKey> generatedConstructors = new HashSet<>();

        public Constructors(Writer w, Typings typings, List<AST> typeParameters) {
            this.w = w;
            this.typings = typings;
            this.typeParameters = typeParameters;
        }

        @Override
        public void visit(Identifier a, Type returnType, List<Parameter> parameters, List<AST> typeParameters, String comment, Void ignore)
            throws IOException {
            int firstOptional = generateConstructor(parameters,typeParameters,  a, returnType, comment);
            for (int i = firstOptional; i < parameters.size(); i++) {
                generateConstructor(parameters.subList(0, i), typeParameters, a, returnType, comment);
            }
        }

        private int generateConstructor(
            List<Parameter> parameters, List<AST> astParameters,
            Identifier a, Type returnType, String comment
        ) throws IOException {
            List<String> mergedParams = merge(this.typeParameters, astParameters, null);
            int[] firstOptional = { 0 };
            String implName = typings.generateConstructor(parameters, firstOptional, a, mergedParams);
            String sep;
            final String functionName = a.getSimpleName();
            for (List<Type> types : alternativeTypes(parameters)) {
                final ConstructorKey fullConstructorKey = new ConstructorKey(functionName, types);
                if (!generatedConstructors.add(fullConstructorKey)) {
                    w.append("  // skipping " + fullConstructorKey + "\n");
                    continue;
                }
                emitComment(w, "  ", comment);
                w.append("  public ");
                w.append(mangleName(false, functionName)).append("(");
                sep = "";
                for (int i = 0; i < parameters.size(); i++) {
                    Parameter p = parameters.get(i);
                    w.append(sep);
                    String type = findType(types.get(i)).getJavaType();
                    if (p.isVararg() && type.endsWith("[]")) {
                        type = type.substring(0, type.length() - 2) + "...";
                    }
                    w.append(type + " ");
                    w.append(p.getName().getSimpleName());
                    sep = ", ";
                }
                w.append(") {\n");
                w.append("    this(").append(functionName).append(".$AS, ");
                w.append("$Typings$.").append(implName);
                w.append("(");
                sep = "";
                for (Parameter p : parameters) {
                    w.append(sep);
                    w.append(toJSParam(p, mergedParams));
                    sep = ", ";
                }
                w.append("));\n");
                w.append("  }\n");
            }
            return firstOptional[0];
        }
    }
    class Fields implements Visitor<Identifier, Type, Set<Type>, Void, String, Void> {
        private final Writer w;
        private final boolean instance;

        private final List<AST> typeParameters;
        private final Typings typings;
        private final String prefix;
        private final String packageName;
        private final Functions fnVisitor;
        private final Set<String> names;
        private boolean useModule;
        int count;

        Fields(Functions fnVisitor, String pn, Writer w, Typings typings, boolean instance, String prefix, List<AST> typeParameters) {
            this.fnVisitor = fnVisitor;
            this.packageName = pn;
            this.w = w;
            this.prefix = prefix;
            this.typings = typings;
            this.instance = instance;
            this.typeParameters = typeParameters;
            this.names = new HashSet<>();
        }

        @Override
        public void visit(Identifier a, Type fullType, Set<Type> callableSignatures, Void d, String comment, Void ignore) throws IOException {
            count++;
            Type type = findType(fullType).clone();
            type.anonimize();
            if (a.getSimpleName() == null || isKeyword(a.getSimpleName())) {
                emitComment(w, "  ", comment);
                w.append("  /* cannot generate " + a.getSimpleName() + " */\n");
                return;
            }
            final String fieldName = a.getSimpleName();
            if (!names.add(fieldName)) {
                w.append("  /* already generated " + a.getSimpleName() + " */\n");
                return;
            }
            boolean wrap = false;
            if (
                type.getKind().isTypeNode() ||
                type.getKind() == SyntaxKind.TypeLiteral ||
                type.getKind() == SyntaxKind.UnionType
            ) {
                wrap = true;
            }
            emitComment(w, "  ", comment);
            w.append("  public ");
            if (!instance) {
                w.append("static ");
            }
            final String fieldType = mangleName(true, type.getJavaType());
            if (fieldType.startsWith("java.lang.")) {
                wrap = false;
            }
            final String javaType = type.getRawJavaType();
            if (instance || useModule) {
                w.append("net.java.html.lib.Objs.Property<");
                final boolean useRaw = isTypeParameter(merge(typeParameters, null, null), type);
                if (useRaw) {
                    w.append("net.java.html.lib.Objs");
                } else {
                    w.append(mangleName(true, type.getBoxedJavaType()));
                }
                w.append("> ").append(fieldName);
                w.append(" = ");
                w.append("net.java.html.lib.Objs.Property.create(");
                if (useModule) {
                    w.append("selfModule(), ");
                } else {
                    w.append("this, ");
                }
                if (useRaw) {
                    w.append("net.java.html.lib.Objs");
                } else {
                    String propType = type.getBoxedIntoJavaType();
                    int at;
                    if ((at = propType.indexOf("<")) >= 0) {
                        propType = propType.substring(0, at);
                    }
                    String prefix = propType.contains(".") ? "" : packageName + ".";
                    w.append(mangleName(prefix, propType));
                }
                w.append(".class, ");
                w.append("\"" + fieldName + "\");\n");
            } else {
                w.append(fieldType).append(" ").append(fieldName).append(" = ");
                w.append("(").append(fieldType).append(")");
                if (wrap) {
                    if (javaType.indexOf('.') == -1) {
                        w.append(packageName).append('.');
                    }
                    w.append(mangleName(true, javaType));
                    w.append(".$as(");
                }
                readStatic(fieldName, type.getTypingsType(), type.getDefaultValue());
                if (wrap) {
                    if (type.getKind() == SyntaxKind.UnionType) {
                        for (Type pt : type.getTypes()) {
                            w.append(", ").append(pt.getBoxedJavaType()).append(".class");
                        }
                    }
                    w.append(")");
                }
                w.append(";\n");
            }
            if (callableSignatures != null && !callableSignatures.isEmpty()) {
                for (Type t : callableSignatures) {
                    final Type callType = t.clone();
                    callType.getTypeArguments().clear();
                    callType.substitute(t.getTypeArguments(), type.getTypeArguments());
                    List<Type> remaining = t.getTypeArguments().subList(type.getTypeArguments().size(), t.getTypeArguments().size());
                    callType.getTypeArguments().addAll(remaining);
                    fnVisitor.generateFunctions(a, callType, callType.getParameters(), null, remaining, comment, null);
                }
            } else {
                if (instance) {
                    final boolean useRaw = isTypeParameter(merge(typeParameters, null, null), type);
                    if (!useRaw && !type.isAnyUsed()) {
                        w.append("  public ");
                        w.append(mangleName(true, type.getBoxedJavaType()));
                        w.append(" ").append(fieldName);
                        w.append("() { return ");
                        w.append(fieldName).append(".get(); }\n");
                    }
                }
            }
        }

        private void readStatic(String fieldName, String type, String defaultValue) throws IOException {
            w.append("$Typings$.").append(typings.readStatics(useModule, prefix, fieldName, type, defaultValue));
            if (useModule) {
                w.append("($js(selfModule()))");
            } else {
                w.append("()");
            }
        }

        public void finish() throws IOException {
        }
    }

    final class Typings {
        private final Writer w;
        private int cnt;

        Typings(String packageName, Writer typingsFile, String[] scripts) throws IOException {
            w = typingsFile;
            w.append("package ").append(packageName).append(";\n");
            if (scripts.length == 1) {
                w.append("@net.java.html.js.JavaScriptResource(\"");
                w.append(scripts[0]);
                w.append("\")\n");
            } else if (scripts.length > 0) {
                throw new IOException("Multiple scripts not supported yet: " + Arrays.toString(scripts));
            }
            w.append("final class $Typings$ {\n");
            w.append("  private $Typings$() {\n");
            w.append("  }\n");
            w.append("  static {\n");
            w.append("    net.java.html.lib.Array.isArray(0.0);\n");
            w.append("  }\n");
            w.append("  @net.java.html.js.JavaScriptBody(args={},body=\"\")\n");
            w.append("  static native void selfInit();\n");
        }

        final String generateFunction(
            boolean virtual,
            List<Parameter> parameters, List<String> typeParameters,
            Identifier a, Type returnType, String prefix, int[] firstOptional
        ) throws IOException {
            firstOptional[0] = 0;
            w.append("  @net.java.html.js.JavaScriptBody(args={");
            String sep = "";
            if (virtual) {
                w.append('"').append("$dukescript$self").append('"');
                sep = ", ";
            }
            boolean callback = false;
            for (Parameter p : parameters) {
                w.append(sep);
                w.append('"').append(p.getName().getSimpleName()).append('"');
                sep = ", ";

                if (!p.isOptional()) {
                    firstOptional[0]++;
                }
                if (p.getType().getKind() == SyntaxKind.FunctionType) {
                    callback = true;
                }
            }
            boolean wrapReturn =
                returnType.getKind().isTypeNode() ||
                returnType.getKind() == SyntaxKind.UnionType ||
                returnType.getKind() == SyntaxKind.ArrayType;
            final String methodName = a.getSimpleName();
            w.append("}, ");
            if (callback) {
                w.append("javacall = true, ");
            }
            w.append("body=\n    \"");
            w.append("var r = ");
            boolean varArgs = !parameters.isEmpty() && parameters.get(parameters.size() - 1).isVararg();
            String openCall = "(";
            String closeCall = ")";
            if (varArgs) {
                if (parameters.size() == 1) {
                    w.append(parameters.get(0).getAccess()).append(";");
                } else {
                    w.append("[];");
                    for (Parameter p : parameters) {
                        if (!p.isVararg()) {
                            w.append("r.push(").append(p.getAccess()).append(");");
                        }
                    }
                    w.append("r.push(").append(parameters.get(parameters.size() - 1).getAccess()).append(");");
                }
                w.append("\\n\" +\n    \"var r = ");
            }
            int generateParams = parameters.size();
            if (virtual) {
                if ("$get".equals(methodName)) {
                    closeCall = "]";
                    w.append("$dukescript$self");
                    openCall = "[";
                } else if ("$apply".equals(methodName)) {
                    closeCall = ")";
                    w.append("$dukescript$self");
                    openCall = "(";
                } else if ("$set".equals(methodName)) {
                    generateParams = 1;
                    closeCall = "] = " + parameters.get(1).getName().getSimpleName();
                    w.append("$dukescript$self");
                    openCall = "[";
                } else if ("$set".equals(methodName)) {
                    generateParams = 1;
                    closeCall = "] = " + parameters.get(1).getName().getSimpleName();
                    w.append("$dukescript$self['r']");
                    openCall = "[";
                } else {
                    w.append("$dukescript$self.").append(methodName);
                }
            } else {
                if (prefix != null) {
                    w.append(prefix).append('.');
                }
                w.append(methodName);
            }
            if (varArgs) {
                if (virtual) {
                    w.append(".apply($dukescript$self, r)");
                } else {
                    w.append(".apply(this, r)");
                }
            } else {
                w.append(openCall);
                sep = "";
                for (int i = 0; i < generateParams; i++) {
                    Parameter p = parameters.get(i);
                    w.append(sep);
                    w.append(p.getAccess());
                    sep = ", ";
                }
                w.append(closeCall);
            }
            if (wrapReturn) {
                w.append(";\\n\" +\n");
                w.append("    \"if (Array.isArray(r)) return hj.array(r);\" +\n");
                w.append("    \"return r;\"\n");
            } else {
                w.append(";\\n\" +\n    \"return r;\"\n");
            }
            w.append("\n  )\n");
            final String implName = methodName + "$" + ++cnt;
            w.append("  static native ");
            typeParameters(w, typeParameters);
            if (wrapReturn) {
                w.append("java.lang.Object");
            } else {
                if (returnType.getKind() == SyntaxKind.FunctionType) {
                    w.append("java.lang.Object");
                } else if (returnType.getKind() == SyntaxKind.ArrayType) {
                    w.append("java.lang.Object");
                } else {
                    w.append(returnType.getJavaType());
                }
            }
            w.append(" ").append(implName).append("(");
            sep = "";
            if (virtual) {
                w.append("java.lang.Object $dukescript$self");
                sep = ", ";
            }
            for (Parameter p : parameters) {
                w.append(sep);
                w.append("java.lang.Object ");
                w.append(p.getName().getSimpleName());
                sep = ", ";
            }
            w.append(");\n\n");
            return implName;
        }

        private String generateConstructor(List<Parameter> parameters, int[] firstOptional, Identifier a, List<String> typeParameters1) throws IOException {
            w.append("  @net.java.html.js.JavaScriptBody(args={");
            String sep = "";
            boolean callback = false;
            for (Parameter p : parameters) {
                w.append(sep);
                w.append('"').append(p.getName().getSimpleName()).append('"');
                sep = ", ";

                if (!p.isOptional()) {
                    firstOptional[0]++;
                }
                if (p.getType().getKind() == SyntaxKind.FunctionType) {
                    callback = true;
                }
            }
            w.append("}, ");
            if (callback) {
                w.append("javacall = true, ");
            }
            w.append("body=\n    \"return new ");
            final String functionName = a.getSimpleName();
            w.append(functionName).append("(");
            sep = "";
            for (Parameter p : parameters) {
                w.append(sep);
                w.append(p.getAccess());
                sep = ", ";
            }
            w.append(");\"\n  )\n");
            final String implName;
            w.append("  static native ");
            implName = "new$" + ++cnt;
            typeParameters(w, typeParameters1);
            w.append("java.lang.Object");
            w.append(" ").append(implName).append("(");
            sep = "";
            for (Parameter p : parameters) {
                w.append(sep);
                w.append("java.lang.Object ");
                w.append(p.getName().getSimpleName());
                sep = ", ";
            }
            w.append(");\n\n");
            return implName;
        }

        private String readStatics(boolean useModules, 
            String prefix, String fieldName, String type, String defaultValue
        ) throws IOException {
            String implName = "readStaticFields$" + ++cnt;
            w.append("  @net.java.html.js.JavaScriptBody(args = {");
            if (useModules) {
                w.append("\"self$dukescript\"");
            }
            w.append("}, body = \"return ");
            if (prefix != null) {
                w.append(prefix).append(".");
            } else {
                w.append("typeof ").append(fieldName).append(" === 'undefined' ? " + defaultValue + " : ");
            }
            w.append(fieldName).append(";\")\n");
            w.append("  static native ").append(type).append(" ").append(implName).append("(");
            if (useModules) {
                w.append("java.lang.Object self$dukescript");
            }
            w.append(");\n");
            return implName;
        }

        void close() throws IOException {
            w.append("}\n");
            w.close();
        }
    }
}
