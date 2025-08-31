// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class j implements ComboBoxModel
{
    private eB A;
    final /* synthetic */ h z;
    
    j(final h z) {
        this.z = z;
        this.A = null;
    }
    
    @Override
    public int getSize() {
        return this.z.t.size();
    }
    
    public eB b(final int n) {
        return this.z.t.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.A = (eB)o;
        this.z.b();
    }
    
    @Override
    public Object getSelectedItem() {
        return this.A;
    }
}
