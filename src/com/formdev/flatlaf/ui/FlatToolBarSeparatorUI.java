// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Graphics;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.JToolBar;
import java.awt.Dimension;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import javax.swing.plaf.basic.BasicToolBarSeparatorUI;

public class FlatToolBarSeparatorUI extends BasicToolBarSeparatorUI implements FlatStylingSupport.StyleableUI, PropertyChangeListener
{
    private static final int LINE_WIDTH = 1;
    @FlatStylingSupport.Styleable
    protected int separatorWidth;
    @FlatStylingSupport.Styleable
    protected Color separatorColor;
    private final boolean shared;
    private boolean defaults_initialized;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.canUseSharedUI(c) ? FlatUIUtils.createSharedUI((Object)FlatToolBarSeparatorUI.class, () -> new FlatToolBarSeparatorUI(true)) : new FlatToolBarSeparatorUI(false);
    }
    
    protected FlatToolBarSeparatorUI(final boolean shared) {
        this.defaults_initialized = false;
        this.shared = shared;
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle((JSeparator)c);
    }
    
    @Override
    protected void installDefaults(final JSeparator c) {
        super.installDefaults(c);
        if (!this.defaults_initialized) {
            this.separatorWidth = UIManager.getInt("ToolBar.separatorWidth");
            this.separatorColor = UIManager.getColor("ToolBar.separatorColor");
            this.defaults_initialized = true;
        }
        c.setAlignmentX(0.0f);
    }
    
    @Override
    protected void uninstallDefaults(final JSeparator s) {
        super.uninstallDefaults(s);
        this.defaults_initialized = false;
        this.oldStyleValues = null;
    }
    
    @Override
    protected void installListeners(final JSeparator s) {
        super.installListeners(s);
        s.addPropertyChangeListener(this);
    }
    
    @Override
    protected void uninstallListeners(final JSeparator s) {
        super.uninstallListeners(s);
        s.removePropertyChangeListener(this);
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent e) {
        final String propertyName = e.getPropertyName();
        switch (propertyName) {
            case "FlatLaf.style":
            case "FlatLaf.styleClass": {
                final JSeparator s = (JSeparator)e.getSource();
                if (this.shared && FlatStylingSupport.hasStyleProperty(s)) {
                    s.updateUI();
                }
                else {
                    this.installStyle(s);
                }
                s.revalidate();
                s.repaint();
                break;
            }
        }
    }
    
    protected void installStyle(final JSeparator s) {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(s, "ToolBarSeparator"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        final Dimension size = ((JToolBar.Separator)c).getSeparatorSize();
        if (size != null) {
            return UIScale.scale(size);
        }
        final int sepWidth = UIScale.scale((this.separatorWidth - 1) / 2) * 2 + UIScale.scale(1);
        final boolean vertical = this.isVertical(c);
        return new Dimension(vertical ? sepWidth : 0, vertical ? 0 : sepWidth);
    }
    
    @Override
    public Dimension getMaximumSize(final JComponent c) {
        final Dimension size = this.getPreferredSize(c);
        if (this.isVertical(c)) {
            return new Dimension(size.width, 32767);
        }
        return new Dimension(32767, size.height);
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        final int width = c.getWidth();
        final int height = c.getHeight();
        final float lineWidth = UIScale.scale(1.0f);
        final float offset = UIScale.scale(2.0f);
        final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);
        g.setColor(this.separatorColor);
        if (this.isVertical(c)) {
            ((Graphics2D)g).fill(new Rectangle2D.Float((float)Math.round((width - lineWidth) / 2.0f), offset, lineWidth, height - offset * 2.0f));
        }
        else {
            ((Graphics2D)g).fill(new Rectangle2D.Float(offset, (float)Math.round((height - lineWidth) / 2.0f), width - offset * 2.0f, lineWidth));
        }
        FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
    }
    
    private boolean isVertical(final JComponent c) {
        return ((JToolBar.Separator)c).getOrientation() == 1;
    }
}
