// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ListModel;

class de implements ListModel
{
    final /* synthetic */ dd gW;
    
    de(final dd gw) {
        this.gW = gw;
    }
    
    @Override
    public int getSize() {
        return this.gW.gT.size();
    }
    
    public gt w(final int n) {
        return this.gW.gT.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
}
