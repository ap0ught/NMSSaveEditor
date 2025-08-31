// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dV implements ActionListener
{
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;
    
    dV(final dN ia, final Application bv) {
        this.ia = ia;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gH gh = (gH)this.ia.hK.getSelectedItem();
        if (gh == null) {
            return;
        }
        final eV d = this.bv.d("PlayerStateData.ShipUsesLegacyColours");
        if (d == null) {
            return;
        }
        if (this.ia.hP.isSelected() ^ d.ab(gh.getIndex())) {
            d.a(gh.getIndex(), this.ia.hP.isSelected());
        }
    }
}
