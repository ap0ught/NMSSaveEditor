// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class J implements ComboBoxModel
{
    gh bs;
    final /* synthetic */ I bt;
    
    J(final I bt) {
        this.bt = bt;
        this.bs = null;
    }
    
    @Override
    public int getSize() {
        return (this.bt.br == null) ? 0 : this.bt.br.cD().size();
    }
    
    public gh o(final int n) {
        return (this.bt.br == null) ? null : this.bt.br.cD().get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.bs = (gh)o;
        if (this.bs == null) {
            this.bt.bi.setText("");
            this.bt.bj.setText("");
            this.bt.bj.setEnabled(false);
        }
        else {
            final gy cj = this.bs.cJ();
            this.bt.bi.setText((cj == null) ? "" : cj.toString());
            this.bt.bj.setText(this.bs.cK());
            this.bt.bj.setEnabled(true);
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.bs;
    }
}
