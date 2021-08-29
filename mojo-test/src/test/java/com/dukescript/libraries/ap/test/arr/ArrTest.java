package com.dukescript.libraries.ap.test.arr;

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

import net.java.html.junit.BrowserRunner;
import net.java.html.lib.Array;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BrowserRunner.class)
public class ArrTest {
    @Test
    public void unitSquare() {
        Array<Point> corners = Exports.square(0, 0, 1);

        assertEquals(0, corners.$get(0).x().doubleValue(), 0.1);
        assertEquals(0, corners.$get(0).y().doubleValue(), 0.1);

        assertEquals(1, corners.$get(1).x().doubleValue(), 0.1);
        assertEquals(0, corners.$get(1).y().doubleValue(), 0.1);

        assertEquals(0, corners.$get(2).x().doubleValue(), 0.1);
        assertEquals(1, corners.$get(2).y().doubleValue(), 0.1);

        assertEquals(1, corners.$get(3).x().doubleValue(), 0.1);
        assertEquals(1, corners.$get(3).y().doubleValue(), 0.1);
    }
}