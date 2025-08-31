// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dr implements ActionListener
{
    final /* synthetic */ dj hl;
    private final /* synthetic */ Application bv;
    
    dr(final dj hl, final Application bv) {
        this.hl = hl;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectedIndex = this.hl.ha.getSelectedIndex();
        if (selectedIndex < 0 || selectedIndex >= this.hl.hj.length) {
            return;
        }
        this.bv.a(this.hl.hj[selectedIndex]);
    }
}
