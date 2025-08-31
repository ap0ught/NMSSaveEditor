// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.geom.Line2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatFileChooserUpFolderIcon extends FlatAbstractIcon
{
    private final Color blueColor;
    
    public FlatFileChooserUpFolderIcon() {
        super(16, 16, UIManager.getColor("Actions.Grey"));
        this.blueColor = UIManager.getColor("Actions.Blue");
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.setStroke(new BasicStroke(1.0f, 1, 1));
        g.draw(FlatFileViewDirectoryIcon.createFolderPath());
        g.setColor(this.blueColor);
        g.draw(new Line2D.Float(8.0f, 6.5f, 8.0f, 11.5f));
        g.draw(FlatUIUtils.createPath(false, 5.5, 9.0, 8.0, 6.5, 10.5, 9.0));
    }
}
