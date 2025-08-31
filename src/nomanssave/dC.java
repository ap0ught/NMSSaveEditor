// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dC implements ActionListener
{
    final /* synthetic */ dz hu;
    
    dC(final dz hu) {
        this.hu = hu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.hu.setVisible(false);
    }
}
