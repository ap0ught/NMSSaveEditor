// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class U implements ActionListener
{
    final /* synthetic */ Q bD;
    
    U(final Q bd) {
        this.bD = bd;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.bD.setVisible(false);
    }
}
