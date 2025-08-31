// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bV implements ActionListener
{
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;
    
    bV(final bS fk, final int fl, final int fm) {
        this.fk = fk;
        this.fl = fl;
        this.fm = fm;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gu f = this.fk.eX.eW.f(this.fl, this.fm);
        if (f != null && f.dA() >= 0 && f.dB() > 0) {
            f.aA(f.dB());
            this.fk.aq();
        }
    }
}
