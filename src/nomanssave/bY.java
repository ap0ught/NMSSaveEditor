// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bY implements ActionListener
{
    final /* synthetic */ bS fk;
    
    bY(final bS fk) {
        this.fk = fk;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (!this.fk.eX.eW.dp() && !en.aS()) {
            return;
        }
        if (this.fk.eX.eW.dv()) {
            this.fk.eX.af();
        }
    }
}
