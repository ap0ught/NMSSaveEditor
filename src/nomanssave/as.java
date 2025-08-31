// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class as implements ActionListener
{
    final /* synthetic */ ap cu;
    
    as(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String[] b = p.b(this.cu);
        boolean b2 = false;
        for (int i = 0; i < b.length; ++i) {
            if (!this.cu.cq.hasValue(b[i])) {
                this.cu.cq.f(b[i]);
                b2 = true;
            }
        }
        if (b2) {
            this.cu.cj.sort();
            this.cu.ci.updateUI();
        }
    }
}
