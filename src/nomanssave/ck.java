// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class ck extends WindowAdapter
{
    final /* synthetic */ cg fF;
    
    ck(final cg ff) {
        this.fF = ff;
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        this.fF.ft.N();
        this.fF.fv.N();
    }
}
