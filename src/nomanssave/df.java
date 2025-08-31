// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class df extends MouseAdapter
{
    final /* synthetic */ dd gW;
    
    df(final dd gw) {
        this.gW = gw;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            dd.a(this.gW, this.gW.gS.getSelectedIndex());
            this.gW.setVisible(false);
        }
    }
}
