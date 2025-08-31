// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class l implements ComboBoxModel
{
    private ey C;
    final /* synthetic */ h z;
    
    l(final h z) {
        this.z = z;
        this.C = null;
    }
    
    @Override
    public int getSize() {
        return this.z.v.size();
    }
    
    public ey d(final int n) {
        return this.z.v.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.C = (ey)o;
    }
    
    @Override
    public Object getSelectedItem() {
        return this.C;
    }
}
