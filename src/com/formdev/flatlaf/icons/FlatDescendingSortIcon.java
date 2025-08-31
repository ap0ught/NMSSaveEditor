// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.geom.Path2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Graphics2D;
import java.awt.Component;

public class FlatDescendingSortIcon extends FlatAscendingSortIcon
{
    @Override
    protected void paintArrow(final Component c, final Graphics2D g, final boolean chevron) {
        if (chevron) {
            final Path2D path = FlatUIUtils.createPath(false, 1.0, 0.0, 5.0, 4.0, 9.0, 0.0);
            g.setStroke(new BasicStroke(1.0f));
            g.draw(path);
        }
        else {
            g.fill(FlatUIUtils.createPath(0.5, 0.0, 5.0, 5.0, 9.5, 0.0));
        }
    }
}
