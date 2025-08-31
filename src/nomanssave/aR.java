// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class aR implements FocusListener
{
    final /* synthetic */ aQ dr;
    
    aR(final aQ dr) {
        this.dr = dr;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        int i;
        try {
            i = Integer.parseInt(this.dr.do.getText());
            if (i != this.dr.dk.width) {
                if (i < this.dr.dl.width) {
                    i = this.dr.dl.width;
                }
                else if (i > this.dr.dm.width && !en.aS()) {
                    i = this.dr.dm.width;
                }
            }
        }
        catch (final RuntimeException ex) {
            i = this.dr.dk.width;
        }
        this.dr.do.setText(Integer.toString(i));
    }
}
