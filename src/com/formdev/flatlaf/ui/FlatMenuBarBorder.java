// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.JMenuBar;
import java.awt.Insets;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics;
import java.awt.Component;
import java.util.Map;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatMenuBarBorder extends FlatMarginBorder implements FlatStylingSupport.StyleableBorder
{
    @FlatStylingSupport.Styleable
    protected Color borderColor;
    
    public FlatMenuBarBorder() {
        this.borderColor = UIManager.getColor("MenuBar.borderColor");
    }
    
    @Override
    public Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos() {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        if (!this.showBottomSeparator(c)) {
            return;
        }
        final float lineHeight = UIScale.scale(1.0f);
        FlatUIUtils.paintFilledRectangle(g, this.borderColor, (float)x, y + height - lineHeight, (float)width, lineHeight);
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        final Insets margin = (c instanceof JMenuBar) ? ((JMenuBar)c).getMargin() : new Insets(0, 0, 0, 0);
        insets.top = UIScale.scale(margin.top);
        insets.left = UIScale.scale(margin.left);
        insets.bottom = UIScale.scale(margin.bottom + 1);
        insets.right = UIScale.scale(margin.right);
        return insets;
    }
    
    protected boolean showBottomSeparator(final Component c) {
        return !FlatMenuBarUI.useUnifiedBackground(c);
    }
}
