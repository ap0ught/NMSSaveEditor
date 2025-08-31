// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class am implements ActionListener
{
    final /* synthetic */ aj cg;
    
    am(final aj cg) {
        this.cg = cg;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.cg.bX.getSelectedIndex() < 0) {
            JOptionPane.showOptionDialog(this.cg, "Invalid galaxy selected, please try again.", "Error", 0, 0, null, new Object[] { "Cancel" }, null);
            return;
        }
        if (JOptionPane.showOptionDialog(this.cg, "This will warp your character and ship to the specified system (not the portal itself).", "Confirm", 2, 1, null, new String[] { "OK", "Cancel" }, null) == 0) {
            aj.a(this.cg, true);
            this.cg.setVisible(false);
        }
    }
}
