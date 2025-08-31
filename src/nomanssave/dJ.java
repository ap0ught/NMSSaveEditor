// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ListCellRenderer;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

class dJ extends JComboBox
{
    final /* synthetic */ dE hE;
    
    dJ(final dE he) {
        this.hE = he;
        this.setModel(new dK(this));
        this.setRenderer(new dL(this));
    }
}
