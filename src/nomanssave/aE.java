// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class aE implements ComboBoxModel
{
    aI cA;
    final /* synthetic */ aD cB;
    
    aE(final aD cb) {
        this.cB = cb;
        this.cA = null;
    }
    
    @Override
    public int getSize() {
        return aI.values().length;
    }
    
    public aI t(final int n) {
        return aI.values()[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.cA = (aI)o;
    }
    
    @Override
    public Object getSelectedItem() {
        return this.cA;
    }
}
