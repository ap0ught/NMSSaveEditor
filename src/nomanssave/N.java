// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class N implements ActionListener
{
    final /* synthetic */ I bt;
    private final /* synthetic */ Application bv;
    
    N(final I bt, final Application bv) {
        this.bt = bt;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gf gf = (gf)this.bt.bk.getSelectedItem();
        if (gf != null) {
            this.bv.a(gf);
        }
    }
}
