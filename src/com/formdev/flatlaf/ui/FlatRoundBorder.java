// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.SpinnerUI;
import javax.swing.JSpinner;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.UIManager;

public class FlatRoundBorder extends FlatBorder
{
    @FlatStylingSupport.Styleable
    protected int arc;
    @FlatStylingSupport.Styleable
    protected Boolean roundRect;
    
    public FlatRoundBorder() {
        this.arc = UIManager.getInt("Component.arc");
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, int x, final int y, int width, final int height) {
        if (this.isMacStyleSpinner(c)) {
            final int macStyleButtonsWidth = ((FlatSpinnerUI)((JSpinner)c).getUI()).getMacStyleButtonsWidth();
            width -= macStyleButtonsWidth;
            if (!c.getComponentOrientation().isLeftToRight()) {
                x += macStyleButtonsWidth;
            }
        }
        super.paintBorder(c, g, x, y, width, height);
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
        return (roundRect != null) ? (roundRect ? 32767 : 0) : (this.isMacStyleSpinner(c) ? 0 : this.arc);
    }
    
    private boolean isMacStyleSpinner(final Component c) {
        if (c instanceof JSpinner) {
            final SpinnerUI ui = ((JSpinner)c).getUI();
            if (ui instanceof FlatSpinnerUI) {
                return ((FlatSpinnerUI)ui).isMacStyle();
            }
        }
        return false;
    }
}
