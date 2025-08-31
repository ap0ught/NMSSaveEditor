// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.awt.Component;
import java.util.Map;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatPopupMenuBorder extends FlatLineBorder implements FlatStylingSupport.StyleableBorder
{
    private Color borderColor;
    
    public FlatPopupMenuBorder() {
        super(UIManager.getInsets("PopupMenu.borderInsets"), UIManager.getColor("PopupMenu.borderColor"));
    }
    
    @Override
    public Object applyStyleProperty(final String key, final Object value) {
        switch (key) {
            case "borderInsets": {
                return this.applyStyleProperty((Insets)value);
            }
            case "borderColor": {
                final Object oldValue = this.getLineColor();
                this.borderColor = (Color)value;
                return oldValue;
            }
            default: {
                throw new FlatStylingSupport.UnknownStyleException(key);
            }
        }
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos() {
        final Map<String, Class<?>> infos = new FlatStylingSupport.StyleableInfosMap<String, Class<?>>();
        infos.put("borderInsets", Insets.class);
        infos.put("borderColor", Color.class);
        return infos;
    }
    
    @Override
    public Object getStyleableValue(final String key) {
        switch (key) {
            case "borderInsets": {
                return this.getStyleableValue();
            }
            case "borderColor": {
                return this.borderColor;
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public Color getLineColor() {
        return (this.borderColor != null) ? this.borderColor : super.getLineColor();
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        if (c instanceof Container && ((Container)c).getComponentCount() > 0 && ((Container)c).getComponent(0) instanceof JScrollPane) {
            final int scale = UIScale.scale(1);
            insets.bottom = scale;
            insets.right = scale;
            insets.top = scale;
            insets.left = scale;
            return insets;
        }
        return super.getBorderInsets(c, insets);
    }
}
