// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class cZ implements ComboBoxModel
{
    private gg gQ;
    final /* synthetic */ cY gR;
    
    cZ(final cY gr) {
        this.gR = gr;
        this.gQ = null;
    }
    
    @Override
    public int getSize() {
        return this.gR.gN.size();
    }
    
    public gg C(final int n) {
        return this.gR.gN.get(n);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.gQ = (gg)o;
    }
    
    @Override
    public Object getSelectedItem() {
        return this.gQ;
    }
}
