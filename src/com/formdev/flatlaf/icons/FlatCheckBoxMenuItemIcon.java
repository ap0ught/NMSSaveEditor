// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import javax.swing.JMenuItem;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.geom.Path2D;
import javax.swing.AbstractButton;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.Map;
import javax.swing.UIManager;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import java.awt.Color;

public class FlatCheckBoxMenuItemIcon extends FlatAbstractIcon
{
    @FlatStylingSupport.Styleable
    protected Color checkmarkColor;
    @FlatStylingSupport.Styleable
    protected Color disabledCheckmarkColor;
    @FlatStylingSupport.Styleable
    protected Color selectionForeground;
    
    public FlatCheckBoxMenuItemIcon() {
        super(15, 15, null);
        this.checkmarkColor = UIManager.getColor("CheckBoxMenuItem.icon.checkmarkColor");
        this.disabledCheckmarkColor = UIManager.getColor("CheckBoxMenuItem.icon.disabledCheckmarkColor");
        this.selectionForeground = UIManager.getColor("MenuItem.selectionForeground");
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
    protected void paintIcon(final Component c, final Graphics2D g2) {
        final boolean selected = c instanceof AbstractButton && ((AbstractButton)c).isSelected();
        if (selected) {
            g2.setColor(this.getCheckmarkColor(c));
            this.paintCheckmark(g2);
        }
    }
    
    protected void paintCheckmark(final Graphics2D g2) {
        final Path2D.Float path = new Path2D.Float(1, 3);
        path.moveTo(4.5f, 7.5f);
        path.lineTo(6.6f, 10.0f);
        path.lineTo(11.25f, 3.5f);
        g2.setStroke(new BasicStroke(1.9f, 1, 1));
        g2.draw(path);
    }
    
    protected Color getCheckmarkColor(final Component c) {
        if (c instanceof JMenuItem && ((JMenuItem)c).isArmed() && !this.isUnderlineSelection()) {
            return this.selectionForeground;
        }
        return c.isEnabled() ? this.checkmarkColor : this.disabledCheckmarkColor;
    }
    
    protected boolean isUnderlineSelection() {
        return "underline".equals(UIManager.getString("MenuItem.selectionType"));
    }
}
