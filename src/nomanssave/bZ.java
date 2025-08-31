// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bZ implements ActionListener
{
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;
    
    bZ(final bS fk, final int fl, final int fm) {
        this.fk = fk;
        this.fl = fl;
        this.fm = fm;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (!this.fk.eX.eW.dq()) {
            return;
        }
        if (!this.fk.eX.eW.l(this.fl, this.fm)) {
            return;
        }
        this.fk.eX.eW.m(this.fl, this.fm);
        this.fk.aq();
    }
}
