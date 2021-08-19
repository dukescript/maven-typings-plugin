/*
 * #%L
 * Annotation Processor Tests - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 - 2016 Dukehoff GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

var compute = eval;

function emptyVector() {
  return [];
}

function addVector(v, y) {
  return v.concat([y]);
}

function StringStack(next){
    this.name = "Ahoj";
    this.stack = [];
    this.next = next;
}
StringStack.prototype.push = function(item) {
    this.stack.push(item);
};
StringStack.prototype.pop = function() {
    return this.stack.pop();
};
StringStack.prototype.lengths = function() {
    var arr = [];
    for (var i = 0; i < this.stack.length; i++) {
        arr.push(this.stack[i].length);
    }
    return arr;
};

var Attr = function() {
    return this;
};
Attr.prototype = Object.prototype;

var AttrValueInitialized = 1;
var UnionInitialized = true;

var singletonNumber = {
    value: function(x, y) {
        return x + y;
    }
};

var firstValue = function() {
    return function(x, y) {
        return x;
    };
};

var ab = {
    b: {
        a: {
            b: "Hi"
        }
    }
};
function fAB() {
    return ab;
}

