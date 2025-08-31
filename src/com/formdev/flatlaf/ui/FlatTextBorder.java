// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Component;
import javax.swing.UIManager;

public class FlatTextBorder extends FlatBorder
{
    @FlatStylingSupport.Styleable
    protected int arc;
    @FlatStylingSupport.Styleable
    protected Boolean roundRect;
    
    public FlatTextBorder() {
        this.arc = UIManager.getInt("TextComponent.arc");
    }
    
    @Override
    protected int getArc(final Component c) {
        if (this.isCellEditor(c)) {
            return 0;
        }
        Boolean roundRect = FlatUIUtils.isRoundRect(c);
        if (roundRect == null) {
            roundRect = this.roundRect;
        }
        return (roundRect != null) ? (roundRect ? 32767 : 0) : this.arc;
    }
}
