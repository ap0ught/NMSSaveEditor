// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.ListUI;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import java.util.function.Function;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Component;

public class FlatListCellBorder extends FlatLineBorder
{
    protected boolean showCellFocusIndicator;
    private Component c;
    
    protected FlatListCellBorder() {
        super(UIManager.getInsets("List.cellMargins"), UIManager.getColor("List.cellFocusColor"));
        this.showCellFocusIndicator = UIManager.getBoolean("List.showCellFocusIndicator");
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        final Insets m = getStyleFromListUI(c, ui -> ui.cellMargins);
        if (m != null) {
            return FlatEmptyBorder.scaleInsets(c, insets, m.top, m.left, m.bottom, m.right);
        }
        return super.getBorderInsets(c, insets);
    }
    
    @Override
    public Color getLineColor() {
        if (this.c != null) {
            final Color color = getStyleFromListUI(this.c, ui -> ui.cellFocusColor);
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
    
    static <T> T getStyleFromListUI(final Component c, final Function<FlatListUI, T> f) {
        final JList<?> list = (JList<?>)SwingUtilities.getAncestorOfClass(JList.class, c);
        if (list != null) {
            final ListUI ui = list.getUI();
            if (ui instanceof FlatListUI) {
                return f.apply((FlatListUI)ui);
            }
        }
        return null;
    }
    
    public static class Default extends FlatListCellBorder
    {
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        }
    }
    
    public static class Focused extends FlatListCellBorder
    {
    }
    
    public static class Selected extends FlatListCellBorder
    {
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            final Boolean b = FlatListCellBorder.getStyleFromListUI(c, ui -> ui.showCellFocusIndicator);
            final boolean showCellFocusIndicator = (b != null) ? b : this.showCellFocusIndicator;
            if (!showCellFocusIndicator) {
                return;
            }
            final JList<?> list = (JList<?>)SwingUtilities.getAncestorOfClass(JList.class, c);
            if (list != null && list.getMinSelectionIndex() == list.getMaxSelectionIndex()) {
                return;
            }
            super.paintBorder(c, g, x, y, width, height);
        }
    }
}
