// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Component;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.geom.Path2D;

public class FlatCapsLockIcon extends FlatAbstractIcon
{
    private Path2D path;
    
    public FlatCapsLockIcon() {
        super(16, 16, UIManager.getColor("PasswordField.capsLockIconColor"));
    }
    
    public Object applyStyleProperty(final String key, final Object value) {
        switch (key) {
            case "capsLockIconColor": {
                final Object oldValue = this.color;
                this.color = (Color)value;
                return oldValue;
            }
            default: {
                throw new FlatStylingSupport.UnknownStyleException(key);
            }
        }
    }
    
    public Object getStyleableValue(final String key) {
        switch (key) {
            case "capsLockIconColor": {
                return this.color;
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        final BasicStroke stroke = new BasicStroke(1.0f, 2, 1);
        if (this.path == null) {
            (this.path = new Path2D.Float(0)).append(new RoundRectangle2D.Float(0.0f, 0.0f, 16.0f, 16.0f, 6.0f, 6.0f), false);
            this.path.append(new Area(stroke.createStrokedShape(new Rectangle2D.Float(5.5f, 11.5f, 5.0f, 2.0f))), false);
            this.path.append(new Area(stroke.createStrokedShape(FlatUIUtils.createPath(2.5, 7.5, 8.0, 2.0, 13.5, 7.5, 10.5, 7.5, 10.5, 9.5, 5.5, 9.5, 5.5, 7.5, 2.5, 7.5))), false);
        }
        g.fill(this.path);
    }
}
