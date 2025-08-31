// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class m implements ActionListener
{
    final /* synthetic */ h z;
    
    m(final h z) {
        this.z = z;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        h.a(this.z, (ey)this.z.q.getSelectedItem());
        this.z.setVisible(false);
    }
}
