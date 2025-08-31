// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.TableModelListener;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.table.TableModel;

class g implements TableModel
{
    final /* synthetic */ f i;
    private final /* synthetic */ Supplier j;
    private final /* synthetic */ Function k;
    
    g(final f i, final Supplier j, final Function k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
    
    @Override
    public int getRowCount() {
        return this.j.get();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(final int n) {
        switch (n) {
            case 0: {
                return "ID";
            }
            case 1: {
                return "Name";
            }
            case 2: {
                return "Unlocked";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public Class getColumnClass(final int n) {
        switch (n) {
            case 0:
            case 1: {
                return String.class;
            }
            default: {
                return Boolean.class;
            }
        }
    }
    
    @Override
    public boolean isCellEditable(final int n, final int n2) {
        return n2 == 2 && this.i.g != null;
    }
    
    @Override
    public Object getValueAt(final int i, final int n) {
        final eI ei = this.k.apply(i);
        switch (n) {
            case 0: {
                return (ei == null) ? "" : ei.getID();
            }
            case 1: {
                return (ei == null) ? "" : ei.getName();
            }
            case 2: {
                return ei != null && this.i.g != null && this.i.g.indexOf(ei.getID()) >= 0;
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public void setValueAt(final Object obj, final int i, final int n) {
        if (this.i.g == null) {
            return;
        }
        final eI ei = this.k.apply(i);
        if (n == 2) {
            final int index = this.i.g.indexOf(ei.getID());
            if (Boolean.TRUE.equals(obj)) {
                if (index < 0) {
                    this.i.g.f(ei.getID());
                }
            }
            else if (index >= 0) {
                this.i.g.ac(index);
            }
        }
    }
    
    @Override
    public void addTableModelListener(final TableModelListener tableModelListener) {
    }
    
    @Override
    public void removeTableModelListener(final TableModelListener tableModelListener) {
    }
}
