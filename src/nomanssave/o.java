// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class o implements ActionListener
{
    final /* synthetic */ h z;
    
    o(final h z) {
        this.z = z;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.z.setVisible(false);
    }
}
