// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class at implements ActionListener
{
    final /* synthetic */ ap cu;
    
    at(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int[] selectedRows = this.cu.ci.getSelectedRows();
        boolean b = false;
        for (int i = selectedRows.length - 1; i >= 0; --i) {
            this.cu.cq.ac(this.cu.ci.convertRowIndexToModel(selectedRows[i]));
            b = true;
        }
        if (b) {
            this.cu.ci.clearSelection();
            this.cu.cj.sort();
            this.cu.ci.updateUI();
        }
    }
}
