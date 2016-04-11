package net.java.html.lib;

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
    protected Array(Constructor<?> constructor, java.lang.Object js) {
        super(constructor, js);
    }
    private static final Constructor<Array> $AS = new Constructor<Array>(Array.class) {
        @Override
        public Array create(Object obj) {
            return new Array(this, obj);
        }
    };
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
  * Gets or sets the length of the array. This is a number one higher than the highest element defined in an array.
  */
  public Property<Number> length = Property.create(this, Number.class, "length");
  public T $get(double n) {
    return (T)CoreTypes.$get$12($js(this), n);
  }
  /**
  * Combines two or more arrays.
  * @param items Additional items to add to the end of array1.
  */
  public Array<T> concat(T... items) {
    return new Array<T>($AS, CoreTypes.concat$13($js(this), items));
  }
  /**
  * Determines whether all the members of an array satisfy the specified test.
  * @param callbackfn A function that accepts up to three arguments. The every method calls the callbackfn function for each element in array1 until the callbackfn returns false, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean every(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Boolean> callbackfn, java.lang.Object thisArg) {
    return CoreTypes.every$14($js(this), callbackfn, /* AnyKeyword*/$js(thisArg));
  }
  /**
  * Determines whether all the members of an array satisfy the specified test.
  * @param callbackfn A function that accepts up to three arguments. The every method calls the callbackfn function for each element in array1 until the callbackfn returns false, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean every(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Boolean> callbackfn) {
    return CoreTypes.every$15($js(this), callbackfn);
  }
  /**
  * Returns the elements of an array that meet the condition specified in a callback function.
  * @param callbackfn A function that accepts up to three arguments. The filter method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public Array<T> filter(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Boolean> callbackfn, java.lang.Object thisArg) {
    return new Array<T>($AS, CoreTypes.filter$16($js(this), callbackfn, /* AnyKeyword*/$js(thisArg)));
  }
  /**
  * Returns the elements of an array that meet the condition specified in a callback function.
  * @param callbackfn A function that accepts up to three arguments. The filter method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public Array<T> filter(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Boolean> callbackfn) {
    return new Array<T>($AS, CoreTypes.filter$17($js(this), callbackfn));
  }
  /**
  * Performs the specified action for each element in an array.
  * @param callbackfn  A function that accepts up to three arguments. forEach calls the callbackfn function one time for each element in the array.
  * @param thisArg  An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public void forEach(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Void> callbackfn, java.lang.Object thisArg) {
    CoreTypes.forEach$18($js(this), callbackfn, /* AnyKeyword*/$js(thisArg));
  }
  /**
  * Performs the specified action for each element in an array.
  * @param callbackfn  A function that accepts up to three arguments. forEach calls the callbackfn function one time for each element in the array.
  * @param thisArg  An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public void forEach(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Void> callbackfn) {
    CoreTypes.forEach$19($js(this), callbackfn);
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
  public <U> Array<U> map(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends U> callbackfn, java.lang.Object thisArg) {
    return new Array<U>($AS, CoreTypes.map$26($js(this), callbackfn, /* AnyKeyword*/$js(thisArg)));
  }
  /**
  * Calls a defined callback function on each element of an array, and returns an array that contains the results.
  * @param callbackfn A function that accepts up to three arguments. The map method calls the callbackfn function one time for each element in the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public <U> Array<U> map(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends U> callbackfn) {
    return new Array<U>($AS, CoreTypes.map$27($js(this), callbackfn));
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
  public <U> U reduce(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super Array<T>,? extends U> callbackfn, U initialValue) {
    return (U)CoreTypes.reduce$30($js(this), callbackfn, /* FirstTypeNode*/$js(initialValue));
  }
  /**
  * Calls the specified callback function for all the elements in an array. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduce method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduce(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super Array<T>,? extends U> callbackfn) {
    return (U)CoreTypes.reduce$31($js(this), callbackfn);
  }
  /**
  * Calls the specified callback function for all the elements in an array, in descending order. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduceRight method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduceRight(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super Array<T>,? extends U> callbackfn, U initialValue) {
    return (U)CoreTypes.reduceRight$32($js(this), callbackfn, /* FirstTypeNode*/$js(initialValue));
  }
  /**
  * Calls the specified callback function for all the elements in an array, in descending order. The return value of the callback function is the accumulated result, and is provided as an argument in the next call to the callback function.
  * @param callbackfn A function that accepts up to four arguments. The reduceRight method calls the callbackfn function one time for each element in the array.
  * @param initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn function provides this value as an argument instead of an array value.
  */
  public <U> U reduceRight(net.java.html.lib.Function.A4<? super U,? super T,? super java.lang.Number,? super Array<T>,? extends U> callbackfn) {
    return (U)CoreTypes.reduceRight$33($js(this), callbackfn);
  }
  /**
  * Reverses the elements in an Array.
  */
  public Array<T>reverse() {
    return new Array<T>($AS, CoreTypes.reverse$34($js(this)));
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
  public T[] slice(double start, double end) {
    return CoreTypes.slice$36($js(this), start, end);
  }
  /**
  * Returns a section of an array.
  * @param start The beginning of the specified portion of the array.
  * @param end The end of the specified portion of the array.
  */
  public T[] slice() {
    return CoreTypes.slice$37($js(this));
  }
  /**
  * Returns a section of an array.
  * @param start The beginning of the specified portion of the array.
  * @param end The end of the specified portion of the array.
  */
  public T[] slice(double start) {
    return CoreTypes.slice$38($js(this), start);
  }
  /**
  * Determines whether the specified callback function returns true for any element of an array.
  * @param callbackfn A function that accepts up to three arguments. The some method calls the callbackfn function for each element in array1 until the callbackfn returns true, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean some(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Boolean> callbackfn, java.lang.Object thisArg) {
    return CoreTypes.some$39($js(this), callbackfn, /* AnyKeyword*/$js(thisArg));
  }
  /**
  * Determines whether the specified callback function returns true for any element of an array.
  * @param callbackfn A function that accepts up to three arguments. The some method calls the callbackfn function for each element in array1 until the callbackfn returns true, or until the end of the array.
  * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined is used as the this value.
  */
  public java.lang.Boolean some(net.java.html.lib.Function.A3<? super T,? super java.lang.Number,? super Array<T>,? extends java.lang.Boolean> callbackfn) {
    return CoreTypes.some$40($js(this), callbackfn);
  }
  /**
  * Sorts an array.
  * @param compareFn The name of the function used to determine the order of the elements. If omitted, the elements are sorted in ascending, ASCII character order.
  */
  public T[] sort(net.java.html.lib.Function.A2<? super T,? super T,? extends java.lang.Number> compareFn) {
    return CoreTypes.sort$41($js(this), compareFn);
  }
  /**
  * Sorts an array.
  * @param compareFn The name of the function used to determine the order of the elements. If omitted, the elements are sorted in ascending, ASCII character order.
  */
  public T[] sort() {
    return CoreTypes.sort$42($js(this));
  }
  /**
  * Removes elements from an array and, if necessary, inserts new elements in their place, returning the deleted elements.
  * @param start The zero-based location in the array from which to start removing elements.
  */
  public Array<T> splice(double start) {
    return splice(start, Integer.MAX_VALUE);
  }
  /**
  * Removes elements from an array and, if necessary, inserts new elements in their place, returning the deleted elements.
  * @param start The zero-based location in the array from which to start removing elements.
  * @param deleteCount The number of elements to remove.
  * @param items Elements to insert into the array in place of the deleted elements.
  */
  public Array<T> splice(double start, double deleteCount, T... items) {
    return new Array<>($AS, CoreTypes.splice$44($js(this), start, deleteCount, items));
  }
  public java.lang.String toLocaleString() {
    return CoreTypes.toLocaleString$45($js(this));
  }
  /**
  * Returns a string representation of an array.
  */
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
  public Array(double arrayLength) {
    this($AS, CoreTypes.new$50(arrayLength));
  }
  public Array() {
    this($AS, CoreTypes.new$51());
  }
  public Array(T... items) {
    this($AS, CoreTypes.new$52(items));
  }

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
