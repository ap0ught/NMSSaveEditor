// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aG implements ActionListener
{
    final /* synthetic */ aD cB;
    
    aG(final aD cb) {
        this.cB = cb;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.cB.setVisible(false);
    }
}
