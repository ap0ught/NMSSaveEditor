// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Color;
import com.formdev.flatlaf.ui.FlatTreeUI;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.UIManager;

public class FlatTreeExpandedIcon extends FlatTreeCollapsedIcon
{
    public FlatTreeExpandedIcon() {
        super(UIManager.getColor("Tree.icon.expandedColor"));
    }
    
    @Override
    void setStyleColorFromTreeUI(final Component c, final Graphics2D g) {
        FlatTreeCollapsedIcon.setStyleColorFromTreeUI(c, g, ui -> ui.iconExpandedColor);
    }
    
    @Override
    void rotate(final Component c, final Graphics2D g) {
        g.rotate(Math.toRadians(90.0), this.width / 2.0, this.height / 2.0);
    }
}
