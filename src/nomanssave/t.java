// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class t implements ActionListener
{
    final /* synthetic */ p I;
    
    t(final p i) {
        this.I = i;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.I.setVisible(false);
    }
}
