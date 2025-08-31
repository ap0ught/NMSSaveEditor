// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bm implements ActionListener
{
    final /* synthetic */ bl er;
    private final /* synthetic */ Application bv;
    
    bm(final bl er, final Application bv) {
        this.er = er;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.er.eq < 0) {
            return;
        }
        if (JOptionPane.showConfirmDialog(this.er, "Are you sure you want to delete this frigate?", "Delete", 2) != 0) {
            return;
        }
        bl.a(this.er, this.bv.k(this.er.ep[this.er.eq].getIndex()));
        if (this.er.ep.length > 0) {
            this.er.dR.setRowSelectionInterval(0, 0);
        }
        else {
            this.er.dR.clearSelection();
        }
        this.er.dR.updateUI();
    }
}
