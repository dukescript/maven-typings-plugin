package com.dukescript.libraries.proc;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
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

    protected abstract Writer createSourceFile(String string, L location) throws IOException;
    protected abstract L findType(String fqn);
    protected abstract void note(String message, L e);
    protected abstract void error(String message, L e);

    final Type findType(Type t) {
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
        Writer typingsFile = createSourceFile(packageName + ".$Typings$", location);

        new Resolver() {
            @Override
            String resolveFQN(String typeStr) {
                String coreBase = "net.java.html.lib." + typeStr;
                if (findType(coreBase) != null) {
                    return coreBase;
                }
                final String javaBase = "java.lang." + typeStr;
                if (findType(javaBase) != null) {
                    return javaBase;
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
        
        Parser p = new Parser();
        AST root = p.parse(libraryTypingsName, libraryTypings);

        final Typings typings = new Typings(packageName, typingsFile, libraryScripts);
        Writer w = createSourceFile(packageName + ".Exports", location);
        w.append("package ").append(packageName).append(";\n");
        w.append("@java.lang.SuppressWarnings(\"unchecked\")\n");
        w.append("public final class Exports extends " + mangleName(true, "Object") + " {\n");
        w.append("  private Exports() {\n");
        w.append("  }\n");
        this.typeAliases = new HashMap<>();
        root.findTypeAliases(typeAliases);
        final Functions fn = new Functions(packageName, w, typings, false);
        root.visitFunctions(fn);
        final Fields fields = new Fields(fn, packageName, w, typings, false, null, Collections.emptyList());
        root.visitFields(fields);
        fields.finish();
        w.append("}\n");
        w.close();
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
                if (heritage.isEmpty()) {
                    w.append(" extends ").append(mangleName(true, "Object"));
                } else {
                    List<AST> types = heritage.get(0).getTypes();
                    final AST typeZero = types.get(0);
                    String typeName = findTypeName(typeZero);
                    String superClass = mangleName(true, typeName);
                    w.append(" extends " + Resolver.findFQN(superClass));
                    List<Type> typeArguments = types.get(0).getTypeArguments();
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
                w.append("  protected " + name + "(java.lang.Class<? extends Object> clazz, java.lang.Object js) {\n");
                w.append("    super(clazz, js);\n");
                w.append("  }\n");
                w.append("  public static " + name + " $as(java.lang.Object obj) {\n");
                w.append("    return obj == null ? null : new " + name + "(" + name + ".class, obj);\n");
                w.append("  }\n");
                w.append("  public static final net.java.html.lib.Function.A1<java.lang.Object," + name + "> $AS = new net.java.html.lib.Function.A1<java.lang.Object," + name + ">() {\n");
                w.append("    @Override\n");
                w.append("    public " + name + " call(java.lang.Object obj) {\n");
                w.append("      return " + name + ".$as(obj);\n");
                w.append("    }\n");
                w.append("  };\n");
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

            private String findTypeName(final AST typeZero) {
                AST expr = typeZero.getExpression().get(0);
                String t = expr.getText();
                if (t == null) {
                    return "Object";
                }
                return t;
            }
        }
        root.visitInterfaces(new Interfaces());
        root.visitClasses(new Interfaces());
        typings.close();
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
    
    static String mangleName(boolean fqn, String name) {
        if (fqn && name.equals("Array")) {
            return "net.java.html.lib.Array";
        }
        return name.equals("Object") ? (fqn ? "net.java.html.lib.Objs" : "Objs") : name;
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


    class Functions implements Visitor<Identifier, Type, List<Parameter>, List<AST>, String,Void> {
        private final Writer w;
        private final boolean virtual;
        private final String prefix;
        private final List<AST> typeParameters;
        private final Typings typings;
        private final String packageName;
        private final Set<MethodKey> generated = new HashSet<>();

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
            String implName = typings.generateFunction(virtual, parameters, allTypeParams,
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
                        w.append("    return (").append(javaType).append(')');
                        wrap = false;
                    } else {
                        w.append("    return (").append(javaReturn).append(")");
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
                    } else {
                        w.append("    return ");
                    }
                }
                w.append("$Typings$.").append(implName);
                if (virtual) {
                    w.append("($js(this)");
                    sep = ", ";
                } else {
                    w.append("(");
                    sep = "";
                }
                for (Parameter p : parameters) {
                    w.append(sep);
                    w.append(p.getObjs());
                    sep = ", ";
                }
                if (wrap) {
                    w.append(')');
                }
                w.append(");\n");
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
                w.append("    this(").append(functionName).append(".class, ");
                w.append("$Typings$.").append(implName);
                w.append("(");
                sep = "";
                for (Parameter p : parameters) {
                    w.append(sep);
                    w.append(p.getObjs());
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

        Fields(Functions fnVisitor, String pn, Writer w, Typings typings, boolean instance, String prefix, List<AST> typeParameters) {
            this.fnVisitor = fnVisitor;
            this.packageName = pn;
            this.w = w;
            this.prefix = prefix;
            this.typings = typings;
            this.instance = instance;
            this.typeParameters = typeParameters;
        }

        @Override
        public void visit(Identifier a, Type fullType, Set<Type> callableSignatures, Void d, String comment, Void ignore) throws IOException {
            Type type = findType(fullType).clone();
            type.anonimize();
            if (a.getSimpleName() == null || isKeyword(a.getSimpleName())) {
                emitComment(w, "  ", comment);
                w.append("  /* cannot generate " + a.getSimpleName() + " */\n");
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
            final String fieldName = a.getSimpleName();
            final String javaType = type.getRawJavaType();
            if (instance) {
                w.append("net.java.html.lib.Function.A0<");
                final boolean useRaw = isTypeParameter(merge(typeParameters, null, null), type);
                if (useRaw) {
                    w.append("net.java.html.lib.Objs");
                } else {
                    w.append(mangleName(true, type.getBoxedJavaType()));
                }
                w.append("> ").append(fieldName);
                w.append(" = ");
                w.append("net.java.html.lib.Function.$read(");
                if (wrap) {
                    if (useRaw) {
                        w.append("net.java.html.lib.Objs");
                    } else {
                        w.append(mangleName(true, javaType));
                    }
                    w.append(".$AS, ");
                }
                w.append("this, ");
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
                        w.append(fieldName).append(".call(); }\n");
                    }
                }
            }
        }

        private void readStatic(String fieldName, String type, String defaultValue) throws IOException {
            w.append("$Typings$.").append(typings.readStatics(prefix, fieldName, type, defaultValue) + "()");
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

        private String readStatics(String prefix, String fieldName, String type, String defaultValue) throws IOException {
            String implName = "readStaticFields$" + ++cnt;
            w.append("  @net.java.html.js.JavaScriptBody(args = {}, body = \"return ");
            if (prefix != null) {
                w.append(prefix).append(".");
            } else {
                w.append("typeof ").append(fieldName).append(" === 'undefined' ? " + defaultValue + " : ");
            }
            w.append(fieldName).append(";\")\n");
            w.append("  static native ").append(type).append(" ").append(implName).append("();\n");
            return implName;
        }

        void close() throws IOException {
            w.append("}\n");
            w.close();
        }
    }
}
