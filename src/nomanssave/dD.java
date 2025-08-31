// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dD implements ActionListener
{
    final /* synthetic */ dz hu;
    
    dD(final dz hu) {
        this.hu = hu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.hu.setVisible(false);
    }
}
