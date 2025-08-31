// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Component;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Insets;
import javax.swing.plaf.BorderUIResource;

public class FlatEmptyBorder extends BorderUIResource.EmptyBorderUIResource
{
    public FlatEmptyBorder() {
        super(0, 0, 0, 0);
    }
    
    public FlatEmptyBorder(final int top, final int left, final int bottom, final int right) {
        super(top, left, bottom, right);
    }
    
    public FlatEmptyBorder(final Insets insets) {
        super(insets);
    }
    
    @Override
    public Insets getBorderInsets() {
        return new Insets(UIScale.scale(this.top), UIScale.scale(this.left), UIScale.scale(this.bottom), UIScale.scale(this.right));
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        return scaleInsets(c, insets, this.top, this.left, this.bottom, this.right);
    }
    
    protected static Insets scaleInsets(final Component c, final Insets insets, final int top, final int left, final int bottom, final int right) {
        final boolean leftToRight = left == right || c == null || c.getComponentOrientation().isLeftToRight();
        insets.left = UIScale.scale(leftToRight ? left : right);
        insets.top = UIScale.scale(top);
        insets.right = UIScale.scale(leftToRight ? right : left);
        insets.bottom = UIScale.scale(bottom);
        return insets;
    }
    
    public Insets getUnscaledBorderInsets() {
        return super.getBorderInsets();
    }
    
    public Object applyStyleProperty(final Insets insets) {
        final Insets oldInsets = this.getUnscaledBorderInsets();
        this.top = insets.top;
        this.left = insets.left;
        this.bottom = insets.bottom;
        this.right = insets.right;
        return oldInsets;
    }
    
    public Insets getStyleableValue() {
        return new Insets(this.top, this.left, this.bottom, this.right);
    }
}
