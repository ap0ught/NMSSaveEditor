// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;

public class FlatCheckBoxUI extends FlatRadioButtonUI
{
    public static ComponentUI createUI(final JComponent c) {
        return (FlatUIUtils.canUseSharedUI(c) && !FlatUIUtils.needsLightAWTPeer(c)) ? FlatUIUtils.createSharedUI((Object)FlatCheckBoxUI.class, () -> new FlatCheckBoxUI(true)) : new FlatCheckBoxUI(false);
    }
    
    protected FlatCheckBoxUI(final boolean shared) {
        super(shared);
    }
    
    public String getPropertyPrefix() {
        return "CheckBox.";
    }
    
    @Override
    String getStyleType() {
        return "CheckBox";
    }
}
