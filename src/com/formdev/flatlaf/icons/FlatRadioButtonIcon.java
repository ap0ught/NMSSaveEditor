// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Component;
import com.formdev.flatlaf.ui.FlatStylingSupport;

public class FlatRadioButtonIcon extends FlatCheckBoxIcon
{
    @FlatStylingSupport.Styleable
    protected float centerDiameter;
    
    public FlatRadioButtonIcon() {
        this.centerDiameter = FlatCheckBoxIcon.getUIFloat("RadioButton.icon.centerDiameter", 8.0f, this.style);
    }
    
    @Override
    protected String getPropertyPrefix() {
        return "RadioButton.";
    }
    
    @Override
    protected void paintFocusBorder(final Component c, final Graphics2D g) {
        final float wh = 15.0f + this.focusWidth * 2.0f;
        g.fill(new Ellipse2D.Float(-this.focusWidth, -this.focusWidth, wh, wh));
    }
    
    @Override
    protected void paintBorder(final Component c, final Graphics2D g, final float borderWidth) {
        if (borderWidth == 0.0f) {
            return;
        }
        g.fillOval(0, 0, 15, 15);
    }
    
    @Override
    protected void paintBackground(final Component c, final Graphics2D g, final float borderWidth) {
        final float xy = borderWidth;
        final float wh = 15.0f - borderWidth * 2.0f;
        g.fill(new Ellipse2D.Float(xy, xy, wh, wh));
    }
    
    @Override
    protected void paintCheckmark(final Component c, final Graphics2D g) {
        final float xy = (15.0f - this.centerDiameter) / 2.0f;
        g.fill(new Ellipse2D.Float(xy, xy, this.centerDiameter, this.centerDiameter));
    }
}
