// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class az implements ActionListener
{
    final /* synthetic */ ap cu;
    
    az(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final Iterator iterator = eS.by().iterator();
        while (iterator.hasNext()) {
            final gA a = this.cu.cp.a((eS)iterator.next());
            a.a(eU.kr, false);
            a.a(eU.ks, false);
            a.a(eU.kt, false);
            a.a(eU.kv, false);
            a.a(eU.kz, false);
        }
        this.cu.cn.updateUI();
    }
}
