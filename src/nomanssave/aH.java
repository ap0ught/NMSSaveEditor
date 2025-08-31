// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.FontMetrics;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.stream.Stream;
import java.util.Iterator;
import java.net.URL;
import com.formdev.flatlaf.FlatLaf;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.io.File;

public class aH
{
    private static File cC;
    public static File cD;
    public static File cE;
    public static File cF;
    public static File cG;
    public static int cH;
    public static int cI;
    public static int cJ;
    private static eY cK;
    private static boolean cL;
    private static /* synthetic */ int[] cM;
    
    public static String getProperty(final String s) {
        return aH.cK.getValueAsString(s);
    }
    
    public static void setProperty(final String s, final String s2) {
        if (s2 == null) {
            aH.cK.N(s);
        }
        else {
            aH.cK.c(s, s2);
        }
        aH.cL = true;
    }
    
    public static int j(final String s) {
        return aH.cK.J(s);
    }
    
    public static int a(final String s, final int n) {
        return aH.cK.c(s, n);
    }
    
    public static void b(final String s, final int i) {
        aH.cK.c(s, (Object)i);
        aH.cL = true;
    }
    
    public static double a(final String s, final double n) {
        return aH.cK.c(s, n);
    }
    
    public static void b(final String s, final double d) {
        aH.cK.c(s, (Object)d);
        aH.cL = true;
    }
    
    public static Object[] a(final String s, final Class clazz) {
        final eV d = aH.cK.d(s);
        if (d == null) {
            return (Object[])Array.newInstance(clazz, 0);
        }
        final Object instance = Array.newInstance(clazz, d.size());
        for (int i = 0; i < d.size(); ++i) {
            Array.set(instance, i, clazz.cast(d.getValue(i)));
        }
        return (Object[])instance;
    }
    
    public static void a(final String s, final Object[] array) {
        final eV ev = new eV();
        for (int i = 0; i < array.length; ++i) {
            ev.f(array[i]);
        }
        aH.cK.c(s, ev);
        aH.cL = true;
    }
    
    static boolean T() {
        return aH.cL;
    }
    
    static void U() {
        final String b = fh.b(aH.cK, true);
        try {
            Throwable t = null;
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(aH.cC);
                try {
                    fileOutputStream.write(b.getBytes("UTF-8"));
                    aH.cL = false;
                }
                finally {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            }
            finally {
                if (t == null) {
                    final Throwable exception;
                    t = exception;
                }
                else {
                    final Throwable exception;
                    if (t != exception) {
                        t.addSuppressed(exception);
                    }
                }
            }
        }
        catch (final IOException ex) {
            hc.error("Could not save configuration file", ex);
        }
    }
    
    public static void init(final boolean b) {
        System.out.println("Initializing environment...");
        File file = null;
        try {
            final URL location = Application.class.getProtectionDomain().getCodeSource().getLocation();
            if (b && location.getFile().endsWith(".jar")) {
                file = Paths.get(location.toURI()).toFile().getParentFile();
            }
            else {
                file = new File(".").getCanonicalFile();
            }
        }
        catch (final URISyntaxException ex) {
            System.out.println("Error: cannot find working directory");
            ex.printStackTrace();
            System.exit(1);
        }
        catch (final IOException ex2) {
            System.out.println("Error: cannot find working directory");
            ex2.printStackTrace();
            System.exit(1);
        }
        if (!file.isDirectory()) {
            System.out.println("Error: working directory error: " + file.getAbsolutePath());
            System.exit(1);
        }
        aH.cD = file;
        aH.cC = new File(file, "NMSSaveEditor.conf");
        aH.cE = new File(file, "bases");
        aH.cF = new File(file, "exported");
        aH.cG = new File(file, "backups");
        if (!aH.cG.exists() && !aH.cG.mkdir()) {
            System.out.println("Error: cannot create backups folder");
            System.exit(1);
        }
        hc.k(new File(file, "NMSSaveEditor.log"));
        hc.debug("Java Vendor: " + System.getProperty("java.vendor"));
        hc.debug("Java Version: " + System.getProperty("java.version"));
        hc.debug("Java Architecture: " + System.getProperty("os.arch"));
        hc.debug("Operating System: " + System.getProperty("os.name"));
        hc.debug("Working Dir: " + file.getAbsolutePath());
        aH.cK = new eY();
        aH.cL = false;
        if (aH.cC.exists()) {
            try {
                final byte[] l = hk.l(aH.cC);
                if (l.length > 0 && l[0] == 123) {
                    aH.cK = eY.E(new String(l, "UTF-8"));
                }
                else {
                    final Properties properties = new Properties();
                    final FileInputStream inStream = new FileInputStream(aH.cC);
                    try {
                        properties.load(inStream);
                    }
                    finally {
                        inStream.close();
                    }
                    inStream.close();
                    final eV ev = new eV();
                    for (final String key : properties.stringPropertyNames()) {
                        try {
                            final String property = properties.getProperty(key);
                            if (key.equals("InventoryFontScale")) {
                                continue;
                            }
                            if (key.equals("InventoryScaling")) {
                                aH.cK.b("InventoryScaling", Double.parseDouble(property));
                            }
                            else if (key.equals("FontScaling")) {
                                aH.cK.b("FontScaling", Double.parseDouble(property));
                            }
                            else if (key.endsWith(".Location")) {
                                final String substring = key.substring(0, key.lastIndexOf("."));
                                final int index;
                                if ((index = property.indexOf(44)) <= 0) {
                                    continue;
                                }
                                final int int1 = Integer.parseInt(property.substring(0, index));
                                final int int2 = Integer.parseInt(property.substring(index + 1));
                                aH.cK.c(String.valueOf(substring) + ".X", (Object)int1);
                                aH.cK.c(String.valueOf(substring) + ".Y", (Object)int2);
                            }
                            else if (key.endsWith(".Size")) {
                                final String substring2 = key.substring(0, key.lastIndexOf("."));
                                final int index2;
                                if ((index2 = property.indexOf(44)) <= 0) {
                                    continue;
                                }
                                final int int3 = Integer.parseInt(property.substring(0, index2));
                                final int int4 = Integer.parseInt(property.substring(index2 + 1));
                                aH.cK.c(String.valueOf(substring2) + ".Width", (Object)int3);
                                aH.cK.c(String.valueOf(substring2) + ".Height", (Object)int4);
                            }
                            else if (key.equals("JSONEditor.Divider")) {
                                aH.cK.c(key, (Object)Integer.parseInt(property));
                            }
                            else if (key.startsWith("SteamID.")) {
                                final String substring3 = key.substring(8);
                                ev.f(Long.parseLong(substring3));
                                aH.cK.c("KnownPlayers." + substring3, property);
                            }
                            else {
                                aH.cK.c(key, property);
                            }
                        }
                        catch (final NumberFormatException ex3) {}
                    }
                    if (ev.size() > 0) {
                        aH.cK.b("SteamIDs", ev);
                    }
                    aH.cL = true;
                }
            }
            catch (final IOException ex4) {
                hc.a("Could not load configuration file", ex4);
            }
        }
        final String valueAsString = aH.cK.getValueAsString("LogLevel");
        if (valueAsString != null) {
            hc.aA(valueAsString);
        }
        FlatLaf.registerCustomDefaultsSource("nomanssave");
        V();
    }
    
