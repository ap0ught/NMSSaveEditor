// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.awt.font.GlyphVector;
import java.text.AttributedCharacterIterator;
import java.awt.Graphics;
import com.formdev.flatlaf.FlatSystemProperties;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import javax.swing.JComponent;
import java.awt.Graphics2D;

public class HiDPIUtils
{
    private static Boolean useTextYCorrection;
    private static final float[] SCALE_FACTORS;
    private static final float[] CORRECTION_SEGOE_UI;
    private static final float[] CORRECTION_TAHOMA;
    private static final float[] CORRECTION_INTER;
    private static final float[] CORRECTION_OPEN_SANS;
    private static Boolean useDebugScaleFactor;
    
    public static void paintAtScale1x(final Graphics2D g, final JComponent c, final Painter painter) {
        paintAtScale1x(g, 0, 0, c.getWidth(), c.getHeight(), painter);
    }
    
    public static void paintAtScale1x(final Graphics2D g, final int x, final int y, final int width, final int height, final Painter painter) {
        final AffineTransform t = g.getTransform();
        final double scaleX = t.getScaleX();
        final double scaleY = t.getScaleY();
        final double shearX = t.getShearX();
        final double shearY = t.getShearY();
        final boolean rotated = shearX != 0.0 || shearY != 0.0 || scaleX <= 0.0 || scaleY <= 0.0;
        double realScaleX;
        double realScaleY;
        if (rotated) {
            realScaleX = Math.hypot(scaleX, shearX);
            realScaleY = Math.hypot(scaleY, shearY);
        }
        else {
            realScaleX = Math.abs(scaleX);
            realScaleY = Math.abs(scaleY);
        }
        if (realScaleX == 1.0 && realScaleY == 1.0) {
            painter.paint(g, x, y, width, height, 1.0);
            return;
        }
        final double px = x * scaleX + y * shearX + t.getTranslateX();
        final double py = y * scaleY + x * shearY + t.getTranslateY();
        final Rectangle2D.Double scaledRect = scale(realScaleX, realScaleY, px, py, width, height);
        try {
            AffineTransform t1x;
            if (rotated) {
                t1x = new AffineTransform(scaleX, shearY, shearX, scaleY, Math.floor(scaledRect.x), Math.floor(scaledRect.y));
                t1x.scale(1.0 / realScaleX, 1.0 / realScaleY);
            }
            else {
                t1x = new AffineTransform(1.0, 0.0, 0.0, 1.0, Math.floor(scaledRect.x), Math.floor(scaledRect.y));
            }
            g.setTransform(t1x);
            final int swidth = (int)scaledRect.width;
            final int sheight = (int)scaledRect.height;
            painter.paint(g, 0, 0, swidth, sheight, realScaleX);
        }
        finally {
            g.setTransform(t);
        }
    }
    
    private static Rectangle2D.Double scale(final double scaleX, final double scaleY, final double px, final double py, final int width, final int height) {
        final double newX = normalize(px);
        final double newY = normalize(py);
        final double newWidth = normalize(px + width * scaleX) - newX;
        final double newHeight = normalize(py + height * scaleY) - newY;
        return new Rectangle2D.Double(newX, newY, newWidth, newHeight);
    }
    
    private static double normalize(final double value) {
        return Math.floor(value + 0.25) + 0.25;
    }
    
    private static boolean useTextYCorrection() {
        if (HiDPIUtils.useTextYCorrection == null) {
            HiDPIUtils.useTextYCorrection = FlatSystemProperties.getBoolean("flatlaf.useTextYCorrection", true);
        }
        return HiDPIUtils.useTextYCorrection;
    }
    
    public static float computeTextYCorrection(final Graphics2D g) {
        if (!useTextYCorrection() || !SystemInfo.isWindows) {
            return 0.0f;
        }
        if (!SystemInfo.isJava_9_orLater) {
            final float scaleFactor = getUserScaleFactor();
            if (scaleFactor > 1.0f) {
                final String family = g.getFont().getFamily();
                switch (family) {
                    case "Segoe UI":
                    case "Segoe UI Light":
                    case "Segoe UI Semibold": {
                        return -(((scaleFactor == 2.25f || scaleFactor == 4.0f) ? 0.875f : 0.625f) * scaleFactor);
                    }
                    case "Noto Sans":
                    case "Open Sans": {
                        return -(0.3f * scaleFactor);
                    }
                    case "Verdana": {
                        return -(((scaleFactor < 2.0f) ? 0.4f : 0.3f) * scaleFactor);
                    }
                }
            }
        }
        else {
            final String family2 = g.getFont().getFamily();
            switch (family2) {
                case "Segoe UI":
                case "Segoe UI Light":
                case "Segoe UI Semibold":
                case "Verdana":
                case "Dialog":
                case "SansSerif": {
                    return correctionForScaleY(g, HiDPIUtils.CORRECTION_SEGOE_UI);
                }
                case "Tahoma": {
                    return correctionForScaleY(g, HiDPIUtils.CORRECTION_TAHOMA);
                }
                case "Inter":
                case "Inter Light":
                case "Inter Semi Bold":
                case "Roboto":
                case "Roboto Light":
                case "Roboto Medium": {
                    return correctionForScaleY(g, HiDPIUtils.CORRECTION_INTER);
                }
                case "Noto Sans":
                case "Open Sans": {
                    return correctionForScaleY(g, HiDPIUtils.CORRECTION_OPEN_SANS);
                }
            }
        }
        return 0.0f;
    }
    
