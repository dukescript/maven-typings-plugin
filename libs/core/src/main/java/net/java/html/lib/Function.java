package net.java.html.lib;

import java.lang.reflect.Method;
import net.java.html.js.JavaScriptBody;

/*
 * #%L
 * ES6 Core Library - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 - 2016 Dukehoff GmbH
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
/** Wrapper around JavaScript function.
 */
public class Function extends Objs {
    protected Function(Constructor<?> constructor, java.lang.Object js) {
        super(constructor, js);
    }
    Function(Constructor<?> constructor) {
        super(constructor);
    }

    private static final Constructor<Function> $AS = new Constructor<Function>(Function.class) {
        @Override
        protected Function create(Object any) {
            return any == null ? null : new JSFn(this, any);
        }
    };
    /**
     * Casts given object to this class.
     *
     * @param obj any object
     * @return a view of the provided <code>obj</code> object
     */
    public static Function $as(java.lang.Object obj) {
        return $AS.create(obj);
    }

  public final Property<Objs> prototype = Property.create(this, Objs.class, "prototype");
  public final Property<java.lang.Number> length = Property.create(this, java.lang.Number.class, "length");
  /**
  * Calls the function, substituting the specified object for the this value of the function, and the specified array for the arguments of the function.
  * @param thisArg The object to be used as the this object.
  * @param argArray A set of arguments to be passed to the function.
  */
  public java.lang.Object apply(java.lang.Object thisArg, java.lang.Object... argArray) {
    argArray = argArray.clone();
    for (int i = 0; i < argArray.length; i++) {
        argArray[i] = Objs.$js(argArray[i]);
    }
    return CoreTypes.apply$300(Objs.$js(this), /* AnyKeyword*/Objs.$js(thisArg), argArray);
  }
  /**
  * For a given function, creates a bound function that has the same body as the original function.
  * The this object of the bound function is associated with the specified object, and has the specified initial parameters.
  * @param thisArg An object to which the this keyword can refer inside the new function.
  * @param argArray A list of arguments to be passed to the new function.
  */
  public java.lang.Object bind(java.lang.Object thisArg, java.lang.Object... argArray) {
    return CoreTypes.bind$302(Objs.$js(this), /* AnyKeyword*/Objs.$js(thisArg), argArray);
  }
  
  /**
     * Creates a new function.
     *
     * @param args a list of arguments the function accepts followed by function's body
     */
    public Function(java.lang.String... args) {
        this($AS, CoreTypes.new$305(args));
    }

