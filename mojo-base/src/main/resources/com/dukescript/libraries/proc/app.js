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

/* global ts */

function log(msg) {
//    if (typeof console === 'undefined') {
//        print(msg);
//    } else {
//        console.log(msg);
//    }
}


if (typeof window === 'undefined') {
    window = this;
}

function printChildTypes(root, source) {
    var copy = {};
    copy.children = [];
    var space = '';
    ts.forEachChild(root, function P(n) {
        log(space + n.kind + ' ' + ts.SyntaxKind[n.kind]);
        space += '  ';
        copy.children.push(dumpObject(n, space, source));
        ts.forEachChild(n, P);
        space = space.substring(2);
    });
    return copy;
}

function dumpObject(n, space, source) {
    function isArray(obj) {
        return Object.prototype.toString.call(obj) === '[object Array]';
    }

    var copy = isArray(n) ? [] : {};
    var fns = '';
    if (n.pos) {
        var cmnts = ts.getLeadingCommentRanges(source, n.pos);
        if (cmnts) {
            var c = cmnts[0];
            n.comment = source.substring(c.pos, c.end);
        }
    }
    for (var p in n) {
        if (p === 'pos' || p === 'end' || p === 'flags') {
            continue;
        }
        v = n[p];
        if (typeof v === 'function') {
            fns += p + ' ';
            continue;
        }
        if (p === 'kind' || p === 'token') {
            v = ts.SyntaxKind[v];
        }
        log(space + '[' + p + '] = ' + v);
        if (typeof v === 'object') {
            copy[p] = dumpObject(v, space + '  ', source);
        } else {
            copy[p] = v;
        }
    }
    log(space + 'functions: ' + fns.substring(0, 40));
    return copy;
}

function parseTypeScript(filename, source, wantText) {
    var sf = ts.createSourceFile(filename, source, 2 /* Latest */);
    var copy = printChildTypes(sf, source);
    return [copy, wantText ? JSON.stringify(copy) : null];
}
