// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class E implements ComboBoxModel
{
    final /* synthetic */ Application aZ;
    
    E(final Application az) {
        this.aZ = az;
    }
    
    @Override
    public int getSize() {
        return this.aZ.aI.length;
    }
    
    public fs n(final int n) {
        return this.aZ.aI[n];
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
            this.aZ.S.hidePopup();
            if (JOptionPane.showConfirmDialog(this.aZ.N, "Are you sure you want to load a different file and lose current changes?", "Save", 2) != 0) {
                return;
            }
            Application.f(this.aZ, false);
        }
        int n = -1;
        synchronized (this.aZ.R) {
            int n2 = 0;
            for (int i = 0; i < this.aZ.aI.length; ++i) {
                if (this.aZ.aI[i] == o) {
                    n = n2;
                    this.aZ.aI[n2++] = this.aZ.aI[i];
                }
                else if (!(this.aZ.aI[i] instanceof F)) {
                    this.aZ.aI[n2++] = this.aZ.aI[i];
                }
            }
            if (n2 < this.aZ.aI.length) {
                final fs[] array = new fs[n2];
                System.arraycopy(this.aZ.aI, 0, array, 0, n2);
                Application.a(this.aZ, array);
            }
            monitorexit(this.aZ.R);
        }
        this.aZ.f(n);
    }
    
    @Override
    public Object getSelectedItem() {
        if (this.aZ.aJ < 0) {
            return null;
        }
        return this.aZ.aI[this.aZ.aJ];
    }
}
