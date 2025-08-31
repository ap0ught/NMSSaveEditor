// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bR implements ActionListener
{
    final /* synthetic */ bO eX;
    
    bR(final bO ex) {
        this.eX = ex;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.eX.eW != null) {
            final Dimension a = aQ.a(this.eX, this.eX.eW.getSize(), this.eX.eW.dm(), this.eX.eW.dn());
            if (a != null && this.eX.eW.a(a)) {
                this.eX.af();
            }
        }
    }
}
