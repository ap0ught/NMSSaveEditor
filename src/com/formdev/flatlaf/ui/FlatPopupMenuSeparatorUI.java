// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;

public class FlatPopupMenuSeparatorUI extends FlatSeparatorUI
{
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.canUseSharedUI(c) ? FlatUIUtils.createSharedUI((Object)FlatPopupMenuSeparatorUI.class, () -> new FlatPopupMenuSeparatorUI(true)) : new FlatPopupMenuSeparatorUI(false);
    }
    
    protected FlatPopupMenuSeparatorUI(final boolean shared) {
        super(shared);
    }
    
    @Override
    protected String getPropertyPrefix() {
        return "PopupMenuSeparator";
    }
    
    @Override
    String getStyleType() {
        return "PopupMenuSeparator";
    }
}
