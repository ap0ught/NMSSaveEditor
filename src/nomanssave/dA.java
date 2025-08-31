// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ListModel;

class dA implements ListModel
{
    final /* synthetic */ dz hu;
    
    dA(final dz hu) {
        this.hu = hu;
    }
    
    @Override
    public int getSize() {
        return this.hu.hs.length;
    }
    
    public ft m(final int n) {
        return this.hu.hs[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
}
