// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class dK implements ComboBoxModel
{
    eM hF;
    final /* synthetic */ dJ hG;
    
    dK(final dJ hg) {
        this.hG = hg;
    }
    
    @Override
    public int getSize() {
        return 1 + eM.getCount();
    }
    
    public eM F(final int n) {
        if (n == 0) {
            return null;
        }
        return eM.S(n - 1);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.hF = (eM)o;
    }
    
    @Override
    public Object getSelectedItem() {
        return this.hF;
    }
}
