// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.BasicStroke;
import java.awt.geom.Path2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

public class FlatOptionPaneQuestionIcon extends FlatOptionPaneAbstractIcon
{
    public FlatOptionPaneQuestionIcon() {
        super("OptionPane.icon.questionColor", "Actions.Blue");
    }
    
    @Override
    protected Shape createOutside() {
        return new Ellipse2D.Float(2.0f, 2.0f, 28.0f, 28.0f);
    }
    
    @Override
    protected Shape createInside() {
        final Path2D q = new Path2D.Float(1, 10);
        q.moveTo(11.5, 11.75);
        q.curveTo(11.75, 9.5, 13.75, 8.0, 16.0, 8.0);
        q.curveTo(18.25, 8.0, 20.5, 9.5, 20.5, 11.75);
        q.curveTo(20.5, 14.75, 16.0, 15.5, 16.0, 19.0);
        final BasicStroke stroke = new BasicStroke(3.0f, 1, 0);
        final Path2D inside = new Path2D.Float(0);
        inside.append(new Ellipse2D.Float(14.3f, 22.3f, 3.4f, 3.4f), false);
        inside.append(stroke.createStrokedShape(q), false);
        return inside;
    }
}
