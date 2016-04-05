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
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object $get$12(java.lang.Object $dukescript$self, java.lang.Object n);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "items"}, body=
    "var r = items;\n" +
    "var r = $dukescript$self.concat.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native Object concat$13(java.lang.Object $dukescript$self, java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean every$14(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean every$15(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native <T> Object filter$16(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native <T> Object filter$17(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native <T> void forEach$18(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
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
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native <T, U> Object map$26(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
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
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduce$30(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduce$31(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, U> java.lang.Object reduceRight$32(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
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
    "return r;"

  )
  static native <T> T[] slice$36(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "return r;"

  )
  static native <T> T[] slice$37(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "return r;"

  )
  static native <T> T[] slice$38(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean some$39(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native <T> java.lang.Boolean some$40(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "return r;"

  )
  static native <T> T[] sort$41(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "return r;"

  )
  static native <T> T[] sort$42(java.lang.Object $dukescript$self);

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

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$48(java.lang.Object js);
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

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.slice(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$56(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.slice(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$57(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.byteLength !== undefined ? js.byteLength : NaN];"
  )
  static native java.lang.Object[] readFields$58(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"arg"}, body=
    "var r = ArrayBuffer.isView(arg);\n" +
    "return r;"

  )
  static native java.lang.Boolean isView$59(java.lang.Object arg);

  @net.java.html.js.JavaScriptBody(args={"byteLength"}, body=
    "return new ArrayBuffer(byteLength);"
  )
  static native java.lang.Object new$60(java.lang.Object byteLength);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN];"
  )
  static native java.lang.Object[] readFields$61(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "n"}, body=
    "var r = $dukescript$self[n];\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T> java.lang.Object $get$62(java.lang.Object $dukescript$self, java.lang.Object n);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$63(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.valueOf();\n" +
    "return r;"

  )
  static native java.lang.Boolean valueOf$64(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "return new Boolean(value);"
  )
  static native java.lang.Object new$65(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new Boolean();"
  )
  static native java.lang.Object new$66();

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "var r = Boolean.newBoolean(value);\n" +
    "return r;"

  )
  static native java.lang.Boolean newBoolean$67(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Boolean.newBoolean();\n" +
    "return r;"

  )
  static native java.lang.Boolean newBoolean$68();

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "littleEndian"}, body=
    "var r = $dukescript$self.getFloat32(byteOffset, littleEndian);\n" +
    "return r;"

  )
  static native double getFloat32$69(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getFloat32(byteOffset);\n" +
    "return r;"

  )
  static native double getFloat32$70(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "littleEndian"}, body=
    "var r = $dukescript$self.getFloat64(byteOffset, littleEndian);\n" +
    "return r;"

  )
  static native double getFloat64$71(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getFloat64(byteOffset);\n" +
    "return r;"

  )
  static native double getFloat64$72(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "littleEndian"}, body=
    "var r = $dukescript$self.getInt16(byteOffset, littleEndian);\n" +
    "return r;"

  )
  static native double getInt16$73(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getInt16(byteOffset);\n" +
    "return r;"

  )
  static native double getInt16$74(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "littleEndian"}, body=
    "var r = $dukescript$self.getInt32(byteOffset, littleEndian);\n" +
    "return r;"

  )
  static native double getInt32$75(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getInt32(byteOffset);\n" +
    "return r;"

  )
  static native double getInt32$76(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getInt8(byteOffset);\n" +
    "return r;"

  )
  static native double getInt8$77(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "littleEndian"}, body=
    "var r = $dukescript$self.getUint16(byteOffset, littleEndian);\n" +
    "return r;"

  )
  static native double getUint16$78(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getUint16(byteOffset);\n" +
    "return r;"

  )
  static native double getUint16$79(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "littleEndian"}, body=
    "var r = $dukescript$self.getUint32(byteOffset, littleEndian);\n" +
    "return r;"

  )
  static native double getUint32$80(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getUint32(byteOffset);\n" +
    "return r;"

  )
  static native double getUint32$81(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset"}, body=
    "var r = $dukescript$self.getUint8(byteOffset);\n" +
    "return r;"

  )
  static native double getUint8$82(java.lang.Object $dukescript$self, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value", "littleEndian"}, body=
    "var r = $dukescript$self.setFloat32(byteOffset, value, littleEndian);\n" +
    "return r;"

  )
  static native void setFloat32$83(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setFloat32(byteOffset, value);\n" +
    "return r;"

  )
  static native void setFloat32$84(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value", "littleEndian"}, body=
    "var r = $dukescript$self.setFloat64(byteOffset, value, littleEndian);\n" +
    "return r;"

  )
  static native void setFloat64$85(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setFloat64(byteOffset, value);\n" +
    "return r;"

  )
  static native void setFloat64$86(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value", "littleEndian"}, body=
    "var r = $dukescript$self.setInt16(byteOffset, value, littleEndian);\n" +
    "return r;"

  )
  static native void setInt16$87(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setInt16(byteOffset, value);\n" +
    "return r;"

  )
  static native void setInt16$88(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value", "littleEndian"}, body=
    "var r = $dukescript$self.setInt32(byteOffset, value, littleEndian);\n" +
    "return r;"

  )
  static native void setInt32$89(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setInt32(byteOffset, value);\n" +
    "return r;"

  )
  static native void setInt32$90(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setInt8(byteOffset, value);\n" +
    "return r;"

  )
  static native void setInt8$91(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value", "littleEndian"}, body=
    "var r = $dukescript$self.setUint16(byteOffset, value, littleEndian);\n" +
    "return r;"

  )
  static native void setUint16$92(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setUint16(byteOffset, value);\n" +
    "return r;"

  )
  static native void setUint16$93(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value", "littleEndian"}, body=
    "var r = $dukescript$self.setUint32(byteOffset, value, littleEndian);\n" +
    "return r;"

  )
  static native void setUint32$94(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value, java.lang.Object littleEndian);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setUint32(byteOffset, value);\n" +
    "return r;"

  )
  static native void setUint32$95(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "byteOffset", "value"}, body=
    "var r = $dukescript$self.setUint8(byteOffset, value);\n" +
    "return r;"

  )
  static native void setUint8$96(java.lang.Object $dukescript$self, java.lang.Object byteOffset, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN];"
  )
  static native java.lang.Object[] readFields$97(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "byteLength"}, body=
    "return new DataView(buffer, byteOffset, byteLength);"
  )
  static native java.lang.Object new$98(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object byteLength);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new DataView(buffer);"
  )
  static native java.lang.Object new$99(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new DataView(buffer, byteOffset);"
  )
  static native java.lang.Object new$100(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getDate();\n" +
    "return r;"

  )
  static native double getDate$101(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getDay();\n" +
    "return r;"

  )
  static native double getDay$102(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getFullYear();\n" +
    "return r;"

  )
  static native double getFullYear$103(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getHours();\n" +
    "return r;"

  )
  static native double getHours$104(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getMilliseconds();\n" +
    "return r;"

  )
  static native double getMilliseconds$105(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getMinutes();\n" +
    "return r;"

  )
  static native double getMinutes$106(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getMonth();\n" +
    "return r;"

  )
  static native double getMonth$107(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getSeconds();\n" +
    "return r;"

  )
  static native double getSeconds$108(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getTime();\n" +
    "return r;"

  )
  static native double getTime$109(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getTimezoneOffset();\n" +
    "return r;"

  )
  static native double getTimezoneOffset$110(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCDate();\n" +
    "return r;"

  )
  static native double getUTCDate$111(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCDay();\n" +
    "return r;"

  )
  static native double getUTCDay$112(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCFullYear();\n" +
    "return r;"

  )
  static native double getUTCFullYear$113(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCHours();\n" +
    "return r;"

  )
  static native double getUTCHours$114(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCMilliseconds();\n" +
    "return r;"

  )
  static native double getUTCMilliseconds$115(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCMinutes();\n" +
    "return r;"

  )
  static native double getUTCMinutes$116(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCMonth();\n" +
    "return r;"

  )
  static native double getUTCMonth$117(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.getUTCSeconds();\n" +
    "return r;"

  )
  static native double getUTCSeconds$118(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "date"}, body=
    "var r = $dukescript$self.setDate(date);\n" +
    "return r;"

  )
  static native double setDate$119(java.lang.Object $dukescript$self, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "year", "month", "date"}, body=
    "var r = $dukescript$self.setFullYear(year, month, date);\n" +
    "return r;"

  )
  static native double setFullYear$120(java.lang.Object $dukescript$self, java.lang.Object year, java.lang.Object month, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "year"}, body=
    "var r = $dukescript$self.setFullYear(year);\n" +
    "return r;"

  )
  static native double setFullYear$121(java.lang.Object $dukescript$self, java.lang.Object year);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "year", "month"}, body=
    "var r = $dukescript$self.setFullYear(year, month);\n" +
    "return r;"

  )
  static native double setFullYear$122(java.lang.Object $dukescript$self, java.lang.Object year, java.lang.Object month);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours", "min", "sec", "ms"}, body=
    "var r = $dukescript$self.setHours(hours, min, sec, ms);\n" +
    "return r;"

  )
  static native double setHours$123(java.lang.Object $dukescript$self, java.lang.Object hours, java.lang.Object min, java.lang.Object sec, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours"}, body=
    "var r = $dukescript$self.setHours(hours);\n" +
    "return r;"

  )
  static native double setHours$124(java.lang.Object $dukescript$self, java.lang.Object hours);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours", "min"}, body=
    "var r = $dukescript$self.setHours(hours, min);\n" +
    "return r;"

  )
  static native double setHours$125(java.lang.Object $dukescript$self, java.lang.Object hours, java.lang.Object min);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours", "min", "sec"}, body=
    "var r = $dukescript$self.setHours(hours, min, sec);\n" +
    "return r;"

  )
  static native double setHours$126(java.lang.Object $dukescript$self, java.lang.Object hours, java.lang.Object min, java.lang.Object sec);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "ms"}, body=
    "var r = $dukescript$self.setMilliseconds(ms);\n" +
    "return r;"

  )
  static native double setMilliseconds$127(java.lang.Object $dukescript$self, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "min", "sec", "ms"}, body=
    "var r = $dukescript$self.setMinutes(min, sec, ms);\n" +
    "return r;"

  )
  static native double setMinutes$128(java.lang.Object $dukescript$self, java.lang.Object min, java.lang.Object sec, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "min"}, body=
    "var r = $dukescript$self.setMinutes(min);\n" +
    "return r;"

  )
  static native double setMinutes$129(java.lang.Object $dukescript$self, java.lang.Object min);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "min", "sec"}, body=
    "var r = $dukescript$self.setMinutes(min, sec);\n" +
    "return r;"

  )
  static native double setMinutes$130(java.lang.Object $dukescript$self, java.lang.Object min, java.lang.Object sec);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "month", "date"}, body=
    "var r = $dukescript$self.setMonth(month, date);\n" +
    "return r;"

  )
  static native double setMonth$131(java.lang.Object $dukescript$self, java.lang.Object month, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "month"}, body=
    "var r = $dukescript$self.setMonth(month);\n" +
    "return r;"

  )
  static native double setMonth$132(java.lang.Object $dukescript$self, java.lang.Object month);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "sec", "ms"}, body=
    "var r = $dukescript$self.setSeconds(sec, ms);\n" +
    "return r;"

  )
  static native double setSeconds$133(java.lang.Object $dukescript$self, java.lang.Object sec, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "sec"}, body=
    "var r = $dukescript$self.setSeconds(sec);\n" +
    "return r;"

  )
  static native double setSeconds$134(java.lang.Object $dukescript$self, java.lang.Object sec);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "time"}, body=
    "var r = $dukescript$self.setTime(time);\n" +
    "return r;"

  )
  static native double setTime$135(java.lang.Object $dukescript$self, java.lang.Object time);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "date"}, body=
    "var r = $dukescript$self.setUTCDate(date);\n" +
    "return r;"

  )
  static native double setUTCDate$136(java.lang.Object $dukescript$self, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "year", "month", "date"}, body=
    "var r = $dukescript$self.setUTCFullYear(year, month, date);\n" +
    "return r;"

  )
  static native double setUTCFullYear$137(java.lang.Object $dukescript$self, java.lang.Object year, java.lang.Object month, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "year"}, body=
    "var r = $dukescript$self.setUTCFullYear(year);\n" +
    "return r;"

  )
  static native double setUTCFullYear$138(java.lang.Object $dukescript$self, java.lang.Object year);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "year", "month"}, body=
    "var r = $dukescript$self.setUTCFullYear(year, month);\n" +
    "return r;"

  )
  static native double setUTCFullYear$139(java.lang.Object $dukescript$self, java.lang.Object year, java.lang.Object month);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours", "min", "sec", "ms"}, body=
    "var r = $dukescript$self.setUTCHours(hours, min, sec, ms);\n" +
    "return r;"

  )
  static native double setUTCHours$140(java.lang.Object $dukescript$self, java.lang.Object hours, java.lang.Object min, java.lang.Object sec, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours"}, body=
    "var r = $dukescript$self.setUTCHours(hours);\n" +
    "return r;"

  )
  static native double setUTCHours$141(java.lang.Object $dukescript$self, java.lang.Object hours);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours", "min"}, body=
    "var r = $dukescript$self.setUTCHours(hours, min);\n" +
    "return r;"

  )
  static native double setUTCHours$142(java.lang.Object $dukescript$self, java.lang.Object hours, java.lang.Object min);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "hours", "min", "sec"}, body=
    "var r = $dukescript$self.setUTCHours(hours, min, sec);\n" +
    "return r;"

  )
  static native double setUTCHours$143(java.lang.Object $dukescript$self, java.lang.Object hours, java.lang.Object min, java.lang.Object sec);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "ms"}, body=
    "var r = $dukescript$self.setUTCMilliseconds(ms);\n" +
    "return r;"

  )
  static native double setUTCMilliseconds$144(java.lang.Object $dukescript$self, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "min", "sec", "ms"}, body=
    "var r = $dukescript$self.setUTCMinutes(min, sec, ms);\n" +
    "return r;"

  )
  static native double setUTCMinutes$145(java.lang.Object $dukescript$self, java.lang.Object min, java.lang.Object sec, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "min"}, body=
    "var r = $dukescript$self.setUTCMinutes(min);\n" +
    "return r;"

  )
  static native double setUTCMinutes$146(java.lang.Object $dukescript$self, java.lang.Object min);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "min", "sec"}, body=
    "var r = $dukescript$self.setUTCMinutes(min, sec);\n" +
    "return r;"

  )
  static native double setUTCMinutes$147(java.lang.Object $dukescript$self, java.lang.Object min, java.lang.Object sec);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "month", "date"}, body=
    "var r = $dukescript$self.setUTCMonth(month, date);\n" +
    "return r;"

  )
  static native double setUTCMonth$148(java.lang.Object $dukescript$self, java.lang.Object month, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "month"}, body=
    "var r = $dukescript$self.setUTCMonth(month);\n" +
    "return r;"

  )
  static native double setUTCMonth$149(java.lang.Object $dukescript$self, java.lang.Object month);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "sec", "ms"}, body=
    "var r = $dukescript$self.setUTCSeconds(sec, ms);\n" +
    "return r;"

  )
  static native double setUTCSeconds$150(java.lang.Object $dukescript$self, java.lang.Object sec, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "sec"}, body=
    "var r = $dukescript$self.setUTCSeconds(sec);\n" +
    "return r;"

  )
  static native double setUTCSeconds$151(java.lang.Object $dukescript$self, java.lang.Object sec);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toDateString();\n" +
    "return r;"

  )
  static native java.lang.String toDateString$152(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toISOString();\n" +
    "return r;"

  )
  static native java.lang.String toISOString$153(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "key"}, body=
    "var r = $dukescript$self.toJSON(key);\n" +
    "return r;"

  )
  static native java.lang.String toJSON$154(java.lang.Object $dukescript$self, java.lang.Object key);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toJSON();\n" +
    "return r;"

  )
  static native java.lang.String toJSON$155(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleDateString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleDateString$156(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$157(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleTimeString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleTimeString$158(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$159(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toTimeString();\n" +
    "return r;"

  )
  static native java.lang.String toTimeString$160(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toUTCString();\n" +
    "return r;"

  )
  static native java.lang.String toUTCString$161(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.valueOf();\n" +
    "return r;"

  )
  static native double valueOf$162(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"s"}, body=
    "var r = Date.parse(s);\n" +
    "return r;"

  )
  static native double parse$163(java.lang.Object s);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours", "minutes", "seconds", "ms"}, body=
    "var r = Date.UTC(year, month, date, hours, minutes, seconds, ms);\n" +
    "return r;"

  )
  static native double UTC$164(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours, java.lang.Object minutes, java.lang.Object seconds, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"year", "month"}, body=
    "var r = Date.UTC(year, month);\n" +
    "return r;"

  )
  static native double UTC$165(java.lang.Object year, java.lang.Object month);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date"}, body=
    "var r = Date.UTC(year, month, date);\n" +
    "return r;"

  )
  static native double UTC$166(java.lang.Object year, java.lang.Object month, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours"}, body=
    "var r = Date.UTC(year, month, date, hours);\n" +
    "return r;"

  )
  static native double UTC$167(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours", "minutes"}, body=
    "var r = Date.UTC(year, month, date, hours, minutes);\n" +
    "return r;"

  )
  static native double UTC$168(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours, java.lang.Object minutes);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours", "minutes", "seconds"}, body=
    "var r = Date.UTC(year, month, date, hours, minutes, seconds);\n" +
    "return r;"

  )
  static native double UTC$169(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours, java.lang.Object minutes, java.lang.Object seconds);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Date.now();\n" +
    "return r;"

  )
  static native double now$170();

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new Date();"
  )
  static native java.lang.Object new$171();

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "return new Date(value);"
  )
  static native java.lang.Object new$172(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours", "minutes", "seconds", "ms"}, body=
    "return new Date(year, month, date, hours, minutes, seconds, ms);"
  )
  static native java.lang.Object new$173(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours, java.lang.Object minutes, java.lang.Object seconds, java.lang.Object ms);

  @net.java.html.js.JavaScriptBody(args={"year", "month"}, body=
    "return new Date(year, month);"
  )
  static native java.lang.Object new$174(java.lang.Object year, java.lang.Object month);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date"}, body=
    "return new Date(year, month, date);"
  )
  static native java.lang.Object new$175(java.lang.Object year, java.lang.Object month, java.lang.Object date);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours"}, body=
    "return new Date(year, month, date, hours);"
  )
  static native java.lang.Object new$176(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours", "minutes"}, body=
    "return new Date(year, month, date, hours, minutes);"
  )
  static native java.lang.Object new$177(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours, java.lang.Object minutes);

  @net.java.html.js.JavaScriptBody(args={"year", "month", "date", "hours", "minutes", "seconds"}, body=
    "return new Date(year, month, date, hours, minutes, seconds);"
  )
  static native java.lang.Object new$178(java.lang.Object year, java.lang.Object month, java.lang.Object date, java.lang.Object hours, java.lang.Object minutes, java.lang.Object seconds);

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "return new Date(value);"
  )
  static native java.lang.Object new$179(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Date.newDate();\n" +
    "return r;"

  )
  static native java.lang.String newDate$180();

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.name !== undefined ? js.name : null, \n    js.message !== undefined ? js.message : null];"
  )
  static native java.lang.Object[] readFields$181(java.lang.Object js);
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

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new EvalError(message);"
  )
  static native java.lang.Object new$186(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new EvalError();"
  )
  static native java.lang.Object new$187();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = EvalError.newEvalError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newEvalError$188(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = EvalError.newEvalError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newEvalError$189();

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$190(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$191(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$192(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$193(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$194(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$195(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$196(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$197(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$198(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$199(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$200(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$201(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$202(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$203(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$204(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$205(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$206(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$207(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$208(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$209(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$210(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$211(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$212(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$213(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$214(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$215(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$216(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$217(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$218(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$219(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$220(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$221(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$222(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$223(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$224(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$225(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$226(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$227(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$228(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$229(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$230(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$231(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$232(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$233(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$234(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$235(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Float32Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$236(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Float32Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$237(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Float32Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$238(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Float32Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$239(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Float32Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$240(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Float32Array(buffer);"
  )
  static native java.lang.Object new$241(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Float32Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$242(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Float32Array(array);"
  )
  static native java.lang.Object new$243(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Float32Array(length);"
  )
  static native java.lang.Object new$244(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$245(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$246(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$247(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$248(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$249(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$250(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$251(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$252(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$253(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$254(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$255(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$256(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$257(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$258(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$259(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$260(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$261(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$262(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$263(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$264(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$265(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$266(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$267(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$268(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$269(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$270(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$271(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$272(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$273(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$274(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$275(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$276(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$277(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$278(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$279(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$280(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$281(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$282(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$283(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$284(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$285(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$286(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$287(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$288(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$289(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$290(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Float64Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$291(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Float64Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$292(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Float64Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$293(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Float64Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$294(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Float64Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$295(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Float64Array(buffer);"
  )
  static native java.lang.Object new$296(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Float64Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$297(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Float64Array(array);"
  )
  static native java.lang.Object new$298(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Float64Array(length);"
  )
  static native java.lang.Object new$299(java.lang.Object length);

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

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.prototype !== undefined ? js.prototype : null, \n    js.length !== undefined ? js.length : NaN, \n    js.arguments !== undefined ? js.arguments : null, \n    js.caller !== undefined ? js.caller : null];"
  )
  static native java.lang.Object[] readFields$304(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"args"}, body=
    "return new Function(args);"
  )
  static native java.lang.Object new$305(java.lang.Object args);

  @net.java.html.js.JavaScriptBody(args={"args"}, body=
    "var r = args;\n" +
    "var r = Function.newFunction.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newFunction$306(java.lang.Object args);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native java.lang.Object $get$307(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.length !== undefined ? js.length : NaN, \n    js.callee !== undefined ? js.callee : null];"
  )
  static native java.lang.Object[] readFields$308(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$309(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$310(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$311(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$312(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$313(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$314(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$315(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$316(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$317(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$318(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$319(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$320(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$321(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$322(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$323(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$324(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$325(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$326(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$327(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$328(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$329(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$330(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$331(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$332(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$333(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$334(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$335(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$336(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$337(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$338(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$339(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$340(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$341(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$342(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$343(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$344(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$345(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$346(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$347(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$348(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$349(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$350(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$351(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$352(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$353(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$354(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Int16Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$355(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Int16Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$356(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Int16Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$357(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Int16Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$358(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Int16Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$359(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Int16Array(buffer);"
  )
  static native java.lang.Object new$360(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Int16Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$361(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Int16Array(array);"
  )
  static native java.lang.Object new$362(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Int16Array(length);"
  )
  static native java.lang.Object new$363(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$364(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$365(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$366(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$367(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$368(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$369(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$370(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$371(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$372(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$373(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$374(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$375(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$376(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$377(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$378(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$379(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$380(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$381(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$382(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$383(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$384(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$385(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$386(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$387(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$388(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$389(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$390(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$391(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$392(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$393(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$394(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$395(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$396(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$397(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$398(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$399(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$400(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$401(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$402(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$403(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$404(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$405(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$406(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$407(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$408(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$409(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Int32Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$410(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Int32Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$411(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Int32Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$412(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Int32Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$413(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Int32Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$414(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Int32Array(buffer);"
  )
  static native java.lang.Object new$415(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Int32Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$416(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Int32Array(array);"
  )
  static native java.lang.Object new$417(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Int32Array(length);"
  )
  static native java.lang.Object new$418(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$419(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$420(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$421(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$422(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$423(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$424(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$425(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$426(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$427(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$428(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$429(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$430(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$431(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$432(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$433(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$434(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$435(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$436(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$437(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$438(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$439(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$440(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$441(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$442(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$443(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$444(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$445(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$446(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$447(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$448(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$449(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$450(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$451(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$452(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$453(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$454(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$455(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$456(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$457(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$458(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$459(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$460(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$461(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$462(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$463(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$464(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Int8Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$465(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Int8Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$466(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Int8Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$467(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Int8Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$468(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Int8Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$469(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Int8Array(buffer);"
  )
  static native java.lang.Object new$470(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Int8Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$471(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Int8Array(array);"
  )
  static native java.lang.Object new$472(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Int8Array(length);"
  )
  static native java.lang.Object new$473(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "fractionDigits"}, body=
    "var r = $dukescript$self.toExponential(fractionDigits);\n" +
    "return r;"

  )
  static native java.lang.String toExponential$474(java.lang.Object $dukescript$self, java.lang.Object fractionDigits);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toExponential();\n" +
    "return r;"

  )
  static native java.lang.String toExponential$475(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "fractionDigits"}, body=
    "var r = $dukescript$self.toFixed(fractionDigits);\n" +
    "return r;"

  )
  static native java.lang.String toFixed$476(java.lang.Object $dukescript$self, java.lang.Object fractionDigits);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toFixed();\n" +
    "return r;"

  )
  static native java.lang.String toFixed$477(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "precision"}, body=
    "var r = $dukescript$self.toPrecision(precision);\n" +
    "return r;"

  )
  static native java.lang.String toPrecision$478(java.lang.Object $dukescript$self, java.lang.Object precision);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toPrecision();\n" +
    "return r;"

  )
  static native java.lang.String toPrecision$479(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "radix"}, body=
    "var r = $dukescript$self.toString(radix);\n" +
    "return r;"

  )
  static native java.lang.String toString$480(java.lang.Object $dukescript$self, java.lang.Object radix);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$481(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.valueOf();\n" +
    "return r;"

  )
  static native double valueOf$482(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "return new Number(value);"
  )
  static native java.lang.Object new$483(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new Number();"
  )
  static native java.lang.Object new$484();

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "var r = Number.newNumber(value);\n" +
    "return r;"

  )
  static native double newNumber$485(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Number.newNumber();\n" +
    "return r;"

  )
  static native double newNumber$486();

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

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "onfulfilled", "onrejected"}, javacall = true, body=
    "var r = $dukescript$self.then(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(onfulfilled, [p1]);}, function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(onrejected, [p1]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, TResult> java.lang.Object then$511(java.lang.Object $dukescript$self, java.lang.Object onfulfilled, java.lang.Object onrejected);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.then();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, TResult> java.lang.Object then$512(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "onfulfilled"}, javacall = true, body=
    "var r = $dukescript$self.then(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(onfulfilled, [p1]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <T, TResult> java.lang.Object then$513(java.lang.Object $dukescript$self, java.lang.Object onfulfilled);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.get();\n" +
    "return r;"

  )
  static native java.lang.Object get$514(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "v"}, body=
    "var r = $dukescript$self.set(v);\n" +
    "return r;"

  )
  static native void set$515(java.lang.Object $dukescript$self, java.lang.Object v);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.configurable !== undefined ? js.configurable : false, \n    js.enumerable !== undefined ? js.enumerable : false, \n    js.value !== undefined ? js.value : null, \n    js.writable !== undefined ? js.writable : false];"
  )
  static native java.lang.Object[] readFields$516(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "s"}, body=
    "var r = $dukescript$self[s];\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object $get$517(java.lang.Object $dukescript$self, java.lang.Object s);

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new RangeError(message);"
  )
  static native java.lang.Object new$518(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new RangeError();"
  )
  static native java.lang.Object new$519();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = RangeError.newRangeError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newRangeError$520(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = RangeError.newRangeError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newRangeError$521();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new ReferenceError(message);"
  )
  static native java.lang.Object new$522(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new ReferenceError();"
  )
  static native java.lang.Object new$523();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = ReferenceError.newReferenceError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newReferenceError$524(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = ReferenceError.newReferenceError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newReferenceError$525();

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.compile();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object compile$526(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "string"}, body=
    "var r = $dukescript$self.exec(string);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object exec$527(java.lang.Object $dukescript$self, java.lang.Object string);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "string"}, body=
    "var r = $dukescript$self.test(string);\n" +
    "return r;"

  )
  static native java.lang.Boolean test$528(java.lang.Object $dukescript$self, java.lang.Object string);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.source !== undefined ? js.source : null, \n    js.global !== undefined ? js.global : false, \n    js.ignoreCase !== undefined ? js.ignoreCase : false, \n    js.multiline !== undefined ? js.multiline : false, \n    js.lastIndex !== undefined ? js.lastIndex : NaN];"
  )
  static native java.lang.Object[] readFields$529(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"pattern", "flags"}, body=
    "return new RegExp(pattern, flags);"
  )
  static native java.lang.Object new$530(java.lang.Object pattern, java.lang.Object flags);

  @net.java.html.js.JavaScriptBody(args={"pattern"}, body=
    "return new RegExp(pattern);"
  )
  static native java.lang.Object new$531(java.lang.Object pattern);

  @net.java.html.js.JavaScriptBody(args={"pattern", "flags"}, body=
    "var r = RegExp.newRegExp(pattern, flags);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newRegExp$532(java.lang.Object pattern, java.lang.Object flags);

  @net.java.html.js.JavaScriptBody(args={"pattern"}, body=
    "var r = RegExp.newRegExp(pattern);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newRegExp$533(java.lang.Object pattern);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.index !== undefined ? js.index : NaN, \n    js.input !== undefined ? js.input : null];"
  )
  static native java.lang.Object[] readFields$534(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.index !== undefined ? js.index : NaN, \n    js.input !== undefined ? js.input : null];"
  )
  static native java.lang.Object[] readFields$535(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native java.lang.String $get$536(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "pos"}, body=
    "var r = $dukescript$self.charAt(pos);\n" +
    "return r;"

  )
  static native java.lang.String charAt$537(java.lang.Object $dukescript$self, java.lang.Object pos);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self.charCodeAt(index);\n" +
    "return r;"

  )
  static native double charCodeAt$538(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "strings"}, body=
    "var r = strings;\n" +
    "var r = $dukescript$self.concat.apply($dukescript$self, r);\n" +
    "return r;"

  )
  static native java.lang.String concat$539(java.lang.Object $dukescript$self, java.lang.Object strings);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchString", "position"}, body=
    "var r = $dukescript$self.indexOf(searchString, position);\n" +
    "return r;"

  )
  static native double indexOf$540(java.lang.Object $dukescript$self, java.lang.Object searchString, java.lang.Object position);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchString"}, body=
    "var r = $dukescript$self.indexOf(searchString);\n" +
    "return r;"

  )
  static native double indexOf$541(java.lang.Object $dukescript$self, java.lang.Object searchString);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchString", "position"}, body=
    "var r = $dukescript$self.lastIndexOf(searchString, position);\n" +
    "return r;"

  )
  static native double lastIndexOf$542(java.lang.Object $dukescript$self, java.lang.Object searchString, java.lang.Object position);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchString"}, body=
    "var r = $dukescript$self.lastIndexOf(searchString);\n" +
    "return r;"

  )
  static native double lastIndexOf$543(java.lang.Object $dukescript$self, java.lang.Object searchString);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "that"}, body=
    "var r = $dukescript$self.localeCompare(that);\n" +
    "return r;"

  )
  static native double localeCompare$544(java.lang.Object $dukescript$self, java.lang.Object that);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "regexp"}, body=
    "var r = $dukescript$self.match(regexp);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object match$545(java.lang.Object $dukescript$self, java.lang.Object regexp);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "regexp"}, body=
    "var r = $dukescript$self.match(regexp);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object match$546(java.lang.Object $dukescript$self, java.lang.Object regexp);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchValue", "replaceValue"}, body=
    "var r = $dukescript$self.replace(searchValue, replaceValue);\n" +
    "return r;"

  )
  static native java.lang.String replace$547(java.lang.Object $dukescript$self, java.lang.Object searchValue, java.lang.Object replaceValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchValue", "replacer"}, javacall = true, body=
    "var r = $dukescript$self.replace(searchValue, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(replacer, [p1,p2]);});\n" +
    "return r;"

  )
  static native java.lang.String replace$548(java.lang.Object $dukescript$self, java.lang.Object searchValue, java.lang.Object replacer);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchValue", "replaceValue"}, body=
    "var r = $dukescript$self.replace(searchValue, replaceValue);\n" +
    "return r;"

  )
  static native java.lang.String replace$549(java.lang.Object $dukescript$self, java.lang.Object searchValue, java.lang.Object replaceValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchValue", "replacer"}, javacall = true, body=
    "var r = $dukescript$self.replace(searchValue, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(replacer, [p1,p2]);});\n" +
    "return r;"

  )
  static native java.lang.String replace$550(java.lang.Object $dukescript$self, java.lang.Object searchValue, java.lang.Object replacer);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "regexp"}, body=
    "var r = $dukescript$self.search(regexp);\n" +
    "return r;"

  )
  static native double search$551(java.lang.Object $dukescript$self, java.lang.Object regexp);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "regexp"}, body=
    "var r = $dukescript$self.search(regexp);\n" +
    "return r;"

  )
  static native double search$552(java.lang.Object $dukescript$self, java.lang.Object regexp);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "return r;"

  )
  static native java.lang.String slice$553(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "return r;"

  )
  static native java.lang.String slice$554(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "return r;"

  )
  static native java.lang.String slice$555(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator", "limit"}, body=
    "var r = $dukescript$self.split(separator, limit);\n" +
    "return r;"

  )
  static native java.lang.String[] split$556(java.lang.Object $dukescript$self, java.lang.Object separator, java.lang.Object limit);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.split(separator);\n" +
    "return r;"

  )
  static native java.lang.String[] split$557(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator", "limit"}, body=
    "var r = $dukescript$self.split(separator, limit);\n" +
    "return r;"

  )
  static native java.lang.String[] split$558(java.lang.Object $dukescript$self, java.lang.Object separator, java.lang.Object limit);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.split(separator);\n" +
    "return r;"

  )
  static native java.lang.String[] split$559(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "from", "length"}, body=
    "var r = $dukescript$self.substr(from, length);\n" +
    "return r;"

  )
  static native java.lang.String substr$560(java.lang.Object $dukescript$self, java.lang.Object from, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "from"}, body=
    "var r = $dukescript$self.substr(from);\n" +
    "return r;"

  )
  static native java.lang.String substr$561(java.lang.Object $dukescript$self, java.lang.Object from);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.substring(start, end);\n" +
    "return r;"

  )
  static native java.lang.String substring$562(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.substring(start);\n" +
    "return r;"

  )
  static native java.lang.String substring$563(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleLowerCase();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleLowerCase$564(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleUpperCase();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleUpperCase$565(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLowerCase();\n" +
    "return r;"

  )
  static native java.lang.String toLowerCase$566(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$567(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toUpperCase();\n" +
    "return r;"

  )
  static native java.lang.String toUpperCase$568(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.trim();\n" +
    "return r;"

  )
  static native java.lang.String trim$569(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.valueOf();\n" +
    "return r;"

  )
  static native java.lang.String valueOf$570(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$571(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"codes"}, body=
    "var r = codes;\n" +
    "var r = String.fromCharCode.apply(this, r);\n" +
    "return r;"

  )
  static native java.lang.String fromCharCode$572(java.lang.Object codes);

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "return new String(value);"
  )
  static native java.lang.Object new$573(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new String();"
  )
  static native java.lang.Object new$574();

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "var r = String.newString(value);\n" +
    "return r;"

  )
  static native java.lang.String newString$575(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = String.newString();\n" +
    "return r;"

  )
  static native java.lang.String newString$576();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new SyntaxError(message);"
  )
  static native java.lang.Object new$577(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new SyntaxError();"
  )
  static native java.lang.Object new$578();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = SyntaxError.newSyntaxError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newSyntaxError$579(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = SyntaxError.newSyntaxError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newSyntaxError$580();

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.raw !== undefined ? js.raw : null];"
  )
  static native java.lang.Object[] readFields$581(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new TypeError(message);"
  )
  static native java.lang.Object new$582(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new TypeError();"
  )
  static native java.lang.Object new$583();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = TypeError.newTypeError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newTypeError$584(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = TypeError.newTypeError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newTypeError$585();

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.enumerable !== undefined ? js.enumerable : false, \n    js.configurable !== undefined ? js.configurable : false, \n    js.writable !== undefined ? js.writable : false, \n    js.value !== undefined ? js.value : null, \n    js.get !== undefined ? js.get : null, \n    js.set !== undefined ? js.set : null];"
  )
  static native java.lang.Object[] readFields$586(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "return new URIError(message);"
  )
  static native java.lang.Object new$587(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "return new URIError();"
  )
  static native java.lang.Object new$588();

  @net.java.html.js.JavaScriptBody(args={"message"}, body=
    "var r = URIError.newURIError(message);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newURIError$589(java.lang.Object message);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = URIError.newURIError();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object newURIError$590();

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$591(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$592(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$593(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$594(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$595(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$596(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$597(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$598(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$599(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$600(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$601(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$602(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$603(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$604(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$605(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$606(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$607(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$608(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$609(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$610(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$611(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$612(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$613(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$614(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$615(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$616(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$617(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$618(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$619(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$620(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$621(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$622(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$623(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$624(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$625(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$626(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$627(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$628(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$629(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$630(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$631(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$632(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$633(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$634(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$635(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$636(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Uint16Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$637(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Uint16Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$638(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Uint16Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$639(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Uint16Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$640(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Uint16Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$641(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Uint16Array(buffer);"
  )
  static native java.lang.Object new$642(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Uint16Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$643(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Uint16Array(array);"
  )
  static native java.lang.Object new$644(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Uint16Array(length);"
  )
  static native java.lang.Object new$645(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$646(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$647(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$648(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$649(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$650(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$651(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$652(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$653(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$654(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$655(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$656(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$657(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$658(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$659(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$660(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$661(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$662(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$663(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$664(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$665(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$666(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$667(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$668(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$669(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$670(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$671(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$672(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$673(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$674(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$675(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$676(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$677(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$678(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$679(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$680(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$681(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$682(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$683(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$684(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$685(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$686(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$687(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$688(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$689(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$690(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$691(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Uint32Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$692(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Uint32Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$693(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Uint32Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$694(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Uint32Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$695(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Uint32Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$696(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Uint32Array(buffer);"
  )
  static native java.lang.Object new$697(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Uint32Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$698(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Uint32Array(array);"
  )
  static native java.lang.Object new$699(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Uint32Array(length);"
  )
  static native java.lang.Object new$700(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$701(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$702(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$703(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$704(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$705(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$706(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$707(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$708(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$709(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$710(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$711(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$712(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$713(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$714(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$715(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$716(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$717(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$718(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$719(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$720(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$721(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$722(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$723(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$724(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$725(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$726(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$727(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$728(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$729(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$730(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$731(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$732(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$733(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$734(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$735(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$736(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$737(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$738(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$739(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$740(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$741(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$742(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$743(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$744(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$745(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$746(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Uint8Array.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$747(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Uint8Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$748(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Uint8Array.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$749(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Uint8Array.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$750(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Uint8Array(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$751(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Uint8Array(buffer);"
  )
  static native java.lang.Object new$752(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Uint8Array(buffer, byteOffset);"
  )
  static native java.lang.Object new$753(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Uint8Array(array);"
  )
  static native java.lang.Object new$754(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Uint8Array(length);"
  )
  static native java.lang.Object new$755(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index"}, body=
    "var r = $dukescript$self[index];\n" +
    "return r;"

  )
  static native double $get$756(java.lang.Object $dukescript$self, java.lang.Object index);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start", "end"}, body=
    "var r = $dukescript$self.copyWithin(target, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$757(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "target", "start"}, body=
    "var r = $dukescript$self.copyWithin(target, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object copyWithin$758(java.lang.Object $dukescript$self, java.lang.Object target, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean every$759(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.every(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean every$760(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start", "end"}, body=
    "var r = $dukescript$self.fill(value, start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$761(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value"}, body=
    "var r = $dukescript$self.fill(value);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$762(java.lang.Object $dukescript$self, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "value", "start"}, body=
    "var r = $dukescript$self.fill(value, start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object fill$763(java.lang.Object $dukescript$self, java.lang.Object value, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$764(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.filter(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object filter$765(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native double find$766(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.find(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native double find$767(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);}, thisArg);\n" +
    "return r;"

  )
  static native double findIndex$768(java.lang.Object $dukescript$self, java.lang.Object predicate, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "predicate"}, javacall = true, body=
    "var r = $dukescript$self.findIndex(function(p1) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(predicate, [p1]);});\n" +
    "return r;"

  )
  static native double findIndex$769(java.lang.Object $dukescript$self, java.lang.Object predicate);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native void forEach$770(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.forEach(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native void forEach$771(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.indexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double indexOf$772(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.indexOf(searchElement);\n" +
    "return r;"

  )
  static native double indexOf$773(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "separator"}, body=
    "var r = $dukescript$self.join(separator);\n" +
    "return r;"

  )
  static native java.lang.String join$774(java.lang.Object $dukescript$self, java.lang.Object separator);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.join();\n" +
    "return r;"

  )
  static native java.lang.String join$775(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement", "fromIndex"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement, fromIndex);\n" +
    "return r;"

  )
  static native double lastIndexOf$776(java.lang.Object $dukescript$self, java.lang.Object searchElement, java.lang.Object fromIndex);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "searchElement"}, body=
    "var r = $dukescript$self.lastIndexOf(searchElement);\n" +
    "return r;"

  )
  static native double lastIndexOf$777(java.lang.Object $dukescript$self, java.lang.Object searchElement);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$778(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.map(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object map$779(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduce$780(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduce$781(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduce(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduce$782(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "return r;"

  )
  static native double reduceRight$783(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);});\n" +
    "return r;"

  )
  static native double reduceRight$784(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "initialValue"}, javacall = true, body=
    "var r = $dukescript$self.reduceRight(function(p1,p2,p3,p4) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3,p4]);}, initialValue);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native <U> java.lang.Object reduceRight$785(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object initialValue);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.reverse();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object reverse$786(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array", "offset"}, body=
    "var r = $dukescript$self.set(array, offset);\n" +
    "return r;"

  )
  static native void set$787(java.lang.Object $dukescript$self, java.lang.Object array, java.lang.Object offset);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "array"}, body=
    "var r = $dukescript$self.set(array);\n" +
    "return r;"

  )
  static native void set$788(java.lang.Object $dukescript$self, java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "index", "value"}, body=
    "var r = $dukescript$self.set(index, value);\n" +
    "return r;"

  )
  static native void set$789(java.lang.Object $dukescript$self, java.lang.Object index, java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start", "end"}, body=
    "var r = $dukescript$self.slice(start, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$790(java.lang.Object $dukescript$self, java.lang.Object start, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.slice();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$791(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "start"}, body=
    "var r = $dukescript$self.slice(start);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object slice$792(java.lang.Object $dukescript$self, java.lang.Object start);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn", "thisArg"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);}, thisArg);\n" +
    "return r;"

  )
  static native java.lang.Boolean some$793(java.lang.Object $dukescript$self, java.lang.Object callbackfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "callbackfn"}, javacall = true, body=
    "var r = $dukescript$self.some(function(p1,p2,p3) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(callbackfn, [p1,p2,p3]);});\n" +
    "return r;"

  )
  static native java.lang.Boolean some$794(java.lang.Object $dukescript$self, java.lang.Object callbackfn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "compareFn"}, javacall = true, body=
    "var r = $dukescript$self.sort(function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(compareFn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$795(java.lang.Object $dukescript$self, java.lang.Object compareFn);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.sort();\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object sort$796(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin", "end"}, body=
    "var r = $dukescript$self.subarray(begin, end);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$797(java.lang.Object $dukescript$self, java.lang.Object begin, java.lang.Object end);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self", "begin"}, body=
    "var r = $dukescript$self.subarray(begin);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object subarray$798(java.lang.Object $dukescript$self, java.lang.Object begin);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toLocaleString();\n" +
    "return r;"

  )
  static native java.lang.String toLocaleString$799(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"$dukescript$self"}, body=
    "var r = $dukescript$self.toString();\n" +
    "return r;"

  )
  static native java.lang.String toString$800(java.lang.Object $dukescript$self);

  @net.java.html.js.JavaScriptBody(args={"js"}, body =
    "\nreturn [\n    js.BYTES_PER_ELEMENT !== undefined ? js.BYTES_PER_ELEMENT : NaN, \n    js.buffer !== undefined ? js.buffer : null, \n    js.byteLength !== undefined ? js.byteLength : NaN, \n    js.byteOffset !== undefined ? js.byteOffset : NaN, \n    js.length !== undefined ? js.length : NaN];"
  )
  static native java.lang.Object[] readFields$801(java.lang.Object js);
  @net.java.html.js.JavaScriptBody(args={"items"}, body=
    "var r = items;\n" +
    "var r = Uint8ClampedArray.of.apply(this, r);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object of$802(java.lang.Object items);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn", "thisArg"}, javacall = true, body=
    "var r = Uint8ClampedArray.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);}, thisArg);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$803(java.lang.Object arrayLike, java.lang.Object mapfn, java.lang.Object thisArg);

  @net.java.html.js.JavaScriptBody(args={"arrayLike"}, body=
    "var r = Uint8ClampedArray.from(arrayLike);\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$804(java.lang.Object arrayLike);

  @net.java.html.js.JavaScriptBody(args={"arrayLike", "mapfn"}, javacall = true, body=
    "var r = Uint8ClampedArray.from(arrayLike, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(mapfn, [p1,p2]);});\n" +
    "var t = typeof r;\n" + 
    "return r;"

  )
  static native java.lang.Object from$805(java.lang.Object arrayLike, java.lang.Object mapfn);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset", "length"}, body=
    "return new Uint8ClampedArray(buffer, byteOffset, length);"
  )
  static native java.lang.Object new$806(java.lang.Object buffer, java.lang.Object byteOffset, java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"buffer"}, body=
    "return new Uint8ClampedArray(buffer);"
  )
  static native java.lang.Object new$807(java.lang.Object buffer);

  @net.java.html.js.JavaScriptBody(args={"buffer", "byteOffset"}, body=
    "return new Uint8ClampedArray(buffer, byteOffset);"
  )
  static native java.lang.Object new$808(java.lang.Object buffer, java.lang.Object byteOffset);

  @net.java.html.js.JavaScriptBody(args={"array"}, body=
    "return new Uint8ClampedArray(array);"
  )
  static native java.lang.Object new$809(java.lang.Object array);

  @net.java.html.js.JavaScriptBody(args={"length"}, body=
    "return new Uint8ClampedArray(length);"
  )
  static native java.lang.Object new$810(java.lang.Object length);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.abs(x);\n" +
    "return r;"

  )
  static native double abs$811(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.acos(x);\n" +
    "return r;"

  )
  static native double acos$812(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.asin(x);\n" +
    "return r;"

  )
  static native double asin$813(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.atan(x);\n" +
    "return r;"

  )
  static native double atan$814(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"y", "x"}, body=
    "var r = Math.atan2(y, x);\n" +
    "return r;"

  )
  static native double atan2$815(java.lang.Object y, java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.ceil(x);\n" +
    "return r;"

  )
  static native double ceil$816(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.cos(x);\n" +
    "return r;"

  )
  static native double cos$817(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.exp(x);\n" +
    "return r;"

  )
  static native double exp$818(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.floor(x);\n" +
    "return r;"

  )
  static native double floor$819(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.log(x);\n" +
    "return r;"

  )
  static native double log$820(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"values"}, body=
    "var r = values;\n" +
    "var r = Math.max.apply(this, r);\n" +
    "return r;"

  )
  static native double max$821(java.lang.Object values);

  @net.java.html.js.JavaScriptBody(args={"values"}, body=
    "var r = values;\n" +
    "var r = Math.min.apply(this, r);\n" +
    "return r;"

  )
  static native double min$822(java.lang.Object values);

  @net.java.html.js.JavaScriptBody(args={"x", "y"}, body=
    "var r = Math.pow(x, y);\n" +
    "return r;"

  )
  static native double pow$823(java.lang.Object x, java.lang.Object y);

  @net.java.html.js.JavaScriptBody(args={}, body=
    "var r = Math.random();\n" +
    "return r;"

  )
  static native double random$824();

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.round(x);\n" +
    "return r;"

  )
  static native double round$825(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.sin(x);\n" +
    "return r;"

  )
  static native double sin$826(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.sqrt(x);\n" +
    "return r;"

  )
  static native double sqrt$827(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={"x"}, body=
    "var r = Math.tan(x);\n" +
    "return r;"

  )
  static native double tan$828(java.lang.Object x);

  @net.java.html.js.JavaScriptBody(args={}, body =
    "return [\n    E !== undefined ? E : NaN, \n    LN10 !== undefined ? LN10 : NaN, \n    LN2 !== undefined ? LN2 : NaN, \n    LOG2E !== undefined ? LOG2E : NaN, \n    LOG10E !== undefined ? LOG10E : NaN, \n    PI !== undefined ? PI : NaN, \n    SQRT1_2 !== undefined ? SQRT1_2 : NaN, \n    SQRT2 !== undefined ? SQRT2 : NaN];"
  )
  static native java.lang.Object[] readStaticFields$829();
  @net.java.html.js.JavaScriptBody(args={"text", "reviver"}, javacall = true, body=
    "var r = JSON.parse(text, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(reviver, [p1,p2]);});\n" +
    "return r;"

  )
  static native java.lang.Object parse$830(java.lang.Object text, java.lang.Object reviver);

  @net.java.html.js.JavaScriptBody(args={"text"}, body=
    "var r = JSON.parse(text);\n" +
    "return r;"

  )
  static native java.lang.Object parse$831(java.lang.Object text);

  @net.java.html.js.JavaScriptBody(args={"value"}, body=
    "var r = JSON.stringify(value);\n" +
    "return r;"

  )
  static native java.lang.String stringify$832(java.lang.Object value);

  @net.java.html.js.JavaScriptBody(args={"value", "replacer"}, body=
    "var r = JSON.stringify(value, replacer);\n" +
    "return r;"

  )
  static native java.lang.String stringify$833(java.lang.Object value, java.lang.Object replacer);

  @net.java.html.js.JavaScriptBody(args={"value", "replacer", "space"}, body=
    "var r = JSON.stringify(value, replacer, space);\n" +
    "return r;"

  )
  static native java.lang.String stringify$834(java.lang.Object value, java.lang.Object replacer, java.lang.Object space);

  @net.java.html.js.JavaScriptBody(args={"value", "replacer"}, javacall = true, body=
    "var r = JSON.stringify(value, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(replacer, [p1,p2]);});\n" +
    "return r;"

  )
  static native java.lang.String stringify$835(java.lang.Object value, java.lang.Object replacer);

  @net.java.html.js.JavaScriptBody(args={"value", "replacer", "space"}, javacall = true, body=
    "var r = JSON.stringify(value, function(p1,p2) { return @net.java.html.lib.Function::$call(Ljava/lang/Object;[Ljava/lang/Object;)(replacer, [p1,p2]);}, space);\n" +
    "return r;"

  )
  static native java.lang.String stringify$836(java.lang.Object value, java.lang.Object replacer, java.lang.Object space);

  @net.java.html.js.JavaScriptBody(args = {}, body = "return Error.prototype;")
  static native java.lang.Object readStaticFields$131();
  
}
