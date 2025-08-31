// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bb implements ActionListener
{
    final /* synthetic */ ba dB;
    private final /* synthetic */ G dC;
    
    bb(final ba db, final G dc) {
        this.dB = db;
        this.dC = dc;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.dC.f(hg.eo().toString());
    }
}
