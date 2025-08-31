// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;

class bc implements PropertyChangeListener
{
    final /* synthetic */ ba dB;
    private final /* synthetic */ JButton dD;
    private final /* synthetic */ G dC;
    
    bc(final ba db, final JButton dd, final G dc) {
        this.dB = db;
        this.dD = dd;
        this.dC = dc;
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        this.dD.setEnabled(this.dC.isEnabled());
    }
}
