// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.table.TableCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.TableCellRenderer;
import javax.swing.RowSorter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.JTable;

class f extends JTable
{
    eV g;
    final /* synthetic */ c h;
    
    f(final c h, final Application application, final Supplier supplier, final Function function) {
        this.h = h;
        this.g = null;
        final g g = new g(this, supplier, function);
        this.setCellSelectionEnabled(false);
        this.getColumnModel().setColumnMargin(2);
        this.setModel(g);
        final TableRowSorter rowSorter = new TableRowSorter(g);
        rowSorter.setSortable(2, false);
        this.setRowSorter((RowSorter<? extends TableModel>)rowSorter);
        this.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new e(2));
        this.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(new e(2));
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setHorizontalAlignment(0);
        this.getColumnModel().getColumn(2).setMaxWidth(80);
        this.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(new e(0));
        this.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(checkBox));
        this.getColumnModel().getColumn(2).setCellRenderer(new d((d)null));
    }
    
    void a(final eV g) {
        this.g = g;
    }
}
