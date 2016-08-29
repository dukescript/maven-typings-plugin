package net.java.html.lib;

/*
 * #%L
 * DukeScript Libraries - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static net.java.html.lib.Exports.*;
import net.java.html.junit.BrowserRunner;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BrowserRunner.class)
public class LibCoreTest {
    public LibCoreTest() {
    }

    @Test
    public void testEval() throws Exception {
        final Object fourtyTwo = eval("6 * 7");
        assertTrue(fourtyTwo instanceof Number, "The result is number: " + fourtyTwo);
        assertNumber((Number) fourtyTwo, 42, "Fourty two");
    }

    @Test
    public void testEvalObject() throws Exception {
        final Object obj = eval("var x = {}; x.x = 'Hi'; x");
        assertNotNull("Value returned", obj);
        assertTrue(obj instanceof Objs, "The result is Objs: " + obj.getClass());
        Objs js = (Objs) obj;
        assertEquals(js.$get("x"), "Hi", "Has property x");
    }

    @Test
    public void uri() throws Exception {
        final java.lang.String url = "http://dukescript.com";
        java.lang.String encoded = encodeURIComponent(url);
        assertEquals(encoded.indexOf("/"), -1, "Really encoded: " + encoded);
        assertEquals(decodeURIComponent(encoded), url);
    }

    @Test
    public void optionalParams() throws Exception {
        double fifteen1 = parseInt("0xF");
        double fifteen2 = parseInt("F", 16);
        assertEquals(fifteen1, fifteen2);
    }

    @Test
    public void nan() throws Exception {
        double nan = NaN;
        assertTrue(isNaN(nan), "Really not a number");
    }

    @Test
    public void json() throws Exception {
        java.lang.Object json = JSON.parse("{ \"world\" : 42 }");
        java.lang.String result = JSON.stringify(json);
        assertTrue(result.contains("world"), "has world: " + result);
        assertTrue(result.contains("42"), "has 42: " + result);
    }

    @Test
    public void arrayOfAndSubArray() throws Exception {
        Int8Array value = new Int8Array(3);
        assertEquals(value.length.get().doubleValue(), 3.0, 0.1, "Length is 3");
    }

    @Test
    public void dateOperation() throws Exception {
        Date eleven = new Date(2016, 1, 10);
        assertEquals(2016.0, eleven.getFullYear());
        assertEquals(1.0, eleven.getMonth());
    }

    @Test
    public void dateHasObjectMethod() throws Exception {
        Method hasOwnProperty = Date.class.getMethod("hasOwnProperty", java.lang.String.class);
        assertEquals(hasOwnProperty.getReturnType(), java.lang.Boolean.class);
        assertEquals(hasOwnProperty.getDeclaringClass(), /* not java.lang */ Objs.class);
    }

    @Test
    public void parseInJSONIsStatic() throws Exception {
        Method parse = JSON.class.getMethod("parse", java.lang.String.class);
        assertEquals(parse.getReturnType(), java.lang.Object.class);
        assertTrue((parse.getModifiers() & Modifier.STATIC) != 0, "parse is static");
    }

    @Test
    public void strigifyJSONWithString() throws Exception {
        Method parse = JSON.class.getMethod("stringify", java.lang.Object.class, java.lang.Object[].class, java.lang.String.class);
        assertEquals(parse.getReturnType(), java.lang.String.class);
        assertTrue((parse.getModifiers() & Modifier.STATIC) != 0, "stringify is static");
    }

    @Test
    public void strigifyJSONWithNumber() throws Exception {
        Method parse = JSON.class.getMethod("stringify", java.lang.Object.class, java.lang.Object[].class, double.class);
        assertEquals(parse.getReturnType(), java.lang.String.class);
        assertTrue((parse.getModifiers() & Modifier.STATIC) != 0, "stringify is static");
    }

    @Test
    public void intArraySetDouble() throws Exception {
        Method set = Uint32Array.class.getMethod("set", double.class, double.class);
        assertEquals(set.getReturnType(), void.class);
    }

    @Test
    public void intArraySetArrayLike() throws Exception {
        Method set = Uint32Array.class.getMethod("set", ArrayLike.class);
        assertEquals(set.getReturnType(), void.class);
    }

    @Test
    public void intArraySetArrayLikeIndex() throws Exception {
        Method set = Uint32Array.class.getMethod("set", ArrayLike.class, double.class);
        assertEquals(set.getReturnType(), void.class);
    }

    @Test
    public void typeErrorIsAnError() throws Exception {
        TypeError te = new TypeError("an error");
        Error error = te;
        assertEquals(te, error, "Assigned");
        assertEquals(error.message.get(), "an error");
        assertEquals(error.name.get(), "TypeError");
    }

    @Test
    public void setGetProperties() throws Exception {
        Objs obj = new Objs().
            $set("key", "value").
            $set("key2", "value2");

        assertEquals(obj.$get("key"), "value");
        assertEquals(obj.$get("key2"), "value2");

        obj.$delete("key2");

        assertEquals(obj.$get("key"), "value");
        assertNotEquals(obj.$get("key2"), "value2");
    }

    @Test
    public void toStringSync() throws Exception {
        Objs objs = new Objs();
        assertNotNull(objs.toString());
    }

    @Test
    public void toStringASync() throws Exception {
        Objs objs = new Objs();
        String[] res = { null };
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    res[0] = objs.toString();
                }
            };
            t.start();
            t.join();
        } catch (SecurityException ex) {
            // bck2brwsr doesn't support threads, skip the test
            return;
        }
        assertNotNull(res[0]);
    }

    @Test
    public void arrayForEach() throws Exception {
        Array<java.lang.Number> arr = new Array<>();
        assertNumber(arr.length.get(), 0.0, "Empty at first");
        arr.push(1.1, 2.2, 3);
        assertNumber(arr.$get(0), 1.1, "1.1 is on position 0");
        assertNumber(arr.$get(1), 2.2, "2.2 is on position 1");
        assertNumber(arr.$get(2), 3.0, "3 is on position 2");
        boolean[] called = { false };
        double[] sum = { 0.0 };
        arr.forEach(new net.java.html.lib.Function.A1<java.lang.Number,Void>() {
            @Override
            public Void call(java.lang.Number p1) {
                called[0] = true;
                sum[0] += p1.doubleValue();
                return null;
            }
        });
        assertTrue(called[0], "forEach invoked");
        assertEquals(sum[0], 6.3, 0.1, "Sum computed");
    }

    @Test
    public void keysForEach() throws Exception {
        Objs obj = new Objs();
        for (String key : Objs.keys(obj)) {
            fail("No key expected in an empty object: " + key);
        }
        obj.$set("hi", "there");
        obj.$set("hello", "world");
        int cnt = 0;
        for (String key : Objs.keys(obj)) {
            assertTrue("hi".equals(key) || "hello".equals(key), "Key is expected: " + key);
            cnt++;
        }
        assertEquals(cnt, 2, "Two keys");
    }

    private static void assertTrue(boolean cond, String msg) {
        Assert.assertTrue(msg, cond);
    }

    private static void assertEquals(double a, double b, double c, String msg) {
        Assert.assertEquals(msg, b, a, c);
    }

    private static void assertEquals(Object actual, Object expected, String msg) {
        Assert.assertEquals(msg, expected, actual);
    }
    private static void assertNumber(Number actual, double expected, String msg) {
        Assert.assertEquals(msg, expected, actual.doubleValue(), 0.01);
    }
    private static void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(expected, actual);
    }
}
