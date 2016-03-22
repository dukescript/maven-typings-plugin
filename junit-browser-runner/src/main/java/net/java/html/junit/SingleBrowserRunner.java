package net.java.html.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import net.java.html.BrwsrCtx;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

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

final class SingleBrowserRunner extends BlockJUnit4ClassRunner {
    private final BrwsrCtx ctx;
    private final String browser;
    SingleBrowserRunner(String browser, BrwsrCtx ctx, Class<?> klass) throws InitializationError {
        super(klass);
        this.browser = browser;
        this.ctx = ctx;
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> methods = super.computeTestMethods();
        List<FrameworkMethod> clone = new ArrayList<>(methods.size());
        for (int i = 0; i < methods.size(); i++) {
            FrameworkMethod m = methods.get(i);
            clone.add(new InBrowserMethod(m.getMethod()));
        }
        return clone;
    }

    @Override
    protected void validateTestMethods(List<Throwable> errors) {
    }

    private class InBrowserMethod extends FrameworkMethod {
        public InBrowserMethod(Method method) {
            super(method);
        }

        @Override
        public String getName() {
            return super.getName() + '[' + browser + ']';
        }

        @Override
        public Object invokeExplosively(Object target, Object... params) throws Throwable {
            CountDownLatch cdl = new CountDownLatch(1);
            Object[] ex = { null };
            List<Runnable> delayed = new ArrayList<>();
            ctx.execute(() -> {
                try {
                    Object ret = super.invokeExplosively(target, params);;
                    if (ret instanceof Runnable) {
                        delayed.add((Runnable) ret);
                    }
                    if (ret instanceof Runnable[]) {
                        delayed.addAll(Arrays.asList(((Runnable[])ret)));
                    }
                } catch (Throwable t) {
                    ex[0] = t;
                } finally {
                    cdl.countDown();
                }
            });
            cdl.await();
            for (Runnable r : delayed) {
                Thread.sleep(100);
                if (ex[0] != null) {
                    break;
                }
                CountDownLatch rDown = new CountDownLatch(1);
                ctx.execute(() -> {
                    try {
                        r.run();
                    } catch (Throwable t) {
                        ex[0] = t;
                    } finally {
                        rDown.countDown();
                    }
                });
                rDown.await();
            }
            if (ex[0] instanceof Throwable) {
                if  (ex[0] instanceof InvocationTargetException) {
                    throw ((InvocationTargetException)ex[0]).getTargetException();
                }
                throw (Throwable)ex[0];
            }
            return null;
        }
    }
}
