// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.ComponentEvent;
import javax.swing.JLayeredPane;
import javax.swing.RootPaneContainer;
import java.awt.event.ComponentListener;
import java.awt.Container;
import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import javax.swing.ToolTipManager;
import java.awt.Insets;
import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;
import java.awt.Dimension;
import java.awt.PointerInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.MouseInfo;
import java.lang.reflect.Method;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import javax.swing.UIManager;
import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.JPopupMenu;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.Window;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import java.awt.Point;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.Popup;
import java.awt.Component;
import java.lang.invoke.MethodHandle;
import javax.swing.PopupFactory;

public class FlatPopupFactory extends PopupFactory
{
    private MethodHandle java8getPopupMethod;
    private MethodHandle java9getPopupMethod;
    
    @Override
    public Popup getPopup(final Component owner, final Component contents, int x, int y) throws IllegalArgumentException {
        final Point pt = this.fixToolTipLocation(owner, contents, x, y);
        if (pt != null) {
            x = pt.x;
            y = pt.y;
        }
        final boolean forceHeavyWeight = this.isOptionEnabled(owner, contents, "Popup.forceHeavyWeight", "Popup.forceHeavyWeight");
        if (!this.isOptionEnabled(owner, contents, "Popup.dropShadowPainted", "Popup.dropShadowPainted") || SystemInfo.isProjector || SystemInfo.isWebswing) {
            return new NonFlashingPopup(this.getPopupForScreenOfOwner(owner, contents, x, y, forceHeavyWeight), contents);
        }
        if (SystemInfo.isMacOS || SystemInfo.isLinux) {
            return new NonFlashingPopup(this.getPopupForScreenOfOwner(owner, contents, x, y, true), contents);
        }
        final int borderCornerRadius;
        if (isWindows11BorderSupported() && (borderCornerRadius = this.getBorderCornerRadius(owner, contents)) > 0) {
            final NonFlashingPopup popup = new NonFlashingPopup(this.getPopupForScreenOfOwner(owner, contents, x, y, true), contents);
            if (popup.popupWindow != null) {
                setupWindows11Border(popup.popupWindow, contents, borderCornerRadius);
            }
            return popup;
        }
        return new DropShadowPopup(this.getPopupForScreenOfOwner(owner, contents, x, y, forceHeavyWeight), owner, contents);
    }
    
    private Popup getPopupForScreenOfOwner(final Component owner, final Component contents, final int x, final int y, final boolean forceHeavyWeight) throws IllegalArgumentException {
        int count = 0;
        while (true) {
            final Popup popup = forceHeavyWeight ? this.getHeavyWeightPopup(owner, contents, x, y) : super.getPopup(owner, contents, x, y);
            final Window popupWindow = SwingUtilities.windowForComponent(contents);
            if (popupWindow == null || owner == null || popupWindow.getGraphicsConfiguration() == owner.getGraphicsConfiguration()) {
                return popup;
            }
            if (++count > 10) {
                return popup;
            }
            if (popupWindow instanceof JWindow) {
                ((JWindow)popupWindow).getContentPane().removeAll();
            }
            popupWindow.dispose();
        }
    }
    
    private static void showPopupAndFixLocation(final Popup popup, final Window popupWindow) {
        if (popupWindow != null) {
            final int x = popupWindow.getX();
            final int y = popupWindow.getY();
            popup.show();
            if (popupWindow.getX() != x || popupWindow.getY() != y) {
                popupWindow.setLocation(x, y);
            }
        }
        else {
            popup.show();
        }
    }
    
    private boolean isOptionEnabled(final Component owner, final Component contents, final String clientKey, final String uiKey) {
        final Object value = this.getOption(owner, contents, clientKey, uiKey);
        return value instanceof Boolean && (boolean)value;
    }
    
    private int getBorderCornerRadius(final Component owner, final Component contents) {
        final String uiKey = (contents instanceof BasicComboPopup) ? "ComboBox.borderCornerRadius" : ((contents instanceof JPopupMenu) ? "PopupMenu.borderCornerRadius" : ((contents instanceof JToolTip) ? "ToolTip.borderCornerRadius" : "Popup.borderCornerRadius"));
        final Object value = this.getOption(owner, contents, "Popup.borderCornerRadius", uiKey);
        return (int)((value instanceof Integer) ? value : 0);
    }
    
    private Object getOption(final Component owner, final Component contents, final String clientKey, final String uiKey) {
        for (final Component c : new Component[] { owner, contents }) {
            if (c instanceof JComponent) {
                final Object value = ((JComponent)c).getClientProperty(clientKey);
                if (value != null) {
                    return value;
                }
            }
        }
        return UIManager.get(uiKey);
    }
    
