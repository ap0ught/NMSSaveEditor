// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dx implements ActionListener
{
    final /* synthetic */ du hp;
    private final /* synthetic */ gF hq;
    
    dx(final du hp, final gF hq) {
        this.hp = hp;
        this.hq = hq;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.hq != null) {
            this.hp.ho.b(this.hp);
        }
    }
}
