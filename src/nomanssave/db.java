// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class db implements ActionListener
{
    final /* synthetic */ cY gR;
    
    db(final cY gr) {
        this.gR = gr;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.gR.setVisible(false);
    }
}