    /** Calls the {@link #Function(java.lang.String...) constructor}.
     *
     * @param args a list of arguments the function accepts followed by function's body
     * @return new instance of the function
     */
    public static Function newFunction(String... args) {
        return new Function(args);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object. One can specify argument types of individual parameters.
     *
     * @param <A> type of parameter A
     * @param fn implementation of the function to wrap
     * @param argTypeA class of parameter A
     * @return instance wrapping the JavaScript representation of the function
     */
    public static <A> net.java.html.lib.Function newFunction(
        A1<? super A, ? extends Object> fn,
        Class<A> argTypeA
    ) {
        return new JavaFn($AS, fn, argTypeA);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object. One can specify argument types of individual parameters.
     *
     * @param <A> type of parameter A
     * @param <B> type of parameter B
     * @param fn implementation of the function to wrap
     * @param argTypeA class of parameter A
     * @param argTypeB class of parameter B
     * @return instance wrapping the JavaScript representation of the function
     */
    public static <A, B> net.java.html.lib.Function newFunction(
        A2<? super A, ? super B, ? extends Object> fn,
        Class<A> argTypeA, Class<B> argTypeB
    ) {
        return new JavaFn($AS, fn, argTypeA, argTypeB);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object. One can specify argument types of individual parameters.
     *
     * @param <A> type of parameter A
     * @param <B> type of parameter B
     * @param <C> type of parameter C
     * @param fn implementation of the function to wrap
     * @param argTypeA class of parameter A
     * @param argTypeB class of parameter B
     * @param argTypeC class of parameter C
     * @return instance wrapping the JavaScript representation of the function
     */
    public static <A, B, C> net.java.html.lib.Function newFunction(
        A3<? super A, ? super B, ? super C, ? extends Object> fn,
        Class<A> argTypeA, Class<B> argTypeB, Class<C> argTypeC
    ) {
        return new JavaFn($AS, fn, argTypeA, argTypeB, argTypeC);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object. One can specify argument types of individual parameters.
     *
     * @param <A> type of parameter A
     * @param <B> type of parameter B
     * @param <C> type of parameter C
     * @param <D> type of parameter D
     * @param fn implementation of the function to wrap
     * @param argTypeA class of parameter A
     * @param argTypeB class of parameter B
     * @param argTypeC class of parameter C
     * @param argTypeD class of parameter D
     * @return instance wrapping the JavaScript representation of the function
     */
    public static <A, B, C, D> net.java.html.lib.Function newFunction(
        A4<? super A, ? super B, ? super C, ? super D, ? extends Object> fn,
        Class<A> argTypeA, Class<B> argTypeB, Class<C> argTypeC, Class<D> argTypeD
    ) {
        return new JavaFn($AS, fn, argTypeA, argTypeB, argTypeC, argTypeD);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object. One can specify argument types of individual parameters.
     *
     * @param <A> type of parameter A
     * @param <B> type of parameter B
     * @param <C> type of parameter C
     * @param <D> type of parameter D
     * @param <E> type of parameter E
     * @param fn implementation of the function to wrap
     * @param argTypeA class of parameter A
     * @param argTypeB class of parameter B
     * @param argTypeC class of parameter C
     * @param argTypeD class of parameter D
     * @param argTypeE class of parameter E
     * @return instance wrapping the JavaScript representation of the function
     */
    public static <A, B, C, D, E> net.java.html.lib.Function newFunction(
        A5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends Object> fn,
        Class<A> argTypeA, Class<B> argTypeB, Class<C> argTypeC, Class<D> argTypeD, Class<E> argTypeE
    ) {
        return new JavaFn($AS, fn, argTypeA, argTypeB, argTypeC, argTypeD, argTypeE);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object.
     *
     * @param fn the implementation of the function
     * @return instance wrapping the JavaScript representation of the function
     */
    public static net.java.html.lib.Function newFunction(
        A5<? extends Object, ? extends Object, ? extends Object, ? extends Object, ? extends Object, ? extends Object> fn
    ) {
        return new JavaFn($AS, fn, (Class[]) null);
    }

    /**
     * Factory method that wraps provided function interface into JavaScript
     * function object. One can specify argument types of individual parameters.
     *
     * @param fn the implementation of the function
     * @param argTypes array with classes of the arguments
     * @return instance wrapping the JavaScript representation of the function
     */
    public static net.java.html.lib.Function newFunction(
        A5<? extends Object, ? extends Object, ? extends Object, ? extends Object, ? extends Object, ? extends Object> fn,
        Class[] argTypes
    ) {
        return new JavaFn($AS, fn, argTypes);
    }

  //
  // Manual implementation of functions with arity
  //

    /** Java function with no arguments. */
    public interface A0<R> extends A1<java.lang.Object, R> {

        public R call();

        @Override
        public default R call(java.lang.Object ignore) {
            return call();
        }
    }

    /** Java function with one argument. */
    public interface A1<P1, R> extends A2<P1, java.lang.Object, R> {

        public R call(P1 p1);

        @Override
        public default R call(P1 p1, java.lang.Object ignore) {
            return call(p1);
        }
    }

    /** Java function with two arguments. */
    public interface A2<P1, P2, R> extends A3<P1, P2, java.lang.Object, R> {

        public R call(P1 p1, P2 p2);

        @Override
        public default R call(P1 p1, P2 p2, java.lang.Object ignore) {
            return call(p1, p2);
        }
    }

    /** Java function with three arguments. */
    public interface A3<P1, P2, P3, R> extends A4<P1, P2, P3, java.lang.Object, R> {

        public R call(P1 p1, P2 p2, P3 p3);

        @Override
        public default R call(P1 p1, P2 p2, P3 p3, java.lang.Object ignore) {
            return call(p1, p2, p3);
        }
    }

    /** Java function with four arguments. */
    public interface A4<P1, P2, P3, P4, R> extends A5<P1, P2, P3, P4, java.lang.Object, R> {

        public R call(P1 p1, P2 p2, P3 p3, P4 p4);

        @Override
        public default R call(P1 p1, P2 p2, P3 p3, P4 p4, java.lang.Object ignore) {
            return call(p1, p2, p3, p4);
        }
    }

    /** Java function with five arguments. */
    public interface A5<P1, P2, P3, P4, P5, R> {

        public R call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
    }

    static Object specialJs(Object fn) {
        if (fn instanceof A5) {
            fn = new JavaFn($AS, (A5<?, ?, ?, ?, ?, ?>) fn, (Class[])null);
            return Objs.$js(fn);
        } else {
            return fn;
        }
    }

    /** Invokes an object that represents a function - e.g. {@link A0},
     * {@link A1}, etc.
     *
     * @param fn the object representing a function
     * @param params parameters to pass to the function
     * @return value returned by the function
     * @throws IllegalArgumentException if the object <code>fn</code> isn't a function
     */
    public static Object $call(Object fn, Object... params) {
        Object ret;
        if (fn instanceof A5) {
            ret = callJavaFunction((A5)fn, params, null);
        } else {
            ret = callFunction(fn, params);
        }
        return unJS(Object.class, ret);
    }

    @JavaScriptBody(args = {"obj"}, body = "return typeof obj == 'function';")
    private static native boolean isFunction(Object obj);

    @JavaScriptBody(args = {"fn", "params"}, body = "return fn.apply(null, params);")
    private static native Object callFunction(Object fn, Object[] params);

    private static Object unJS(Class<?> type, Object obj) {
        if (isFunction(obj)) {
            return new JSFn($AS, obj);
        }
        return Objs.$asRaw(type, obj);
    }

    private static Object[] unJsParams(JavaFn wrapper, Class<?> lamda, Object[] params, int length) {
        Class[] found = wrapper == null ? null : wrapper.types;
        if (found == null) {
            OUTER: for (Method m : lamda.getDeclaredMethods()) {
                if (!m.getName().equals("call")) {
                    continue;
                }
                Class[] paramTypes = m.getParameterTypes();
                if (paramTypes.length != length) {
                    continue;
                }
                for (Class<?> param : m.getParameterTypes()) {
                    if (param != Object.class) {
                        found = paramTypes;
                        break OUTER;
                    }
                }
            }
            if (wrapper != null && found != null) {
                wrapper.types = found;
            }
        }

        for (int i = 0; i < length; i++) {
            Class<?> typeAt = found == null ? null : found[i];
            params[i] = unJS(typeAt == null ? Object.class : typeAt, params[i]);
        }
        return params;
    }

    private static Object callJavaFunction(A5 fn, Object[] params, JavaFn wrapper) {
        int arity;
        if (fn instanceof A0) {
            return ((A0)fn).call();
        } else if (fn instanceof A1) {
            arity = 1;
        } else if (fn instanceof A2) {
            arity = 2;
        } else if (fn instanceof A3) {
            arity = 3;
        } else if (fn instanceof A4) {
            arity = 4;
        } else {
            arity = 5;
        }
        Object ret;
        params = unJsParams(wrapper, fn.getClass(), params, arity);
        AGAIN: for (;;) {
            try {
                switch (arity) {
                    case 1:
                        ret = ((A1)fn).call(params[0]);
                        break;
                    case 2:
                        ret = ((A2)fn).call(params[0], params[1]);
                        break;
                    case 3:
                        ret = ((A3)fn).call(params[0], params[1], params[2]);
                        break;
                    case 4:
                        ret = ((A4)fn).call(params[0], params[1], params[2], params[3]);
                        break;
                    default:
                        ret = ((A5)fn).call(params[0], params[1], params[2], params[3], params[4]);
                        break;
                }
                break;
            } catch (ClassCastException ex) {
                int depth = ex.getStackTrace().length;
                int currentDepth = new Exception().getStackTrace().length;
                if (depth == currentDepth) {
                    String msg = ex.getMessage();
                    final String cannotBe = "cannot be cast to";
                    int at = msg == null ? -1 : msg.indexOf(cannotBe);
                    if (at >= 0) {
                        String oldName = msg.substring(0, at).trim();
                        String newName = msg.substring(at + cannotBe.length()).trim();
                        if (oldName != null) {
                            for (int i = 0; i < arity; i++) {
                                if (params[i] != null && params[i].getClass().getName().equals(oldName)) {
                                    Object alternative = Objs.$as(newName, params[i]);
                                    if (alternative != params[i]) {
                                        params[i] = alternative;
                                        if (wrapper != null) {
                                            assert alternative.getClass().getName().equals(newName);
                                            wrapper.types[i] = alternative.getClass();
                                        }
                                        continue AGAIN;
                                    }
                                }
                            }
                        }
                    }
                }
                throw ex;
            }
        }
        return Objs.$js(ret);
    }

    private static final class JavaFn extends Function {
        private final A5<?,?,?,?,?,?> delegate;
        private Class[] types;

        JavaFn(Constructor<?> c, A5<?,?,?,?,?,?> delegate, Class... types) {
            super(c);
            this.delegate = delegate;
            this.types = types;
        }

        @Override
        Object createJS() {
            return wrap(this);
        }

        @Override
        public Object apply(Object thisArg, Object... argArray) {
            return callJavaFunction(delegate, argArray, this);
        }

        @JavaScriptBody(args = {"fn"}, javacall = true, body
            = "var obj = function(p1, p2, p3, p4, p5) {\n"
            + "  return fn.@net.java.html.lib.Function::apply(Ljava/lang/Object;[Ljava/lang/Object;)"
            + "(null, [ p1, p2, p3, p4, p5 ]);\n"
            + "};\n"
            + "return obj;\n"
        )
        private static native Object wrap(JavaFn fn);
    }

    private static final class JSFn extends Function implements A0<Object> {
        JSFn(Constructor<?> c, Object obj) {
            super(c, obj);
        }

        @Override
        public Object call(Object p1, Object p2, Object p3, Object p4, Object p5) {
            Object ret = call0(Objs.$js(this), null, new Object[]{p1, p2, p3, p4, p5});
            return unJS(Object.class, ret);
        }

        @JavaScriptBody(args = {"fn", "thiz", "params"}, body = "return fn.apply(thiz, params);")
        private static native Object call0(Object fn, Object thiz, Object[] params);

        @Override
        public Object call() {
            return call(null, null, null, null, null);
        }

        @Override
        public Object call(Object p1) {
            return call(p1, null, null, null, null);
        }

        @Override
        public Object call(Object p1, Object p2) {
            return call(p1, p2, null, null, null);
        }

        @Override
        public Object call(Object p1, Object p2, Object p3) {
            return call(p1, p2, p3, null, null);
        }

        @Override
        public Object call(Object p1, Object p2, Object p3, Object p4) {
            return call(p1, p2, p3, p4, null);
        }
    } // end of JSFn

}
