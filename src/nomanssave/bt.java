// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.EventQueue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class bt implements ListSelectionListener
{
    final /* synthetic */ bl er;
    private final /* synthetic */ Application bv;
    
    bt(final bl er, final Application bv) {
        this.er = er;
        this.bv = bv;
    }
    
    @Override
    public void valueChanged(final ListSelectionEvent listSelectionEvent) {
        EventQueue.invokeLater(new bu(this, this.bv));
    }
}
