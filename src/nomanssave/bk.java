// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bk implements ActionListener
{
    final /* synthetic */ bd dP;
    private final /* synthetic */ Application bv;
    
    bk(final bd dp, final Application bv) {
        this.dP = dp;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.dP.dO == null) {
            return;
        }
        this.bv.b(this.dP.dO);
    }
}
