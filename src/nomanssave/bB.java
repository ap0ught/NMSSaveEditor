// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class bB implements ComboBoxModel
{
    er eu;
    final /* synthetic */ bl er;
    
    private bB(final bl er) {
        this.er = er;
    }
    
    @Override
    public int getSize() {
        return (this.er.en == null) ? 0 : this.er.en.length;
    }
    
    public er v(final int n) {
        return (this.er.en == null) ? null : this.er.en[n];
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
            final er ar = this.er.ep[this.er.eq].ar(0);
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
                    this.er.ep[this.er.eq].a(0, null);
                }
                else {
                    this.er.ep[this.er.eq].a(0, this.eu);
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
