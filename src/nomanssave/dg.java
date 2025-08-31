// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dg implements ActionListener
{
    final /* synthetic */ dd gW;
    
    dg(final dd gw) {
        this.gW = gw;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        dd.a(this.gW, this.gW.gS.getSelectedIndex());
        this.gW.setVisible(false);
    }
}
