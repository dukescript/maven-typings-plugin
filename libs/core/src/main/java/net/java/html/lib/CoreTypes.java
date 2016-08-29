package net.java.html.lib;

import net.java.html.js.JavaScriptResource;

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
@JavaScriptResource("hjTypings.js")
final class CoreTypes {
  private CoreTypes() {
  }
  @net.java.html.js.JavaScriptBody(args={"encodedURI"}, body=
    "var r = decodeURI(encodedURI);\n" +
    "return r;"

  )
  static native java.lang.String decodeURI$1(java.lang.Object encodedURI);

  @net.java.html.js.JavaScriptBody(args={"encodedURIComponent"}, body=
    "var r = decodeURIComponent(encodedURIComponent);\n" +
    "return r;"

  )
  static native java.lang.String decodeURIComponent$2(java.lang.Object encodedURIComponent);

  @net.java.html.js.JavaScriptBody(args={"uri"}, body=
    "var r = encodeURI(uri);\n" +
    "return r;"

  )
  static native java.lang.String encodeURI$3(java.lang.Object uri);

  @net.java.html.js.JavaScriptBody(args={"uriComponent"}, body=
    "var r = encodeURIComponent(uriComponent);\n" +
    "return r;"

  )
  static native java.lang.String encodeURIComponent$4(java.lang.Object uriComponent);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = eval(x);\n" +
    "return r;"

  )
  static native java.lang.Object eval$5(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"number"}, body=
    "var r = isFinite(number);\n" +
    "return r;"

  )
  static native java.lang.Boolean isFinite$6(java.lang.Object number);

  @net.java.html.js.JavaScriptBody(args={"number"}, body=
    "var r = isNaN(number);\n" +
    "return r;"

  )
  static native java.lang.Boolean isNaN$7(java.lang.Object number);

  @net.java.html.js.JavaScriptBody(args={"string"}, body=
    "var r = parseFloat(string);\n" +
    "return r;"

  )
  static native double parseFloat$8(java.lang.Object string);

  @net.java.html.js.JavaScriptBody(args={"s", "radix"}, body=
    "var r = parseInt(s, radix);\n" +
    "return r;"

  )
  static native double parseInt$9(java.lang.Object s, java.lang.Object radix);

  @net.java.html.js.JavaScriptBody(args={"s"}, body=
    "var r = parseInt(s);\n" +
    "return r;"

  )
  static native double parseInt$10(java.lang.Object s);

  @net.java.html.js.JavaScriptBody(args={}, body =
    "return [\n    NaN !== undefined ? NaN : NaN, \n    Infinity !== undefined ? Infinity : NaN];"
  )
  static native java.lang.Object[] readStaticFields$11();
  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "n"}, body=
    "var r = $dukescript$self[n];\n" +
    "return r;"

  )
  static native <T> java.lang.Object $get$12(java.lang.Object $dukescript$self, java.lang.Object n);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "n", "v"}, wait4js = false, body=
    "$dukescript$self.$set(n, v);\n"
  )
  static native void $set$12(java.lang.Object $dukescript$self, java.lang.Object n, java.lang.Object v);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "items"}, body=
    "var r = items;\n" +
    "var r = $dukescript$self.concat.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native Object concat$13(java.lang.Object $dukescript$self, java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(callbackfn, thisArg);\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean every$14(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(callbackfn);\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean every$15(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(callbackfn, thisArg);\n" +
    "return r;"

  )
  static native <T> Object filter$16(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(callbackfn);\n" +
    "return r;"

  )
  static native <T> Object filter$17(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(callbackfn, thisArg);\n" +
    "return r;"

  )
  static native <T> void forEach$18(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(callbackfn);\n" +
    "return r;"

  )
  static native <T> void forEach$19(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native <T> double indexOf$20(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native <T> double indexOf$21(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native <T> java.lang.String join$22(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native <T> java.lang.String join$23(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native <T> double lastIndexOf$24(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native <T> double lastIndexOf$25(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(callbackfn, thisArg);\n" +
    "return r;"

  )
  static native <T, U> Object map$26(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(callbackfn);\n" +
    "return r;"

  )
  static native <T, U> Object map$27(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.pop();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object pop$28(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "items"}, body=
    "var r = items;\n" +
    "var r = $dukescript$self.push.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native <T> double push$29(java.lang.Object $dukescript$self, java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(callbackfn, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduce$30(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(callbackfn);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduce$31(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(callbackfn, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduceRight$32(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(callbackfn);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduceRight$33(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "return r;"

  )
  static native Object reverse$34(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.shift();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object shift$35(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "return hj.array(r);"
  )
  static native Object slice$36(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "return hj.array(r);"
  )
  static native Object slice$37(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "return hj.array(r);"
  )
  static native Object slice$38(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(callbackfn, thisArg);\n" +
    "return r;"
  )
  static native <T> java.lang.Boolean some$39(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(callbackfn);\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean some$40(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(compareFn);\n" +
    "return r;"

  )
  static native Object sort$41(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "return r;"

  )
  static native Object sort$42(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.splice(start);\n" +
    "return r;"

  )
  static native Object splice$43(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "deleteCount", "items"}, body=
    "var r = [start, deleteCount].concat(items);\n" +
    "var r = $dukescript$self.splice.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native Object splice$44(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object deleteCount, java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native <T> java.lang.String toLocaleString$45(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native <T> java.lang.String toString$46(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "items"}, body=
    "var r = items;\n" +
    "var r = $dukescript$self.unshift.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native <T> double unshift$47(java.lang.Object $dukescript$self, java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arg"}, body=
    "var r = Array.isArray(arg);\n" +
    "return r;"

  )
  static native java.lang.Boolean/*TypePredicate*/ isArray$49(java.lang.Object arg);

  @net.java.html.js.JavaScriptBody(args={"arrayLength"}, body=
    "return hj.array(new Array(arrayLength));"
  )
  static native <T> java.lang.Object new$50(java.lang.Object arrayLength);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return hj.array(new Array());"
  )
  static native <T> java.lang.Object new$51();

  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "return hj.array(items);"
  )
  static native <T> java.lang.Object new$52(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLength"}, body=
    "var r = Array.newArray(arrayLength);\n" +
    "return r;"

  )
  static native <T> T[] newArray$53(java.lang.Object arrayLength);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Array.newArray();\n" +
    "return r;"

  )
  static native <T> T[] newArray$54();

  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Array.newArray.apply(this, r);\n" +
    "return r;"

  )
  static native <T> T[] newArray$55(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args = {}, body = "return Error.prototype;")
  static native java.lang.Object readStaticFields$131();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new Error(message);"
  )
  static native java.lang.Object new$182(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new Error();"
  )
  static native java.lang.Object new$183();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = Error.newError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newError$184(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Error.newError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newError$185();

  @net.java.html.js.JavaScriptBody(args={"fn", "thisArg", "argArray"}, body=
    "var r = fn.apply(thisArg, argArray);\n" +
    "if (Array.isArray(r)) return hj.array(r);\n" +
    "return r;"

  )
  static native java.lang.Object apply$300(java.lang.Object $dukescript$self, java.lang.Object thisArg, java.lang.Object argArray);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "thisArg"}, body=
    "var r = $dukescript$self.apply(thisArg);\n" +
    "return r;"

  )
  static native java.lang.Object apply$301(java.lang.Object $dukescript$self, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "thisArg", "argArray"}, body=
    "var r = [];r.push(thisArg);r.push(argArray);\n" +
    "var r = $dukescript$self.bind.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native java.lang.Object bind$302(java.lang.Object $dukescript$self, java.lang.Object thisArg, java.lang.Object argArray);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "thisArg", "argArray"}, body=
    "var r = [];r.push(thisArg);r.push(argArray);\n" +
    "var r = $dukescript$self.call.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native java.lang.Object call$303(java.lang.Object $dukescript$self, java.lang.Object thisArg, java.lang.Object argArray);

  @net.java.html.js.JavaScriptBody(args={"args"}, body=
    "return new Function(args);"
  )
  static native java.lang.Object new$305(java.lang.Object args);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "v"}, body=
    "var r = $dukescript$self.hasOwnProperty(v);\n" +
    "return r;"

  )
  static native java.lang.Boolean hasOwnProperty$487(java.lang.Object $dukescript$self, java.lang.Object v);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "v"}, body=
    "var r = $dukescript$self.isPrototypeOf(v);\n" +
    "return r;"

  )
  static native java.lang.Boolean isPrototypeOf$488(java.lang.Object $dukescript$self, java.lang.Object v);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "v"}, body=
    "var r = $dukescript$self.propertyIsEnumerable(v);\n" +
    "return r;"

  )
  static native java.lang.Boolean propertyIsEnumerable$489(java.lang.Object $dukescript$self, java.lang.Object v);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$490(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$491(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.valueOf();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object valueOf$492(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.getPrototypeOf(o);\n" +
    "return r;"

  )
  static native java.lang.Object getPrototypeOf$493(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o", "p"}, body=
    "var r = Object.getOwnPropertyDescriptor(o, p);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object getOwnPropertyDescriptor$494(java.lang.Object o, java.lang.Object p);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.getOwnPropertyNames(o);\n" +
    "return r;"

  )
  static native java.lang.String[] getOwnPropertyNames$495(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o", "properties"}, body=
    "var r = Object.create(o, properties);\n" +
    "return r;"

  )
  static native java.lang.Object create$496(java.lang.Object o, java.lang.Object properties);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.create(o);\n" +
    "return r;"

  )
  static native java.lang.Object create$497(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o", "p", "attributes"}, body=
    "var r = Object.defineProperty(o, p, attributes);\n" +
    "return r;"

  )
  static native java.lang.Object defineProperty$498(java.lang.Object o, java.lang.Object p, java.lang.Object attributes);

  @net.java.html.js.JavaScriptBody(args={"o", "properties"}, body=
    "var r = Object.defineProperties(o, properties);\n" +
    "return r;"

  )
  static native java.lang.Object defineProperties$499(java.lang.Object o, java.lang.Object properties);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.seal(o);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object seal$500(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.freeze(o);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object freeze$501(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.preventExtensions(o);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object preventExtensions$502(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.isSealed(o);\n" +
    "return r;"

  )
  static native java.lang.Boolean isSealed$503(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.isFrozen(o);\n" +
    "return r;"

  )
  static native java.lang.Boolean isFrozen$504(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.isExtensible(o);\n" +
    "return r;"

  )
  static native java.lang.Boolean isExtensible$505(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"o"}, body=
    "var r = Object.keys(o);\n" +
    "return hj.array(r);"

  )
  static native Object keys$506(java.lang.Object o);

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "return new Object(value);"
  )
  static native java.lang.Object new$507(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new Object();"
  )
  static native java.lang.Object new$508();

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Object.newObject();\n" +
    "return r;"

  )
  static native java.lang.Object newObject$509();

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "var r = Object.newObject(value);\n" +
    "return r;"

  )
  static native java.lang.Object newObject$510(java.lang.Object value);

}
