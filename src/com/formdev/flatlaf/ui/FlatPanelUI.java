// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics2D;
import java.awt.Graphics;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.beans.PropertyChangeListener;
import javax.swing.plaf.basic.BasicPanelUI;

public class FlatPanelUI extends BasicPanelUI implements FlatStylingSupport.StyleableUI, PropertyChangeListener
{
    @FlatStylingSupport.Styleable
    protected int arc;
    private final boolean shared;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.canUseSharedUI(c) ? FlatUIUtils.createSharedUI((Object)FlatPanelUI.class, () -> new FlatPanelUI(true)) : new FlatPanelUI(false);
    }
    
    protected FlatPanelUI(final boolean shared) {
        this.arc = -1;
        this.shared = shared;
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        c.addPropertyChangeListener(this);
        this.installStyle((JPanel)c);
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        c.removePropertyChangeListener(this);
        this.oldStyleValues = null;
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent e) {
        final String propertyName = e.getPropertyName();
        switch (propertyName) {
            case "FlatLaf.style":
            case "FlatLaf.styleClass": {
                final JPanel c = (JPanel)e.getSource();
                if (this.shared && FlatStylingSupport.hasStyleProperty(c)) {
                    c.updateUI();
                }
                else {
                    this.installStyle(c);
                }
                c.revalidate();
                c.repaint();
                break;
            }
        }
    }
    
    protected void installStyle(final JPanel c) {
        try {
            this.applyStyle(c, FlatStylingSupport.getResolvedStyle(c, "Panel"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final JPanel c, final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, (key, value) -> this.applyStyleProperty(c, key, value));
    }
    
    protected Object applyStyleProperty(final JPanel c, final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, c, key, value);
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
    public void update(final Graphics g, final JComponent c) {
        if (c.isOpaque()) {
            final int width = c.getWidth();
            final int height = c.getHeight();
            final int arc = (this.arc >= 0) ? this.arc : ((c.getBorder() instanceof FlatLineBorder) ? ((FlatLineBorder)c.getBorder()).getArc() : 0);
            if (arc > 0) {
                FlatUIUtils.paintParentBackground(g, c);
            }
            g.setColor(c.getBackground());
            if (arc > 0) {
                final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);
                FlatUIUtils.paintComponentBackground((Graphics2D)g, 0, 0, width, height, 0.0f, (float)UIScale.scale(arc));
                FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
            }
            else {
                g.fillRect(0, 0, width, height);
            }
        }
        this.paint(g, c);
    }
}
