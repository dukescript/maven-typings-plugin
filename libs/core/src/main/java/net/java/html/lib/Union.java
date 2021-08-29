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

import java.lang.reflect.Type;

public abstract class Union extends Objs {
    Union(Object obj) {
        super($AS, obj);
    }

    private static Constructor<Union> $AS = new Constructor<Union>(Union.class) {
        @Override
        protected Union create(Object any) {
            return new Impl(any, Void.class, Void.class, Void.class, Void.class, Void.class);
        }

        @Override
        protected Union create(Object any, Type... typeParameters) {
            return new Impl(any,
                at(typeParameters, 0),
                at(typeParameters, 1),
                at(typeParameters, 2),
                at(typeParameters, 3),
                at(typeParameters, 4)
            );
        }

        private Class<?> at(Type[] arr, int index) {
            if (arr != null && index < arr.length && arr[index] instanceof Class<?>) {
                return (Class<?>)arr[index];
            }
            return Void.class;
        }
    };

    /** Casts the value in this union to requested type.
     *
     * @param <T> the requested type
     * @param type class of the requested type
     * @return value
     * @throws ClassCastException if the value cannot be cast
     */
    public abstract <T> T cast(Class<T> type);

    /**
     * Checks if the current value can be casted to instance of given type.
     *
     * @param type the class to assign the value to
     * @return <code>true</code>, if it can be casted, <code>false</code> otherwise
     */
    public abstract boolean instanceOf(Class<?> type);

    /** Creates a generic union with value, but no known types.
     *
     * @param value value for the union
     * @return a view of the provided <code>obj</code> object
     */
    public static Union $as(Object value) {
        return $as(value, Void.class, Void.class, Void.class, Void.class, Void.class);
    }
    
    /** Creates an union for provided value and list of known types.
     *
     * @param <A> type a
     * @param <B> type b
     * @param value the actual value of the union
     * @param a class a
     * @param b class b
     * @return union that holds the value and all associated types
     */
    public static <A,B> Union.A2<A,B> $as(Object value, Class<A> a, Class<B> b) {
        return $as(value, a, b, Void.class, Void.class, Void.class);
    }

    /** Creates an union for provided value and list of known types.
     *
     * @param <A> type a
     * @param <B> type b
     * @param <C> type c
     * @param value the actual value of the union
     * @param a class a
     * @param b class b
     * @param c class c
     * @return union that holds the value and all associated types
     */
    public static <A,B,C> Union.A3<A,B,C> $as(Object value, Class<A> a, Class<B> b, Class<C> c) {
        return $as(value, a, b, c, Void.class, Void.class);
    }

    /** Creates an union for provided value and list of known types.
     *
     * @param <A> type a
     * @param <B> type b
     * @param <C> type c
     * @param <D> type d
     * @param value the actual value of the union
     * @param a class a
     * @param b class b
     * @param c class c
     * @param d class d
     * @return union that holds the value and all associated types
     */
    public static <A,B,C,D> Union.A4<A,B,C,D> $as(Object value, Class<A> a, Class<B> b, Class<C> c, Class<D> d) {
        return $as(value, a, b, c, d, Void.class);
    }

    /** Creates an union for provided value and list of known types.
     *
     * @param <A> type a
     * @param <B> type b
     * @param <C> type c
     * @param <D> type d
     * @param <E> type d
     * @param value the actual value of the union
     * @param a class a
     * @param b class b
     * @param c class c
     * @param d class d
     * @param e class e
     * @return union that holds the value and all associated types
     */
    public static <A,B,C,D,E> Union.A5<A,B,C,D,E> $as(Object value, Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e) {
        return new Impl<>(value, a, b, c, d, e);
    }

    public static abstract class A2<P1, P2> extends Union {
        A2(Object value) {
            super(value);
        }
    }
    public static abstract class A3<P1, P2, P3> extends A2<P1,P2> {
        A3(Object value) {
            super(value);
        }
    }
    public static abstract class A4<P1, P2, P3, P4> extends A3<P1,P2,P3> {
        A4(Object value) {
            super(value);
        }
    }
    public static abstract class A5<P1, P2, P3, P4, P5> extends A4<P1,P2,P3,P4> {
        A5(Object value) {
            super(value);
        }
    }

    private static final class Impl<P1, P2, P3, P4, P5> extends A5<P1, P2, P3, P4, P5> {
        public Impl(Object value, Class<P1> a, Class<P2> b, Class<P3> c, Class<P4> d, Class<P5> e) {
            super(value);
        }

        @Override
        public <T> T cast(Class<T> type) {
            return Objs.$as(type, this);
        }

        @Override
        public boolean instanceOf(Class<?> type) {
            return type.isInstance($js(this)) || Objs.class.isAssignableFrom(type);
        }
    }
}
