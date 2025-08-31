// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.JScrollBar;
import javax.swing.JViewport;
import java.awt.Container;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatTableHeaderBorder extends FlatEmptyBorder
{
    protected Color separatorColor;
    protected Color bottomSeparatorColor;
    protected boolean showTrailingVerticalLine;
    
    public FlatTableHeaderBorder() {
        super(UIManager.getInsets("TableHeader.cellMargins"));
        this.separatorColor = UIManager.getColor("TableHeader.separatorColor");
        this.bottomSeparatorColor = UIManager.getColor("TableHeader.bottomSeparatorColor");
        this.showTrailingVerticalLine = UIManager.getBoolean("TableHeader.showTrailingVerticalLine");
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        final JTableHeader header = (JTableHeader)SwingUtilities.getAncestorOfClass(JTableHeader.class, c);
        if (header != null && header.getUI() instanceof FlatTableHeaderUI) {
            final FlatTableHeaderUI ui = (FlatTableHeaderUI)header.getUI();
            if (ui.cellMargins != null) {
                final Insets m = ui.cellMargins;
                return FlatEmptyBorder.scaleInsets(c, insets, m.top, m.left, m.bottom, m.right);
            }
        }
        return super.getBorderInsets(c, insets);
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        final JTableHeader header = (JTableHeader)SwingUtilities.getAncestorOfClass(JTableHeader.class, c);
        final boolean leftToRight = ((header != null) ? header : c).getComponentOrientation().isLeftToRight();
        boolean paintLeft = !leftToRight;
        boolean paintRight = leftToRight;
        Color separatorColor = this.separatorColor;
        Color bottomSeparatorColor = this.bottomSeparatorColor;
        if (header != null) {
            final int hx = SwingUtilities.convertPoint(c, x, y, header).x;
            if (this.isDraggedColumn(header, hx)) {
                paintRight = (paintLeft = true);
            }
            else {
                if (hx <= 0 && !leftToRight && this.hideTrailingVerticalLine(header)) {
                    paintLeft = false;
                }
                if (hx + width >= header.getWidth() && leftToRight && this.hideTrailingVerticalLine(header)) {
                    paintRight = false;
                }
            }
            if (header.getUI() instanceof FlatTableHeaderUI) {
                final FlatTableHeaderUI ui = (FlatTableHeaderUI)header.getUI();
                if (ui.separatorColor != null) {
                    separatorColor = ui.separatorColor;
                }
                if (ui.bottomSeparatorColor != null) {
                    bottomSeparatorColor = ui.bottomSeparatorColor;
                }
            }
        }
        final float lineWidth = UIScale.scale(1.0f);
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(separatorColor);
            if (paintLeft) {
                g2.fill(new Rectangle2D.Float((float)x, (float)y, lineWidth, height - lineWidth));
            }
            if (paintRight) {
                g2.fill(new Rectangle2D.Float(x + width - lineWidth, (float)y, lineWidth, height - lineWidth));
            }
            g2.setColor(bottomSeparatorColor);
            g2.fill(new Rectangle2D.Float((float)x, y + height - lineWidth, (float)width, lineWidth));
        }
        finally {
            g2.dispose();
        }
    }
    
    protected boolean isDraggedColumn(final JTableHeader header, final int x) {
        final TableColumn draggedColumn = header.getDraggedColumn();
        if (draggedColumn == null) {
            return false;
        }
        final int draggedDistance = header.getDraggedDistance();
        if (draggedDistance == 0) {
            return false;
        }
        for (int columnCount = header.getColumnModel().getColumnCount(), i = 0; i < columnCount; ++i) {
            if (header.getHeaderRect(i).x + draggedDistance == x) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean hideTrailingVerticalLine(final JTableHeader header) {
        if (header.getUI() instanceof FlatTableHeaderUI) {
            final FlatTableHeaderUI ui = (FlatTableHeaderUI)header.getUI();
            if (ui.showTrailingVerticalLine != null) {
                return !ui.showTrailingVerticalLine;
            }
        }
        if (this.showTrailingVerticalLine) {
            return false;
        }
        final Container viewport = header.getParent();
        final Container viewportParent = (viewport != null) ? viewport.getParent() : null;
        if (!(viewportParent instanceof JScrollPane)) {
            return false;
        }
        final JScrollPane scrollPane = (JScrollPane)viewportParent;
        final JViewport columnHeader = scrollPane.getColumnHeader();
        if (viewport != columnHeader) {
            return false;
        }
        final JScrollBar vsb = scrollPane.getVerticalScrollBar();
        return vsb == null || !vsb.isVisible() || vsb.getY() == viewport.getY();
    }
}
