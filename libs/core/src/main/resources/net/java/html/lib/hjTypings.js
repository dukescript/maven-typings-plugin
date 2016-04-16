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
(function () {
    var t = {};
    function HtmlJavaArray() {
    }
    function HtmlJavaArrayUpdate(arr, hjArray) {
        hjArray.length = arr.length;
        hjArray.arr = arr;
        for (var i = 0; i < arr.length; i++) {
            hjArray[i] = arr[i];
        }
    }
    function newArray(arr) {
        var obj = new HtmlJavaArray;
        HtmlJavaArrayUpdate(arr, obj);
        return obj;
    }
    
    HtmlJavaArray.prototype.push = function() {
        var ret = this.arr.push.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return ret;
    };
    HtmlJavaArray.prototype.reverse = function() {
        var ret = this.arr.reverse.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return this;
    };
    HtmlJavaArray.prototype.pop = function() {
        return this.arr.pop.apply(this.arr, arguments);
    };
    HtmlJavaArray.prototype.slice = function() {
        var ret = this.arr.slice.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return ret;
    };
    HtmlJavaArray.prototype.splice = function() {
        var ret = this.arr.splice.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return newArray(ret);
    };
    HtmlJavaArray.prototype.shift = function() {
        var ret = this.arr.shift.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return ret === undefined ? null : ret;
    };
    HtmlJavaArray.prototype.sort = function() {
        this.arr.sort.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return this;
    };
    HtmlJavaArray.prototype.join = function() {
        return this.arr.join.apply(this.arr, arguments);
    };
    HtmlJavaArray.prototype.indexOf = function() {
        return this.arr.indexOf.apply(this.arr, arguments);
    };
    HtmlJavaArray.prototype.lastIndexOf = function() {
        return this.arr.lastIndexOf.apply(this.arr, arguments);
    };
    HtmlJavaArray.prototype.concat = function() {
        var ret = this.arr.concat.apply(this.arr, arguments);
        return newArray(ret);
    };
    HtmlJavaArray.prototype.map = function() {
        var ret = this.arr.map.apply(this.arr, arguments);
        return newArray(ret);
    };
    HtmlJavaArray.prototype.filter = function() {
        var ret = this.arr.filter.apply(this.arr, arguments);
        return newArray(ret);
    };
    HtmlJavaArray.prototype.forEach = function() {
        var ret = this.arr.forEach.apply(this.arr, arguments);
        HtmlJavaArrayUpdate(this.arr, this);
        return ret;
    };
    HtmlJavaArray.prototype.some = function() {
        var ret = this.arr.some.apply(this.arr, arguments);
        return ret;
    };
    HtmlJavaArray.prototype.reduce = function() {
        var ret = this.arr.reduce.apply(this.arr, arguments);
        return ret;
    };
    HtmlJavaArray.prototype.reduceRight = function() {
        var ret = this.arr.reduceRight.apply(this.arr, arguments);
        return ret;
    };
    HtmlJavaArray.prototype.toString = function() {
        var ret = this.arr.toString();
        return ret;
    };
    HtmlJavaArray.prototype.toLocaleString = function() {
        var ret = this.arr.toLocaleString();
        return ret;
    };


    t.array = newArray;
    this['hj'] = t;
})();
