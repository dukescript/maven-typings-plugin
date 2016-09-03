package net.java.html.lib;

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



/** Support for integrating JavaScript modules. Whenever a typings module
 * needs to access its <code>exports</code> object, it uses the
 * {@link #find(java.lang.String)} method with the ID of the object to
 * search for.
 *
 * @since 0.4
 */
public final class Modules {

    private Modules() {
    }

    private static Provider loaders;

    /** Looks a JavaScript module by its id.
     *
     * @param id the string ID to search for
     * @return the JavaScript object or <code>null</code>
     * @since 0.4
     */
    public static Objs find(String id) {
        Provider l = loaders;
        while (l != null) {
            Objs result = l.find(id);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    /** Register provide if you can look JavaScript modules by their names.
     * By subclassing and implementing the {@link #find(java.lang.String)}
     * method you can participate in lookup of module exports objects as
     * used by generated typings <code>Exports</code> classes.
     * @since 0.4
     */
    public static abstract class Provider {
        private Provider next;

        /** Constructor for subclasses. Once the provider is instantiated
         * it gets registered in the system and is available to answer
         * {@link Modules#find(java.lang.String)} queries. Use
         * {@link #dispose()} to unregister the provider.
         * @since 0.4
         */
        protected Provider() {
            synchronized (Modules.class) {
                next = loaders;
                loaders = this;
            }
        }

        /** Seeks for a module with given id.
         *
         * @param id the id of the module to seek for
         * @return JavaScript object representing the module or <code>null</code>,
         *   if this provider cannot resolve the module
         * @since 0.4
         */
        protected abstract Objs find(String id);

        /** Unregisters this provider from the system.
         * @since 0.4
         */
        protected final void dispose() {
            synchronized (Modules.class) {
                Provider l = loaders;
                if (l == this) {
                    loaders = this.next;
                    return;
                }
                while (l != null) {
                    if (l.next == this) {
                        l.next = this.next;
                        break;
                    }
                    l = l.next;
                }
            }
        }
    }

}
