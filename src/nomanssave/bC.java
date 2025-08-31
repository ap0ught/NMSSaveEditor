// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class bC implements ComboBoxModel
{
    final int ev;
    er eu;
    final /* synthetic */ bl er;
    
    bC(final bl er, final int ev) {
        this.er = er;
        this.ev = ev;
    }
    
    @Override
    public int getSize() {
        return 1 + ((this.er.eo == null) ? 0 : this.er.eo.length);
    }
    
    public er v(final int n) {
        if (n == 0) {
            return null;
        }
        return (this.er.eo == null) ? null : this.er.eo[n - 1];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.eu = (er)o;
        if (this.er.eq >= 0) {
            final er ar = this.er.ep[this.er.eq].ar(this.ev);
            if (this.eu != ar) {
                if (ar != null) {
                    final int ordinal = ar.aU().ordinal();
                    int i = this.er.ep[this.er.eq].aq(ordinal) - ar.aV();
                    if (i < 0) {
                        i = 0;
                    }
                    this.er.ep[this.er.eq].e(ordinal, i);
                    this.er.ea[ordinal].setText(Integer.toString(i));
                }
                if (this.eu == null) {
                    this.er.ep[this.er.eq].a(this.ev, null);
                }
                else {
                    this.er.ep[this.er.eq].a(this.ev, this.eu);
                    final int ordinal2 = this.eu.aU().ordinal();
                    int j = this.er.ep[this.er.eq].aq(ordinal2) + this.eu.aV();
                    if (j < 0) {
                        j = 0;
                    }
                    this.er.ep[this.er.eq].e(ordinal2, j);
                    this.er.ea[ordinal2].setText(Integer.toString(j));
                }
                this.er.dR.updateUI();
            }
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.eu;
    }
}
