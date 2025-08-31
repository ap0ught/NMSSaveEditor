// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;

class cz extends ComponentAdapter
{
    final /* synthetic */ cy gg;
    
    cz(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public void componentMoved(final ComponentEvent componentEvent) {
        final Point location = this.gg.getBounds().getLocation();
        aH.b("JSONEditor.X", location.x);
        aH.b("JSONEditor.Y", location.y);
    }
    
    @Override
    public void componentResized(final ComponentEvent componentEvent) {
        final Dimension size = this.gg.getBounds().getSize();
        aH.b("JSONEditor.Width", size.width);
        aH.b("JSONEditor.Height", size.height);
    }
}
