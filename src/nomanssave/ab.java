// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class ab implements ComboBoxModel
{
    final /* synthetic */ X bV;
    
    ab(final X bv) {
        this.bV = bv;
    }
    
    @Override
    public int getSize() {
        return gl.values().length;
    }
    
    public gl r(final int n) {
        return gl.values()[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
    }
    
    @Override
    public Object getSelectedItem() {
        return gl.oF;
    }
}
