// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class aS implements FocusListener
{
    final /* synthetic */ aQ dr;
    
    aS(final aQ dr) {
        this.dr = dr;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        int i;
        try {
            i = Integer.parseInt(this.dr.dp.getText());
            if (i != this.dr.dk.height) {
                if (i < this.dr.dl.height) {
                    i = this.dr.dl.height;
                }
                else if (i > this.dr.dm.height && !en.aS()) {
                    i = this.dr.dm.height;
                }
            }
        }
        catch (final RuntimeException ex) {
            i = this.dr.dk.height;
        }
        this.dr.dp.setText(Integer.toString(i));
    }
}
