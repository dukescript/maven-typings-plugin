package net.java.html.lib;

/*
 * #%L
 * DukeScript Libraries Processor - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2016 Eppleton IT Consulting
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

public final class Union  {
    /** Casts given object to this class.
     *
     * @param obj any object
     * @return a view of the provided <code>obj</code> object
     */
    public static <T extends Union.A9> T $as(Object value) {
        return (T)new A2() {
            @Override
            public Object cast(Class type) {
                return type.cast(value);
            }

            @Override
            public boolean instanceOf(Class type) {
                return type.isInstance(value);
            }
        };
    }
    /**
     * Function to cast given object to this class. Function that calls
     * {@link #$as(java.lang.Object)}.
     */
    public static final Function.A1<java.lang.Object, Union.A9> $AS = new Function.A1<Object, Union.A9>() {
        @Override
        public Union.A9 call(Object obj) {
            return $as(obj);
        }
    };

    public static abstract class A2<P1, P2> extends A3<P1,P2,Void> {
        A2() {}
    }
    public static abstract class A3<P1, P2, P3> extends A4<P1,P2,P3,Void> {
        A3() {}
    }
    public static abstract class A4<P1, P2, P3, P4> extends A5<P1,P2,P3,P4,Void> {
        A4() {}
    }
    public static abstract class A5<P1, P2, P3, P4, P5> extends A6<P1,P2,P3,P4,P5,Void> {
        A5() {}
    }
    public static abstract class A6<P1, P2, P3, P4, P5, P6> extends A7<P1,P2,P3,P4,P5,P6,Void> {
        A6() {}
    }
    public static abstract class A7<P1, P2, P3, P4, P5, P6, P7> extends A8<P1,P2,P3,P4,P5,P6,P7,Void> {
        A7() {}
    }
    public static abstract class A8<P1, P2, P3, P4, P5, P6, P7, P8> extends A9<P1,P2,P3,P4,P5,P6,P7,P8,Void> {
        A8() {}
    }
    public static abstract class A9<P1, P2, P3, P4, P5, P6, P7, P8, P9> {
        A9() {
        }
        /** Casts the value in this union to requested type.
         *
         * @param <T> the requested type
         * @param type class of the requested type
         * @return value
         * @throws ClassCastException if the value cannot be cast
         */
        public abstract <T> T cast(Class<T> type);

        /** Checks if the current value is instance of given type.
         *
         * @param type the class to assign the value to
         * @return <code>true</code>, if it is, <code>false</code> otherwise
         */
        public abstract boolean instanceOf(Class<?> type);
    }
}
