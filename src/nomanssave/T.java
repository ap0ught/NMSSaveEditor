// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class T implements ActionListener
{
    final /* synthetic */ Q bD;
    
    T(final Q bd) {
        this.bD = bd;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        Q.a(this.bD, new W(Integer.parseInt(this.bD.bA.getText()), Integer.parseInt(this.bD.bB.getText())));
        this.bD.setVisible(false);
    }
}
