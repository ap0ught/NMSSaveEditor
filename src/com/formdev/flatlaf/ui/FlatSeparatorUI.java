// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics2D;
import java.awt.Graphics;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.beans.PropertyChangeListener;
import javax.swing.plaf.basic.BasicSeparatorUI;

public class FlatSeparatorUI extends BasicSeparatorUI implements FlatStylingSupport.StyleableUI, PropertyChangeListener
{
    @FlatStylingSupport.Styleable
    protected int height;
    @FlatStylingSupport.Styleable
    protected int stripeWidth;
    @FlatStylingSupport.Styleable
    protected int stripeIndent;
    private final boolean shared;
    private boolean defaults_initialized;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.canUseSharedUI(c) ? FlatUIUtils.createSharedUI((Object)FlatSeparatorUI.class, () -> new FlatSeparatorUI(true)) : new FlatSeparatorUI(false);
    }
    
    protected FlatSeparatorUI(final boolean shared) {
        this.defaults_initialized = false;
        this.shared = shared;
    }
    
    protected String getPropertyPrefix() {
        return "Separator";
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle((JSeparator)c);
    }
    
    @Override
    protected void installDefaults(final JSeparator s) {
        super.installDefaults(s);
        if (!this.defaults_initialized) {
            final String prefix = this.getPropertyPrefix();
            this.height = UIManager.getInt(prefix + ".height");
            this.stripeWidth = UIManager.getInt(prefix + ".stripeWidth");
            this.stripeIndent = UIManager.getInt(prefix + ".stripeIndent");
            this.defaults_initialized = true;
        }
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
            this.applyStyle(s, FlatStylingSupport.getResolvedStyle(s, this.getStyleType()));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    String getStyleType() {
        return "Separator";
    }
    
    protected void applyStyle(final JSeparator s, final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, (key, value) -> this.applyStyleProperty(s, key, value));
    }
    
    protected Object applyStyleProperty(final JSeparator s, final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, s, key, value);
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
    public void paint(final Graphics g, final JComponent c) {
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(c.getForeground());
            final float width = UIScale.scale((float)this.stripeWidth);
            final float indent = UIScale.scale((float)this.stripeIndent);
            if (((JSeparator)c).getOrientation() == 1) {
                g2.fill(new Rectangle2D.Float(indent, 0.0f, width, (float)c.getHeight()));
            }
            else {
                g2.fill(new Rectangle2D.Float(0.0f, indent, (float)c.getWidth(), width));
            }
        }
        finally {
            g2.dispose();
        }
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        if (((JSeparator)c).getOrientation() == 1) {
            return new Dimension(UIScale.scale(this.height), 0);
        }
        return new Dimension(0, UIScale.scale(this.height));
    }
}
