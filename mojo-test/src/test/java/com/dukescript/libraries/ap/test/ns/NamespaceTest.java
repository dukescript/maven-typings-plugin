package com.dukescript.libraries.ap.test.ns;

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

import com.dukescript.libraries.ap.test.ns.geo.Circle;
import com.dukescript.libraries.ap.test.ns.geo.Elipse;
import net.java.html.junit.BrowserRunner;
import net.java.html.lib.Modules;
import net.java.html.lib.Objs;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BrowserRunner.class)
public class NamespaceTest {
    private static ProviderImpl provider;

    @BeforeClass
    public static void registerModuleProvider() {
        provider = new ProviderImpl();
    }

    @AfterClass
    public static void unregisterModuleProvider() {
        provider.remove();
    }

    @Test
    public void elipseIsCircle() {
        Elipse elipse = null;
        Circle circle = elipse;
        Assert.assertNull("Check the value", circle);
    }

    @Test
    public void elipseGeo2d() {
        Elipse elipse;
        elipse = com.dukescript.libraries.ap.test.ns.geo2d.Elipse.$as(this);
        Assert.assertNotNull("Geo2d is elipse", elipse);
    }

    @Test
    public void elipseGeo3d() {
        Elipse elipse;
        elipse = com.dukescript.libraries.ap.test.ns.geo3d.Elipse.$as(this);
        Assert.assertNotNull("Geo3d is elipse", elipse);
    }

    @Test
    public void elipseGeoBoth() {
        com.dukescript.libraries.ap.test.ns.geo3d.Elipse elipse;
        elipse = com.dukescript.libraries.ap.test.ns.geo3dplus.Elipse.$as(this);
        Assert.assertNotNull("Geo3d is elipse", elipse);
    }

    @Test
    public void checkNamespaces() {
        String text = Exports.math.hello().toString();
        Assert.assertEquals("Hello", text);
    }

    @Test
    public void staticModuleFunction() {
        Circle c = com.dukescript.libraries.ap.test.ns.geo.Exports.createCircle();
        assertNotNull("Circle is returned", c);
    }

    @Test
    public void staticModuleValue() {
        double c = com.dukescript.libraries.ap.test.ns.geo.Exports.countCircle;
        Assert.assertEquals("33", 33, c, 0.1);
    }

    private static final class ProviderImpl extends Modules.Provider {
        @Override
        protected Objs find(String id) {
            if (id.equals("geo")) {
                return Objs.$as(Exports.geo);
            }
            return null;
        }

        void remove() {
            super.dispose();
        }
    }
}
