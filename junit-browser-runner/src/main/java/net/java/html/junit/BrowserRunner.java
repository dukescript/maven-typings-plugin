package net.java.html.junit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import net.java.html.BrwsrCtx;
import net.java.html.boot.BrowserBuilder;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.netbeans.html.boot.spi.Fn;

/*
 * #%L
 * DukeScript JUnit Runner - a library from the DukeScript project.
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

public final class BrowserRunner extends Suite {
    private final List<Runner> cases;

    public BrowserRunner(Class<?> klass) throws InitializationError {
        super(klass, Collections.<Runner>emptyList());
        cases = new ArrayList<>();
        for (Info info : create(klass)) {
            cases.add(new SingleBrowserRunner(info.name, info.ctx, klass));
        }
        if (cases.isEmpty()) {
            throw new InitializationError("No presenter found. Add net.java.html.fx or script JAR on classpath!");
        }
    }
    @Override
    protected List<Runner> getChildren() {
        return cases;
    }

    private static Info[] contexts;
    private static Info[] create(Class<?> klass) throws InitializationError {
        if (contexts != null) {
            return contexts;
        }
        final String url;
        try {
            final File page = File.createTempFile("test", ".html");
            HTMLContent content = klass.getAnnotation(HTMLContent.class);
            if (content != null) {
                try (FileWriter w = new FileWriter(page)) {
                    w.write(content.value());
                }
            }
            url = page.toURI().toASCIIString();
            page.deleteOnExit();
        } catch (IOException ex) {
            throw new InitializationError(ex);
        }
        List<Info> ctxs = new ArrayList<>();
        for (Fn.Presenter p : ServiceLoader.load(Fn.Presenter.class)) {
            final BrwsrCtx ctx = initPresenter(url, p, klass);
            ctxs.add(new Info(p.getClass().getSimpleName(), ctx));
        }
        try {
            Class<?> scripts = klass.getClassLoader().loadClass("net.java.html.boot.script.Scripts");
            Fn.Presenter p = (Fn.Presenter) scripts.getMethod("createPresenter").invoke(null);
            final BrwsrCtx ctx = initPresenter(url, p, klass);
            ctxs.add(new Info(p.getClass().getSimpleName(), ctx));
        } catch (ClassNotFoundException ex) {
            // OK, go on
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new InitializationError(ex);
        }
        contexts = ctxs.toArray(new Info[ctxs.size()]);
        return contexts;
    }

    private static BrwsrCtx initPresenter(String url, Fn.Presenter p, Class<?> klass) throws InitializationError {
        BrwsrCtx[] ret = { null };
        CountDownLatch cdl = new CountDownLatch(1);
        BrowserBuilder bb = BrowserBuilder.newBrowser(p).loadFinished(new Runnable() {
            @Override
            public void run() {
                ret[0] = BrwsrCtx.findDefault(klass);
                cdl.countDown();
            }
        }).loadPage(url);
        Executors.newSingleThreadExecutor().execute(() -> {
            bb.showAndWait();
        });
        try {
            cdl.await();
        } catch (InterruptedException ex) {
            throw new InitializationError(ex);
        }
        return ret[0];
    }

    private static final class Info {
        final String name;
        final BrwsrCtx ctx;

        public Info(String name, BrwsrCtx ctx) {
            this.name = name;
            this.ctx = ctx;
        }
    }
}
