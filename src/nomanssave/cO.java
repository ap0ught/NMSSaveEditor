// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.SwingUtilities;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class cO implements ComboBoxModel
{
    final /* synthetic */ cN gt;
    private final /* synthetic */ Class gu;
    
    cO(final cN gt, final Class gu) {
        this.gt = gt;
        this.gu = gu;
    }
    
    @Override
    public int getSize() {
        return ((Enum[])this.gu.getEnumConstants()).length + this.gt.go.size();
    }
    
    @Override
    public Object getElementAt(final int n) {
        if (n < ((Enum[])this.gu.getEnumConstants()).length) {
            return ((Enum[])this.gu.getEnumConstants())[n];
        }
        return this.gt.go.get(n - ((Enum[])this.gu.getEnumConstants()).length);
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.gt.gq;
        cN.a(this.gt, o);
        if (this.gt.gp != null) {
            SwingUtilities.invokeLater(() -> {
                if (this.gt.gq == null) {
                    if (obj != null) {
                        this.gt.gp.setSelectedValue(null);
                    }
                }
                else if (obj == null || !this.gt.gq.equals(obj)) {
                    if (this.gt.gm) {
                        this.gt.gp.setSelectedValue(((gD)this.gt.gq).K());
                    }
                    else if (this.gt.gq instanceof Enum) {
                        this.gt.gp.setSelectedValue(((Enum)this.gt.gq).name());
                    }
                    else {
                        this.gt.gp.setSelectedValue(this.gt.gq.toString());
                    }
                }
            });
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.gt.gq;
    }
}
