// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bj implements ActionListener
{
    final /* synthetic */ bd dP;
    private final /* synthetic */ Application bv;
    
    bj(final bd dp, final Application bv) {
        this.dP = dp;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.dP.dO == null) {
            return;
        }
        this.bv.a(this.dP.dO);
    }
}
