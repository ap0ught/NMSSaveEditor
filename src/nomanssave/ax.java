// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class ax implements TableModel
{
    final /* synthetic */ ap cu;
    
    ax(final ap cu) {
        this.cu = cu;
    }
    
    @Override
    public int getRowCount() {
        return eS.bx();
    }
    
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(final int n) {
        switch (n) {
            case 0: {
                return "Word";
            }
            case 1: {
                return "ID";
            }
            case 2: {
                return eU.kr.toString();
            }
            case 3: {
                return eU.ks.toString();
            }
            case 4: {
                return eU.kt.toString();
            }
            case 5: {
                return eU.kv.toString();
            }
            case 6: {
                return eU.kz.toString();
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
        if (n2 < 2 || n2 >= this.getColumnCount()) {
            return false;
        }
        final eS t = eS.T(n);
        if (t == null) {
            return false;
        }
        switch (n2) {
            case 2: {
                return t.a(eU.kr);
            }
            case 3: {
                return t.a(eU.ks);
            }
            case 4: {
                return t.a(eU.kt);
            }
            case 5: {
                return t.a(eU.kv);
            }
            case 6: {
                return t.a(eU.kz);
            }
            default: {
                return false;
            }
        }
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        final eS t = eS.T(n);
        final gA a = this.cu.cp.a(t);
        switch (n2) {
            case 0: {
                return (t == null) ? "" : t.getText();
            }
            case 1: {
                return a.getID();
            }
            case 2: {
                return a.c(eU.kr);
            }
            case 3: {
                return a.c(eU.ks);
            }
            case 4: {
                return a.c(eU.kt);
            }
            case 5: {
                return a.c(eU.kv);
            }
            case 6: {
                return a.c(eU.kz);
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public void setValueAt(final Object obj, final int n, final int n2) {
        final gA a = this.cu.cp.a(eS.T(n));
        switch (n2) {
            case 2: {
                a.a(eU.kr, Boolean.TRUE.equals(obj));
                break;
            }
            case 3: {
                a.a(eU.ks, Boolean.TRUE.equals(obj));
                break;
            }
            case 4: {
                a.a(eU.kt, Boolean.TRUE.equals(obj));
                break;
            }
            case 5: {
                a.a(eU.kv, Boolean.TRUE.equals(obj));
                break;
            }
            case 6: {
                a.a(eU.kz, Boolean.TRUE.equals(obj));
                break;
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
