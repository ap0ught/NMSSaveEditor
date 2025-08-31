// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Color;
import com.formdev.flatlaf.ui.FlatTreeUI;
import java.awt.Shape;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.geom.Path2D;

public class FlatTreeClosedIcon extends FlatAbstractIcon
{
    private Path2D path;
    
    public FlatTreeClosedIcon() {
        super(16, 16, UIManager.getColor("Tree.icon.closedColor"));
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        FlatTreeCollapsedIcon.setStyleColorFromTreeUI(c, g, ui -> ui.iconClosedColor);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        if (this.path == null) {
            this.path = FlatFileViewDirectoryIcon.createFolderPath();
        }
        g.draw(this.path);
    }
}
