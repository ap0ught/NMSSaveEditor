// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class H implements FocusListener
{
    final /* synthetic */ G bg;
    
    H(final G bg) {
        this.bg = bg;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        this.bg.N();
    }
}
