// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class aB extends DefaultTableCellRenderer
{
    final /* synthetic */ ap cu;
    
    private aB(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        final JLabel label = (JLabel)super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
        label.setIcon((Icon)o);
        return label;
    }
}
