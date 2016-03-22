package com.dukescript.libraries.ko;

import java.util.concurrent.CountDownLatch;
import net.java.html.BrwsrCtx;
import net.java.html.boot.BrowserBuilder;
import net.java.html.js.JavaScriptBody;
import net.java.html.json.Model;
import net.java.html.json.Models;
import net.java.html.lib.Objs;
import net.java.html.lib.Function;
import net.java.html.lib.ko.KnockoutObservable;
import static net.java.html.lib.ko.Exports.ko;
import static net.java.html.lib.dom.Exports.window;
import org.junit.Assert;
import org.junit.Test;

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

@Model(className = "KnockoutModel", properties = {
})
public class KnockoutTest {
    void onPageLoad() {
        Objs obj = new Objs();
        KnockoutObservable msg = ko.observable("It runs!");
        obj.$set("msg", msg);
        ko.applyBindings(obj);
        assertText("It runs!");
        msg.$apply("It runs even better!");
        assertText("It runs even better!");
    }

    void initializeRoute() {
        Objs routing = new Objs();
        class Init implements Function.A2<Object,Function.A0<Object>, Void> {
            @Override
            public Void call(Object p1, Function.A0<Object> p2) {
                Function.A0<Void> onHashChange = () -> {
                    String hash = window.location().hash().substring(2);
                    int at = hash.lastIndexOf("/");
                    String after = hash.substring(at + 1);
                    Function.A1<Object, ?> callback = (Function.A1<Object,?>) p2.call();
                    callback.call(after);
                    return null;
                };
                window.$set("onhashchange", onHashChange);
                return null;
            }
        }
        routing.$set("init", new Init());
        ko.bindingHandlers().$set("route", routing);
    }

    String assertText(String msg) {
        String txt = window.document().getElementById("text").innerHTML();
        if (msg == null) {
            return txt;
        }
        Assert.assertEquals(msg, txt);
        return txt;
    }

    @JavaScriptBody(args = {}, body =
          "var e = window.document.getElementById('home');\n "
        + "var ev = window.document.createEvent('MouseEvents');\n "
        + "ev.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);\n "
        + "e.dispatchEvent(ev);\n "
        + "if (!e.checked) {\n"
        + "  e.checked = true;\n "
        + "  e.dispatchEvent(ev);\n "
        + "}\n"
    )
    public native void triggerClick();
    
    /*
    void triggerClick() {
        Document d = window.document.call();
        HTMLElement e = d.getElementById("home");
        MouseEvent ev = (MouseEvent)d.createEvent("MouseEvents");
        ev.initMouseEvent("click", true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
        e.dispatchEvent(ev);
        if (!e.checked) {
            e.checked = true;
            e.dispatchEvent(ev);
        }
    }
*/

    @Test
    public void initPresenter() throws Exception {
        CountDownLatch ok = new CountDownLatch(1);
        BrwsrCtx[] ctx = { null };
        final BrowserBuilder builder = BrowserBuilder.newBrowser().
            loadPage("index.html").
            loadFinished(new Runnable() {
                @Override
                public void run() {
                    Models.toRaw(new KnockoutModel());
                    initializeRoute();
                    onPageLoad();
                    ctx[0] = BrwsrCtx.findDefault(KnockoutTest.class);
                    ok.countDown();
                }
                
            });
        new Thread("Initialize") {
            @Override
            public void run() {
                builder.showAndWait();
            }
        }.start();

        ok.await();

        for (;;) {
            String[] currentText = { null };
            CountDownLatch clickOk = new CountDownLatch(1);
            ctx[0].execute(() -> {
                triggerClick();
                currentText[0] = assertText(null);
                clickOk.countDown();
            });
            clickOk.await();

            if ("home".equals(currentText[0])) {
                break;
            }
        }
    }
}
