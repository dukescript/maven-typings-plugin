package com.dukescript.libraries.proc;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import net.java.html.json.ComputedProperty;
import net.java.html.json.Model;
import net.java.html.json.ModelOperation;
import net.java.html.json.Property;

@Model(className = "AST", properties = {
    @Property(name = "children", type = AST.class, array = true),
    @Property(name = "kind", type = SyntaxKind.class),
//    @Property(name = "pos", type = int.class),
//    @Property(name = "end", type = int.class),
//    @Property(name = "flags", type = int.class),
    @Property(name = "comment", type = String.class),
    @Property(name = "name", type = Identifier.class),
    @Property(name = "type", type = Type.class),
    @Property(name = "text", type = String.class),
    @Property(name = "declarationList", type = VariableDeclarationList.class),
    @Property(name = "parameters", type = Parameter.class, array = true),
    @Property(name = "typeParameters", type = AST.class, array = true),
    @Property(name = "typeArguments", type = Type.class, array = true),
    @Property(name = "members", type = AST.class, array = true),
    @Property(name = "heritageClauses", type = Heritage.class, array = true),
    @Property(name = "expression", type = AST.class, array = true),
    @Property(name = "body", type = AST.class, array = true),
    @Property(name = "statements", type = AST.class, array = true),
})
class ASTCntrl {
    @Model(className = "VariableDeclarationList", properties = {
        @Property(name = "declarations", type = AST.class, array = true)
    })
    static final class VariableDeclarationListCntrl {
    }

    @Model(className = "Token", properties = {
        @Property(name = "kind", type = SyntaxKind.class)
    })
    static final class TokenCntrl {
    }
    @Model(className = "Identifier", properties = {
        @Property(name = "kind", type = SyntaxKind.class),
        @Property(name = "text", type = String.class),
        @Property(name = "right", type = Identifier.class, array = true),
    })
    static final class IdentifierCntrl {
        @ComputedProperty
        static String simpleName(SyntaxKind kind, String text, List<Identifier> right) {
            if (text != null) {
                return text;
            } else {
                return right.isEmpty() ? null : right.get(0).getSimpleName();
            }
        }
    }
    @Model(className = "Type", properties = {
        @Property(name = "kind", type = SyntaxKind.class),
        @Property(name = "text", type = String.class),
        @Property(name = "typeName", type = Identifier.class),
        @Property(name = "type", type = Type.class, array = true),
        @Property(name = "types", type = Type.class, array = true),
        @Property(name = "typeArguments", type = Type.class, array = true),
        @Property(name = "parameters", type = Parameter.class, array = true),
        @Property(name = "elementType", type = Type.class, array = true),
        @Property(name = "elementTypes", type = Type.class, array = true),
        @Property(name = "members", type = Type.class, array = true)
    })
    static final class TypeCntrl {
        @ComputedProperty
        static List<Type> unionTypes(SyntaxKind kind, List<Type> types) {
            if (kind == SyntaxKind.UnionType) {
                return types;
            } else {
                return null;
            }
        }

        @ComputedProperty
        static String defaultValue(SyntaxKind kind) {
            switch (kind) {
                case AnyKeyword:
                case StringKeyword:
                case VoidKeyword:
                case FirstTypeNode:
                case LastTypeNode:
                case ArrayType:
                case FunctionType:
                case UnionType:
                case TypeLiteral:
                case TypeQuery:
                case PropertySignature:
                case IndexSignature:
                    return "null";
                case NumberKeyword:
                    return "NaN";
                case TypePredicate:
                    return "false";
                case BooleanKeyword:
                    return "false";
            }
            throw new IllegalStateException("Unknown " + kind);
        }

        @ModelOperation
        static void anonimize(Type model) {
            if (model.getKind() == SyntaxKind.FunctionType) {
                List<Type> typeArgs = findTypeArguments(model);
                if (typeArgs.isEmpty()) {
                    return;
                }
                List<Type> replace = new ArrayList<>();
                for (Type t : typeArgs) {
                    replace.add(new Type(SyntaxKind.FirstTypeNode, null, new Identifier(null, "?")));
                }
                substitute(model, typeArgs, replace);
            }
        }

