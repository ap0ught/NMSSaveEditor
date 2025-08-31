// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import javax.swing.plaf.TreeUI;
import javax.swing.SwingUtilities;
import javax.swing.JTree;
import com.formdev.flatlaf.ui.FlatTreeUI;
import java.util.function.Function;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Component;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.geom.Path2D;

public class FlatTreeCollapsedIcon extends FlatAbstractIcon
{
    private final boolean chevron;
    private Path2D path;
    
    public FlatTreeCollapsedIcon() {
        this(UIManager.getColor("Tree.icon.collapsedColor"));
    }
    
    FlatTreeCollapsedIcon(final Color color) {
        super(11, 11, color);
        this.chevron = FlatUIUtils.isChevron(UIManager.getString("Component.arrowType"));
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        this.setStyleColorFromTreeUI(c, g);
        this.rotate(c, g);
        final String arrowType = getStyleFromTreeUI(c, ui -> ui.iconArrowType);
        final boolean chevron = (arrowType != null) ? FlatUIUtils.isChevron(arrowType) : this.chevron;
        if (chevron) {
            g.setStroke(new BasicStroke(1.0f, 1, 0));
            if (this.path == null) {
                this.path = FlatUIUtils.createPath(false, 3.5, 1.5, 7.5, 5.5, 3.5, 9.5);
            }
            g.draw(this.path);
        }
        else {
            if (this.path == null) {
                this.path = FlatUIUtils.createPath(2.0, 1.0, 2.0, 10.0, 10.0, 5.5);
            }
            g.fill(this.path);
        }
    }
    
    void setStyleColorFromTreeUI(final Component c, final Graphics2D g) {
        setStyleColorFromTreeUI(c, g, ui -> ui.iconCollapsedColor);
    }
    
    void rotate(final Component c, final Graphics2D g) {
        if (!c.getComponentOrientation().isLeftToRight()) {
            g.rotate(Math.toRadians(180.0), this.width / 2.0, this.height / 2.0);
        }
    }
    
    static <T> T getStyleFromTreeUI(final Component c, final Function<FlatTreeUI, T> f) {
        final JTree tree = (JTree)((c instanceof JTree) ? c : ((JTree)SwingUtilities.getAncestorOfClass(JTree.class, c)));
        if (tree != null) {
            final TreeUI ui = tree.getUI();
            if (ui instanceof FlatTreeUI) {
                return f.apply((FlatTreeUI)ui);
            }
        }
        return null;
    }
    
    static void setStyleColorFromTreeUI(final Component c, final Graphics2D g, final Function<FlatTreeUI, Color> f) {
        final Color color = getStyleFromTreeUI(c, f);
        if (color != null) {
            g.setColor(color);
        }
    }
}
