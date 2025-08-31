// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.geom.AffineTransform;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.Window;
import java.awt.Toolkit;
import com.formdev.flatlaf.util.SystemInfo;

class FlatNativeLinuxLibrary
{
    static final int MOVE = 8;
    private static Boolean isXWindowSystem;
    
    static boolean isLoaded() {
        return SystemInfo.isLinux && FlatNativeLibrary.isLoaded();
    }
    
    private static boolean isXWindowSystem() {
        if (FlatNativeLinuxLibrary.isXWindowSystem == null) {
            FlatNativeLinuxLibrary.isXWindowSystem = Toolkit.getDefaultToolkit().getClass().getName().endsWith(".XToolkit");
        }
        return FlatNativeLinuxLibrary.isXWindowSystem;
    }
    
    static boolean isWMUtilsSupported(final Window window) {
        return hasCustomDecoration(window) && isXWindowSystem() && isLoaded();
    }
    
    static boolean moveOrResizeWindow(final Window window, final MouseEvent e, final int direction) {
        final Point pt = scale(window, e.getLocationOnScreen());
        return xMoveOrResizeWindow(window, pt.x, pt.y, direction);
    }
    
    static boolean showWindowMenu(final Window window, final MouseEvent e) {
        final Point pt = scale(window, e.getLocationOnScreen());
        return xShowWindowMenu(window, pt.x, pt.y);
    }
    
    private static Point scale(final Window window, final Point pt) {
        final AffineTransform transform = window.getGraphicsConfiguration().getDefaultTransform();
        final int x = (int)Math.round(pt.x * transform.getScaleX());
        final int y = (int)Math.round(pt.y * transform.getScaleY());
        return new Point(x, y);
    }
    
    private static native boolean xMoveOrResizeWindow(final Window p0, final int p1, final int p2, final int p3);
    
    private static native boolean xShowWindowMenu(final Window p0, final int p1, final int p2);
    
    private static boolean hasCustomDecoration(final Window window) {
        return (window instanceof JFrame && JFrame.isDefaultLookAndFeelDecorated() && ((JFrame)window).isUndecorated()) || (window instanceof JDialog && JDialog.isDefaultLookAndFeelDecorated() && ((JDialog)window).isUndecorated());
    }
}
