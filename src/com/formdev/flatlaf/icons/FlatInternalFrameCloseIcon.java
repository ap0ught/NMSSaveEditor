// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.geom.Path2D;
import com.formdev.flatlaf.ui.FlatButtonUI;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatInternalFrameCloseIcon extends FlatInternalFrameAbstractIcon
{
    private final Color hoverForeground;
    private final Color pressedForeground;
    
    public FlatInternalFrameCloseIcon() {
        super(UIManager.getDimension("InternalFrame.buttonSize"), UIManager.getColor("InternalFrame.closeHoverBackground"), UIManager.getColor("InternalFrame.closePressedBackground"));
        this.hoverForeground = UIManager.getColor("InternalFrame.closeHoverForeground");
        this.pressedForeground = UIManager.getColor("InternalFrame.closePressedForeground");
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        this.paintBackground(c, g);
        g.setColor(FlatButtonUI.buttonStateColor(c, c.getForeground(), null, null, this.hoverForeground, this.pressedForeground));
        final float mx = (float)(this.width / 2);
        final float my = (float)(this.height / 2);
        final float r = 3.25f;
        final Path2D path = new Path2D.Float(0, 4);
        path.moveTo(mx - r, my - r);
        path.lineTo(mx + r, my + r);
        path.moveTo(mx - r, my + r);
        path.lineTo(mx + r, my - r);
        g.setStroke(new BasicStroke(1.0f));
        g.draw(path);
    }
}
