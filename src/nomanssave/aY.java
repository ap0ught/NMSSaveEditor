// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aY implements ActionListener
{
    final /* synthetic */ aW dy;
    
    aY(final aW dy) {
        this.dy = dy;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.dy.setVisible(false);
    }
}
