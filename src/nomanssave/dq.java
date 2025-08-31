// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dq implements ActionListener
{
    final /* synthetic */ dj hl;
    private final /* synthetic */ Application bv;
    
    dq(final dj hl, final Application bv) {
        this.hl = hl;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectedIndex = this.hl.ha.getSelectedIndex();
        if (selectedIndex < 0 || selectedIndex >= this.hl.hj.length) {
            return;
        }
        if (this.hl.hj.length == 1) {
            this.bv.c("You cannot delete the only multitool you have!");
            return;
        }
        if (JOptionPane.showConfirmDialog(this.hl, "Are you sure you want to delete this multitool?\nAll technology in the multitool will be lost!", "Delete", 2) != 0) {
            return;
        }
        this.bv.h(this.hl.hj[selectedIndex].getIndex());
    }
}
