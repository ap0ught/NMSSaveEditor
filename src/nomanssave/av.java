// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class av implements ActionListener
{
    final /* synthetic */ ap cu;
    
    av(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String[] c = p.c(this.cu);
        boolean b = false;
        for (int i = 0; i < c.length; ++i) {
            final ey d = ey.d(c[i]);
            if (!this.cu.ct.contains(c[i])) {
                if (d.be()) {
                    this.cu.cs.f(c[i]);
                }
                if (d.bd()) {
                    this.cu.cr.f(c[i]);
                }
                this.cu.ct.add(c[i]);
                b = true;
            }
        }
        if (b) {
            this.cu.cl.sort();
            this.cu.ck.updateUI();
        }
    }
}
