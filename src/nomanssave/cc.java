// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cc implements ActionListener
{
    final /* synthetic */ bS fk;
    
    cc(final bS fk) {
        this.fk = fk;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.fk.eX.eW.dr()) {
            this.fk.eX.af();
        }
    }
}