    public static void V() {
        final aI obj = Stream.of(aI.values()).filter(ai -> {
            aH.cK.getValueAsString("LookAndFeel");
            return ai.name().equalsIgnoreCase(anotherString);
        }).findFirst().orElse(aI.cN);
        try {
            FlatLaf lookAndFeel = null;
            switch (W()[obj.ordinal()]) {
                default: {
                    lookAndFeel = new FlatLightLaf();
                    break;
                }
                case 2: {
                    lookAndFeel = new FlatDarkLaf();
                    break;
                }
                case 3: {
                    lookAndFeel = new FlatIntelliJLaf();
                    break;
                }
                case 4: {
                    lookAndFeel = new FlatDarculaLaf();
                    break;
                }
                case 6: {
                    lookAndFeel = new FlatMacDarkLaf();
                    break;
                }
                case 5: {
                    lookAndFeel = new FlatMacLightLaf();
                    break;
                }
            }
            UIManager.setLookAndFeel(lookAndFeel);
        }
        catch (final UnsupportedLookAndFeelException ex) {
            hc.a("Could not set look and feel: " + obj, ex);
            return;
        }
        hc.debug("Look and Feel: " + UIManager.getLookAndFeel().getName());
        final Font font = UIManager.getFont("Label.font");
        if (font == null) {
            aH.cH = 120;
            aH.cI = 350;
            aH.cJ = 200;
            UIManager.put("Inventory.font", null);
            UIManager.put("Inventory.gridSize", 200);
            UIManager.put("Inventory.iconSize", 64);
        }
        else {
            double l = aH.cK.L("InventoryScaling");
            if (l <= 0.0) {
                l = 1.0;
                aH.cK.b("InventoryScaling", l);
                aH.cL = true;
            }
            final Font font2 = new Font(font.getName(), 0, (int)Math.round(font.getSize() * l));
            final Canvas canvas = new Canvas();
            final FontMetrics fontMetrics = canvas.getFontMetrics(font);
            aH.cH = fontMetrics.stringWidth("MMMMMMMMMM");
            aH.cI = fontMetrics.stringWidth("MMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            aH.cJ = fontMetrics.stringWidth("MMMMMMMMMMMMMMMMM");
            final FontMetrics fontMetrics2 = canvas.getFontMetrics(font2);
            final int stringWidth = fontMetrics2.stringWidth("MMMMMMMMMMM");
            int n;
            int i;
            for (n = stringWidth - (fontMetrics2.getHeight() * 2 + 8), i = 16; i * 2 <= n; i *= 2) {}
            if (i * 1.5 <= n) {
                i *= (int)1.5;
            }
            UIManager.put("Inventory.font", font2);
            UIManager.put("Inventory.gridSize", stringWidth);
            UIManager.put("Inventory.iconSize", i);
        }
    }
    
    static /* synthetic */ int[] W() {
        final int[] cm = aH.cM;
        if (cm != null) {
            return cm;
        }
        final int[] cm2 = new int[aI.values().length];
        try {
            cm2[aI.cQ.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            cm2[aI.cO.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            cm2[aI.cP.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            cm2[aI.cN.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            cm2[aI.cS.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            cm2[aI.cR.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        return aH.cM = cm2;
    }
}
