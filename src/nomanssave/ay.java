// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ay implements ActionListener
{
    final /* synthetic */ ap cu;
    
    ay(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        for (final eS es : eS.by()) {
            final gA a = this.cu.cp.a(es);
            if (es.a(eU.kr)) {
                a.a(eU.kr, true);
            }
            if (es.a(eU.ks)) {
                a.a(eU.ks, true);
            }
            if (es.a(eU.kt)) {
                a.a(eU.kt, true);
            }
            if (es.a(eU.kv)) {
                a.a(eU.kv, true);
            }
            if (es.a(eU.kz)) {
                a.a(eU.kz, true);
            }
        }
        this.cu.cn.updateUI();
    }
}
