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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTest {
    private static AST ast;

    public ParserTest() {
    }

    @BeforeClass
    public static void initializeParser() throws Exception {
        Parser p = new Parser();

        InputStream is = p.getClass().getClassLoader().getResourceAsStream("com/dukescript/libraries/proc/lib.core.d.ts");
        assertNotNull(is);

        ast = p.parse("lib.core.d.ts", is);
        assertNotNull(ast, "AST created");
    }

    @Test
    public void searchForFields() throws Exception {
        final AST first = ast.getChildren().get(0);
        assertEquals(first.getKind(), SyntaxKind.VariableStatement, "First object is variable");
        List<AST> declarations = first.getDeclarationList().getDeclarations();
        assertEquals(declarations.size(), 1, "One declaration");
        AST var = declarations.get(0);
        assertEquals(var.getName().getSimpleName(), "NaN", "not a number is the name");
        assertEquals(var.getType().getKind(), SyntaxKind.NumberKeyword);

        class Fields implements Visitor<Identifier, Type, Set<Type>, Void, String, Void> {
            Map<String,Type> found = new LinkedHashMap<>();

            @Override
            public void visit(Identifier a, Type b, Set<Type> c, Void d, String e, Void f) {
                Type prev = found.put(a.getSimpleName(), b);
                assertNull(prev, "No previous value");
            }
        }

        Fields visitor = new Fields();
        ast.visitFields(visitor);

        Map.Entry<String, Type> field1 = visitor.found.entrySet().iterator().next();
        assertEquals(field1.getKey(), "NaN", "not a number");
        assertEquals(field1.getValue().getKind(), SyntaxKind.NumberKeyword);

        Type objectType = visitor.found.get("Object");
        assertNull(objectType, "Field with ObjectConstructor type not visited");
    }

    @Test
    public void searchForFunctions() {
        class Functions implements Visitor<Identifier, Type, List<Parameter>, List<AST>, String, Void> {
            Map<String,List<Parameter>> found = new LinkedHashMap<>();
            @Override
            public void visit(Identifier a, Type b, List<Parameter> c, List<AST> d, String e, Void ignore) {
                List<Parameter> prev = found.put(a.getSimpleName(), c);
                assertNull(prev, "No previous value");
            }
        }
        Functions f = new Functions();
        ast.visitFunctions(f);
        assertEquals(f.found.get("eval").get(0).getType().getKind(), SyntaxKind.StringKeyword);

        List<Parameter> parseInt = f.found.get("parseInt");
        assertEquals(parseInt.size(), 2, "Two parameters");
        assertFalse(parseInt.get(0).isOptional(), "First is not optional");
        assertTrue(parseInt.get(1).isOptional(), "Second is optional");
    }

    @Test
    public void searchForErrorDefinition() {
        class Interfaces implements Visitor<Identifier, List<AST>, List<AST>, AST, List<Heritage>, Map<String,Set<Type>>> {
            boolean found;
            List<AST> properties;
            AST constructor;
            List<Heritage> heritages;
            @Override
            public void visit(Identifier a, List<AST> c, List<AST> d, AST constructor, List<Heritage> herigateClauses, Map<String,Set<Type>> ignore) throws IOException {
                final String name = a.getSimpleName();
                if (name.endsWith("Constructor")) {
                    fail("There should be no constructors in the interfaces: " + name);
                }
                if ("Error".equals(name)) {
                    assertFalse(found, "Just one error");
                    found = true;
                    this.properties = d;
                    this.constructor = constructor;
                }
                if ("TypeError".equals(name)) {
                    this.heritages = herigateClauses;
                }
            }
        }
        Interfaces interfaces = new Interfaces();
        ast.visitInterfaces(interfaces);
        assertTrue(interfaces.found, "Interfaces found");
        assertEquals(interfaces.properties.size(), 2, "Two props");
        assertEquals(interfaces.properties.get(0).getName().getSimpleName(), "name", "1st name is name");
        assertEquals(interfaces.properties.get(1).getName().getSimpleName(), "message", "2nd name is messsage");
        assertNotNull(interfaces.constructor, "Constructor class reference provided");
        assertNotNull(interfaces.heritages);
        assertEquals(interfaces.heritages.size(), 1, "One element: " + interfaces.heritages);
        assertEquals("Error", interfaces.heritages.get(0).getTypes().get(0).getExpression().get(0).getText());
    }

    @Test
    public void oneConcatInArray() {
        class SeekArray implements Visitor<Identifier, List<AST>, List<AST>, AST, List<Heritage>, Map<String,Set<Type>>> {
            List<AST> array;
            @Override
            public void visit(Identifier a, List<AST> parameterTypes, List<AST> members, AST constructor, List<Heritage> herigateClauses, Map<String,Set<Type>> ignore) throws IOException {
                final String name = a.getSimpleName();
                if (name.equals("Array")) {
                    assertNull(array, "Just one definition of Array expected");
                    array = members;
                }
            }
        }
        SeekArray interfaces = new SeekArray();
        ast.visitInterfaces(interfaces);
        assertNotNull(interfaces.array, "Array found");
        int concatCount = 0;
        int spliceCount = 0;
        StringBuilder found = new StringBuilder();
        for (AST m : interfaces.array) {
            found.append(m.getName()).append("\n");
            if (m.getName() != null && "concat".equals(m.getName().getSimpleName())) {
                concatCount++;
            }
            if (m.getName() != null && "splice".equals(m.getName().getSimpleName())) {
                spliceCount++;
            }
        }
        assertEquals(concatCount, 1, "One concat method found: " + found);
        assertEquals(spliceCount, 2, "Two splice methods found: " + found);
    }

    @Test
    public void arrayConstructors() {
        class SeekArray implements Visitor<Identifier, List<AST>, List<AST>, AST, List<Heritage>, Map<String,Set<Type>>> {
            AST arrayConstructor;
            @Override
            public void visit(Identifier a, List<AST> parameterTypes, List<AST> members, AST constructor, List<Heritage> herigateClauses, Map<String,Set<Type>> ignore) throws IOException {
                final String name = a.getSimpleName();
                if (name.equals("Array")) {
                    assertNull(arrayConstructor, "Just one definition of Array expected");
                    arrayConstructor = constructor;
                }
            }
        }
        SeekArray interfaces = new SeekArray();
        ast.visitInterfaces(interfaces);
        assertNotNull(interfaces.arrayConstructor, "Array found");
        
        List<AST> constructors = new ArrayList<>();
        for (AST m : interfaces.arrayConstructor.getMembers()) {
            if (m.getKind() != SyntaxKind.ConstructSignature) {
                continue;
            }
            constructors.add(m);
        }
        assertEquals(constructors.size(), 2, "Two constructors found");
        final List<Parameter> first = constructors.get(0).getParameters();
        assertEquals(first.size(), 1, "One argument 1st");
        final List<Parameter> second = constructors.get(1).getParameters();
        assertEquals(second.size(), 1, "One argument 2nd");
        assertNotEquals(second.get(0).isOptional(), second.get(0).isVararg(), "One vararg" + second);
        assertNotEquals(first.get(0).isOptional(), first.get(0).isVararg(), "One optional" + first);
    }

    private static void assertNotNull(Object obj) {
        Assert.assertNotNull(obj);
    }
    private static void assertNotNull(Object obj, String msg) {
        Assert.assertNotNull(msg, obj);
    }
    private static void assertNull(Object obj) {
        Assert.assertNull(obj);
    }
    private static void assertNull(Object obj, String msg) {
        Assert.assertNull(msg, obj);
    }

    private void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(expected, actual);
    }
    private static void assertEquals(Object actual, Object expected, String msg) {
        Assert.assertEquals(msg, expected, actual);
    }
    private static void assertNotEquals(Object actual, Object expected, String msg) {
        Assert.assertNotEquals(msg, expected, actual);
    }

    private static void assertFalse(boolean value, String msg) {
        Assert.assertFalse(msg, value);
    }

    private void assertTrue(boolean value, String msg) {
        Assert.assertTrue(msg, value);
    }
}
