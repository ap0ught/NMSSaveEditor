// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dh implements ActionListener
{
    final /* synthetic */ dd gW;
    
    dh(final dd gw) {
        this.gW = gw;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.gW.setVisible(false);
    }
}
