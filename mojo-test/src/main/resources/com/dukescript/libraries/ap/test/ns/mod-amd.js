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
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};

function define(deps, fn) {
    fn(null, this);
}

define(["require", "exports"], function (require, exports) {
    var geo;
    (function (geo) {
        var Circle = (function () {
            function Circle() {
            }
            return Circle;
        })();
        geo.Circle = Circle;
        var Elipse = (function (_super) {
            __extends(Elipse, _super);
            function Elipse() {
                _super.apply(this, arguments);
            }
            return Elipse;
        })(Circle);
        geo.Elipse = Elipse;
        geo.createCircle = function() {
            geo.countCircle++;
            return new Circle();
        };
        geo.countCircle = 0;
    })(geo = exports.geo || (exports.geo = {}));

    exports.math = {
        hello : function () {
            return "Hello";
        }
    };
});