    private static float correctionForScaleY(final Graphics2D g, final float[] correction) {
        if (correction.length != 9) {
            throw new IllegalArgumentException();
        }
        final double scaleY = g.getTransform().getScaleY();
        return (scaleY < 1.25) ? 0.0f : correction[scaleFactor2index((float)scaleY)];
    }
    
    private static int scaleFactor2index(final float scaleFactor) {
        for (int i = 0; i < HiDPIUtils.SCALE_FACTORS.length; ++i) {
            if (scaleFactor <= HiDPIUtils.SCALE_FACTORS[i]) {
                return i;
            }
        }
        return HiDPIUtils.SCALE_FACTORS.length - 1;
    }
    
    private static boolean useDebugScaleFactor() {
        if (HiDPIUtils.useDebugScaleFactor == null) {
            HiDPIUtils.useDebugScaleFactor = FlatSystemProperties.getBoolean("FlatLaf.debug.HiDPIUtils.useDebugScaleFactor", false);
        }
        return HiDPIUtils.useDebugScaleFactor;
    }
    
    private static float getUserScaleFactor() {
        return useDebugScaleFactor() ? Float.parseFloat(System.getProperty("FlatLaf.debug.HiDPIUtils.debugScaleFactor", "1")) : UIScale.getUserScaleFactor();
    }
    
    public static void drawStringWithYCorrection(final JComponent c, final Graphics2D g, final String text, final int x, final int y) {
        drawStringUnderlineCharAtWithYCorrection(c, g, text, -1, x, y);
    }
    
    public static void drawStringUnderlineCharAtWithYCorrection(final JComponent c, final Graphics2D g, final String text, final int underlinedIndex, final int x, final int y) {
        final float yCorrection = computeTextYCorrection(g);
        if (yCorrection != 0.0f) {
            g.translate(0.0, yCorrection);
            JavaCompatibility.drawStringUnderlineCharAt(c, g, text, underlinedIndex, x, y);
            g.translate(0.0, -yCorrection);
        }
        else {
            JavaCompatibility.drawStringUnderlineCharAt(c, g, text, underlinedIndex, x, y);
        }
    }
    
    public static Graphics2D createGraphicsTextYCorrection(final Graphics2D g) {
        final float yCorrection = computeTextYCorrection(g);
        if (yCorrection == 0.0f) {
            return g;
        }
        return new Graphics2DProxy(g) {
            @Override
            public void drawString(final String str, final int x, final int y) {
                super.drawString(str, (float)x, y + yCorrection);
            }
            
            @Override
            public void drawString(final String str, final float x, final float y) {
                super.drawString(str, x, y + yCorrection);
            }
            
            @Override
            public void drawString(final AttributedCharacterIterator iterator, final int x, final int y) {
                super.drawString(iterator, (float)x, y + yCorrection);
            }
            
            @Override
            public void drawString(final AttributedCharacterIterator iterator, final float x, final float y) {
                super.drawString(iterator, x, y + yCorrection);
            }
            
            @Override
            public void drawChars(final char[] data, final int offset, final int length, final int x, final int y) {
                super.drawChars(data, offset, length, x, Math.round(y + yCorrection));
            }
            
            @Override
            public void drawBytes(final byte[] data, final int offset, final int length, final int x, final int y) {
                super.drawBytes(data, offset, length, x, Math.round(y + yCorrection));
            }
            
            @Override
            public void drawGlyphVector(final GlyphVector g, final float x, final float y) {
                super.drawGlyphVector(g, x, y + yCorrection);
            }
        };
    }
    
    static {
        SCALE_FACTORS = new float[] { 1.25f, 1.5f, 1.75f, 2.0f, 2.25f, 2.5f, 3.0f, 3.5f, 4.0f };
        CORRECTION_SEGOE_UI = new float[] { -0.5f, -0.5f, -0.625f, -0.75f, -0.75f, -0.75f, -0.75f, -0.75f, -0.875f };
        CORRECTION_TAHOMA = new float[] { -0.25f, -0.25f, -0.25f, -0.0f, -0.125f, -0.125f, -0.125f, -0.125f, -0.0f };
        CORRECTION_INTER = new float[] { -0.25f, -0.25f, -0.25f, -0.0f, -0.125f, -0.125f, -0.0f, -0.25f, -0.0f };
        CORRECTION_OPEN_SANS = new float[] { -0.5f, -0.25f, -0.25f, -0.0f, -0.25f, -0.25f, -0.0f, -0.25f, -0.25f };
    }
    
    public interface Painter
    {
        void paint(final Graphics2D p0, final int p1, final int p2, final int p3, final int p4, final double p5);
    }
}
