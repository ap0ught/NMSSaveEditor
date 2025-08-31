// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bW implements ActionListener
{
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;
    
    bW(final bS fk, final int fl, final int fm) {
        this.fk = fk;
        this.fl = fl;
        this.fm = fm;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.fk.eX.eW.g(this.fl, this.fm)) {
            this.fk.eX.eW.g(this.fl, this.fm);
            this.fk.aq();
        }
    }
}
