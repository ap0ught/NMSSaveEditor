// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import com.formdev.flatlaf.FlatSystemProperties;
import com.formdev.flatlaf.util.SystemInfo;
import java.beans.PropertyChangeEvent;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JComponent;
import com.formdev.flatlaf.FlatLaf;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.beans.PropertyChangeListener;
import java.awt.Container;
import java.awt.Window;
import javax.swing.JRootPane;

public class FlatNativeWindowBorder
{
    private static final boolean canUseWindowDecorations;
    private static final boolean canUseJBRCustomDecorations;
    private static Boolean supported;
    private static Provider nativeProvider;
    
    public static boolean isSupported() {
        if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
            return JBRCustomDecorations.isSupported();
        }
        initialize();
        return FlatNativeWindowBorder.supported;
    }
    
    static Object install(final JRootPane rootPane) {
        if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
            return JBRCustomDecorations.install(rootPane);
        }
        if (!isSupported()) {
            return null;
        }
        final Container parent = rootPane.getParent();
        if (parent != null && !(parent instanceof Window)) {
            return null;
        }
        if (parent instanceof Window && parent.isDisplayable()) {
            install((Window)parent);
        }
        final PropertyChangeListener ancestorListener = e -> {
            final Object newValue = e.getNewValue();
            if (newValue instanceof Window) {
                install((Window)newValue);
            }
            else if (newValue == null && e.getOldValue() instanceof Window) {
                uninstall((Window)e.getOldValue());
            }
            return;
        };
        rootPane.addPropertyChangeListener("ancestor", ancestorListener);
        return ancestorListener;
    }
    
    static void install(final Window window) {
        if (hasCustomDecoration(window)) {
            return;
        }
        if (UIManager.getLookAndFeel().getSupportsWindowDecorations()) {
            return;
        }
        if (window instanceof JFrame) {
            final JFrame frame = (JFrame)window;
            final JRootPane rootPane = frame.getRootPane();
            if (!useWindowDecorations(rootPane)) {
                return;
            }
            if (frame.isUndecorated()) {
                return;
            }
            setHasCustomDecoration(frame, true);
            if (!hasCustomDecoration(frame)) {
                return;
            }
            rootPane.setWindowDecorationStyle(1);
        }
        else if (window instanceof JDialog) {
            final JDialog dialog = (JDialog)window;
            final JRootPane rootPane = dialog.getRootPane();
            if (!useWindowDecorations(rootPane)) {
                return;
            }
            if (dialog.isUndecorated()) {
                return;
            }
            setHasCustomDecoration(dialog, true);
            if (!hasCustomDecoration(dialog)) {
                return;
            }
            rootPane.setWindowDecorationStyle(2);
        }
    }
    
    static void uninstall(final JRootPane rootPane, final Object data) {
        if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
            JBRCustomDecorations.uninstall(rootPane, data);
            return;
        }
        if (!isSupported()) {
            return;
        }
        if (data instanceof PropertyChangeListener) {
            rootPane.removePropertyChangeListener("ancestor", (PropertyChangeListener)data);
        }
        if (UIManager.getLookAndFeel() instanceof FlatLaf && useWindowDecorations(rootPane)) {
            return;
        }
        final Container parent = rootPane.getParent();
        if (parent instanceof Window) {
            uninstall((Window)parent);
        }
    }
    
    private static void uninstall(final Window window) {
        if (!hasCustomDecoration(window)) {
            return;
        }
        setHasCustomDecoration(window, false);
        if (window instanceof JFrame) {
            final JFrame frame = (JFrame)window;
            frame.getRootPane().setWindowDecorationStyle(0);
        }
        else if (window instanceof JDialog) {
            final JDialog dialog = (JDialog)window;
            dialog.getRootPane().setWindowDecorationStyle(0);
        }
    }
    
    private static boolean useWindowDecorations(final JRootPane rootPane) {
        return FlatUIUtils.getBoolean(rootPane, "flatlaf.useWindowDecorations", "JRootPane.useWindowDecorations", "TitlePane.useWindowDecorations", false);
    }
    
    public static boolean hasCustomDecoration(final Window window) {
        if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
            return JBRCustomDecorations.hasCustomDecoration(window);
        }
        return isSupported() && FlatNativeWindowBorder.nativeProvider.hasCustomDecoration(window);
    }
    
    public static void setHasCustomDecoration(final Window window, final boolean hasCustomDecoration) {
        if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
            JBRCustomDecorations.setHasCustomDecoration(window, hasCustomDecoration);
            return;
        }
        if (!isSupported()) {
            return;
        }
        FlatNativeWindowBorder.nativeProvider.setHasCustomDecoration(window, hasCustomDecoration);
    }
    
    static void setTitleBarHeightAndHitTestSpots(final Window window, final int titleBarHeight, final List<Rectangle> hitTestSpots, final Rectangle appIconBounds, final Rectangle minimizeButtonBounds, final Rectangle maximizeButtonBounds, final Rectangle closeButtonBounds) {
        if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
            JBRCustomDecorations.setTitleBarHeightAndHitTestSpots(window, titleBarHeight, hitTestSpots);
            return;
        }
        if (!isSupported()) {
            return;
        }
        FlatNativeWindowBorder.nativeProvider.updateTitleBarInfo(window, titleBarHeight, hitTestSpots, appIconBounds, minimizeButtonBounds, maximizeButtonBounds, closeButtonBounds);
    }
    
    static boolean showWindow(final Window window, final int cmd) {
        return !FlatNativeWindowBorder.canUseJBRCustomDecorations && isSupported() && FlatNativeWindowBorder.nativeProvider.showWindow(window, cmd);
    }
    
    private static void initialize() {
        if (FlatNativeWindowBorder.supported != null) {
            return;
        }
        FlatNativeWindowBorder.supported = false;
        if (!FlatNativeWindowBorder.canUseWindowDecorations) {
            return;
        }
        try {
            setNativeProvider(FlatWindowsNativeWindowBorder.getInstance());
        }
        catch (final Exception ex) {}
    }
    
    public static void setNativeProvider(final Provider provider) {
        if (FlatNativeWindowBorder.nativeProvider != null) {
            throw new IllegalStateException();
        }
        FlatNativeWindowBorder.nativeProvider = provider;
        FlatNativeWindowBorder.supported = (FlatNativeWindowBorder.nativeProvider != null);
    }
    
    static {
        canUseWindowDecorations = (SystemInfo.isWindows_10_orLater && (SystemInfo.isWindows_11_orLater || !FlatSystemProperties.getBoolean("sun.java2d.opengl", false)) && !SystemInfo.isProjector && !SystemInfo.isWebswing && !SystemInfo.isWinPE && FlatSystemProperties.getBoolean("flatlaf.useWindowDecorations", true));
        canUseJBRCustomDecorations = (FlatNativeWindowBorder.canUseWindowDecorations && SystemInfo.isJetBrainsJVM_11_orLater && FlatSystemProperties.getBoolean("flatlaf.useJetBrainsCustomDecorations", false));
    }
    
    static class WindowTopBorder extends JBRCustomDecorations.JBRWindowTopBorder
    {
        private static WindowTopBorder instance;
        
        static JBRCustomDecorations.JBRWindowTopBorder getInstance() {
            if (FlatNativeWindowBorder.canUseJBRCustomDecorations) {
                return JBRCustomDecorations.JBRWindowTopBorder.getInstance();
            }
            if (WindowTopBorder.instance == null) {
                WindowTopBorder.instance = new WindowTopBorder();
            }
            return WindowTopBorder.instance;
        }
        
        @Override
        void installListeners() {
            FlatNativeWindowBorder.nativeProvider.addChangeListener(e -> {
                this.update();
                Window.getWindows();
                final Window[] array;
                int i = 0;
                for (int length = array.length; i < length; ++i) {
                    final Window window = array[i];
                    if (window.isDisplayable()) {
                        window.repaint(0, 0, window.getWidth(), 1);
                    }
                }
            });
        }
        
        @Override
        boolean isColorizationColorAffectsBorders() {
            return FlatNativeWindowBorder.nativeProvider.isColorizationColorAffectsBorders();
        }
        
        @Override
        Color getColorizationColor() {
            return FlatNativeWindowBorder.nativeProvider.getColorizationColor();
        }
        
        @Override
        int getColorizationColorBalance() {
            return FlatNativeWindowBorder.nativeProvider.getColorizationColorBalance();
        }
    }
    
    public interface Provider
    {
        public static final int SW_MAXIMIZE = 3;
        public static final int SW_MINIMIZE = 6;
        public static final int SW_RESTORE = 9;
        
        boolean hasCustomDecoration(final Window p0);
        
        void setHasCustomDecoration(final Window p0, final boolean p1);
        
        void updateTitleBarInfo(final Window p0, final int p1, final List<Rectangle> p2, final Rectangle p3, final Rectangle p4, final Rectangle p5, final Rectangle p6);
        
        boolean showWindow(final Window p0, final int p1);
        
        boolean isColorizationColorAffectsBorders();
        
        Color getColorizationColor();
        
        int getColorizationColorBalance();
        
        void addChangeListener(final ChangeListener p0);
        
        void removeChangeListener(final ChangeListener p0);
    }
}
