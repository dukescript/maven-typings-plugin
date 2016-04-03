package com.dukescript.libraries.proc;

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

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.java.html.BrwsrCtx;
import net.java.html.boot.script.Scripts;
import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;
import net.java.html.json.Models;
import org.netbeans.html.boot.spi.Fn;

@JavaScriptResource("app.js")
final class Parser {
    private final Fn.Presenter js;
    Parser() throws IOException {
        js = Scripts.createPresenter();
        try (Closeable c = Fn.activate(js)) {
            TypeScript.initialize();
            initialize();
        }
    }

    @JavaScriptBody(args = {  }, body = "")
    private static native void initialize();

    public AST parse(String filename, InputStream is) throws IOException {
        InputStreamReader reader = new InputStreamReader(is, "UTF-8");
        StringBuilder sb = new StringBuilder(4096);
        char[] arr = new char[4096];
        for (;;) {
            int len = reader.read(arr);
            if (len == -1) {
                break;
            }
            sb.append(arr, 0, len);
        }
        final String text = sb.toString();
        final BrwsrCtx ctx = BrwsrCtx.findDefault(AST.class);

        File tmpDir = new File(System.getProperty("java.io.tmpdir"));
        File cache = new File(tmpDir, "ast-" + Integer.toHexString(text.hashCode()) + ".json");

        try (Closeable c = Fn.activate(js)) {
            if (cache.exists()) {
                try (InputStream cachedStream = new FileInputStream(cache)) {
                    return Models.parse(ctx, AST.class, cachedStream);
                }
            }
            boolean wantText = false;
            Object[] astAndText = parseTypeScript(filename, text, wantText);
            Object ast = astAndText[0];
            AST structures = Models.fromRaw(ctx, AST.class, ast);
            try (FileOutputStream os = new FileOutputStream(cache)) {
                os.write(structures.toString().getBytes("UTF-8"));
            }
            return structures;
        }
    }

    @JavaScriptBody(args = { "filename", "source", "wantText" }, body =
        "return parseTypeScript(filename, source, wantText);"
    )
    private static native Object[] parseTypeScript(String filename, String source, boolean wantText);
}
