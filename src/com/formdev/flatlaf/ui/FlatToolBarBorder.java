// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.ToolBarUI;
import java.util.function.Function;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import javax.swing.JToolBar;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Color;

public class FlatToolBarBorder extends FlatMarginBorder
{
    private static final int DOT_COUNT = 4;
    private static final int DOT_SIZE = 2;
    private static final int GRIP_SIZE = 6;
    protected Color gripColor;
    
    public FlatToolBarBorder() {
        super(UIManager.getInsets("ToolBar.borderMargins"));
        this.gripColor = UIManager.getColor("ToolBar.gripColor");
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        if (c instanceof JToolBar && ((JToolBar)c).isFloatable()) {
            final Graphics2D g2 = (Graphics2D)g.create();
            try {
                FlatUIUtils.setRenderingHints(g2);
                final Color color = getStyleFromToolBarUI(c, ui -> ui.gripColor);
                g2.setColor((color != null) ? color : this.gripColor);
                this.paintGrip(c, g2, x, y, width, height);
            }
            finally {
                g2.dispose();
            }
        }
    }
    
    protected void paintGrip(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        final Rectangle r = this.calculateGripBounds(c, x, y, width, height);
        FlatUIUtils.paintGrip(g, r.x, r.y, r.width, r.height, ((JToolBar)c).getOrientation() == 1, 4, 2, 2, false);
    }
    
    protected Rectangle calculateGripBounds(final Component c, final int x, final int y, final int width, final int height) {
        final Insets insets = super.getBorderInsets(c, new Insets(0, 0, 0, 0));
        final Rectangle r = FlatUIUtils.subtractInsets(new Rectangle(x, y, width, height), insets);
        final int gripSize = UIScale.scale(6);
        if (((JToolBar)c).getOrientation() == 0) {
            if (!c.getComponentOrientation().isLeftToRight()) {
                r.x = r.x + r.width - gripSize;
            }
            r.width = gripSize;
        }
        else {
            r.height = gripSize;
        }
        return r;
    }
    
    @Override
    public Insets getBorderInsets(final Component c, Insets insets) {
        final Insets m = getStyleFromToolBarUI(c, ui -> ui.borderMargins);
        if (m != null) {
            final int t = this.top;
            final int l = this.left;
            final int b = this.bottom;
            final int r = this.right;
            this.top = m.top;
            this.left = m.left;
            this.bottom = m.bottom;
            this.right = m.right;
            insets = super.getBorderInsets(c, insets);
            this.top = t;
            this.left = l;
            this.bottom = b;
            this.right = r;
        }
        else {
            insets = super.getBorderInsets(c, insets);
        }
        if (c instanceof JToolBar && ((JToolBar)c).isFloatable()) {
            final int gripInset = UIScale.scale(6);
            if (((JToolBar)c).getOrientation() == 0) {
                if (c.getComponentOrientation().isLeftToRight()) {
                    final Insets insets2 = insets;
                    insets2.left += gripInset;
                }
                else {
                    final Insets insets3 = insets;
                    insets3.right += gripInset;
                }
            }
            else {
                final Insets insets4 = insets;
                insets4.top += gripInset;
            }
        }
        return insets;
    }
    
    static <T> T getStyleFromToolBarUI(final Component c, final Function<FlatToolBarUI, T> f) {
        if (c instanceof JToolBar) {
            final ToolBarUI ui = ((JToolBar)c).getUI();
            if (ui instanceof FlatToolBarUI) {
                return f.apply((FlatToolBarUI)ui);
            }
        }
        return null;
    }
}
