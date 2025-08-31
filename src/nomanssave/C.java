// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;

class C extends ComponentAdapter
{
    final /* synthetic */ Application aZ;
    
    C(final Application az) {
        this.aZ = az;
    }
    
    @Override
    public void componentMoved(final ComponentEvent componentEvent) {
        final Point location = this.aZ.N.getBounds().getLocation();
        aH.b("MainFrame.X", location.x);
        aH.b("MainFrame.Y", location.y);
    }
    
    @Override
    public void componentResized(final ComponentEvent componentEvent) {
        final Dimension size = this.aZ.N.getBounds().getSize();
        aH.b("MainFrame.Width", size.width);
        aH.b("MainFrame.Height", size.height);
    }
}
