// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.border.Border;
import javax.swing.plaf.TableUI;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import java.util.function.Function;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Component;

public class FlatTableCellBorder extends FlatLineBorder
{
    protected boolean showCellFocusIndicator;
    private Component c;
    
    protected FlatTableCellBorder() {
        super(UIManager.getInsets("Table.cellMargins"), UIManager.getColor("Table.cellFocusColor"));
        this.showCellFocusIndicator = UIManager.getBoolean("Table.showCellFocusIndicator");
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        final Insets m = getStyleFromTableUI(c, ui -> ui.cellMargins);
        if (m != null) {
            return FlatEmptyBorder.scaleInsets(c, insets, m.top, m.left, m.bottom, m.right);
        }
        return super.getBorderInsets(c, insets);
    }
    
    @Override
    public Color getLineColor() {
        if (this.c != null) {
            final Color color = getStyleFromTableUI(this.c, ui -> ui.cellFocusColor);
            if (color != null) {
                return color;
            }
        }
        return super.getLineColor();
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        super.paintBorder(this.c = c, g, x, y, width, height);
        this.c = null;
    }
    
    static <T> T getStyleFromTableUI(final Component c, final Function<FlatTableUI, T> f) {
        final JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
        if (table != null) {
            final TableUI ui = table.getUI();
            if (ui instanceof FlatTableUI) {
                return f.apply((FlatTableUI)ui);
            }
        }
        return null;
    }
    
    public static class Default extends FlatTableCellBorder
    {
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        }
    }
    
    public static class Focused extends FlatTableCellBorder
    {
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            if (c != null && c.getClass().getName().equals("javax.swing.JTable$BooleanRenderer")) {
                final JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
                if (table != null && c.getForeground() == table.getSelectionForeground() && c.getBackground() == table.getSelectionBackground()) {
                    final Border border = UIManager.getBorder("Table.focusSelectedCellHighlightBorder");
                    if (border != null) {
                        border.paintBorder(c, g, x, y, width, height);
                        return;
                    }
                }
            }
            super.paintBorder(c, g, x, y, width, height);
        }
    }
    
    public static class Selected extends FlatTableCellBorder
    {
        public int maxCheckCellsEditable;
        
        public Selected() {
            this.maxCheckCellsEditable = 50;
        }
        
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            final Boolean b = FlatTableCellBorder.getStyleFromTableUI(c, ui -> ui.showCellFocusIndicator);
            final boolean showCellFocusIndicator = (b != null) ? b : this.showCellFocusIndicator;
            if (!showCellFocusIndicator) {
                final JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
                if (table != null && !this.shouldShowCellFocusIndicator(table)) {
                    return;
                }
            }
            super.paintBorder(c, g, x, y, width, height);
        }
        
        protected boolean shouldShowCellFocusIndicator(final JTable table) {
            final boolean rowSelectionAllowed = table.getRowSelectionAllowed();
            final boolean columnSelectionAllowed = table.getColumnSelectionAllowed();
            if (rowSelectionAllowed && columnSelectionAllowed) {
                return false;
            }
            if (rowSelectionAllowed) {
                if (table.getSelectedRowCount() != 1) {
                    return false;
                }
                final int columnCount = table.getColumnCount();
                if (columnCount > this.maxCheckCellsEditable) {
                    return true;
                }
                final int selectedRow = table.getSelectedRow();
                for (int column = 0; column < columnCount; ++column) {
                    if (table.isCellEditable(selectedRow, column)) {
                        return true;
                    }
                }
            }
            else if (columnSelectionAllowed) {
                if (table.getSelectedColumnCount() != 1) {
                    return false;
                }
                final int rowCount = table.getRowCount();
                if (rowCount > this.maxCheckCellsEditable) {
                    return true;
                }
                final int selectedColumn = table.getSelectedColumn();
                for (int row = 0; row < rowCount; ++row) {
                    if (table.isCellEditable(row, selectedColumn)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
