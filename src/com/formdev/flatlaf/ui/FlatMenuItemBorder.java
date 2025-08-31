// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.MenuBarUI;
import java.awt.Container;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Insets;

public class FlatMenuItemBorder extends FlatMarginBorder
{
    private final Insets menuBarItemMargins;
    
    public FlatMenuItemBorder() {
        this.menuBarItemMargins = UIManager.getInsets("MenuBar.itemMargins");
    }
    
    @Override
    public Insets getBorderInsets(final Component c, final Insets insets) {
        final Container parent = c.getParent();
        if (parent instanceof JMenuBar) {
            final MenuBarUI ui = ((JMenuBar)parent).getUI();
            final Insets margins = (ui instanceof FlatMenuBarUI && ((FlatMenuBarUI)ui).itemMargins != null) ? ((FlatMenuBarUI)ui).itemMargins : this.menuBarItemMargins;
            insets.top = UIScale.scale(margins.top);
            insets.left = UIScale.scale(margins.left);
            insets.bottom = UIScale.scale(margins.bottom);
            insets.right = UIScale.scale(margins.right);
            return insets;
        }
        return super.getBorderInsets(c, insets);
    }
}
