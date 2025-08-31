// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.UIManager;

public class FlatFileChooserDetailsViewIcon extends FlatAbstractIcon
{
    public FlatFileChooserDetailsViewIcon() {
        super(16, 16, UIManager.getColor("Actions.Grey"));
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        g.fillRoundRect(2, 3, 2, 1, 1, 1);
        g.fillRoundRect(2, 6, 2, 1, 1, 1);
        g.fillRoundRect(2, 9, 2, 1, 1, 1);
        g.fillRoundRect(2, 12, 2, 1, 1, 1);
        g.fillRoundRect(6, 3, 8, 1, 1, 1);
        g.fillRoundRect(6, 6, 8, 1, 1, 1);
        g.fillRoundRect(6, 9, 8, 1, 1, 1);
        g.fillRoundRect(6, 12, 8, 1, 1, 1);
    }
}
