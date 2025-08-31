// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bT implements ActionListener
{
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;
    
    bT(final bS fk, final int fl, final int fm) {
        this.fk = fk;
        this.fl = fl;
        this.fm = fm;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (!this.fk.eX.eW.dp() && !en.aS()) {
            return;
        }
        if (this.fk.eY.isSelected()) {
            this.fk.eX.eW.i(this.fl, this.fm);
        }
        else {
            if (this.fk.eX.eW.f(this.fl, this.fm) != null) {
                this.fk.eY.setSelected(true);
                this.fk.eX.eR.c("Cannot disable slots that are in use!");
                return;
            }
            this.fk.eX.eW.j(this.fl, this.fm);
        }
        this.fk.aq();
    }
}
