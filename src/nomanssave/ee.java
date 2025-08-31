// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class ee implements ComboBoxModel
{
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;
    
    ee(final ec ik, final int il) {
        this.ik = ik;
        this.il = il;
    }
    
    @Override
    public int getSize() {
        return eb.ie.length;
    }
    
    public gy H(final int n) {
        return eb.ie[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        final gy gy = (gy)o;
        if (gy != null && !gy.equals(this.ik.ij.ic[this.il].ed())) {
            this.ik.ij.ic[this.il].a(gy);
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.ik.ij.ic[this.il].ed();
    }
}
