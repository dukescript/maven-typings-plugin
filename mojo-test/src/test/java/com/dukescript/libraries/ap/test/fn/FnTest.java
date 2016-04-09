package com.dukescript.libraries.ap.test.fn;

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

import net.java.html.lib.Function;
import net.java.html.lib.Objs;
import net.java.html.junit.BrowserRunner;
import net.java.html.lib.Union;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BrowserRunner.class)
public class FnTest {
    @Test
    public void workWithFunctions() {
        Function.A1<Integer,Integer> f = Math::abs;
        Function.A1<Integer,String> g = Integer::toHexString;
        Function.A1<Integer, ? extends String> h = Exports.compose(f, g);

        assertEquals("ff", h.call(255));

        Function raw = (Function) h;
        assertEquals("f", raw.apply(null, 15));
    }


    @Test
    public void functionWithProperties() {
        Objs obj = Exports.fn;
        assertNotNull("fn", obj);
        assertEquals(42, obj.$get("fourtyTwo"));
        assertEquals("Hi", Exports.fn());
        assertEquals("Length4", Exports.fn(4));
    }

    @Test
    public void typedFunctionWithProperties() {
        FnT obj = Exports.fnT;
        assertNotNull("fnT", obj);
        assertEquals(42, obj.fourtyTwo.call());
        assertEquals("Hi", Exports.fnT());
//        assertEquals("Length4", Exports.fnT(4));
    }

    @Test
    public void typedFunctionWithPropertiesOnObject() {
        FnT obj = Exports.fnT;
        assertNotNull("fnT", obj.FnT);
        assertEquals(42, obj.FnT.call().fourtyTwo.call());
        assertEquals("Hi", obj.FnT());
//        assertEquals("Length4", Exports.fnT(4));
    }

    @Test
    public void firstAsNumber() {
        FnT obj = Exports.fnT;
        assertEquals(42.1, obj.first(42.1), 0.1);
    }
    @Test
    public void firstAsString() {
        FnT obj = Exports.fnT;
        assertEquals(obj.first("Hi"), "Hi");
    }
    @Test
    public void notifyWithOneParam() {
        Rev rev = Exports.rev;
        Number n = rev.notify(33);
        assertEquals(42, n.intValue());
    }

    @Test
    public void stringLiteralBoolean() {
        boolean b = Exports.literal((Boolean)null);
        assertTrue(b);
    }

    @Test
    public void stringLiteralNumber() {
        double d = Exports.literal((Number)null);
        assertEquals(1.0, d, 0.1);
    }

    @Test
    public void stringLiteralDefault() {
        Object any = Exports.literal("any");
        assertEquals(Boolean.FALSE, any);
    }

    @Test
    public void scopeCompute() {
        Number n = Exports.scope.$compute((Object p1) -> 42);
        assertEquals(42, n.intValue());
    }

    @Test
    public void trippleTest() {
        Object[] arr = Exports.tripple();
        assertEquals(3, arr.length);
        assertTrue(arr[0] instanceof Number);
        assertTrue(arr[1] instanceof String);
        assertTrue(arr[2] instanceof Boolean);
    }

    @Test
    public void oneFnString() {
        Union.A2<String, Number> value = Exports.oneFn("one");
        assertEquals("one", value.cast(String.class));
    }

    @Test
    public void oneFnNumber() {
        Union.A2<String, Number> value = Exports.oneFn(1);
        assertEquals("One is returned", 1.0, (double) value.cast(Number.class), 0.1);
    }

    @Test
    public void oneOf() {
        Object value = Exports.oneOf.cast(String.class);
        assertEquals("two", value);
    }
}
