// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ai implements ActionListener
{
    final /* synthetic */ X bV;
    private final /* synthetic */ Application bv;
    
    ai(final X bv, final Application bv2) {
        this.bV = bv;
        this.bv = bv2;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectedIndex = this.bV.bG.getSelectedIndex();
        if (selectedIndex < 0 || selectedIndex >= this.bV.bT.length) {
            return;
        }
        if (JOptionPane.showConfirmDialog(this.bV, "Are you sure you want to delete this companion?", "Delete", 2) != 0) {
            return;
        }
        this.bv.a(this.bV.bT[selectedIndex].cL(), this.bV.bT[selectedIndex].getIndex());
    }
}
