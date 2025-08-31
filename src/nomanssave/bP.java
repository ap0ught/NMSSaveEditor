// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class bP implements ComboBoxModel
{
    final /* synthetic */ bO eX;
    
    bP(final bO ex) {
        this.eX = ex;
    }
    
    @Override
    public int getSize() {
        return this.eX.eV.size();
    }
    
    public gt w(final int n) {
        return this.eX.eV.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        bO.a(this.eX, (gt)o);
        this.eX.eU.setVisible(this.eX.eW != null && (en.aS() || this.eX.eW.dk()));
        this.eX.af();
    }
    
    @Override
    public Object getSelectedItem() {
        return this.eX.eW;
    }
}
