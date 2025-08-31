// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class al implements ComboBoxModel
{
    String ch;
    final /* synthetic */ aj cg;
    
    al(final aj cg) {
        this.cg = cg;
        this.ch = null;
    }
    
    @Override
    public int getSize() {
        return aj.bW.size();
    }
    
    public String s(final int n) {
        return aj.bW.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.ch = (String)o;
    }
    
    @Override
    public Object getSelectedItem() {
        return this.ch;
    }
}
