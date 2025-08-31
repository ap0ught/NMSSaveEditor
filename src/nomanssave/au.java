// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class au implements TableModel
{
    final /* synthetic */ ap cu;
    
    au(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public void addTableModelListener(final TableModelListener tableModelListener) {
    }
    
    @Override
    public Class getColumnClass(final int n) {
        if (n == 0) {
            return ImageIcon.class;
        }
        return String.class;
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(final int n) {
        switch (n) {
            case 0: {
                return "";
            }
            case 1: {
                return "Name";
            }
            case 2: {
                return "Category";
            }
            case 3: {
                return "ID";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public int getRowCount() {
        return (this.cu.ct == null) ? 0 : this.cu.ct.size();
    }
    
    @Override
    public Object getValueAt(final int index, final int n) {
        final String s = this.cu.ct.get(index);
        final ey d = ey.d(s);
        switch (n) {
            case 0: {
                return (d == null) ? null : d.N(3);
            }
            case 1: {
                return (d == null) ? "" : d.getName();
            }
            case 2: {
                return (d == null) ? "" : d.bc().toString();
            }
            case 3: {
                return s;
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public boolean isCellEditable(final int n, final int n2) {
        return false;
    }
    
    @Override
    public void removeTableModelListener(final TableModelListener tableModelListener) {
    }
    
    @Override
    public void setValueAt(final Object o, final int n, final int n2) {
    }
}
