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

export var circle: geo.Circle;

export module geo {
    export class Circle {
    }
    export class Elipse extends Circle {
    }
}

declare var math: math.MathStatic;
declare namespace math {
    interface MathStatic {
        hello(): ComNum;
    }
    export module complex {
        interface ComNum {
            toString(): String;
        }
    }
}

export module geo2d {
    import * as geo from "geo";
    export interface Elipse extends geo.Elipse {
    }
}

export module geo3d {
    import * as geo from "geo";
    export interface Elipse extends geo.Elipse {
    }
}

export module geo3dplus {
    import * as geo3d from "geo3d";
    export interface Elipse extends geo3d.Elipse {
    }
}

