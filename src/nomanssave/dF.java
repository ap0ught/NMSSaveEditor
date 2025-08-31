// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class dF implements ComboBoxModel
{
    private gE hD;
    final /* synthetic */ dE hE;
    
    dF(final dE he) {
        this.hE = he;
        this.hD = null;
    }
    
    @Override
    public int getSize() {
        return (this.hE.hC == null) ? 0 : this.hE.hC.length;
    }
    
    public gE E(final int n) {
        return this.hE.hC[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.hD = (gE)o;
        if (this.hD == null) {
            this.hE.hy.setText("");
            this.hE.hz.setText("");
            for (int i = 0; i < this.hE.ea.length; ++i) {
                this.hE.ea[i].setText("");
            }
            this.hE.hB.a(new gF[0]);
        }
        else {
            this.hE.hy.setText(this.hD.getName());
            this.hE.hz.setText(this.hD.cK());
            for (int j = 0; j < this.hE.ea.length; ++j) {
                this.hE.ea[j].setText(Integer.toString(this.hD.aq(j)));
            }
            this.hE.hB.a(this.hD.dX());
        }
        this.hE.hA.revalidate();
    }
    
    @Override
    public Object getSelectedItem() {
        return this.hD;
    }
}
