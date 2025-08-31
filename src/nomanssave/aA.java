// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class aA extends DefaultTableCellRenderer
{
    int f;
    
    public aA(final JTable table, final int f) {
        this.f = f;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        final JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(this.f);
        return label;
    }
}
