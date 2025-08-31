// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Z implements ActionListener
{
    final /* synthetic */ X bV;
    private final /* synthetic */ Application bv;
    
    Z(final X bv, final Application bv2) {
        this.bV = bv;
        this.bv = bv2;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gj gj = (gj)this.bV.bG.getSelectedItem();
        if (gj != null) {
            this.bv.a(gj);
        }
    }
}
