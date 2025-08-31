// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class cD implements PropertyChangeListener
{
    final /* synthetic */ cy gg;
    
    cD(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        aH.b("JSONEditor.Divider", (int)propertyChangeEvent.getNewValue());
    }
}
