// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class q implements TableModel
{
    final /* synthetic */ p I;
    
    q(final p i) {
        this.I = i;
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
        return (this.I.F == null) ? 0 : this.I.F.size();
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        switch (n2) {
            case 0: {
                return this.I.F.get(n).N(3);
            }
            case 1: {
                return this.I.F.get(n).getName();
            }
            case 2: {
                return this.I.F.get(n).bc().toString();
            }
            case 3: {
                return this.I.F.get(n).getID();
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
