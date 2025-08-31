// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class k implements ComboBoxModel
{
    private ex B;
    final /* synthetic */ h z;
    
    k(final h z) {
        this.z = z;
        this.B = null;
    }
    
    @Override
    public int getSize() {
        return this.z.u.size();
    }
    
    public ex c(final int n) {
        return this.z.u.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.B = (ex)o;
        this.z.c();
    }
    
    @Override
    public Object getSelectedItem() {
        return this.B;
    }
}
