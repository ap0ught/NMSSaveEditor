// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Shape;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Graphics2D;

public class FlatWindowMaximizeIcon extends FlatWindowAbstractIcon
{
    @Override
    protected void paintIconAt1x(final Graphics2D g, final int x, final int y, final int width, final int height, final double scaleFactor) {
        final int iwh = (int)(10.0 * scaleFactor);
        final int ix = x + (width - iwh) / 2;
        final int iy = y + (height - iwh) / 2;
        final float thickness = SystemInfo.isWindows_11_orLater ? ((float)scaleFactor) : ((float)(int)scaleFactor);
        final int arc = Math.max((int)(1.5 * scaleFactor), 2);
        g.fill(SystemInfo.isWindows_11_orLater ? FlatUIUtils.createRoundRectangle((float)ix, (float)iy, (float)iwh, (float)iwh, thickness, (float)arc, (float)arc, (float)arc, (float)arc) : FlatUIUtils.createRectangle((float)ix, (float)iy, (float)iwh, (float)iwh, thickness));
    }
}