        private static List<Type> findTypeArguments(Type root) {
            Set<Type> types = new LinkedHashSet<>();
            class TypeArguments implements ProcessList {
                @Override
                public void process(List<Type> arr) {
                    for (Type t : arr) {
                        types.addAll(t.getTypeArguments());
                    }
                }
            }
            walkType(root, new TypeArguments());
            return new ArrayList<>(types);
        }

        static interface ProcessList {
            void process(List<Type> arr);
        }

        private static void walkType(Type model, ProcessList p) {
            p.process(model.getElementType());
            p.process(model.getMembers());
            p.process(model.getType());
            p.process(model.getTypeArguments());
            p.process(model.getTypes());
            for (Parameter param : model.getParameters()) {
                Type[] paramType = { param.getType() };
                p.process(Arrays.asList(paramType));
                param.setType(paramType[0]);
            }
        }
        
        @ModelOperation
        static void substitute(Type model, List<Type> names, List<Type> actualTypes) {
            for (int i = 0; i < Math.min(names.size(), actualTypes.size()); i++) {
                Type n = names.get(i);
                if (Objects.equals(model.getTypeName(), n.getTypeName())) {
                    model.setTypeName(actualTypes.get(i).getTypeName());
                }
            }
            class ReplaceList implements ProcessList {
                @Override
                public void process(List<Type> toChange) {
                    for (int i = 0; i < toChange.size(); i++) {
                        Type clone = toChange.get(i).clone();
                        clone.substitute(names, actualTypes);
                        toChange.set(i, clone);
                    }
                }
            }
            walkType(model, new ReplaceList());
        }

        @ModelOperation
        static void cast(Type model, String expr, Appendable add) throws IOException {
            switch (model.getKind()) {
                case AnyKeyword:
                case StringKeyword:
                case VoidKeyword:
                case FirstTypeNode:
                case LastTypeNode:
                case ArrayType:
                case FunctionType:
                case UnionType:
                case TupleType:
                case TypePredicate:
                case BooleanKeyword:
                    add.append("(").append(model.getBoxedJavaType()).append(")").append(expr);
                    return;
                case TypeLiteral:
                    add.append("net.java.html.lib.Objs.$as(").append(expr).append(")");
                    return;
                case NumberKeyword:
                    add.append("((java.lang.Number)").append(expr).append(").doubleValue()");
                    return;
            }
            throw new IllegalStateException("Unknown " + model.getKind());
        }

        @ComputedProperty
        static String javaType(
            SyntaxKind kind, Identifier typeName,
            List<Type> elementType, List<Type> type,
            List<Type> types, List<Parameter> parameters,
            List<Type> typeArguments
        ) {
            return javaType(false, false, false, kind, typeName, elementType, type, types, parameters, typeArguments);
        }

        @ComputedProperty
        static String rawJavaType(
            SyntaxKind kind, Identifier typeName,
            List<Type> elementType, List<Type> type,
            List<Type> types, List<Parameter> parameters,
            List<Type> typeArguments
        ) {
            return javaType(false, false, true, kind, typeName, elementType, type, types, parameters, typeArguments);
        }
        @ComputedProperty
        static String boxedJavaType(
            SyntaxKind kind, Identifier typeName,
            List<Type> elementType, List<Type> type,
            List<Type> types, List<Parameter> parameters,
            List<Type> typeArguments
        ) {
            return javaType(true, false, false, kind, typeName, elementType, type, types, parameters, typeArguments);
        }
        @ComputedProperty
        static String boxedIntoJavaType(
            SyntaxKind kind, Identifier typeName,
            List<Type> elementType, List<Type> type,
            List<Type> types, List<Parameter> parameters,
            List<Type> typeArguments
        ) {
            return javaType(true, true, false, kind, typeName, elementType, type, types, parameters, typeArguments);
        }

