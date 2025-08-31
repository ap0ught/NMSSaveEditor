// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Path2D;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Shape;

public class FlatOptionPaneWarningIcon extends FlatOptionPaneAbstractIcon
{
    public FlatOptionPaneWarningIcon() {
        super("OptionPane.icon.warningColor", "Actions.Yellow");
    }
    
    @Override
    protected Shape createOutside() {
        return FlatUIUtils.createRoundTrianglePath(16.0f, 0.0f, 32.0f, 28.0f, 0.0f, 28.0f, 4.0f);
    }
    
    @Override
    protected Shape createInside() {
        final Path2D inside = new Path2D.Float(0);
        inside.append(new RoundRectangle2D.Float(14.0f, 8.0f, 4.0f, 11.0f, 4.0f, 4.0f), false);
        inside.append(new Ellipse2D.Float(14.0f, 21.0f, 4.0f, 4.0f), false);
        return inside;
    }
}
