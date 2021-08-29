package net.java.html.lib;

import java.lang.reflect.Type;

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
public class Error extends net.java.html.lib.Objs {
    protected Error(Constructor<?> constructor, java.lang.Object js) {
        this(constructor, js, (Type[])null);
    }

    /**
     * @since 0.20
     */
    protected Error(Constructor<?> constructor, java.lang.Object js, Type... typeParameters) {
        super(constructor, js, typeParameters);
    }

    /**
     * Casts given object to this class.
     *
     * @param obj any object
     * @return a view of the provided <code>obj</code> object
     */
    public static Error $as(java.lang.Object obj) {
      return obj == null ? null : new Error($AS, obj);
    }
    /**
     * Function to cast given object to this class. Function that calls
     * {@link #$as(java.lang.Object)}.
     */
    private static final Constructor<Error> $AS = new Constructor<Error>(Error.class) {
      @Override
      protected Error create(Object any) {
          return $as(any);
      }
    };
    
  public Property<java.lang.String> name = Property.create(this, String.class, "name");
  public Property<java.lang.String> message = Property.create(this, String.class, "message");
  // constructor ErrorConstructor
  public static Error prototype = Error.$as(CoreTypes.readStaticFields$131());
  public Error(java.lang.String message) {
    this($AS, CoreTypes.new$182(message));
  }
  public Error() {
    this($AS, CoreTypes.new$183());
  }
  public static Error newError(java.lang.String message) {
    return (Error)CoreTypes.newError$184(message);
  }
  public static Error newError() {
    return (Error)CoreTypes.newError$185();
  }
}
