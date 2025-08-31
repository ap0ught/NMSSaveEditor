// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class r implements ActionListener
{
    final /* synthetic */ p I;
    
    r(final p i) {
        this.I = i;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int[] selectedRows = this.I.D.getSelectedRows();
        p.a(this.I, new ArrayList());
        for (int i = 0; i < selectedRows.length; ++i) {
            this.I.G.add(this.I.D.getModel().getValueAt(this.I.D.convertRowIndexToModel(selectedRows[i]), 3));
        }
        this.I.setVisible(false);
    }
}
