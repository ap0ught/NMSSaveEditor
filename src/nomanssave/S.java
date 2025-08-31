// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class S implements FocusListener
{
    final /* synthetic */ Q bD;
    
    S(final Q bd) {
        this.bD = bd;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        int i;
        try {
            i = Integer.parseInt(this.bD.bB.getText());
            if (i < this.bD.by) {
                i = this.bD.by;
            }
        }
        catch (final RuntimeException ex) {
            i = this.bD.bw.bF;
        }
        this.bD.bB.setText(Integer.toString(i));
    }
}
