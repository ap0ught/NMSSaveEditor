// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ce implements ActionListener
{
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;
    
    ce(final bS fk, final int fl, final int fm) {
        this.fk = fk;
        this.fl = fl;
        this.fm = fm;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.fk.eX.eW.f(this.fl, this.fm) == null) {
            this.fk.eX.a(this.fk);
        }
    }
}
