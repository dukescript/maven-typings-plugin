
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
 
interface Point {
    x: number;
    y: number;
}

declare function square(lx : number, ly: number, size: number): Array<Point>;

interface Navigable<K,V> {
    nav(index: K) : V;
}

interface List<T> extends Navigable<number,T> {
    [index: number]: T;
}

declare function squareNav(lx : number, ly: number, size: number): Navigable<number, Point>;
declare function squareList(lx : number, ly: number, size: number): List<Point>;

interface MapSingle extends Navigable<Point,Array<Point>> {
}

declare function singletonArray(): MapSingle;