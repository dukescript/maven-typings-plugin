package net.java.html.lib.dom;

import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import net.java.html.junit.BrowserRunner;
import net.java.html.junit.HTMLContent;
import static net.java.html.lib.dom.Exports.window;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/*
 * #%L
 * DukeScript Libraries Processor - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
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

@RunWith(BrowserRunner.class)
@HTMLContent("\n"
    + "<span id='text'>Nothing yet</span>\n"
)
public class DocumentTest {
    String assertText(String msg) {
        final Document doc = window.document();
        final HTMLElement element = doc.getElementById("text");
        String txt = element.innerHTML();
        if (msg == null) {
            return txt;
        }
        Assert.assertEquals(msg, txt);
        return txt;
    }

    @Test
    public void iterateAllElements() throws Exception {
        final int[] counter = { 0 };
        Logger log = Logger.getLogger("org.netbeans.html.boot.fx.FXPresenter");
        log.setLevel(Level.FINE);
        final Handler handler = new Handler() {
            int report;
            @Override
            public void publish(LogRecord record) {
                if (record.getMessage().contains("calling")) {
                    counter[0]++;
                    if (report++ > 5) {
                        Thread.dumpStack();
                        report = 0;
                    }
                }
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() throws SecurityException {
            }
        };
        handler.setLevel(Level.FINE);
        log.addHandler(handler);
        assertText("Nothing yet");
        NodeListOf<Element> all = window.document().getElementsByTagName("span");
        for (int i = 0; i < all.length().intValue(); i++) {
            Element el = all.$get(i);
            el.textContent.set("Hi there!");
        }
        log.removeHandler(handler);
        assertText("Hi there!");

        if (counter[0] < 10 || counter[0] > 30) {
            fail("Too many (" + counter[0] + ") calls into JavaScript");
        }
    }
}
