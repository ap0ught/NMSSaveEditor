// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class br implements ActionListener
{
    final /* synthetic */ bl er;
    private final /* synthetic */ Application bv;
    
    br(final bl er, final Application bv) {
        this.er = er;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.er.eq < 0) {
            return;
        }
        bl.a(this.er, this.bv.a(this.er.ep[this.er.eq].getIndex(), hg.eo().toString()));
        this.er.dS.setEnabled(this.er.ep.length < 30 || en.aS());
        this.er.dR.updateUI();
    }
}
