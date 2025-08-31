// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aX implements ActionListener
{
    final /* synthetic */ aW dy;
    private final /* synthetic */ cy dz;
    
    aX(final aW dy, final cy dz) {
        this.dy = dy;
        this.dz = dz;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String text = this.dy.ds.getText();
        if (text.length() > 0) {
            this.dz.a(text, this.dy.dw.isSelected(), this.dy.dt.isSelected(), this.dy.du.isSelected());
        }
    }
}
