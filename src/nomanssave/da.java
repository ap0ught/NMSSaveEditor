// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class da implements ActionListener
{
    final /* synthetic */ cY gR;
    
    da(final cY gr) {
        this.gR = gr;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        cY.a(this.gR, this.gR.gM.getSelectedIndex());
        this.gR.setVisible(false);
    }
}
