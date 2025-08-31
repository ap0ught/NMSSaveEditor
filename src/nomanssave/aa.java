// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aa implements ActionListener
{
    final /* synthetic */ X bV;
    private final /* synthetic */ Application bv;
    
    aa(final X bv, final Application bv2) {
        this.bV = bv;
        this.bv = bv2;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gj j = this.bv.j();
        if (j != null) {
            int length = -1;
            final gj[] array = new gj[this.bV.bT.length + 1];
            for (int i = 0; i < this.bV.bT.length; ++i) {
                if (this.bV.bT[i].getIndex() < j.getIndex()) {
                    array[i] = this.bV.bT[i];
                }
                else {
                    array[i + 1] = this.bV.bT[i];
                    if (length < 0) {
                        length = i;
                    }
                }
            }
            if (length < 0) {
                length = this.bV.bT.length;
            }
            array[length] = j;
            X.a(this.bV, array);
            hc.info("Imported " + j.cL().name().toLowerCase() + ": " + j.getIndex());
            this.bV.bG.setSelectedIndex(length);
            this.bV.bG.updateUI();
        }
    }
}
