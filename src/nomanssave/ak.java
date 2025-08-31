// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ak implements ActionListener
{
    final /* synthetic */ aj cg;
    
    ak(final aj cg) {
        this.cg = cg;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        try {
            aj.a(this.cg, hl.e(this.cg.m.getText().trim(), this.cg.bX.getSelectedIndex()));
            this.cg.P();
        }
        catch (final RuntimeException ex) {
            JOptionPane.showOptionDialog(this.cg, "Invalid address value, please try again.", "Error", 0, 0, null, new Object[] { "Cancel" }, null);
        }
    }
}
