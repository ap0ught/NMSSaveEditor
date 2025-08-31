// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class R implements FocusListener
{
    final /* synthetic */ Q bD;
    
    R(final Q bd) {
        this.bD = bd;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        int i;
        try {
            i = Integer.parseInt(this.bD.bA.getText());
            if (i % 250 != 0) {
                i = (int)Math.round(i / 250.0);
            }
            if (i < this.bD.bx) {
                i = this.bD.bx;
            }
        }
        catch (final RuntimeException ex) {
            i = this.bD.bw.bE;
        }
        this.bD.bA.setText(Integer.toString(i));
    }
}
