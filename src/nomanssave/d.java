// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.JCheckBox;

class d extends JCheckBox implements TableCellRenderer
{
    private d() {
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.setBackground(table.getBackground());
        this.setHorizontalAlignment(0);
        this.setSelected(Boolean.TRUE == o);
        return this;
    }
}
