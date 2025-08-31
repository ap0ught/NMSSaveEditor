// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class bw implements ComboBoxModel
{
    gr et;
    final /* synthetic */ bl er;
    
    bw(final bl er) {
        this.er = er;
    }
    
    @Override
    public int getSize() {
        return gr.values().length;
    }
    
    public gr u(final int n) {
        return gr.values()[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.et = (gr)o;
        bl.a(this.er, (er[])((this.er.eq < 0) ? null : nomanssave.er.a(this.et)));
        bl.b(this.er, (er[])((this.er.eq < 0) ? null : nomanssave.er.b(this.et)));
        if (this.er.eq >= 0 && this.et != null && !this.et.equals(this.er.ep[this.er.eq].da())) {
            this.er.ep[this.er.eq].c(this.et);
            if (this.er.en != null && this.er.en.length > 0) {
                this.er.ep[this.er.eq].a(0, this.er.en[0]);
                this.er.ec.setSelectedItem(this.er.en[0]);
            }
            else {
                this.er.ec.setSelectedItem(null);
            }
            this.er.ed.setSelectedItem(null);
            this.er.ee.setSelectedItem(null);
            this.er.ef.setSelectedItem(null);
            this.er.eg.setSelectedItem(null);
        }
        this.er.dR.updateUI();
        this.er.ec.updateUI();
        this.er.ed.updateUI();
        this.er.ee.updateUI();
        this.er.ef.updateUI();
        this.er.eg.updateUI();
    }
    
    @Override
    public Object getSelectedItem() {
        return this.et;
    }
}
