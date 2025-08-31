// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dR implements ActionListener
{
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;
    
    dR(final dN ia, final Application bv) {
        this.ia = ia;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectedIndex = this.ia.hK.getSelectedIndex();
        if (selectedIndex < 0 || selectedIndex >= this.ia.hX.length) {
            return;
        }
        this.bv.a(this.ia.hX[selectedIndex]);
    }
}
