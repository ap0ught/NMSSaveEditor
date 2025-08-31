// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import javax.swing.JMenu;
import java.awt.geom.Path2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.Map;
import javax.swing.UIManager;
import java.awt.Color;
import com.formdev.flatlaf.ui.FlatStylingSupport;

public class FlatMenuArrowIcon extends FlatAbstractIcon
{
    @FlatStylingSupport.Styleable
    protected String arrowType;
    @FlatStylingSupport.Styleable
    protected Color arrowColor;
    @FlatStylingSupport.Styleable
    protected Color disabledArrowColor;
    @FlatStylingSupport.Styleable
    protected Color selectionForeground;
    
    public FlatMenuArrowIcon() {
        super(6, 10, null);
        this.arrowType = UIManager.getString("Component.arrowType");
        this.arrowColor = UIManager.getColor("Menu.icon.arrowColor");
        this.disabledArrowColor = UIManager.getColor("Menu.icon.disabledArrowColor");
        this.selectionForeground = UIManager.getColor("Menu.selectionForeground");
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
        if (c != null && !c.getComponentOrientation().isLeftToRight()) {
            g.rotate(Math.toRadians(180.0), this.width / 2.0, this.height / 2.0);
        }
        g.setColor(this.getArrowColor(c));
        if (FlatUIUtils.isChevron(this.arrowType)) {
            final Path2D path = FlatUIUtils.createPath(false, 1.0, 1.0, 5.0, 5.0, 1.0, 9.0);
            g.setStroke(new BasicStroke(1.0f));
            g.draw(path);
        }
        else {
            g.fill(FlatUIUtils.createPath(0.0, 0.5, 5.0, 5.0, 0.0, 9.5));
        }
    }
    
    protected Color getArrowColor(final Component c) {
        if (c instanceof JMenu && ((JMenu)c).isSelected() && !this.isUnderlineSelection()) {
            return this.selectionForeground;
        }
        return (c == null || c.isEnabled()) ? this.arrowColor : this.disabledArrowColor;
    }
    
    protected boolean isUnderlineSelection() {
        return "underline".equals(UIManager.getString("MenuItem.selectionType"));
    }
}
