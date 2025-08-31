// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class P implements ActionListener
{
    final /* synthetic */ I bt;
    private final /* synthetic */ Application bv;
    
    P(final I bt, final Application bv) {
        this.bt = bt;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gf gf = (gf)this.bt.bk.getSelectedItem();
        if (gf == null) {
            return;
        }
        final List ci = gf.cI();
        if (ci.size() == 0) {
            this.bv.c("Cannot move base computer.\nPlease ensure that your base has a suitable Signal Booster / Blueprint Analyser / Beacon placed where you want your base computer to be.");
            return;
        }
        final int a;
        if ((a = cY.a(this.bv.g(), ci)) < 0) {
            return;
        }
        final gg gg = ci.get(a);
        hc.info("Attempting to swap base computer with " + gg.toString() + "...");
        if (gf.a(gg)) {
            hc.info("Base computer relocated: " + gf.getName());
        }
        else {
            hc.info("Base computer not moved.");
            this.bv.c("An error occurred while attempting to move base computer.");
        }
    }
}
