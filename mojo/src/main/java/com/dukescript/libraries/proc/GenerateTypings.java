package com.dukescript.libraries.proc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;

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
@Mojo(name = "generate",
    requiresDependencyResolution = ResolutionScope.COMPILE,
    defaultPhase = LifecyclePhase.GENERATE_SOURCES
)
public final class GenerateTypings extends AbstractMojo {
    @org.apache.maven.plugins.annotations.Parameter(defaultValue = "${project}")
    private MavenProject prj;

    @Component
    private MavenProjectHelper projectHelper;

    @org.apache.maven.plugins.annotations.Parameter
    private File typings;

    @org.apache.maven.plugins.annotations.Parameter(alias = "package")
    private String packageName;

    @org.apache.maven.plugins.annotations.Parameter
    private List<String> imports;

    @org.apache.maven.plugins.annotations.Parameter
    private List<String> scripts;

    @org.apache.maven.plugins.annotations.Parameter(defaultValue = "${project.build.directory}/generated-sources/typings/")
    private File output;

    @org.apache.maven.plugins.annotations.Parameter(defaultValue = "${project.build.outputDirectory}")
    private File classes;

    @org.apache.maven.plugins.annotations.Parameter(defaultValue = "")
    private String globalModuleName;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (typings == null) {
            throw new MojoExecutionException("Specify typings to point to TypeScript typings file");
        }
        if (!typings.canRead()) {
            throw new MojoExecutionException("typings file doesn't seem to exist: " + typings);
        }
        if (packageName == null) {
            throw new MojoExecutionException("package must be set!");
        }
        if (output.isDirectory()) {
            File pkgOutput = new File(output, packageName.replace('.', File.separatorChar));
            if (pkgOutput.isDirectory()) {
                prj.addCompileSourceRoot(output.getPath());
                getLog().info("Skipping, output directory already exists: " + pkgOutput);
                return;
            }
        }
        List<URL> arr = new ArrayList<>();
        try {
            for (String path : prj.getCompileClasspathElements()) {
                arr.add(new File(path).toURI().toURL());
            }
        } catch (DependencyResolutionRequiredException | MalformedURLException ex) {
            throw new MojoExecutionException("", ex);
        }
        URLClassLoader loader = new URLClassLoader(arr.toArray(new URL[0]));
        MojoGenerator generator = new MojoGenerator(loader);

        String[] libraryScripts = array(scripts);
        for (int i = 0; i < libraryScripts.length; i++) {
            try {
                URL url = new URL(libraryScripts[i]);
                final String urlString = url.toExternalForm();
                String urlName = urlString.substring(urlString.lastIndexOf('/') + 1);
                File copyTo = new File(new File(classes, packageName.replace('.', File.separatorChar)), urlName);
                if (!copyTo.exists()) {
                    copyTo.getParentFile().mkdirs();
                    getLog().info("Downloading " + url + " to " + copyTo);
                    try {
                        Files.copy(url.openStream(), copyTo.toPath());
                    } catch (IOException ex) {
                        throw new MojoExecutionException("Cannot copy " + url + " to " + copyTo);
                    }
                } else {
                    getLog().debug("File " + copyTo + " exists. Skipping download of " + url);
                }
                libraryScripts[i] = copyTo.getName();
                getLog().debug("Using " + libraryScripts[i] + " ");
            } catch (MalformedURLException ex) {
                // OK, keep the script name
            }
        }


        try (FileInputStream is = new FileInputStream(typings)) {
            List<String> activeImports;
            if (imports == null) {
                activeImports = generator.loadImports();
            } else {
                activeImports = imports;
            }
            generator.generateSources(array(activeImports),
                libraryScripts,
                packageName, typings.getName(), is, typings
            );
            prj.addCompileSourceRoot(output.getPath());
        } catch (IOException ex) {
            throw new MojoFailureException("Cannot process " + typings, ex);
        }
    }

    private String[] array(List<String> arr) {
        return arr == null ? new String[0] : arr.toArray(new String[0]);
    }

    private final class MojoGenerator extends Generator<Object> {
        private final ClassLoader classpath;

        public MojoGenerator(ClassLoader classpath) {
            this.classpath = classpath;
        }

        @Override
        protected String globalModuleName() {
            return globalModuleName == null || globalModuleName.isEmpty() ? null : globalModuleName;
        }

        @Override
        protected Writer createSourceFile(String fqn, Object location) throws IOException {
            int lastDot = fqn.lastIndexOf('.');
            File dir = new File(output, fqn.substring(0, lastDot + 1).replace('.', File.separatorChar));
            if (!dir.isDirectory() && !dir.mkdirs()) {
                throw new IOException("Cannot create " + dir);
            }
            return new FileWriter(new File(dir, fqn.substring(lastDot + 1) + ".java"));
        }

        @Override
        protected void registerPackages(String... packages) throws IOException {
            File imports = new File(new File(new File(classes, "META-INF"), "typings"), "package.properties");
            Properties props = new Properties();
            if (imports.exists()) {
                try (InputStream is = new FileInputStream(imports)) {
                    props.load(is);
                }
            } else {
                imports.getParentFile().mkdirs();
            }
            for (String p : packages) {
                props.setProperty(p, typings.getName());
            }
            try (FileOutputStream os = new FileOutputStream(imports)) {
                props.store(os, null);
            }
        }

        List<String> loadImports() throws IOException {
            List<String> allImports = new ArrayList<>();
            Enumeration<URL> en = classpath.getResources("META-INF/typings/package.properties");
            while (en.hasMoreElements()) {
                URL resource = en.nextElement();
                Properties props = new Properties();
                try (InputStream is = resource.openStream()) {
                    props.load(is);
                }
                for (Map.Entry<Object, Object> entry : props.entrySet()) {
                    Object packageImport = entry.getKey();
                    allImports.add(packageImport.toString());
                }
            }
            return allImports;
        }

        @Override
        protected Object findType(String fqn) {
            if (fqn.startsWith("java.lang.")) {
                try {
                    Class<?> clazz = Class.forName(fqn);
                    if ((clazz.getModifiers() & Modifier.PUBLIC) != 0) {
                        return clazz;
                    } else {
                        return null;
                    }
                } catch (ClassNotFoundException ex) {
                    return null;
                }
            }
            final String classResource = fqn.replace('.', '/') + ".class";
            final URL res = classpath.getResource(classResource);
            if (res != null) {
                return res;
            }
            File srcRoot = new File(prj.getBuild().getSourceDirectory());
            String javaResource = fqn.replace('.', '/') + ".java";
            File src = new File(srcRoot, javaResource);
            return src.isFile() ? src : null;
        }

        @Override
        protected void note(String message, Object e) {
            getLog().info(message);
        }

        @Override
        protected void error(String message, Object e) {
            getLog().error(message);
        }
    }
}
