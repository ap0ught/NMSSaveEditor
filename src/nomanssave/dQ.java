// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dQ implements ActionListener
{
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;
    
    dQ(final dN ia, final Application bv) {
        this.ia = ia;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectedIndex = this.ia.hK.getSelectedIndex();
        if (selectedIndex < 0 || selectedIndex >= this.ia.hX.length) {
            return;
        }
        if (this.ia.hX.length == 1) {
            this.bv.c("You cannot delete the only ship you have!");
            return;
        }
        if (JOptionPane.showConfirmDialog(this.ia, "Are you sure you want to delete this ship?\nAll items and technology in the ship inventory will be lost!", "Delete", 2) != 0) {
            return;
        }
        this.bv.i(this.ia.hX[selectedIndex].getIndex());
    }
}
