package com.dukescript.libraries.ap.test.hello;

/*
 * #%L
 * Annotation Processor Tests - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 - 2016 Dukehoff GmbH
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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import net.java.html.lib.Array;
import net.java.html.junit.BrowserRunner;
import net.java.html.lib.Union;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BrowserRunner.class)
public class HelloTest {
    @Test
    public void workWithAnArray() {
        Array<Number> obj = Exports.emptyVector();
        assertNotNull(obj);
        Array<Number> one = Exports.addVector(obj, 1);
        Array<Number> two = Exports.addVector(one, 2);
        assertEquals("Two elements", 2, two.length.call().doubleValue(), 0.1);
        two.push(3.0);
        assertEquals("Three elements", 3, two.length.call().intValue());
    }

    @Test
    public void parametrizedType() throws Exception {
        Type type = Exports.class.getMethod("emptyVector").getGenericReturnType();
        assertTrue("Array has a parameter" + type, type instanceof ParameterizedType);
        ParameterizedType pt = (ParameterizedType) type;
        assertEquals("One type", 1, pt.getActualTypeArguments().length);
        Type first = pt.getActualTypeArguments()[0];
        assertTrue(first instanceof Class);
        assertEquals("Parametrized by number", Number.class, first);
    }

    @Test
    public void ownStringStack() {
        StringStack stack = new StringStack();
        stack.push("World");
        stack.push("Hello");
        assertEquals("HelloWorld", stack.pop() + stack.pop());
    }

    @Test
    public void returnArrayWraper() {
        StringStack stack = new StringStack();
        stack.push("Hi");
        stack.push("World");
        Array<Number> lens = stack.lengths();
        assertNotNull("Lengths found", lens);
        assertEquals("Two items", 2, lens.length.call().intValue());
        assertEquals("two for Hi", 2, lens.$get(0).intValue());
        assertEquals("five for World", 5, lens.$get(1).intValue());
    }

    @Test
    public void nextStack() {
        StringStack stack = new StringStack(new StringStack());
        assertEquals("Ahoj", stack.name.call());
        assertNotNull(stack.next.call());
        assertNull(stack.next.call().next.call());
    }

    @Test
    public void changeStackName() {
        StringStack stack = new StringStack();
        assertEquals("Ahoj", stack.name.call());
        String ret = stack.name.call("Hi");
        assertEquals("Hi", stack.name.call());
        assertEquals("Hi", ret);
    }

    @Test
    public void accessUnionType() {
        assertFalse("Not instance of number", Exports.UnionInitialized.instanceOf(Number.class));
        assertFalse("Not instance of string", Exports.UnionInitialized.instanceOf(String.class));
        assertTrue("instance of boolean", Exports.UnionInitialized.instanceOf(Boolean.class));
        assertEquals(Boolean.TRUE, Exports.UnionInitialized.cast(Boolean.class));
    }

    @Test
    public void complexUnionType() {
        Union.A3<A, B, String> abUnion = Exports.ab;
        A abViewAsA = abUnion.cast(A.class);
        assertNotNull(abViewAsA);
        assertEquals(abViewAsA.getClass(), A.class);
        Union.A3<A, B, String> abaUnion = abViewAsA.b.call();
        B abaViewAsB = abaUnion.cast(B.class);
        Union.A3<A, B, String> abbaUnion = abaViewAsB.a.call();
        Union.A3<A, B, String> terminalUnion = abbaUnion.cast(A.class).b.call();
        assertEquals("Hi", terminalUnion.cast(String.class));
    }
}
