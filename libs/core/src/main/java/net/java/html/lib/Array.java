package net.java.html.lib;

import java.lang.reflect.Type;
import java.util.Iterator;
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
public class Array<T> extends Objs implements java.lang.Iterable<T> {
    private final Class<T> typeParameter;

    protected Array(Constructor<?> constructor, java.lang.Object js) {
        this(constructor, js, null);
    }

    /** Construct an array with possibly known element type.
     *
     * @param constructor the constructor
     * @param js the JavaScript object to represent
     * @param elementType type of element to check for
     * @since 0.20
     */
    protected Array(Constructor<?> constructor, java.lang.Object js, Class<?> elementType) {
        super(constructor, js);
        this.typeParameter = (Class<T>) elementType;
    }

    private static final class $Constructor extends net.java.html.lib.Objs.Constructor<Array> {
        $Constructor() {
            super(Array.class);
        }

        @Override
        public Array create(java.lang.Object obj) {
            return obj == null ? null : new Array(this, obj);
        }

        @Override
        public Array create(java.lang.Object obj, Type... arr) {
            if (obj == null) {
                return null;
            }
            Class<?> elementType;
            if (arr != null && arr.length > 0 && arr[0] instanceof Class<?>) {
                elementType = (Class<?>) arr[0];
            } else {
                elementType = Object.class;
            }
            return new Array(this, obj, elementType);
        }
    };
    private static final $Constructor $AS = new $Constructor();

    /**
     * Casts given object to this class.
     *
     * @param obj any object
     * @return a view of the provided <code>obj</code> object
     */
    public static Array<?> $as(java.lang.Object obj) {
        return $AS.create(obj);
    }

    /**
     * Casts given object to this class.
     *
     * @param obj any object
     * @param typeParameters optional specification of the array element type
     * @return a view of the provided <code>obj</code> object
     * @sicne 0.20
     */
    public static Array $as(java.lang.Object obj, Type... typeParameters) {
        return $AS.create(obj, typeParameters);
    }

  /**
  * Gets or sets the length of the array. This is a number one higher than the highest element defined in an array.
  */
  public net.java.html.lib.Objs.Property<java.lang.Number> length = net.java.html.lib.Objs.Property.create(this, java.lang.Number.class, "length");

  /**
   * Returns length of the array.
   * @return value of {@link #length} property converted to integer
   */
  public int length() {
      return length.get().intValue();
  }

  /** Gets an item from the array.
   *
   * @param index the (integer) index to the array
   * @return value at the index location
   */
  public T $get(double index) {
      Object ret = CoreTypes.$get$12($js(this), index);
      if (typeParameter != null) {
          return Objs.$as(typeParameter, ret);
      }
      return (T)ret;
  }

  /** Sets a value at index in the array.
   *
   * @param index the (integer) index into the array
   * @param value value to assign at that index
   * @return instance of <code>this</code> array
   */
  public Array<T> $set(double index, Object value) {
      CoreTypes.$set$12($js(this), index, value);
      return this;
  }

