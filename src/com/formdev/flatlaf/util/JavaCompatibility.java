// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.awt.FontMetrics;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.lang.invoke.MethodHandle;

public class JavaCompatibility
{
    private static MethodHandle drawStringUnderlineCharAtMethod;
    private static MethodHandle getClippedStringMethod;
    
    public static void drawStringUnderlineCharAt(final JComponent c, final Graphics g, final String text, final int underlinedIndex, final int x, final int y) {
        synchronized (JavaCompatibility.class) {
            if (JavaCompatibility.drawStringUnderlineCharAtMethod == null) {
                try {
                    final Class<?> cls = Class.forName(SystemInfo.isJava_9_orLater ? "javax.swing.plaf.basic.BasicGraphicsUtils" : "sun.swing.SwingUtilities2");
                    final MethodType mt = MethodType.methodType(Void.TYPE, SystemInfo.isJava_9_orLater ? new Class[] { JComponent.class, Graphics2D.class, String.class, Integer.TYPE, Float.TYPE, Float.TYPE } : new Class[] { JComponent.class, Graphics.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE });
                    JavaCompatibility.drawStringUnderlineCharAtMethod = MethodHandles.publicLookup().findStatic(cls, "drawStringUnderlineCharAt", mt);
                }
                catch (final Exception ex) {
                    LoggingFacade.INSTANCE.logSevere(null, ex);
                    throw new RuntimeException(ex);
                }
            }
        }
        try {
            if (SystemInfo.isJava_9_orLater) {
                JavaCompatibility.drawStringUnderlineCharAtMethod.invoke(c, (Graphics2D)g, text, underlinedIndex, (float)x, (float)y);
            }
            else {
                JavaCompatibility.drawStringUnderlineCharAtMethod.invoke(c, g, text, underlinedIndex, x, y);
            }
        }
        catch (final Throwable ex2) {
            LoggingFacade.INSTANCE.logSevere(null, ex2);
            throw new RuntimeException(ex2);
        }
    }
    
    public static String getClippedString(final JComponent c, final FontMetrics fm, final String string, final int availTextWidth) {
        synchronized (JavaCompatibility.class) {
            if (JavaCompatibility.getClippedStringMethod == null) {
                try {
                    final Class<?> cls = Class.forName(SystemInfo.isJava_9_orLater ? "javax.swing.plaf.basic.BasicGraphicsUtils" : "sun.swing.SwingUtilities2");
                    final MethodType mt = MethodType.methodType(String.class, JComponent.class, FontMetrics.class, String.class, Integer.TYPE);
                    JavaCompatibility.getClippedStringMethod = MethodHandles.publicLookup().findStatic(cls, SystemInfo.isJava_9_orLater ? "getClippedString" : "clipStringIfNecessary", mt);
                }
                catch (final Exception ex) {
                    LoggingFacade.INSTANCE.logSevere(null, ex);
                    throw new RuntimeException(ex);
                }
            }
        }
        try {
            return JavaCompatibility.getClippedStringMethod.invoke(c, fm, string, availTextWidth);
        }
        catch (final Throwable ex2) {
            LoggingFacade.INSTANCE.logSevere(null, ex2);
            throw new RuntimeException(ex2);
        }
    }
}
