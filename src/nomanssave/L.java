// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class L implements ComboBoxModel
{
    gf bu;
    final /* synthetic */ I bt;
    
    L(final I bt) {
        this.bt = bt;
        this.bu = null;
    }
    
    @Override
    public int getSize() {
        return (this.bt.br == null) ? 0 : this.bt.br.cE().size();
    }
    
    public gf p(final int n) {
        return (this.bt.br == null) ? null : this.bt.br.cE().get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.bu = (gf)o;
        if (this.bu == null) {
            this.bt.bm.setText("");
            this.bt.bl.setText("");
            this.bt.bl.setEnabled(false);
            this.bt.bn.setEnabled(false);
            this.bt.bo.setEnabled(false);
            this.bt.bp.setEnabled(false);
        }
        else {
            this.bt.bm.setText(Integer.toString(this.bu.cG()));
            this.bt.bl.setText(this.bu.getName());
            this.bt.bl.setEnabled(true);
            this.bt.bn.setEnabled(true);
            this.bt.bo.setEnabled(true);
            this.bt.bp.setEnabled(true);
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.bu;
    }
}
