// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;

class A implements Runnable
{
    final /* synthetic */ Application aZ;
    private final /* synthetic */ String bc;
    
    A(final Application az, final String bc) {
        this.aZ = az;
        this.bc = bc;
    }
    
    @Override
    public void run() {
        JOptionPane.showOptionDialog(this.aZ.N, this.bc, "Warning", 0, 2, null, new Object[] { "OK" }, null);
    }
}
