// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class an implements ActionListener
{
    final /* synthetic */ aj cg;
    
    an(final aj cg) {
        this.cg = cg;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.cg.setVisible(false);
    }
}
