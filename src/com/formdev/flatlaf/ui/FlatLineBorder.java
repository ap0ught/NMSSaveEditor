// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Paint;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Color;

public class FlatLineBorder extends FlatEmptyBorder
{
    private final Color lineColor;
    private final float lineThickness;
    private final int arc;
    
    public FlatLineBorder(final Insets insets, final Color lineColor) {
        this(insets, lineColor, 1.0f, 0);
    }
    
    public FlatLineBorder(final Insets insets, final Color lineColor, final float lineThickness, final int arc) {
        super(insets);
        this.lineColor = lineColor;
        this.lineThickness = lineThickness;
        this.arc = arc;
    }
    
    public Color getLineColor() {
        return this.lineColor;
    }
    
    public float getLineThickness() {
        return this.lineThickness;
    }
    
    public int getArc() {
        return this.arc;
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            FlatUIUtils.paintOutlinedComponent(g2, x, y, width, height, 0.0f, 0.0f, 0.0f, UIScale.scale(this.getLineThickness()), (float)UIScale.scale(this.getArc()), null, this.getLineColor(), null);
        }
        finally {
            g2.dispose();
        }
    }
}
