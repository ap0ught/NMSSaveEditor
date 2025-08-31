// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dc implements ActionListener
{
    final /* synthetic */ cY gR;
    
    dc(final cY gr) {
        this.gR = gr;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.gR.setVisible(false);
    }
}
