// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.Collections;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class dk implements ComboBoxModel
{
    private gv hk;
    final /* synthetic */ dj hl;
    
    dk(final dj hl) {
        this.hl = hl;
        this.hk = null;
    }
    
    @Override
    public int getSize() {
        return (this.hl.hj == null) ? 0 : this.hl.hj.length;
    }
    
    public gv D(final int n) {
        return this.hl.hj[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.hk = (gv)o;
        if (this.hk == null) {
            this.hl.hb.setText("");
            this.hl.hc.setSelectedIndex(-1);
            this.hl.hd.setSelectedIndex(-1);
            this.hl.he.setText("");
            this.hl.hf.setText("");
            this.hl.hg.setText("");
            this.hl.hh.setText("");
            this.hl.hi.a(Collections.emptyList());
            return;
        }
        this.hl.hb.setText(this.hk.getName());
        this.hl.hc.m(this.hk.cT());
        this.hl.hd.m(this.hk.cW());
        this.hl.he.setText(this.hk.cK());
        this.hl.hf.setText(Double.toString(this.hk.dF()));
        this.hl.hg.setText(Double.toString(this.hk.dG()));
        this.hl.hh.setText(Double.toString(this.hk.dH()));
        this.hl.hi.a(Collections.singletonList(this.hk.dE()));
    }
    
    @Override
    public Object getSelectedItem() {
        return this.hk;
    }
}
