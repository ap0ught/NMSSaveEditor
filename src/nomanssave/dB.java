// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dB implements ActionListener
{
    final /* synthetic */ dz hu;
    
    dB(final dz hu) {
        this.hu = hu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectedIndex = this.hu.hr.getSelectedIndex();
        if (selectedIndex >= 0 && !this.hu.hs[selectedIndex].isEmpty() && JOptionPane.showConfirmDialog(this.hu, "You are about to overwrite this save slot, are you sure you want to do this?", "Warning", 2) != 0) {
            return;
        }
        dz.a(this.hu, selectedIndex);
        this.hu.setVisible(false);
    }
}
