// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ca implements ActionListener
{
    final /* synthetic */ bS fk;
    
    ca(final bS fk) {
        this.fk = fk;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (!this.fk.eX.eW.dq()) {
            return;
        }
        if (this.fk.eX.eW.ds()) {
            this.fk.eX.af();
        }
    }
}
