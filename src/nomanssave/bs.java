// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class bs implements TableModel
{
    final /* synthetic */ bl er;
    
    bs(final bl er) {
        this.er = er;
    }
    
    @Override
    public void addTableModelListener(final TableModelListener tableModelListener) {
    }
    
    @Override
    public Class getColumnClass(final int n) {
        return String.class;
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(final int n) {
        switch (n) {
            case 0: {
                return "Name";
            }
            case 1: {
                return "Type";
            }
            case 2: {
                return "Class";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public int getRowCount() {
        return (this.er.ep == null) ? 0 : this.er.ep.length;
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        switch (n2) {
            case 0: {
                return (this.er.ep == null) ? null : this.er.ep[n].toString();
            }
            case 1: {
                final gr gr = (this.er.ep == null) ? null : this.er.ep[n].da();
                return (gr == null) ? "Unknown" : gr.toString();
            }
            case 2: {
                return (this.er.ep == null) ? null : this.er.ep[n].cW().toString();
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
