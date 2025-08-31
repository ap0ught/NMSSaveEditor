// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class di implements ActionListener
{
    final /* synthetic */ dd gW;
    
    di(final dd gw) {
        this.gW = gw;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.gW.setVisible(false);
    }
}
