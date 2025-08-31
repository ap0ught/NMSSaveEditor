// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ah implements ActionListener
{
    final /* synthetic */ X bV;
    
    ah(final X bv) {
        this.bV = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gj gj = (gj)this.bV.bG.getSelectedItem();
        if (gj == null) {
            return;
        }
        if (this.bV.bN.isSelected() ^ gj.cQ()) {
            gj.d(this.bV.bN.isSelected());
        }
    }
}
