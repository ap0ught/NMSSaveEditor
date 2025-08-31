// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class eg implements ComboBoxModel
{
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;
    
    eg(final ec ik, final int il) {
        this.ik = ik;
        this.il = il;
    }
    
    @Override
    public int getSize() {
        return gL.values().length;
    }
    
    public gL I(final int n) {
        return gL.values()[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        final gL gl = (gL)o;
        if (gl != null && !gl.equals(this.ik.ij.ic[this.il].ef())) {
            this.ik.ij.ic[this.il].a(gl);
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.ik.ij.ic[this.il].ef();
    }
}
