// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

class bQ extends DefaultListCellRenderer
{
    final /* synthetic */ bO eX;
    
    bQ(final bO ex) {
        this.eX = ex;
    }
    
    @Override
    public Component getListCellRendererComponent(final JList list, Object simpleName, final int index, final boolean isSelected, final boolean cellHasFocus) {
        if (simpleName instanceof gt) {
            simpleName = ((gt)simpleName).getSimpleName();
        }
        return super.getListCellRendererComponent(list, simpleName, index, isSelected, cellHasFocus);
    }
}