        private static String javaType(
            boolean boxed, boolean intoJava, boolean rawType,
            SyntaxKind kind, Identifier typeName,
            List<Type> elementType, List<Type> type,
            List<Type> types, List<Parameter> parameters,
            List<Type> typeArguments
        ) {
            switch (kind) {
                case AnyKeyword:
                case TypeQuery:
                    return "java.lang.Object";
                case StringLiteral:
                case SymbolKeyword:
                case StringKeyword: return "java.lang.String";
                case NumberKeyword: return boxed ? "java.lang.Number" : "double";
                case TypePredicate: return "java.lang.Boolean/*TypePredicate*/";
                case BooleanKeyword: return "java.lang.Boolean";
                case VoidKeyword: return boxed ? "java.lang.Void" : "void";
                case FirstTypeNode:
                case LastTypeNode: {
                    String typeStr = typeName == null ? null : typeName.getSimpleName();
                    if (typeStr == null) {
                        return "net.java.html.lib.Objs";
                    }
                    typeStr = Resolver.findFQN(typeStr);
                    if (rawType || typeArguments.isEmpty()) {
                        return typeStr;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(typeStr);
                    sb.append("<");
                    String sep = "";
                    for (Type arg : typeArguments) {
                        sb.append(sep);
                        sb.append(arg.getBoxedJavaType());
                        sep = ",";
                    }
                    sb.append(">");
                    return sb.toString();
                }
                case TupleType:
                    return "java.lang.Object[]";
                case ArrayType: return intoJava ?
                    "net.java.html.lib.Array<" + elementType.get(0).getBoxedJavaType() + ">" :
                    elementType.get(0).getJavaType() + "[]";
                case FunctionType: {
                    StringBuilder sb = new StringBuilder();
                    sb.append("net.java.html.lib.Function");
                    sb.append(".A").append(parameters.size());
                    if (rawType) {
                        return sb.toString();
                    }
                    sb.append("<");
                    for (Parameter p : parameters) {
                        if (p.getType() != null) {
                            sb.append("? super ");
                            sb.append(p.getType().getBoxedIntoJavaType()).append(",");
                        } else {
                            sb.append(Generator.mangleName(false, p.getName().getSimpleName())).append(",");
                        }
                    }
                    sb.append("? extends ");
                    sb.append(type.get(0).getBoxedJavaType());
                    sb.append(">");
                    return sb.toString();
                }
                case UnionType: {
                    if (rawType) {
                        return "net.java.html.lib.Union";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("net.java.html.lib.Union");
                    sb.append(".A").append(types.size());
                    sb.append("<");
                    String sep = "";
                    for (Type t : types) {
                        sb.append(sep);
                        sb.append(t.getBoxedJavaType());
                        sep = ",";
                    }
                    sb.append(">");
                    return sb.toString();
                }
                case TypeLiteral: return "net.java.html.lib.Objs";
            }
            return "/* Unknown " + kind + "*/java.lang.Object";
        }

        @ComputedProperty
        static boolean anyUsed(SyntaxKind kind, Identifier typeName, List<Type> elementType, List<Type> elementTypes) {
            switch (kind) {
                case AnyKeyword: return true;
                case StringKeyword: return false;
                case NumberKeyword: return false;
                case BooleanKeyword: return false;
                case VoidKeyword: return false;
                case FirstTypeNode: return false;
                case LastTypeNode: return false;
                case TypeQuery: return false;
                case ArrayType: return elementType.get(0).isAnyUsed();
                case FunctionType: return false;
                case PropertySignature:
                case IndexSignature: return false;
                case UnionType: return true;
                case TypePredicate: return true;
                case TypeLiteral: return true;
                case TupleType:
                    for (Type t : elementTypes) {
                        if (t.isAnyUsed()) {
                            return true;
                        }
                    }
                    return false;
            }
            throw new IllegalStateException("Unknown " + kind);
        }

        @ComputedProperty
        static String typingsType(SyntaxKind kind, Identifier typeName, List<Type> elementType) {
            switch (kind) {
                case StringKeyword:
                    return "java.lang.String";
                case NumberKeyword:
                    return "double";
                case TypePredicate:
                case BooleanKeyword:
                    return "boolean";
                case VoidKeyword:
                    return "void";
                case AnyKeyword:
                case FirstTypeNode:
                case LastTypeNode:
                case ArrayType:
                case TypeLiteral:
                case FunctionType:
                case PropertySignature:
                case IndexSignature:
                case UnionType:
                case TypeQuery:
                case TupleType:
                    return "java.lang.Object";
            }
            throw new IllegalStateException("Unknown " + kind);
        }

        @ModelOperation
        static void findCalls(Type type, Map<String,Set<Type>> namedCalls, Set<Type> calls) {
            if (type.getKind().isTypeNode() && type.getTypeName() != null) {
                final String typeName = type.getTypeName().getSimpleName();
                if (typeName != null) {
                    Set<Type> named = namedCalls.get(typeName);
                    if (named != null) {
                        calls.addAll(named);
                    }
                }
            }
            for (Type t : type.getMembers()) {
                if (t.getKind() == SyntaxKind.CallSignature) {
                    calls.add(t);
                }
            }
        }
    }

    @Model(className = "Parameter", properties = {
        @Property(name = "name", type = Identifier.class),
        @Property(name = "type", type = Type.class),
        @Property(name = "questionToken", type = Token.class),
        @Property(name = "dotDotDotToken", type = Token.class),
    })
    static final class ParameterCntrl {
        @ComputedProperty
        static boolean optional(Token questionToken) {
            return questionToken != null;
        }
        @ComputedProperty
        static boolean vararg(Token dotDotDotToken) {
            return dotDotDotToken != null;
        }
        @ComputedProperty
        static String access(Identifier name, Type type, Token questionToken, Token dotDotDotToken) {
            if (type.getKind() == SyntaxKind.FunctionType) {
                List<Parameter> parameters = type.getParameters();
                StringBuilder sb = new StringBuilder();
                sb.append("function(");
                int cnt = 0;
                for (Parameter p : parameters) {
                    if (cnt > 0) {
                        sb.append(",");
                    }
                    sb.append("p").append(++cnt);
                }
                sb.append(") { return ");
                sb.append("@net.java.html.lib.Function");
                sb.append("::$call(Ljava/lang/Object;");
                sb.append("[Ljava/lang/Object;");
                sb.append(")(");
                sb.append(name.getSimpleName());
                sb.append(", [");
                cnt = 0;
                for (Parameter p : parameters) {
                    if (cnt > 0) {
                        sb.append(",");
                    }
                    sb.append("p").append(++cnt);
                }
                sb.append("]);");
                sb.append("}");
                return sb.toString();
            }
            if (type.getKind() == SyntaxKind.StringLiteral) {
                return "'" + type.getText() + "'";
            }
            return name.getSimpleName();
        }
        @ComputedProperty
        static String objs(Identifier name, Type type) {
            switch (type.getKind()) {
                case StringKeyword:
                case VoidKeyword:
                case NumberKeyword:
                case BooleanKeyword:
                case TypePredicate:
                    break;
                case ArrayType:
                case FunctionType :
                    return "/* " + type.getKind() + "*/"
                        + "$js(" + name.getSimpleName() + ")";
                case AnyKeyword:
                case FirstTypeNode:
                case UnionType:
                case TypeLiteral: {
                final String javaType = type.getJavaType();
                    if (!javaType.equals("java.lang.Object") && javaType.startsWith("java.lang.")) {
                        return name.getSimpleName();
                    }
                    return "/* " + type.getKind() + "*/" +
                    "$js(" + name.getSimpleName() + ")";
                }
            }
            return name.getSimpleName();
        }
    }

    @Model(className = "Heritage", properties = {
        @Property(name = "token", type = SyntaxKind.class),
        @Property(name = "types", type = AST.class, array = true),
    })
    static final class HeritageCntrl {
    }

    @ModelOperation
    static void visitFields(AST self, Visitor<Identifier,Type,Set<Type>,Void,String,Void> visitor) throws IOException {
        Map<String,AST> constructors = findConstructors(self);
        Map<String, Set<Type>> globalCallSignatures = findCallSignatures(self);
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.VariableStatement) {
                List<AST> declarations = ch.getDeclarationList().getDeclarations();
                for (AST var : declarations) {
                    final Type type = var.getType();
                    if (type.getKind().isTypeNode()) {
                        final String typeName = type.getTypeName().getSimpleName();
                        if (typeName == null || constructors.containsKey(typeName)) {
                            continue;
                        }
                    }
                    Set<Type> callSignatures = new HashSet<>();
                    type.findCalls(globalCallSignatures, callSignatures);
                    visitor.visit(var.getName(), type, callSignatures, null, var.getComment(), null);
                }
            }
        }
    }

