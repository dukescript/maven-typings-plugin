
/*
 * #%L
 * DukeScript Libraries Processor - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
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

function square(lx, ly, size) {
    return [
        { x : lx, y : ly },
        { x : lx + size, y : ly },
        { x : lx, y : ly + size },
        { x : lx + size, y : ly + size }
    ];
}

function squareList(lx, ly, size) {
    var value = square(lx, ly, size);
    var ret = {
        nav : function(at) { return value[at]; }
    };
    for (var i in value) {
        ret[i] = value[i];
    }
    return ret;
}

function squareNav(lx, ly, size) {
    var value = square(lx, ly, size);
    return {
        nav : function(at) { return value[at]; }
    };
}

function singletonArray() {
    return {
        nav: function(p) { return [p]; }
    };
}

function navigableArray() {
    return {
        nav: function(n) { return [n]; }
    };
}