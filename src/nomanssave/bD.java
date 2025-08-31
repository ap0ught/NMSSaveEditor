// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

class bD extends DefaultListCellRenderer
{
    final /* synthetic */ bl er;
    
    private bD(final bl er) {
        this.er = er;
    }
    
    @Override
    public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean cellHasFocus) {
        final Component listCellRendererComponent = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value == null && listCellRendererComponent instanceof JLabel) {
            ((JLabel)listCellRendererComponent).setText(" ");
        }
        if (value instanceof er && listCellRendererComponent instanceof JLabel) {
            final er er = (er)value;
            final JLabel label = (JLabel)listCellRendererComponent;
            if (er.aW()) {
                if (isSelected) {
                    label.setBackground(UIManager.getColor("Frigate.positiveTraitHighlight"));
                }
                else {
                    label.setForeground(UIManager.getColor("Frigate.positiveTraitColor"));
                }
            }
            else if (isSelected) {
                label.setBackground(UIManager.getColor("Frigate.negativeTraitHighlight"));
            }
            else {
                label.setForeground(UIManager.getColor("Frigate.negativeTraitColor"));
            }
        }
        return listCellRendererComponent;
    }
}