    @ModelOperation
    static void visitFunctions(AST self, Visitor<Identifier,Type,List<Parameter>,List<AST>,String,Void> visitor) throws IOException {
        Collection<AST> filteredMembers = filteredMembers(self.getTypeParameters(), false, self.getChildren(), SyntaxKind.FunctionDeclaration);
        for (AST ch : filteredMembers) {
            visitor.visit(ch.getName(), ch.getType(), ch.getParameters(), ch.getTypeParameters(), ch.getComment(), null);
        }
    }

    private static List<AST> filteredMembers(List<AST> classParams, boolean incodeOthers, List<AST> members, SyntaxKind... kinds) {
        for (int i = 0; i < kinds.length; i++) {
            members = implFilteredMembers(classParams, incodeOthers, members, kinds[i]);
        }
        return members;
    }
    private static List<AST> implFilteredMembers(List<AST> classParams, boolean incodeOthers, List<AST> members, SyntaxKind kind) {
        List<AST> result = new ArrayList<>();
        class NameAndArity implements Comparable<NameAndArity> {
            final String name;
            final String arity;

            public NameAndArity(String name, List<AST> typeParameters, List<Parameter> params) {
                this.name = name == null ? "" : name;

                Set<String> typeParametersNames = new HashSet<>();
                for (AST p : typeParameters) {
                    String typeName = p.getName().getSimpleName();
                    typeParametersNames.add(typeName);
                }
                for (AST p : classParams) {
                    String typeName = p.getName().getSimpleName();
                    typeParametersNames.add(typeName);
                }

                StringBuilder sb = new StringBuilder();
                for (Parameter p : params) {
                   String typeName = p.getType().getBoxedJavaType();
                    boolean array = false;
                    if (typeName.endsWith("[]")) {
                        typeName = typeName.substring(0, typeName.length() - 2);
                        array = true;
                    }
                    if (typeParametersNames.contains(typeName)) {
                        typeName = "java.lang.Object";
                    } else {
                        int generic = typeName.indexOf('<');
                        if (generic >= 0) {
                            typeName = typeName.substring(0, generic);
                        }
                    }
                    if (array) {
                        typeName += "[]";
                    }
                    sb.append(typeName).append(" ");
                }
                this.arity = sb.toString();
            }

            @Override
            public int hashCode() {
                int hash = 5;
                hash = 71 * hash + Objects.hashCode(this.name);
                hash = 71 * hash + this.arity.hashCode();
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
                final NameAndArity other = (NameAndArity) obj;
                if (!Objects.equals(this.arity, other.arity)) {
                    return false;
                }
                if (!Objects.equals(this.name, other.name)) {
                    return false;
                }
                return true;
            }

            @Override
            public int compareTo(NameAndArity o) {
                int compare = name.compareTo(o.name);
                if (compare == 0) {
                    int a1 = arity.split(" ").length;
                    int a2 = arity.split(" ").length;
                    compare = a1 - a2;
                    if (compare == 0) {
                        compare = arity.compareTo(o.arity);
                    }
                }
                return compare;
            }
        }
        Map<NameAndArity,AST> mostTypeArity = new TreeMap<>();
        for (AST ch : members) {
            if (ch.getKind() != kind) {
                if (incodeOthers) {
                    result.add(ch);
                }
                continue;
            }
            final String name = ch.getName() != null ? ch.getName().getSimpleName() : "";
            NameAndArity key = new NameAndArity(name, ch.getTypeParameters(), ch.getParameters());
            AST prev = mostTypeArity.put(key, ch);
            if (prev != null) {
                List<Parameter> from;
                List<Parameter> to;
                if (prev.getParameters().size() > ch.getParameters().size()) {
                    from = ch.getParameters();
                    to = prev.getParameters();
                    mostTypeArity.put(key, prev);
                } else {
                    to = ch.getParameters();
                    from = prev.getParameters();
                }
                for (int i = 0; i < Math.min(from.size(), to.size()); i++) {
                    Token token = from.get(i).getQuestionToken();
                    if (token != null) {
                        to.get(i).setQuestionToken(token);
                    }
                }
            }
        }
        result.addAll(mostTypeArity.values());
        return result;
    }

