// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.Area;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Graphics2D;

public class FlatWindowRestoreIcon extends FlatWindowAbstractIcon
{
    @Override
    protected void paintIconAt1x(final Graphics2D g, final int x, final int y, final int width, final int height, final double scaleFactor) {
        final int iwh = (int)(10.0 * scaleFactor);
        final int ix = x + (width - iwh) / 2;
        final int iy = y + (height - iwh) / 2;
        final float thickness = SystemInfo.isWindows_11_orLater ? ((float)scaleFactor) : ((float)(int)scaleFactor);
        final int arc = Math.max((int)(1.5 * scaleFactor), 2);
        final int arcOuter = (int)(arc + 1.5 * scaleFactor);
        final int rwh = (int)(8.0 * scaleFactor);
        final int ro2 = iwh - rwh;
        final Path2D r1 = SystemInfo.isWindows_11_orLater ? FlatUIUtils.createRoundRectangle((float)(ix + ro2), (float)iy, (float)rwh, (float)rwh, thickness, (float)arc, (float)arcOuter, (float)arc, (float)arc) : FlatUIUtils.createRectangle((float)(ix + ro2), (float)iy, (float)rwh, (float)rwh, thickness);
        final Path2D r2 = SystemInfo.isWindows_11_orLater ? FlatUIUtils.createRoundRectangle((float)ix, (float)(iy + ro2), (float)rwh, (float)rwh, thickness, (float)arc, (float)arc, (float)arc, (float)arc) : FlatUIUtils.createRectangle((float)ix, (float)(iy + ro2), (float)rwh, (float)rwh, thickness);
        final Area area = new Area(r1);
        if (SystemInfo.isWindows_11_orLater) {
            area.subtract(new Area(new Rectangle2D.Float((float)ix, (float)(iy + scaleFactor), (float)rwh, (float)rwh)));
            area.subtract(new Area(new Rectangle2D.Float((float)(ix + scaleFactor), (float)(iy + ro2), (float)rwh, (float)rwh)));
        }
        else {
            area.subtract(new Area(new Rectangle2D.Float((float)ix, (float)(iy + ro2), (float)rwh, (float)rwh)));
        }
        g.fill(area);
        g.fill(r2);
    }
}
