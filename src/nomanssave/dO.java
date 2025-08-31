// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.Collections;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class dO implements ComboBoxModel
{
    private gH hZ;
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;
    
    dO(final dN ia, final Application bv) {
        this.ia = ia;
        this.bv = bv;
        this.hZ = null;
    }
    
    @Override
    public int getSize() {
        return (this.ia.hX == null) ? 0 : this.ia.hX.length;
    }
    
    public gH G(final int n) {
        return this.ia.hX[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.hZ = (gH)o;
        if (this.hZ == null) {
            this.ia.hL.setText("");
            this.ia.hM.setSelectedIndex(-1);
            this.ia.hN.setSelectedIndex(-1);
            this.ia.hO.setText("");
            this.ia.hP.setSelected(false);
            this.ia.hP.setEnabled(false);
            this.ia.bQ.setEnabled(false);
            this.ia.hS.setText("");
            this.ia.hT.setText("");
            this.ia.hU.setText("");
            this.ia.hV.setText("");
            this.ia.hW.a(Collections.emptyList());
            return;
        }
        this.ia.hL.setText(this.hZ.getName());
        this.ia.hM.m(this.hZ.cT());
        this.ia.hN.m(this.hZ.cW());
        this.ia.hO.setText(this.hZ.cK());
        final eV d = this.bv.d("PlayerStateData.ShipUsesLegacyColours");
        this.ia.hP.setSelected(d != null && d.ab(this.hZ.getIndex()));
        this.ia.hP.setEnabled(true);
        this.ia.bQ.setEnabled(true);
        this.ia.hS.setText(Double.toString(this.hZ.dF()));
        this.ia.hT.setText(Double.toString(this.hZ.eb()));
        this.ia.hU.setText(Double.toString(this.hZ.cX()));
        this.ia.hV.setText(Double.toString(this.hZ.ec()));
        this.ia.hW.a(this.hZ.cC());
        this.ia.hQ.setEnabled(false);
        this.ia.hR.setEnabled(false);
        if (this.ia.hY != null) {
            for (int i = 0; i < this.ia.hX.length; ++i) {
                if (this.hZ == this.ia.hX[i] && i == this.ia.hY.dV()) {
                    this.ia.hQ.setEnabled(true);
                    this.ia.hR.setEnabled(true);
                }
            }
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.hZ;
    }
}
