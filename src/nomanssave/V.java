// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class V implements ActionListener
{
    final /* synthetic */ Q bD;
    
    V(final Q bd) {
        this.bD = bd;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.bD.setVisible(false);
    }
}
