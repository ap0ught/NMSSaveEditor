// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.Collections;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class eq implements ComboBoxModel
{
    private gO iz;
    final /* synthetic */ ep iA;
    
    eq(final ep ia) {
        this.iA = ia;
        this.iz = null;
    }
    
    @Override
    public int getSize() {
        return (this.iA.iy == null) ? 0 : this.iA.iy.length;
    }
    
    public gO J(final int n) {
        return this.iA.iy[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.iz = (gO)o;
        if (this.iz == null) {
            this.iA.ix.a(Collections.emptyList());
            return;
        }
        this.iA.ix.a(this.iz.cC());
    }
    
    @Override
    public Object getSelectedItem() {
        return this.iz;
    }
}
