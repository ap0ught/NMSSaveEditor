// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class D implements ComboBoxModel
{
    final /* synthetic */ Application aZ;
    
    D(final Application az) {
        this.aZ = az;
    }
    
    @Override
    public int getSize() {
        return this.aZ.aG.length;
    }
    
    public ft m(final int n) {
        return this.aZ.aG[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        if (this.aZ.aL) {
            this.aZ.R.hidePopup();
            final int showConfirmDialog = JOptionPane.showConfirmDialog(this.aZ.N, "Save data before switching slots?", "Save", 1);
            if (showConfirmDialog == 0) {
                this.aZ.n();
            }
            else {
                if (showConfirmDialog == 2) {
                    return;
                }
                Application.f(this.aZ, false);
            }
        }
        int n = -1;
        synchronized (this.aZ.R) {
            for (int i = 0; i < this.aZ.aG.length; ++i) {
                if (this.aZ.aG[i] == o) {
                    n = i;
                    break;
                }
            }
            monitorexit(this.aZ.R);
        }
        this.aZ.e(n);
    }
    
    @Override
    public Object getSelectedItem() {
        return (this.aZ.aH < 0) ? null : this.aZ.aG[this.aZ.aH];
    }
}
