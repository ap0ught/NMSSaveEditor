// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aT implements ActionListener
{
    final /* synthetic */ aQ dr;
    
    aT(final aQ dr) {
        this.dr = dr;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        aQ.a(this.dr, new Dimension(Integer.parseInt(this.dr.do.getText()), Integer.parseInt(this.dr.dp.getText())));
        this.dr.setVisible(false);
    }
}
