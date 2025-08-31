// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Color;
import com.formdev.flatlaf.util.AnimatedIcon;

public abstract class FlatAnimatedIcon extends FlatAbstractIcon implements AnimatedIcon
{
    public FlatAnimatedIcon(final int width, final int height, final Color color) {
        super(width, height, color);
    }
    
    @Override
    public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        super.paintIcon(c, g, x, y);
        AnimationSupport.saveIconLocation(this, c, x, y);
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        AnimationSupport.paintIcon(this, c, g, 0, 0);
    }
}
