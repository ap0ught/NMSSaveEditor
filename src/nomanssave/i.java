// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class i implements ActionListener
{
    final /* synthetic */ h z;
    
    i(final h z) {
        this.z = z;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        h.a(this.z, ey.b(this.z.r, this.z.m.getText()));
        this.z.a();
        if (this.z.s.size() == 0) {
            JOptionPane.showOptionDialog(this.z, "Item not found.", "Warning", 0, 2, null, new Object[] { "OK" }, null);
        }
    }
}
