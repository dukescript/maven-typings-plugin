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
function compose(f, g) {
    return function(x) {
        return g(f(x));
    };
}

var fn = function() {
    if (arguments.length === 0) {
        return "Hi";
    } else {
        return "Length" + arguments[0];
    }
};
fn.fourtyTwo = 42;
fn.rec = fn;
fn.first = function(first, next) {
    return first;
};

var fnT = fn;

var rev = {
};
rev.reverse = function(arr) {
    var ret = new Array(arr.length);
    for (var i = 0; i < arr.length; i++) {
        ret[i] = arr[arr.length - 1 - i];
    }
    return ret;
};
rev.notify = function() { return 42; };

function literal(s) {
    switch (s) {
        case 'boolean': return true;
        case 'number': return 1;
    }
    return false;
}

var scope = {
    $compute : function(c) { return c(scope); }
}
