// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class cB implements DocumentListener
{
    final /* synthetic */ cy gg;
    
    cB(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public void insertUpdate(final DocumentEvent documentEvent) {
        cy.a(this.gg, true);
    }
    
    @Override
    public void removeUpdate(final DocumentEvent documentEvent) {
        cy.a(this.gg, true);
    }
    
    @Override
    public void changedUpdate(final DocumentEvent documentEvent) {
    }
}
