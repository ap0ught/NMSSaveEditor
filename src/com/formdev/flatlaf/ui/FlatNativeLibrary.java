// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.net.URL;
import java.security.CodeSource;
import java.io.File;
import com.formdev.flatlaf.util.LoggingFacade;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.NativeLibrary;

class FlatNativeLibrary
{
    private static NativeLibrary nativeLibrary;
    
    static synchronized boolean isLoaded() {
        initialize();
        return FlatNativeLibrary.nativeLibrary != null && FlatNativeLibrary.nativeLibrary.isLoaded();
    }
    
    private static void initialize() {
        if (FlatNativeLibrary.nativeLibrary != null) {
            return;
        }
        String classifier;
        String ext;
        if (SystemInfo.isWindows_10_orLater && (SystemInfo.isX86 || SystemInfo.isX86_64)) {
            classifier = (SystemInfo.isX86_64 ? "windows-x86_64" : "windows-x86");
            ext = "dll";
            loadJAWT();
        }
        else {
            if (!SystemInfo.isLinux || !SystemInfo.isX86_64) {
                return;
            }
            classifier = "linux-x86_64";
            ext = "so";
            loadJAWT();
        }
        FlatNativeLibrary.nativeLibrary = createNativeLibrary(classifier, ext);
    }
    
    private static NativeLibrary createNativeLibrary(final String classifier, final String ext) {
        final String libraryName = "flatlaf-" + classifier;
        final String libraryPath = System.getProperty("flatlaf.nativeLibraryPath");
        if (libraryPath != null) {
            if ("system".equals(libraryPath)) {
                final NativeLibrary library = new NativeLibrary(libraryName, true);
                if (library.isLoaded()) {
                    return library;
                }
                LoggingFacade.INSTANCE.logSevere("Did not find library " + libraryName + " in java.library.path, using extracted library instead", null);
            }
            else {
                final File libraryFile = new File(libraryPath, System.mapLibraryName(libraryName));
                if (libraryFile.exists()) {
                    return new NativeLibrary(libraryFile, true);
                }
                LoggingFacade.INSTANCE.logSevere("Did not find external library " + libraryFile + ", using extracted library instead", null);
            }
        }
        final File libraryFile = findLibraryBesideJar(classifier, ext);
        if (libraryFile != null) {
            return new NativeLibrary(libraryFile, true);
        }
        return new NativeLibrary("com/formdev/flatlaf/natives/" + libraryName, null, true);
    }
    
    private static File findLibraryBesideJar(final String classifier, final String ext) {
        try {
            final CodeSource codeSource = FlatNativeLibrary.class.getProtectionDomain().getCodeSource();
            final URL jarUrl = (codeSource != null) ? codeSource.getLocation() : null;
            if (jarUrl == null) {
                return null;
            }
            if (!"file".equals(jarUrl.getProtocol())) {
                return null;
            }
            final File jarFile = new File(jarUrl.toURI());
            if (!jarFile.isFile()) {
                return null;
            }
            final String jarName = jarFile.getName();
            final String jarBasename = jarName.substring(0, jarName.lastIndexOf(46));
            final File parent = jarFile.getParentFile();
            final String libraryName = jarBasename + (jarBasename.contains("flatlaf") ? "" : "-flatlaf") + '-' + classifier + '.' + ext;
            File libraryFile = new File(parent, libraryName);
            if (libraryFile.isFile()) {
                return libraryFile;
            }
            if (parent.getName().equalsIgnoreCase("lib")) {
                libraryFile = new File(parent.getParentFile(), "bin/" + libraryName);
                if (libraryFile.isFile()) {
                    return libraryFile;
                }
            }
        }
        catch (final Exception ex) {
            LoggingFacade.INSTANCE.logSevere(ex.getMessage(), ex);
        }
        return null;
    }
    
    private static void loadJAWT() {
        try {
            System.loadLibrary("jawt");
        }
        catch (final UnsatisfiedLinkError ex) {
            final String message = ex.getMessage();
            if (message == null || !message.contains("already loaded in another classloader")) {
                LoggingFacade.INSTANCE.logSevere(message, ex);
            }
        }
        catch (final Exception ex2) {
            LoggingFacade.INSTANCE.logSevere(ex2.getMessage(), ex2);
        }
    }
}
