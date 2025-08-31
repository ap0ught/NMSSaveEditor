// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class dI implements TableModel
{
    final /* synthetic */ dE hE;
    
    dI(final dE he) {
        this.hE = he;
    }
    
    @Override
    public void addTableModelListener(final TableModelListener tableModelListener) {
    }
    
    @Override
    public Class getColumnClass(final int n) {
        if (n == 1) {
            return eM.class;
        }
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
                return "ID";
            }
            case 1: {
                return "Name";
            }
            case 2: {
                return "Description";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public int getRowCount() {
        final gE ge = (gE)this.hE.hx.getSelectedItem();
        if (ge == null) {
            return 0;
        }
        return ge.dW();
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        final gE ge = (gE)this.hE.hx.getSelectedItem();
        final String s = (ge == null) ? null : ge.aH(n);
        final eM x = eM.x(s);
        switch (n2) {
            case 0: {
                return s;
            }
            case 1: {
                return x;
            }
            case 2: {
                return (x == null) ? "" : x.getDescription();
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public boolean isCellEditable(final int n, final int n2) {
        return n2 == 1;
    }
    
    @Override
    public void removeTableModelListener(final TableModelListener tableModelListener) {
    }
    
    @Override
    public void setValueAt(final Object o, final int n, final int n2) {
        final gE ge = (gE)this.hE.hx.getSelectedItem();
        if (ge == null || n2 != 1) {
            return;
        }
        final eM em = (eM)o;
        final String ah = ge.aH(n);
        if (em.bb()) {
            final int index = ah.indexOf("#");
            if (index >= 0 && ah.substring(0, index).equals(em.getID())) {
                return;
            }
            ge.c(n, String.valueOf(em.getID()) + ("#" + (int)Math.floor(Math.random() * 100000.0)));
        }
        else {
            if (ah.endsWith(em.getID())) {
                return;
            }
            ge.c(n, em.getID());
        }
    }
}
