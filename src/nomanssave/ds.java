// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ds implements ActionListener
{
    final /* synthetic */ dj hl;
    private final /* synthetic */ Application bv;
    
    ds(final dj hl, final Application bv) {
        this.hl = hl;
        this.bv = bv;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final gv i = this.bv.i();
        if (i != null) {
            final gv[] array = new gv[this.hl.hj.length + 1];
            int length = -1;
            for (int j = 0; j < this.hl.hj.length; ++j) {
                if (this.hl.hj[j].getIndex() < i.getIndex()) {
                    array[j] = this.hl.hj[j];
                }
                else {
                    array[j + 1] = this.hl.hj[j];
                    if (length < 0) {
                        length = j;
                    }
                }
            }
            if (length < 0) {
                length = this.hl.hj.length;
            }
            array[length] = i;
            dj.a(this.hl, array);
            this.hl.ha.setSelectedIndex(length);
            this.hl.ha.updateUI();
        }
    }
}
