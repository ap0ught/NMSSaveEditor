// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ed implements ActionListener
{
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;
    
    ed(final ec ik, final int il) {
        this.ik = ik;
        this.il = il;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.ik.if.isSelected() ^ this.ik.ij.ic[this.il].isEnabled()) {
            final boolean selected = this.ik.if.isSelected();
            this.ik.ij.ic[this.il].setEnabled(selected);
            this.ik.ig.setEnabled(selected);
            this.ik.bj.setEnabled(selected);
            this.ik.ih.setEnabled(selected);
            this.ik.hO.setEnabled(selected);
            this.ik.ii.setEnabled(selected);
        }
    }
}
