// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.geom.Path2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import javax.swing.plaf.TableHeaderUI;
import com.formdev.flatlaf.ui.FlatTableHeaderUI;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import java.awt.Graphics2D;
import java.awt.Component;
import com.formdev.flatlaf.ui.FlatUIUtils;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatAscendingSortIcon extends FlatAbstractIcon
{
    protected boolean chevron;
    protected Color sortIconColor;
    
    public FlatAscendingSortIcon() {
        super(10, 5, null);
        this.chevron = FlatUIUtils.isChevron(UIManager.getString("Component.arrowType"));
        this.sortIconColor = UIManager.getColor("Table.sortIconColor");
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        boolean chevron = this.chevron;
        Color sortIconColor = this.sortIconColor;
        final JTableHeader tableHeader = (JTableHeader)SwingUtilities.getAncestorOfClass(JTableHeader.class, c);
        if (tableHeader != null) {
            final TableHeaderUI ui = tableHeader.getUI();
            if (ui instanceof FlatTableHeaderUI) {
                final FlatTableHeaderUI fui = (FlatTableHeaderUI)ui;
                if (fui.arrowType != null) {
                    chevron = FlatUIUtils.isChevron(fui.arrowType);
                }
                if (fui.sortIconColor != null) {
                    sortIconColor = fui.sortIconColor;
                }
            }
        }
        g.setColor(sortIconColor);
        this.paintArrow(c, g, chevron);
    }
    
    protected void paintArrow(final Component c, final Graphics2D g, final boolean chevron) {
        if (chevron) {
            final Path2D path = FlatUIUtils.createPath(false, 1.0, 4.0, 5.0, 0.0, 9.0, 4.0);
            g.setStroke(new BasicStroke(1.0f));
            g.draw(path);
        }
        else {
            g.fill(FlatUIUtils.createPath(0.5, 5.0, 5.0, 0.0, 9.5, 5.0));
        }
    }
}
