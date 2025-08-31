// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ListCellRenderer;
import javax.swing.ComboBoxModel;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;
import javax.swing.JComboBox;

public class cN extends JComboBox
{
    private final boolean gm;
    private final Enum[] gn;
    private final List go;
    private cR gp;
    private Object gq;
    private static final Color gr;
    private static final Color gs;
    
    static {
        gr = Color.RED;
        gs = new Color(255, 100, 100);
    }
    
    public cN(final Class clazz) {
        this.gm = gD.class.isAssignableFrom(clazz);
        this.gn = clazz.getEnumConstants();
        this.go = new ArrayList();
        this.setModel(new cO(this, clazz));
        this.setRenderer(new cP(this));
    }
    
    public void m(final String s) {
        Object value = null;
        if (s != null) {
            Enum[] gn;
            for (int length = (gn = this.gn).length, i = 0; i < length; ++i) {
                final Enum enum1 = gn[i];
                if (this.gm) {
                    if (((gD)enum1).K().equals(s)) {
                        value = enum1;
                        break;
                    }
                }
                else if (enum1.name().equals(s)) {
                    value = enum1;
                    break;
                }
            }
            if (value == null) {
                final int index = this.go.indexOf(new cQ(this, s));
                if (index >= 0) {
                    value = this.go.get(index);
                }
                else {
                    value = (this.gm ? new cS(this, s) : s);
                    this.go.add(value);
                }
            }
        }
        this.gq = value;
        this.selectedItemChanged();
        this.updateUI();
    }
    
    public void a(final cR gp) {
        this.gp = gp;
    }
}
