// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;

class z implements Runnable
{
    final /* synthetic */ Application aZ;
    private final /* synthetic */ String bc;
    
    z(final Application az, final String bc) {
        this.aZ = az;
        this.bc = bc;
    }
    
    @Override
    public void run() {
        JOptionPane.showOptionDialog(this.aZ.N, this.bc, "Error", 0, 0, null, new Object[] { "Cancel" }, null);
    }
}
