// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class bM implements FocusListener
{
    final /* synthetic */ bL eC;
    private final /* synthetic */ bK eD;
    
    bM(final bL ec, final bK ed) {
        this.eC = ec;
        this.eD = ed;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        if (this.eC.ey.cp == null) {
            return;
        }
        final JTextField textField = (JTextField)focusEvent.getComponent();
        final String ab = this.eD.ab();
        final String text = textField.getText();
        if (!text.equals(ab)) {
            try {
                this.eD.l(text);
            }
            catch (final RuntimeException ex) {
                textField.setText(ab);
            }
        }
    }
}
