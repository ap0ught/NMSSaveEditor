// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aw implements ActionListener
{
    final /* synthetic */ ap cu;
    
    aw(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int[] selectedRows = this.cu.ck.getSelectedRows();
        boolean b = false;
        for (int i = selectedRows.length - 1; i >= 0; --i) {
            final int convertRowIndexToModel = this.cu.ck.convertRowIndexToModel(selectedRows[i]);
            final String s = this.cu.ct.get(convertRowIndexToModel);
            this.cu.ct.remove(convertRowIndexToModel);
            int index;
            while ((index = this.cu.cs.indexOf(s)) >= 0) {
                this.cu.cs.ac(index);
            }
            int index2;
            while ((index2 = this.cu.cr.indexOf(s)) >= 0) {
                this.cu.cr.ac(index2);
            }
            b = true;
        }
        if (b) {
            this.cu.ck.clearSelection();
            this.cu.cl.sort();
            this.cu.ck.updateUI();
        }
    }
}
