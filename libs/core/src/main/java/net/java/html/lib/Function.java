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
public class Function extends Objs {
    protected Function(Constructor<?> constructor, java.lang.Object js) {
        super(constructor, js);
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

  public java.lang.Object prototype;
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
  {
    try {
    java.lang.Object[] arr = CoreTypes.readFields$304(Objs.$js(this));
    prototype = (java.lang.Object)arr[0];
    } catch (Exception ex) { ex.printStackTrace(); }
  }
  // constructor FunctionConstructor
  /**
  * Creates a new function.
  * @param args A list of arguments the function accepts.
  */
  public Function(java.lang.String... args) {
    this($AS, CoreTypes.new$305(args));
  }
  public static net.java.html.lib.Function newFunction(java.lang.String... args) {
    return $as(CoreTypes.newFunction$306(args));
  }
  public static net.java.html.lib.Function newFunction(A5<? extends Object,? extends Object,? extends Object,? extends Object,? extends Object,? extends Object> customFunction) {
    return $as(wrap(customFunction));
  }

  //
  // Manual implementation of functions with arity
  //

    public interface A0<R> extends A1<java.lang.Object, R> {

        public R call();

        @Override
        public default R call(java.lang.Object ignore) {
            return call();
        }
    }

    public interface A1<P1, R> extends A2<P1, java.lang.Object, R> {

        public R call(P1 p1);

        @Override
        public default R call(P1 p1, java.lang.Object ignore) {
            return call(p1);
        }
    }

    public interface A2<P1, P2, R> extends A3<P1, P2, java.lang.Object, R> {

        public R call(P1 p1, P2 p2);

        @Override
        public default R call(P1 p1, P2 p2, java.lang.Object ignore) {
            return call(p1, p2);
        }
    }

    public interface A3<P1, P2, P3, R> extends A4<P1, P2, P3, java.lang.Object, R> {

        public R call(P1 p1, P2 p2, P3 p3);

        @Override
        public default R call(P1 p1, P2 p2, P3 p3, java.lang.Object ignore) {
            return call(p1, p2, p3);
        }
    }

    public interface A4<P1, P2, P3, P4, R> extends A5<P1, P2, P3, P4, java.lang.Object, R> {

        public R call(P1 p1, P2 p2, P3 p3, P4 p4);

        @Override
        public default R call(P1 p1, P2 p2, P3 p3, P4 p4, java.lang.Object ignore) {
            return call(p1, p2, p3, p4);
        }
    }

    public interface A5<P1, P2, P3, P4, P5, R> {

        public R call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
    }

    static Object specialJs(Object fn) {
        if (fn instanceof A5) {
            return wrap(fn);
        } else {
            return fn;
        }
    }

    @JavaScriptBody(args = {"fn"}, javacall = true, body
        = "var obj = function(p1, p2, p3, p4, p5) {\n"
        + "  return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)"
        + "(fn, [ p1, p2, p3, p4, p5 ]);\n"
        + "};\n"
        + "return obj;\n"
    )
    private static native Object wrap(Object fn);

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
            ret = callJavaFunction(fn, params);
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
        return Objs.$as(type, obj);
    }

    private static Object[] unJsParams(Class<?> lamda, Object[] params, int length) {
        Class[] found = null;
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

        for (int i = 0; i < length; i++) {
            params[i] = unJS(found == null ? Object.class : found[i], params[i]);
        }
        return params;
    }

    private static Object callJavaFunction(Object fn, Object[] params) {
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
        params = unJsParams(fn.getClass(), params, arity);
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
                    int at = msg.indexOf(cannotBe);
                    if (at >= 0) {
                        String oldName = msg.substring(0, at).trim();
                        String newName = msg.substring(at + cannotBe.length()).trim();
                        if (oldName != null) {
                            for (int i = 0; i < arity; i++) {
                                if (params[i] != null && params[i].getClass().getName().equals(oldName)) {
                                    Object alternative = Objs.$as(newName, params[i]);
                                    if (alternative != params[i]) {
                                        params[i] = alternative;
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
