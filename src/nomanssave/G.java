// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.FocusListener;
import javax.swing.JTextField;

public abstract class G extends JTextField
{
    public G() {
        this.addFocusListener(new H(this));
    }
    
    public void N() {
        this.setText(this.g(this.getText()));
    }
    
    public void f(final String s) {
        this.setText(this.g(s));
    }
    
    protected abstract String g(final String p0);
}
