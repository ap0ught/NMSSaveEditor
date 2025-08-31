// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class B extends WindowAdapter
{
    final /* synthetic */ Application aZ;
    
    B(final Application az) {
        this.aZ = az;
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        if ((this.aZ.aL || this.aZ.aO) && JOptionPane.showConfirmDialog(this.aZ.N, "Save data before closing?", "Save", 0) == 0) {
            if (this.aZ.aL) {
                this.aZ.n();
            }
            if (this.aZ.aO) {
                this.aZ.m();
            }
        }
        if (aH.T()) {
            aH.U();
        }
        this.aZ.N.dispose();
    }
    
    @Override
    public void windowDeactivated(final WindowEvent windowEvent) {
        Application.e(this.aZ, true);
    }
    
    @Override
    public void windowActivated(final WindowEvent windowEvent) {
        Application.e(this.aZ, false);
        this.aZ.f();
    }
}
