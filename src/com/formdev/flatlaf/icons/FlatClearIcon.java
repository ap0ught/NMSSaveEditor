// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import javax.swing.ButtonModel;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import javax.swing.AbstractButton;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.Map;
import javax.swing.UIManager;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import java.awt.Color;

public class FlatClearIcon extends FlatAbstractIcon
{
    @FlatStylingSupport.Styleable
    protected Color clearIconColor;
    @FlatStylingSupport.Styleable
    protected Color clearIconHoverColor;
    @FlatStylingSupport.Styleable
    protected Color clearIconPressedColor;
    private final boolean ignoreButtonState;
    
    public FlatClearIcon() {
        this(false);
    }
    
    public FlatClearIcon(final boolean ignoreButtonState) {
        super(16, 16, null);
        this.clearIconColor = UIManager.getColor("SearchField.clearIconColor");
        this.clearIconHoverColor = UIManager.getColor("SearchField.clearIconHoverColor");
        this.clearIconPressedColor = UIManager.getColor("SearchField.clearIconPressedColor");
        this.ignoreButtonState = ignoreButtonState;
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
        if (!this.ignoreButtonState && c instanceof AbstractButton) {
            final ButtonModel model = ((AbstractButton)c).getModel();
            if (model.isPressed() || model.isRollover()) {
                g.setColor(model.isPressed() ? this.clearIconPressedColor : this.clearIconHoverColor);
                final Path2D path = new Path2D.Float(0);
                path.append(new Ellipse2D.Float(1.75f, 1.75f, 12.5f, 12.5f), false);
                path.append(FlatUIUtils.createPath(4.5, 5.5, 5.5, 4.5, 8.0, 7.0, 10.5, 4.5, 11.5, 5.5, 9.0, 8.0, 11.5, 10.5, 10.5, 11.5, 8.0, 9.0, 5.5, 11.5, 4.5, 10.5, 7.0, 8.0), false);
                g.fill(path);
                return;
            }
        }
        g.setColor(this.clearIconColor);
        final Path2D path2 = new Path2D.Float(0, 4);
        path2.moveTo(5.0, 5.0);
        path2.lineTo(11.0, 11.0);
        path2.moveTo(5.0, 11.0);
        path2.lineTo(11.0, 5.0);
        g.draw(path2);
    }
}
