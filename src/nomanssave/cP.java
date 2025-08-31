// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

class cP extends DefaultListCellRenderer
{
    final /* synthetic */ cN gt;
    
    cP(final cN gt) {
        this.gt = gt;
    }
    
    @Override
    public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean cellHasFocus) {
        final Component listCellRendererComponent = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value == null && listCellRendererComponent instanceof JLabel) {
            ((JLabel)listCellRendererComponent).setText(" ");
        }
        if (listCellRendererComponent instanceof JLabel) {
            boolean b = false;
            Enum[] e;
            for (int length = (e = this.gt.gn).length, i = 0; i < length; ++i) {
                if (e[i] == value) {
                    b = true;
                    break;
                }
            }
            final JLabel label = (JLabel)listCellRendererComponent;
            if (!b) {
                if (isSelected) {
                    label.setBackground(cN.gs);
                }
                else {
                    label.setForeground(cN.gr);
                }
            }
        }
        return listCellRendererComponent;
    }
}
