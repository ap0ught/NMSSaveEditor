// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JCheckBox;

class aC extends JCheckBox implements TableCellRenderer
{
    final JLabel cv;
    
    aC() {
        this.cv = new JLabel();
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, int convertRowIndexToModel, final int n) {
        convertRowIndexToModel = table.convertRowIndexToModel(convertRowIndexToModel);
        if (!table.getModel().isCellEditable(convertRowIndexToModel, n)) {
            return this.cv;
        }
        this.setBackground(table.getBackground());
        this.setHorizontalAlignment(0);
        this.setSelected(Boolean.TRUE == o);
        return this;
    }
}