    private static Type constructorFor(AST declaration) {
        for (AST member : declaration.getMembers()) {
            if (member.getName() != null && "prototype".equals(member.getName().getSimpleName())) {
                return member.getType();
            }
        }
        if (declaration.getMembers().size() == 1) {
            AST only = declaration.getMembers().get(0);
            if (only.getKind() == SyntaxKind.ConstructSignature) {
                return only.getType();
            }
        }
        return null;
    }

    @ModelOperation
    static void findTypeAliases(AST self, Map<Identifier,Type> aliases) {
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.TypeAliasDeclaration) {
                aliases.put(ch.getName(), ch.getType());
            }
        }
    }

    @ModelOperation
    static void findClassesAndInterfaces(AST self, String pkg, Map<String,String> classesAndInterfaces) {
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.InterfaceDeclaration || ch.getKind() == SyntaxKind.ClassDeclaration ) {
                String name = ch.getName().getText();
                if (pkg != null) {
                    name = pkg + '.' + name;
                }

                classesAndInterfaces.put(ch.getName().getText(), name);
            }
        }
    }

    @ModelOperation
    static void visitInterfaces(AST self, Visitor<Identifier,List<AST>,List<AST>,AST,List<Heritage>, Map<String,Set<Type>>> visitor) throws IOException {
        Map<String,AST> unique = new TreeMap<>();
        Map<String,Set<Type>> callSigs = findCallSignatures(self);
        Map<String,AST> constructors = findConstructors(self);
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.InterfaceDeclaration) {
                final String key = ch.getName().getSimpleName();
                if (constructors.containsKey(key) && constructors.get(key) == null) {
                    continue;
                }
                AST prev = unique.put(key, ch);
                if (prev != null) {
                    if (ch.getTypeParameters().equals(prev.getTypeParameters())) {
                        AST merge = ch.clone();
                        merge.getMembers().addAll(prev.getMembers());
                        unique.put(key, merge);
                    }
                }
            }
        }
        for (Map.Entry<String, AST> entry : unique.entrySet()) {
            AST ch = entry.getValue();
            AST chConstructor = constructors.remove(ch.getName().getSimpleName());
            if (chConstructor != null) {
                constructors.remove(chConstructor.getName().getSimpleName());
                List<AST> filteredConstructors = filteredMembers(Collections.emptyList(), true, chConstructor.getMembers(), SyntaxKind.ConstructSignature, SyntaxKind.CallSignature);
                chConstructor.getMembers().clear();
                chConstructor.getMembers().addAll(filteredConstructors);
            }
            final List<AST> filteredMembers = filteredMembers(ch.getTypeParameters(), true, ch.getMembers(), SyntaxKind.MethodSignature);
            visitor.visit(ch.getName(), ch.getTypeParameters(), filteredMembers, chConstructor, ch.getHeritageClauses(), callSigs);
        }
        for (AST ch : self.getChildren()) {
            if (ch.getKind() != SyntaxKind.InterfaceDeclaration) {
                continue;
            }
            if (!constructors.containsKey(ch.getName().getSimpleName())) {
                continue;
            }
            final List<AST> filteredMembers = filteredMembers(ch.getTypeParameters(), true, ch.getMembers(), SyntaxKind.MethodSignature);
            visitor.visit(ch.getName(), ch.getTypeParameters(), filteredMembers, ch, ch.getHeritageClauses(), callSigs);
        }
    }

    @ModelOperation
    static void visitClasses(AST self, Visitor<Identifier,List<AST>,List<AST>,AST,List<Heritage>, Map<String,Set<Type>>> visitor) throws IOException {
        Map<String,Set<Type>> callSigs = findCallSignatures(self);
        for (AST ch : self.getChildren()) {
            if (ch.getKind() != SyntaxKind.ClassDeclaration) {
                continue;
            }
            final List<AST> filteredMembers = filteredMembers(ch.getTypeParameters(), true, ch.getMembers(), SyntaxKind.MethodSignature);
            visitor.visit(ch.getName(), ch.getTypeParameters(), filteredMembers, null, ch.getHeritageClauses(), callSigs);
        }
    }

    @ModelOperation
    static void visitModules(AST self, Visitor<Identifier,AST,Void,Void,Void,Void> visitor) throws IOException {
        Map<String,Set<Type>> callSigs = findCallSignatures(self);
        for (AST ch : self.getChildren()) {
            if (ch.getKind() != SyntaxKind.ModuleDeclaration) {
                continue;
            }
            for (AST ast : ch.getBody()) {
                ch.getChildren().addAll(ast.getStatements());
            }
            visitor.visit(ch.getName(), ch, null, null, null, null);
        }
    }

    private static Map<String, AST> findConstructors(AST self) {
        Set<String> constructorClasses = new HashSet<>();
        Map<String,AST> constructors = new TreeMap<>();
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.InterfaceDeclaration) {
                final Type prototype = constructorFor(ch);
                if (prototype != null) {
                    if (prototype.getKind().isTypeNode()) {
                        constructors.put(prototype.getTypeName().getSimpleName(), ch);
                        constructorClasses.add(ch.getName().getSimpleName());
                    }
                }
            }
        }
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.VariableStatement) {
                List<AST> declarations = ch.getDeclarationList().getDeclarations();
                for (AST var : declarations) {
                    final Type type = var.getType();
                    if (type.getKind().isTypeNode()) {
                        final String typeName = type.getTypeName().getSimpleName();
                        String varName = var.getName().getSimpleName();
                        if (Objects.equals(typeName, varName) || constructorClasses.contains(typeName)) {
                            constructors.put(typeName, null);
                        }
                    }
                }
            }
        }
        return constructors;
    }
    private static Map<String, Set<Type>> findCallSignatures(AST self) {
        Map<String,Set<Type>> callSigs = new TreeMap<>();
        for (AST ch : self.getChildren()) {
            if (ch.getKind() == SyntaxKind.InterfaceDeclaration) {
                String name = ch.getName().getSimpleName();
                for (AST f : ch.getMembers()) {
                    if (f.getKind() == SyntaxKind.CallSignature) {
                        Set<Type> calls = callSigs.get(name);
                        if (calls == null) {
                            calls = new HashSet<>();
                            callSigs.put(name, calls);
                        }
                        Type callType = f.getType().clone();
                        for (AST typeParam : ch.getTypeParameters()) {
                            callType.getTypeArguments().add(new Type(typeParam.getKind(), null, typeParam.getName()));
                        }
                        callType.getParameters().addAll(f.getParameters());
                        calls.add(callType);
                    }
                }
            }
        }
        return callSigs;
    }
}
