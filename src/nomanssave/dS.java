// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dS implements ActionListener
{
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;
    
    dS(final dN ia, final Application bv) {
        this.ia = ia;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gH h = this.bv.h();
        if (h != null) {
            final gH[] array = new gH[this.ia.hX.length + 1];
            int length = -1;
            for (int i = 0; i < this.ia.hX.length; ++i) {
                if (this.ia.hX[i].getIndex() < h.getIndex()) {
                    array[i] = this.ia.hX[i];
                }
                else {
                    array[i + 1] = this.ia.hX[i];
                    if (length < 0) {
                        length = i;
                    }
                }
            }
            if (length < 0) {
                length = this.ia.hX.length;
            }
            array[length] = h;
            dN.a(this.ia, array);
            hc.info("Imported ship: " + h.getIndex());
            this.ia.hK.setSelectedIndex(length);
            this.ia.hK.updateUI();
        }
    }
}
