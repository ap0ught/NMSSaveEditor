// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bz implements ActionListener
{
    final /* synthetic */ bl er;
    
    bz(final bl er) {
        this.er = er;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.er.eq < 0) {
            return;
        }
        hc.info("Repairing frigate damage");
        this.er.ep[this.er.eq].aw(0);
        this.er.ep[this.er.eq].ax(0);
        this.er.el.setText("");
        this.er.em.setVisible(false);
    }
}