    private Popup getHeavyWeightPopup(final Component owner, final Component contents, final int x, final int y) throws IllegalArgumentException {
        try {
            if (SystemInfo.isJava_9_orLater) {
                if (this.java9getPopupMethod == null) {
                    final MethodType mt = MethodType.methodType(Popup.class, Component.class, Component.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
                    this.java9getPopupMethod = MethodHandles.lookup().findVirtual(PopupFactory.class, "getPopup", mt);
                }
                return this.java9getPopupMethod.invoke(this, owner, contents, x, y, true);
            }
            if (this.java8getPopupMethod == null) {
                final Method m = PopupFactory.class.getDeclaredMethod("getPopup", Component.class, Component.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                m.setAccessible(true);
                this.java8getPopupMethod = MethodHandles.lookup().unreflect(m);
            }
            return this.java8getPopupMethod.invoke(this, owner, contents, x, y, 2);
        }
        catch (final Throwable ex) {
            return super.getPopup(owner, contents, x, y);
        }
    }
    
    private Point fixToolTipLocation(final Component owner, final Component contents, final int x, final int y) {
        if (!(contents instanceof JToolTip) || !this.wasInvokedFromToolTipManager() || this.hasTipLocation(owner)) {
            return null;
        }
        final PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        if (pointerInfo == null) {
            return null;
        }
        final Point mouseLocation = pointerInfo.getLocation();
        final Dimension tipSize = contents.getPreferredSize();
        final Rectangle tipBounds = new Rectangle(x, y, tipSize.width, tipSize.height);
        if (!tipBounds.contains(mouseLocation)) {
            return null;
        }
        GraphicsConfiguration gc = null;
        for (final GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            final GraphicsConfiguration dgc = device.getDefaultConfiguration();
            if (dgc.getBounds().contains(mouseLocation)) {
                gc = dgc;
                break;
            }
        }
        if (gc == null) {
            gc = owner.getGraphicsConfiguration();
        }
        if (gc == null) {
            return null;
        }
        final Rectangle screenBounds = gc.getBounds();
        final Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        final int screenTop = screenBounds.y + screenInsets.top;
        final int newY = mouseLocation.y - tipSize.height - UIScale.scale(20);
        if (newY < screenTop) {
            return null;
        }
        return new Point(x, newY);
    }
    
    private boolean wasInvokedFromToolTipManager() {
        return StackUtils.wasInvokedFrom(ToolTipManager.class.getName(), "showTipWindow", 8);
    }
    
    private boolean hasTipLocation(final Component owner) {
        if (!(owner instanceof JComponent)) {
            return false;
        }
        final AWTEvent e = EventQueue.getCurrentEvent();
        MouseEvent me;
        if (e instanceof MouseEvent) {
            me = (MouseEvent)e;
        }
        else {
            final PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            if (pointerInfo == null) {
                return false;
            }
            final Point location = new Point(pointerInfo.getLocation());
            SwingUtilities.convertPointFromScreen(location, owner);
            me = new MouseEvent(owner, 503, System.currentTimeMillis(), 0, location.x, location.y, 0, false);
        }
        return me.getSource() == owner && ((JComponent)owner).getToolTipLocation(me) != null;
    }
    
    private static boolean isWindows11BorderSupported() {
        return SystemInfo.isWindows_11_orLater && FlatNativeWindowsLibrary.isLoaded();
    }
    
    private static void setupWindows11Border(final Window popupWindow, final Component contents, final int borderCornerRadius) {
        if (!popupWindow.isDisplayable()) {
            popupWindow.addNotify();
        }
        final long hwnd = FlatNativeWindowsLibrary.getHWND(popupWindow);
        final int cornerPreference = (borderCornerRadius <= 4) ? 3 : 2;
        FlatNativeWindowsLibrary.setWindowCornerPreference(hwnd, cornerPreference);
        int red = -1;
        int green = 0;
        int blue = 0;
        if (contents instanceof JComponent) {
            Border border = ((JComponent)contents).getBorder();
            border = FlatUIUtils.unwrapNonUIResourceBorder(border);
            Color borderColor = null;
            if (border instanceof FlatLineBorder) {
                borderColor = ((FlatLineBorder)border).getLineColor();
            }
            else if (border instanceof LineBorder) {
                borderColor = ((LineBorder)border).getLineColor();
            }
            else if (border instanceof EmptyBorder) {
                red = -2;
            }
            if (borderColor != null) {
                red = borderColor.getRed();
                green = borderColor.getGreen();
                blue = borderColor.getBlue();
            }
        }
        FlatNativeWindowsLibrary.setWindowBorderColor(hwnd, red, green, blue);
    }
    
    private static void resetWindows11Border(final Window popupWindow) {
        final long hwnd = FlatNativeWindowsLibrary.getHWND(popupWindow);
        if (hwnd == 0L) {
            return;
        }
        FlatNativeWindowsLibrary.setWindowCornerPreference(hwnd, 1);
    }
    
    private class NonFlashingPopup extends Popup
    {
        private Popup delegate;
        private Component contents;
        protected Window popupWindow;
        private Color oldPopupWindowBackground;
        
        NonFlashingPopup(final Popup delegate, final Component contents) {
            this.delegate = delegate;
            this.contents = contents;
            this.popupWindow = SwingUtilities.windowForComponent(contents);
            if (this.popupWindow != null) {
                this.oldPopupWindowBackground = this.popupWindow.getBackground();
                this.popupWindow.setBackground(contents.getBackground());
            }
        }
        
        @Override
        public void show() {
            if (this.delegate != null) {
                showPopupAndFixLocation(this.delegate, this.popupWindow);
                if (this.contents instanceof JToolTip && this.popupWindow == null) {
                    final Container parent = this.contents.getParent();
                    if (parent instanceof JPanel) {
                        final Dimension prefSize = parent.getPreferredSize();
                        if (!prefSize.equals(parent.getSize())) {
                            final Container mediumWeightPanel = SwingUtilities.getAncestorOfClass(Panel.class, parent);
                            final Container c = (mediumWeightPanel != null) ? mediumWeightPanel : parent;
                            c.setSize(prefSize);
                            c.validate();
                        }
                    }
                }
            }
        }
        
        @Override
        public void hide() {
            if (this.delegate != null) {
                this.delegate.hide();
                this.delegate = null;
                this.contents = null;
            }
            if (this.popupWindow != null) {
                this.popupWindow.setBackground(this.oldPopupWindowBackground);
                this.popupWindow = null;
            }
        }
    }
    
    private class DropShadowPopup extends NonFlashingPopup
    {
        private final Component owner;
        private JComponent lightComp;
        private Border oldBorder;
        private boolean oldOpaque;
        private boolean mediumWeightShown;
        private Panel mediumWeightPanel;
        private JPanel dropShadowPanel;
        private ComponentListener mediumPanelListener;
        private Popup dropShadowDelegate;
        private Window dropShadowWindow;
        private Color oldDropShadowWindowBackground;
        
        DropShadowPopup(final Popup delegate, final Component owner, final Component contents) {
            super(delegate, contents);
            this.owner = owner;
            final Dimension size = contents.getPreferredSize();
            if (size.width <= 0 || size.height <= 0) {
                return;
            }
            if (this.popupWindow != null) {
                final JPanel dropShadowPanel = new JPanel();
                dropShadowPanel.setBorder(this.createDropShadowBorder());
                dropShadowPanel.setOpaque(false);
                final Dimension prefSize = this.popupWindow.getPreferredSize();
                final Insets insets = dropShadowPanel.getInsets();
                dropShadowPanel.setPreferredSize(new Dimension(prefSize.width + insets.left + insets.right, prefSize.height + insets.top + insets.bottom));
                final int x = this.popupWindow.getX() - insets.left;
                final int y = this.popupWindow.getY() - insets.top;
                this.dropShadowDelegate = FlatPopupFactory.this.getPopupForScreenOfOwner(owner, dropShadowPanel, x, y, true);
                this.dropShadowWindow = SwingUtilities.windowForComponent(dropShadowPanel);
                if (this.dropShadowWindow != null) {
                    this.oldDropShadowWindowBackground = this.dropShadowWindow.getBackground();
                    this.dropShadowWindow.setBackground(new Color(0, true));
                }
                if (isWindows11BorderSupported()) {
                    resetWindows11Border(this.popupWindow);
                    if (this.dropShadowWindow != null) {
                        resetWindows11Border(this.dropShadowWindow);
                    }
                }
            }
            else {
                this.mediumWeightPanel = (Panel)SwingUtilities.getAncestorOfClass(Panel.class, contents);
                if (this.mediumWeightPanel != null) {
                    (this.dropShadowPanel = new JPanel()).setBorder(this.createDropShadowBorder());
                    this.dropShadowPanel.setOpaque(false);
                    this.dropShadowPanel.setSize(FlatUIUtils.addInsets(this.mediumWeightPanel.getSize(), this.dropShadowPanel.getInsets()));
                }
                else {
                    final Container p = contents.getParent();
                    if (!(p instanceof JComponent)) {
                        return;
                    }
                    this.lightComp = (JComponent)p;
                    this.oldBorder = this.lightComp.getBorder();
                    this.oldOpaque = this.lightComp.isOpaque();
                    this.lightComp.setBorder(this.createDropShadowBorder());
                    this.lightComp.setOpaque(false);
                    this.lightComp.setSize(this.lightComp.getPreferredSize());
                }
            }
        }
        
        private Border createDropShadowBorder() {
            return new FlatDropShadowBorder(UIManager.getColor("Popup.dropShadowColor"), UIManager.getInsets("Popup.dropShadowInsets"), FlatUIUtils.getUIFloat("Popup.dropShadowOpacity", 0.5f));
        }
        
        @Override
        public void show() {
            if (this.dropShadowDelegate != null) {
                showPopupAndFixLocation(this.dropShadowDelegate, this.dropShadowWindow);
            }
            if (this.mediumWeightPanel != null) {
                this.showMediumWeightDropShadow();
            }
            super.show();
            if (this.lightComp != null) {
                final Insets insets = this.lightComp.getInsets();
                if (insets.left != 0 || insets.top != 0) {
                    this.lightComp.setLocation(this.lightComp.getX() - insets.left, this.lightComp.getY() - insets.top);
                }
            }
        }
        
        @Override
        public void hide() {
            if (this.dropShadowDelegate != null) {
                this.dropShadowDelegate.hide();
                this.dropShadowDelegate = null;
            }
            if (this.mediumWeightPanel != null) {
                this.hideMediumWeightDropShadow();
                this.dropShadowPanel = null;
                this.mediumWeightPanel = null;
            }
            super.hide();
            if (this.dropShadowWindow != null) {
                this.dropShadowWindow.setBackground(this.oldDropShadowWindowBackground);
                this.dropShadowWindow = null;
            }
            if (this.lightComp != null) {
                this.lightComp.setBorder(this.oldBorder);
                this.lightComp.setOpaque(this.oldOpaque);
                this.lightComp = null;
            }
        }
        
        private void showMediumWeightDropShadow() {
            if (this.mediumWeightShown) {
                return;
            }
            this.mediumWeightShown = true;
            if (this.owner == null) {
                return;
            }
            final Window window = SwingUtilities.windowForComponent(this.owner);
            if (!(window instanceof RootPaneContainer)) {
                return;
            }
            this.dropShadowPanel.setVisible(false);
            final JLayeredPane layeredPane = ((RootPaneContainer)window).getLayeredPane();
            layeredPane.add(this.dropShadowPanel, JLayeredPane.POPUP_LAYER, 0);
            this.moveMediumWeightDropShadow();
            this.resizeMediumWeightDropShadow();
            this.mediumPanelListener = new ComponentListener() {
                @Override
                public void componentShown(final ComponentEvent e) {
                    if (DropShadowPopup.this.dropShadowPanel != null) {
                        DropShadowPopup.this.dropShadowPanel.setVisible(true);
                    }
                }
                
                @Override
                public void componentHidden(final ComponentEvent e) {
                    if (DropShadowPopup.this.dropShadowPanel != null) {
                        DropShadowPopup.this.dropShadowPanel.setVisible(false);
                    }
                }
                
                @Override
                public void componentMoved(final ComponentEvent e) {
                    DropShadowPopup.this.moveMediumWeightDropShadow();
                }
                
                @Override
                public void componentResized(final ComponentEvent e) {
                    DropShadowPopup.this.resizeMediumWeightDropShadow();
                }
            };
            this.mediumWeightPanel.addComponentListener(this.mediumPanelListener);
        }
        
        private void hideMediumWeightDropShadow() {
            this.mediumWeightPanel.removeComponentListener(this.mediumPanelListener);
            final Container parent = this.dropShadowPanel.getParent();
            if (parent != null) {
                final Rectangle bounds = this.dropShadowPanel.getBounds();
                parent.remove(this.dropShadowPanel);
                parent.repaint(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        }
        
        private void moveMediumWeightDropShadow() {
            if (this.dropShadowPanel != null && this.mediumWeightPanel != null) {
                final Point location = this.mediumWeightPanel.getLocation();
                final Insets insets = this.dropShadowPanel.getInsets();
                this.dropShadowPanel.setLocation(location.x - insets.left, location.y - insets.top);
            }
        }
        
        private void resizeMediumWeightDropShadow() {
            if (this.dropShadowPanel != null && this.mediumWeightPanel != null) {
                this.dropShadowPanel.setSize(FlatUIUtils.addInsets(this.mediumWeightPanel.getSize(), this.dropShadowPanel.getInsets()));
            }
        }
    }
}
