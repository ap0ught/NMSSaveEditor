// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.FocusEvent;
import java.awt.event.ContainerEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.KeyboardFocusManager;
import javax.swing.JTree;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.event.FocusListener;
import java.awt.event.ContainerListener;
import java.beans.PropertyChangeEvent;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeListener;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JViewport;
import java.awt.Rectangle;
import javax.swing.Scrollable;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import javax.swing.plaf.basic.BasicScrollPaneUI;

public class FlatScrollPaneUI extends BasicScrollPaneUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected Boolean showButtons;
    private Handler handler;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatScrollPaneUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        if (FlatUIUtils.needsLightAWTPeer(c)) {
            FlatUIUtils.runWithLightAWTPeerUIDefaults(() -> this.installUIImpl(c));
        }
        else {
            this.installUIImpl(c);
        }
    }
    
    private void installUIImpl(final JComponent c) {
        super.installUI(c);
        final int focusWidth = UIManager.getInt("Component.focusWidth");
        LookAndFeel.installProperty(c, "opaque", focusWidth == 0);
        this.installStyle();
        MigLayoutVisualPadding.install(this.scrollpane);
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        MigLayoutVisualPadding.uninstall(this.scrollpane);
        super.uninstallUI(c);
        this.oldStyleValues = null;
        this.borderShared = null;
    }
    
    @Override
    protected void installListeners(final JScrollPane c) {
        super.installListeners(c);
        this.addViewportListeners(this.scrollpane.getViewport());
    }
    
    @Override
    protected void uninstallListeners(final JComponent c) {
        super.uninstallListeners(c);
        this.removeViewportListeners(this.scrollpane.getViewport());
        this.handler = null;
    }
    
    @Override
    protected MouseWheelListener createMouseWheelListener() {
        final MouseWheelListener superListener = super.createMouseWheelListener();
        return e -> {
            if (this.isSmoothScrollingEnabled() && this.scrollpane.isWheelScrollingEnabled() && e.getScrollType() == 0 && e.getPreciseWheelRotation() != 0.0 && e.getPreciseWheelRotation() != e.getWheelRotation()) {
                this.mouseWheelMovedSmooth(e);
            }
            else {
                superListener.mouseWheelMoved(e);
            }
        };
    }
    
    protected boolean isSmoothScrollingEnabled() {
        final Object smoothScrolling = this.scrollpane.getClientProperty("JScrollPane.smoothScrolling");
        if (smoothScrolling instanceof Boolean) {
            return (boolean)smoothScrolling;
        }
        return UIManager.getBoolean("ScrollPane.smoothScrolling");
    }
    
    private void mouseWheelMovedSmooth(final MouseWheelEvent e) {
        final JViewport viewport = this.scrollpane.getViewport();
        if (viewport == null) {
            return;
        }
        JScrollBar scrollbar = this.scrollpane.getVerticalScrollBar();
        if (scrollbar == null || !scrollbar.isVisible() || e.isShiftDown()) {
            scrollbar = this.scrollpane.getHorizontalScrollBar();
            if (scrollbar == null || !scrollbar.isVisible()) {
                return;
            }
        }
        e.consume();
        final double rotation = e.getPreciseWheelRotation();
        final int orientation = scrollbar.getOrientation();
        final Component view = viewport.getView();
        int unitIncrement;
        if (view instanceof Scrollable) {
            final Scrollable scrollable = (Scrollable)view;
            final Rectangle visibleRect = new Rectangle(viewport.getViewSize());
            unitIncrement = scrollable.getScrollableUnitIncrement(visibleRect, orientation, 1);
            if (unitIncrement > 0) {
                if (orientation == 1) {
                    final Rectangle rectangle = visibleRect;
                    rectangle.y += unitIncrement;
                    final Rectangle rectangle2 = visibleRect;
                    rectangle2.height -= unitIncrement;
                }
                else {
                    final Rectangle rectangle3 = visibleRect;
                    rectangle3.x += unitIncrement;
                    final Rectangle rectangle4 = visibleRect;
                    rectangle4.width -= unitIncrement;
                }
                final int unitIncrement2 = scrollable.getScrollableUnitIncrement(visibleRect, orientation, 1);
                if (unitIncrement2 > 0) {
                    unitIncrement = Math.min(unitIncrement, unitIncrement2);
                }
            }
        }
        else {
            final int direction = (rotation < 0.0) ? -1 : 1;
            unitIncrement = scrollbar.getUnitIncrement(direction);
        }
        final int viewportWH = (orientation == 1) ? viewport.getHeight() : viewport.getWidth();
        final int scrollIncrement = Math.min(unitIncrement * e.getScrollAmount(), viewportWH);
        final double delta = rotation * scrollIncrement;
        int idelta = (int)Math.round(delta);
        if (idelta == 0) {
            if (rotation > 0.0) {
                idelta = 1;
            }
            else if (rotation < 0.0) {
                idelta = -1;
            }
        }
        final int value = scrollbar.getValue();
        final int minValue = scrollbar.getMinimum();
        final int maxValue = scrollbar.getMaximum() - scrollbar.getModel().getExtent();
        final int newValue = Math.max(minValue, Math.min(value + idelta, maxValue));
        if (newValue != value) {
            scrollbar.setValue(newValue);
        }
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        PropertyChangeListener superListener = super.createPropertyChangeListener();
        // If custom property change handling is needed, wrap the superListener here.
        // For now, just return the superclass's listener.
        return superListener;
    }
    
    private Handler getHandler() {
        if (this.handler == null) {
            this.handler = new Handler();
        }
        return this.handler;
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.scrollpane, "ScrollPane"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        if (key.equals("focusWidth")) {
            final int focusWidth = (int)((value instanceof Integer) ? value : UIManager.getInt("Component.focusWidth"));
            LookAndFeel.installProperty(this.scrollpane, "opaque", focusWidth == 0);
        }
        if (this.borderShared == null) {
            this.borderShared = new AtomicBoolean(true);
        }
        return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.scrollpane, this.borderShared);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.scrollpane.getBorder());
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, this.scrollpane.getBorder(), key);
    }
    
    @Override
    protected void updateViewport(final PropertyChangeEvent e) {
        super.updateViewport(e);
        final JViewport oldViewport = (JViewport)e.getOldValue();
        final JViewport newViewport = (JViewport)e.getNewValue();
        this.removeViewportListeners(oldViewport);
        this.addViewportListeners(newViewport);
    }
    
    private void addViewportListeners(final JViewport viewport) {
        if (viewport == null) {
            return;
        }
        viewport.addContainerListener(this.getHandler());
        final Component view = viewport.getView();
        if (view != null) {
            view.addFocusListener(this.getHandler());
        }
    }
    
    private void removeViewportListeners(final JViewport viewport) {
        if (viewport == null) {
            return;
        }
        viewport.removeContainerListener(this.getHandler());
        final Component view = viewport.getView();
        if (view != null) {
            view.removeFocusListener(this.getHandler());
        }
    }
    
    @Override
    public void update(final Graphics g, final JComponent c) {
        if (c.isOpaque()) {
            FlatUIUtils.paintParentBackground(g, c);
            final Insets insets = c.getInsets();
            g.setColor(c.getBackground());
            g.fillRect(insets.left, insets.top, c.getWidth() - insets.left - insets.right, c.getHeight() - insets.top - insets.bottom);
        }
        this.paint(g, c);
    }
    
    public static boolean isPermanentFocusOwner(final JScrollPane scrollPane) {
        final JViewport viewport = scrollPane.getViewport();
        final Component view = (viewport != null) ? viewport.getView() : null;
        if (view == null) {
            return false;
        }
        if (FlatUIUtils.isPermanentFocusOwner(view)) {
            return true;
        }
        if ((view instanceof JTable && ((JTable)view).isEditing()) || (view instanceof JTree && ((JTree)view).isEditing())) {
            final Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
            if (focusOwner != null) {
                return SwingUtilities.isDescendingFrom(focusOwner, view);
            }
        }
        return false;
    }
    
    private class Handler implements ContainerListener, FocusListener
    {
        @Override
        public void componentAdded(final ContainerEvent e) {
            e.getChild().addFocusListener(this);
        }
        
        @Override
        public void componentRemoved(final ContainerEvent e) {
            e.getChild().removeFocusListener(this);
        }
        
        @Override
        public void focusGained(final FocusEvent e) {
            FlatScrollPaneUI.this.scrollpane.repaint();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            FlatScrollPaneUI.this.scrollpane.repaint();
        }
    }
}
