// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

class dL extends DefaultListCellRenderer
{
    final /* synthetic */ dJ hG;
    
    dL(final dJ hg) {
        this.hG = hg;
    }
    
    @Override
    public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean cellHasFocus) {
        final JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value == null) {
            label.setText("");
        }
        else if (((eM)value).aW()) {
            if (isSelected) {
                label.setBackground(UIManager.getColor("Settlement.positivePerkHighlight"));
            }
            else {
                label.setForeground(UIManager.getColor("Settlement.positivePerkColor"));
            }
        }
        else if (isSelected) {
            label.setBackground(UIManager.getColor("Settlement.negativePerkHighlight"));
        }
        else {
            label.setForeground(UIManager.getColor("Settlement.negativePerkColor"));
        }
        return label;
    }
}
