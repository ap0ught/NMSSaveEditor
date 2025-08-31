// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.Collections;
import javax.swing.JComponent;

public class aJ extends em
{
    private static final int cV = 200;
    private static final int cW = 100;
    private static final int cX = 100;
    private static final long cY = 4294967295L;
    private static final long cZ = 4294967295L;
    private static final long da = 4294967295L;
    private G db;
    private G dc;
    private G dd;
    private G de;
    private G df;
    private G dg;
    private bO dh;
    private gz di;
    
    aJ(final Application application) {
        this.k("Main Stats");
        this.a("Health", (JComponent)(this.de = new aK(this)));
        this.a("Shield", (JComponent)(this.df = new aL(this)));
        this.a("Energy", (JComponent)(this.dg = new aM(this)));
        this.a("Units", (JComponent)(this.db = new aN(this, application)));
        this.a("Nanites", (JComponent)(this.dc = new aO(this)));
        this.a("Quicksilver", (JComponent)(this.dd = new aP(this)));
        this.b(this.dh = new bO(application));
    }
    
    void w() {
        this.dh.w();
    }
    
    void x() {
        this.dh.x();
    }
    
    void y() {
        this.dh.y();
    }
    
    void A() {
        this.dh.A();
    }
    
    void a(final gt gt) {
        this.dh.a(gt);
    }
    
    gz X() {
        return this.di;
    }
    
    void a(final gz di) {
        if (di == null) {
            this.di = null;
            this.db.setText("");
            this.dc.setText("");
            this.dd.setText("");
            this.de.setText("");
            this.df.setText("");
            this.dg.setText("");
            this.dh.a(Collections.emptyList());
        }
        else {
            this.di = di;
            this.db.setText(Long.toString(di.dJ()));
            this.dc.setText(Long.toString(di.dK()));
            this.dd.setText(Long.toString(di.dL()));
            this.de.setText(Integer.toString(di.dM()));
            this.df.setText(Integer.toString(di.dN()));
            this.dg.setText(Integer.toString(di.dO()));
            this.dh.a(di.cC());
        }
    }
}
