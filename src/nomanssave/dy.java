// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class dy extends MouseAdapter
{
    final /* synthetic */ du hp;
    private final /* synthetic */ gF hq;
    
    dy(final du hp, final gF hq) {
        this.hp = hp;
        this.hq = hq;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2 && this.hq != null) {
            cg.a(this.hp.ho, this.hq);
            this.hp.aM();
        }
    }
}
