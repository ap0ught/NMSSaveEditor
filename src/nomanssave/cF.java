// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class cF extends AbstractAction
{
    final /* synthetic */ cy gg;
    
    cF(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int selectionStart = this.gg.fX.getSelectionStart();
        final int selectionEnd = this.gg.fX.getSelectionEnd();
        aW.a(this.gg, (selectionEnd > selectionStart) ? this.gg.fX.getText().substring(selectionStart, selectionEnd) : null);
    }
}
