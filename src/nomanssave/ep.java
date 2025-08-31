// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class ep extends em
{
    private JComboBox iw;
    private bO ix;
    private gO[] iy;
    
    ep(final Application application) {
        (this.iw = new JComboBox()).setModel(new eq(this));
        this.a("Vehicle", true, this.iw);
        this.b(this.ix = new bO(application));
    }
    
    void w() {
        this.ix.w();
    }
    
    void x() {
        this.ix.x();
    }
    
    void y() {
        this.ix.y();
    }
    
    void A() {
        this.ix.A();
    }
    
    void a(final gt gt) {
        this.ix.a(gt);
    }
    
    gO[] aT() {
        return this.iy;
    }
    
    void a(final gO[] iy) {
        if (iy.length == 0) {
            this.iy = new gO[0];
            this.iw.setSelectedIndex(-1);
        }
        else {
            this.iy = iy;
            this.iw.setSelectedIndex(0);
        }
        this.iw.updateUI();
    }
}
