// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.geom.Path2D;
import com.formdev.flatlaf.ui.FlatButtonUI;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.Map;
import com.formdev.flatlaf.ui.FlatUIUtils;
import javax.swing.UIManager;
import java.awt.Color;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import java.awt.Dimension;

public class FlatTabbedPaneCloseIcon extends FlatAbstractIcon
{
    @FlatStylingSupport.Styleable
    protected Dimension closeSize;
    @FlatStylingSupport.Styleable
    protected int closeArc;
    @FlatStylingSupport.Styleable
    protected float closeCrossPlainSize;
    @FlatStylingSupport.Styleable
    protected float closeCrossFilledSize;
    @FlatStylingSupport.Styleable
    protected float closeCrossLineWidth;
    @FlatStylingSupport.Styleable
    protected Color closeBackground;
    @FlatStylingSupport.Styleable
    protected Color closeForeground;
    @FlatStylingSupport.Styleable
    protected Color closeHoverBackground;
    @FlatStylingSupport.Styleable
    protected Color closeHoverForeground;
    @FlatStylingSupport.Styleable
    protected Color closePressedBackground;
    @FlatStylingSupport.Styleable
    protected Color closePressedForeground;
    
    public FlatTabbedPaneCloseIcon() {
        super(16, 16, null);
        this.closeSize = UIManager.getDimension("TabbedPane.closeSize");
        this.closeArc = UIManager.getInt("TabbedPane.closeArc");
        this.closeCrossPlainSize = FlatUIUtils.getUIFloat("TabbedPane.closeCrossPlainSize", 7.5f);
        this.closeCrossFilledSize = FlatUIUtils.getUIFloat("TabbedPane.closeCrossFilledSize", this.closeCrossPlainSize);
        this.closeCrossLineWidth = FlatUIUtils.getUIFloat("TabbedPane.closeCrossLineWidth", 1.0f);
        this.closeBackground = UIManager.getColor("TabbedPane.closeBackground");
        this.closeForeground = UIManager.getColor("TabbedPane.closeForeground");
        this.closeHoverBackground = UIManager.getColor("TabbedPane.closeHoverBackground");
        this.closeHoverForeground = UIManager.getColor("TabbedPane.closeHoverForeground");
        this.closePressedBackground = UIManager.getColor("TabbedPane.closePressedBackground");
        this.closePressedForeground = UIManager.getColor("TabbedPane.closePressedForeground");
    }
    
    public Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }
    
    public Map<String, Class<?>> getStyleableInfos() {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    public Object getStyleableValue(final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        final Color bg = FlatButtonUI.buttonStateColor(c, this.closeBackground, null, null, this.closeHoverBackground, this.closePressedBackground);
        if (bg != null) {
            g.setColor(FlatUIUtils.deriveColor(bg, c.getBackground()));
            g.fillRoundRect((this.width - this.closeSize.width) / 2, (this.height - this.closeSize.height) / 2, this.closeSize.width, this.closeSize.height, this.closeArc, this.closeArc);
        }
        final Color fg = FlatButtonUI.buttonStateColor(c, this.closeForeground, null, null, this.closeHoverForeground, this.closePressedForeground);
        g.setColor(FlatUIUtils.deriveColor(fg, c.getForeground()));
        final float mx = (float)(this.width / 2);
        final float my = (float)(this.height / 2);
        final float r = ((bg != null) ? this.closeCrossFilledSize : this.closeCrossPlainSize) / 2.0f;
        final Path2D path = new Path2D.Float(0, 4);
        path.moveTo(mx - r, my - r);
        path.lineTo(mx + r, my + r);
        path.moveTo(mx - r, my + r);
        path.lineTo(mx + r, my - r);
        g.setStroke(new BasicStroke(this.closeCrossLineWidth));
        g.draw(path);
    }
}
