// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.IOException;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.net.URL;
import java.util.HashMap;
import javax.swing.plaf.UIResource;
import javax.swing.text.StyleContext;
import java.awt.Font;
import java.util.Map;

public class FontUtils
{
    private static Map<String, Runnable> loadersMap;
    
    public static Font getCompositeFont(final String family, final int style, final int size) {
        loadFontFamily(family);
        Font font = StyleContext.getDefaultStyleContext().getFont(family, style, size);
        if (font instanceof UIResource) {
            font = font.deriveFont(font.getStyle());
        }
        return font;
    }
    
    public static void registerFontFamilyLoader(final String family, final Runnable loader) {
        if (FontUtils.loadersMap == null) {
            FontUtils.loadersMap = new HashMap<String, Runnable>();
        }
        FontUtils.loadersMap.put(family, loader);
    }
    
    public static void loadFontFamily(final String family) {
        if (!hasLoaders()) {
            return;
        }
        final Runnable loader = FontUtils.loadersMap.remove(family);
        if (loader != null) {
            loader.run();
        }
        if (FontUtils.loadersMap.isEmpty()) {
            FontUtils.loadersMap = null;
        }
    }
    
    public static boolean installFont(final URL url) {
        try (final InputStream in = url.openStream()) {
            final Font font = Font.createFont(0, in);
            return GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        }
        catch (final FontFormatException | IOException ex) {
            LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to install font " + url, ex);
            return false;
        }
    }
    
    public static String[] getAvailableFontFamilyNames() {
        final String[] availableFontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        if (!hasLoaders()) {
            return availableFontFamilyNames;
        }
        final ArrayList<String> result = new ArrayList<String>(availableFontFamilyNames.length + FontUtils.loadersMap.size());
        for (final String name : availableFontFamilyNames) {
            result.add(name);
        }
        for (final String name2 : FontUtils.loadersMap.keySet()) {
            if (!result.contains(name2)) {
                result.add(name2);
            }
        }
        return result.toArray(new String[result.size()]);
    }
    
    public static Font[] getAllFonts() {
        if (hasLoaders()) {
            final String[] array;
            final String[] families = array = FontUtils.loadersMap.keySet().toArray(new String[FontUtils.loadersMap.size()]);
            for (final String family : array) {
                loadFontFamily(family);
            }
        }
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    }
    
    private static boolean hasLoaders() {
        return FontUtils.loadersMap != null && !FontUtils.loadersMap.isEmpty();
    }
}
