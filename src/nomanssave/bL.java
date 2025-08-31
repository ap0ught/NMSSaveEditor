// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusListener;
import javax.swing.JTextField;

class bL extends JTextField
{
    final bK eB;
    final /* synthetic */ bE ey;
    
    bL(final bE ey, final bK eb, final boolean enabled) {
        this.ey = ey;
        this.eB = eb;
        this.setEnabled(enabled);
        this.addFocusListener(new bM(this, eb));
    }
    
    void ac() {
        String ab;
        if (this.ey.cp == null) {
            ab = "";
        }
        else {
            ab = this.eB.ab();
        }
        this.setText(ab);
    }
}