  /**
  * Combines two or more arrays.
  * @param items Additional items to add to the end of array1.
  */
  public net.java.html.lib.Array<T> concat(T... items) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.concat$13($js(this), items));
  }
  /**
  * Determines whether all the members of an array satisfy the specified test.
  * @param callbackfn A function that accepts up to three arguments. The every method calls the callbackfn function for each element in array1 until the callbackfn returns false, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean every(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Boolean> callbackfn, java.lang.Object thisArg) {
    return CoreTypes.every$14($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})), /* AnyKeyword*/$js(thisArg));
  }
  /**
  * Determines whether all the members of an array satisfy the specified test.
  * @param callbackfn A function that accepts up to three arguments. The every method calls the callbackfn function for each element in array1 until the callbackfn returns false, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean every(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Boolean> callbackfn) {
    return CoreTypes.every$15($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})));
  }
  /**
  * Returns the elements of an array that meet the condition specified in a callback function.
  * @param callbackfn A function that accepts up to three arguments. The filter method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public net.java.html.lib.Array<T> filter(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Boolean> callbackfn, java.lang.Object thisArg) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.filter$16($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})), /* AnyKeyword*/$js(thisArg)));
  }
  /**
  * Returns the elements of an array that meet the condition specified in a callback function.
  * @param callbackfn A function that accepts up to three arguments. The filter method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public net.java.html.lib.Array<T> filter(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Boolean> callbackfn) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.filter$17($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null}))));
  }
  /**
  * Performs the specified action for each element in an array.
  * @param callbackfn  A function that accepts up to three arguments. forEach calls the callbackfn function one time for each element in the array.
  * @param thisArg  An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public void forEach(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Void> callbackfn, java.lang.Object thisArg) {
    CoreTypes.forEach$18($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})), /* AnyKeyword*/$js(thisArg));
  }
  /**
  * Performs the specified action for each element in an array.
  * @param callbackfn  A function that accepts up to three arguments. forEach calls the callbackfn function one time for each element in the array.
  * @param thisArg  An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public void forEach(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Void> callbackfn) {
    CoreTypes.forEach$19($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})));
  }
  /**
  * Returns the index of the first occurrence of a value in an array.
  * @param searchElement The value to locate in the array.
  * @param fromIndex The array index at which to begin the search. If fromIndex is omitted, the search starts at index 0.
  */
  public double indexOf(T searchElement, double fromIndex) {
    return CoreTypes.indexOf$20($js(this), /* FirstTypeNode*/$js(searchElement), fromIndex);
  }
  /**
  * Returns the index of the first occurrence of a value in an array.
  * @param searchElement The value to locate in the array.
  * @param fromIndex The array index at which to begin the search. If fromIndex is omitted, the search starts at index 0.
  */
  public double indexOf(T searchElement) {
    return CoreTypes.indexOf$21($js(this), /* FirstTypeNode*/$js(searchElement));
  }
  /**
  * Adds all the elements of an array separated by the specified separator string.
  * @param separator A string used to separate one element of an array from the next in the resulting String. If omitted, the array elements are separated with a comma.
  */
  public java.lang.String join(java.lang.String separator) {
    return CoreTypes.join$22($js(this), separator);
  }
  /**
  * Adds all the elements of an array separated by the specified separator string.
  * @param separator A string used to separate one element of an array from the next in the resulting String. If omitted, the array elements are separated with a comma.
  */
  public java.lang.String join() {
    return CoreTypes.join$23($js(this));
  }
  /**
  * Returns the index of the last occurrence of a specified value in an array.
  * @param searchElement The value to locate in the array.
  * @param fromIndex The array index at which to begin the search. If fromIndex is omitted, the search starts at the last index in the array.
  */
  public double lastIndexOf(T searchElement, double fromIndex) {
    return CoreTypes.lastIndexOf$24($js(this), /* FirstTypeNode*/$js(searchElement), fromIndex);
  }
  /**
  * Returns the index of the last occurrence of a specified value in an array.
  * @param searchElement The value to locate in the array.
  * @param fromIndex The array index at which to begin the search. If fromIndex is omitted, the search starts at the last index in the array.
  */
  public double lastIndexOf(T searchElement) {
    return CoreTypes.lastIndexOf$25($js(this), /* FirstTypeNode*/$js(searchElement));
  }
  /**
  * Calls a defined callback function on each element of an array, and returns an array that contains the results.
  * @param callbackfn A function that accepts up to three arguments. The map method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public <U> net.java.html.lib.Array<U> map(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends U> callbackfn, java.lang.Object thisArg) {
    return (net.java.html.lib.Array<U>)net.java.html.lib.Array.$as(CoreTypes.map$26($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})), /* AnyKeyword*/$js(thisArg)));
  }
  /**
  * Calls a defined callback function on each element of an array, and returns an array that contains the results.
  * @param callbackfn A function that accepts up to three arguments. The map method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public <U> net.java.html.lib.Array<U> map(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends U> callbackfn) {
    return (net.java.html.lib.Array<U>)net.java.html.lib.Array.$as(CoreTypes.map$27($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null}))));
  }
  /**
  * Removes the last element from an array and returns it.
  */
  public T pop() {
    return (T)CoreTypes.pop$28($js(this));
  }
  /**
  * Appends new elements to an array, and returns the new length of the array.
  * @param items New elements of the Array.
  */
  public double push(T... items) {
    return CoreTypes.push$29($js(this), items);
  }
  /**
  * Calls the specified callback function for all the elements in an array. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduce method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduce(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends U> callbackfn, U initialValue) {
    return (U)CoreTypes.reduce$30($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, null, java.lang.Number.class, null})), /* FirstTypeNode*/$js(initialValue));
  }
  /**
  * Calls the specified callback function for all the elements in an array. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduce method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduce(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends U> callbackfn) {
    return (U)CoreTypes.reduce$31($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, null, java.lang.Number.class, null})));
  }
  /**
  * Calls the specified callback function for all the elements in an array, in descending order. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduceRight method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduceRight(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends U> callbackfn, U initialValue) {
    return (U)CoreTypes.reduceRight$32($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, null, java.lang.Number.class, null})), /* FirstTypeNode*/$js(initialValue));
  }
  /**
  * Calls the specified callback function for all the elements in an array, in descending order. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduceRight method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduceRight(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends U> callbackfn) {
    return (U)CoreTypes.reduceRight$33($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, null, java.lang.Number.class, null})));
  }
  /**
  * Reverses the elements in an Array.
  */
  public net.java.html.lib.Array<T> reverse() {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.reverse$34($js(this)));
  }
  /**
  * Removes the first element from an array and returns it.
  */
  public T shift() {
    return (T)CoreTypes.shift$35($js(this));
  }
  /**
  * Returns a section of an array.
  * @param start The beginning of the specified portion of the array.
  * @param end The end of the specified portion of the array.
  */
  public net.java.html.lib.Array<T> slice(double start, double end) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.slice$36($js(this), start, end));
  }
  /**
  * Returns a section of an array.
  * @param start The beginning of the specified portion of the array.
  * @param end The end of the specified portion of the array.
  */
  public net.java.html.lib.Array<T> slice() {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.slice$37($js(this)));
  }
  /**
  * Returns a section of an array.
  * @param start The beginning of the specified portion of the array.
  * @param end The end of the specified portion of the array.
  */
  public net.java.html.lib.Array<T> slice(double start) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.slice$38($js(this), start));
  }
  /**
  * Determines whether the specified callback function returns true for any element of an array.
  * @param callbackfn A function that accepts up to three arguments. The some method calls the callbackfn function for each element in array1 until the callbackfn returns true, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean some(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Boolean> callbackfn, java.lang.Object thisArg) {
    return CoreTypes.some$39($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})), /* AnyKeyword*/$js(thisArg));
  }
  /**
  * Determines whether the specified callback function returns true for any element of an array.
  * @param callbackfn A function that accepts up to three arguments. The some method calls the callbackfn function for each element in array1 until the callbackfn returns true, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean some(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super net.java.html.lib.Array<T>,? extends java.lang.Boolean> callbackfn) {
    return CoreTypes.some$40($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(callbackfn, new Class[] {null, java.lang.Number.class, null})));
  }
  /**
  * Sorts an array.
  * @param compareFn The name of the function used to determine the order of the elements. If omitted, the elements are sorted in ascending, ASCII character order.
  */
  public net.java.html.lib.Array<T> sort(net.java.html.lib.Function.A2<? super T,? super T,? extends java.lang.Number> compareFn) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.sort$41($js(this), net.java.html.lib.Objs.$js(net.java.html.lib.Function.newFunction(compareFn, new Class[] {null, null}))));
  }
  /**
  * Sorts an array.
  * @param compareFn The name of the function used to determine the order of the elements. If omitted, the elements are sorted in ascending, ASCII character order.
  */
  public net.java.html.lib.Array<T> sort() {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.sort$42($js(this)));
  }
  /**
  * Removes elements from an array and, if necessary, inserts new elements in their place, returning the deleted elements.
  * @param start The zero-based location in the array from which to start removing elements.
  */
  public net.java.html.lib.Array<T> splice(double start) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.splice$43($js(this), start));
  }
  /**
  * Removes elements from an array and, if necessary, inserts new elements in their place, returning the deleted elements.
  * @param start The zero-based location in the array from which to start removing elements.
  * @param deleteCount The number of elements to remove.
  * @param items Elements to insert into the array in place of the deleted elements.
  */
  public net.java.html.lib.Array<T> splice(double start, double deleteCount, T... items) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.splice$44($js(this), start, deleteCount, items));
  }
  public java.lang.String toLocaleString() {
    return CoreTypes.toLocaleString$45($js(this));
  }
  /**
  * Returns a string representation of an array.
  */
  /* cannot generate toString */
  /**
  * Inserts new elements at the start of an array.
  * @param items  Elements to insert at the start of the Array.
  */
  public double unshift(T... items) {
    return CoreTypes.unshift$47($js(this), items);
  }
  // constructor ArrayConstructor
  public static java.lang.Boolean/*TypePredicate*/ isArray(java.lang.Object arg) {
    return CoreTypes.isArray$49(/* AnyKeyword*/$js(arg));
  }
  public static Array<java.lang.Object> prototype = (Array<java.lang.Object>)net.java.html.lib.Array.$as(CoreTypes.readStaticFields$11());
  public Array(double arrayLength) {
    this(Array.$AS, CoreTypes.new$50(arrayLength));
  }
  public Array() {
    this(Array.$AS, CoreTypes.new$51());
  }
  public Array(T... items) {
    this(Array.$AS, CoreTypes.new$52(items));
  }
  public static <T> net.java.html.lib.Array<T> newArray(double arrayLength) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.newArray$53(arrayLength));
  }
  public static <T> net.java.html.lib.Array<T> newArray() {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.newArray$54());
  }
  public static <T> net.java.html.lib.Array<T> newArray(T... items) {
    return (net.java.html.lib.Array<T>)net.java.html.lib.Array.$as(CoreTypes.newArray$55(items));
  }

  /**
  * Returns a string representation of an array.
  */
  @Override
  public java.lang.String toString() {
    return CoreTypes.toString$46($js(this));
  }

  /** Converts the JavaScript array into Java array.
   * @return elements in the Object[] array
   */
  public Object[] toArray() {
      return toArray($js(this));
  }

  @JavaScriptBody(args = { "arr" }, body = "return arr.arr;")
  private static native Object[] toArray(Object arr);

    @Override
    public Iterator<T> iterator() {
        Object[] arr = toArray();
        return new Iterator<T>() {
            int at = 0;
            @Override
            public boolean hasNext() {
                return at < arr.length;
            }

            @Override
            public T next() {
                return (T)arr[at++];
            }
        };
    }
}
