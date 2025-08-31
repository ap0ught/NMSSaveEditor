// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aU implements ActionListener
{
    final /* synthetic */ aQ dr;
    
    aU(final aQ dr) {
        this.dr = dr;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.dr.setVisible(false);
    }
}
