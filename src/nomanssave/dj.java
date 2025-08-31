// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class dj extends em
{
    private static final double gX = 1000.0;
    private static final double gY = 1000.0;
    private static final double gZ = 1000.0;
    private JComboBox ha;
    private G hb;
    private cN hc;
    private cN hd;
    private G he;
    private G hf;
    private G hg;
    private G hh;
    private JButton bQ;
    private JButton bR;
    private JButton bS;
    private bO hi;
    private gv[] hj;
    
    dj(final Application application) {
        (this.ha = new JComboBox()).setModel(new dk(this));
        this.a("Multitool", true, this.ha);
        this.a("Name", (JComponent)(this.hb = new dl(this)));
        (this.hc = new cN(gx.class)).a(s2 -> {
            final gv gv = (gv)this.ha.getSelectedItem();
            if (gv != null) {
                gv.ag(s2);
            }
            return;
        });
        this.a("Type", this.hc);
        (this.hd = new cN(gN.class)).a(s4 -> {
            final gv gv2 = (gv)this.ha.getSelectedItem();
            if (gv2 != null) {
                gv2.aj(s4);
            }
            return;
        });
        this.a("Class", this.hd);
        this.a("Seed", this.he = new dm(this));
        this.k("Base Stats");
        this.a("Damage", (JComponent)(this.hf = new dn(this)));
        this.a("Mining", (JComponent)(this.hg = new do(this)));
        this.a("Scan", (JComponent)(this.hh = new dp(this)));
        this.Y();
        final JPanel panel = new JPanel();
        (this.bQ = new JButton("Delete Multitool")).addActionListener(new dq(this, application));
        panel.add(this.bQ);
        (this.bR = new JButton("Export")).addActionListener(new dr(this, application));
        panel.add(this.bR);
        (this.bS = new JButton("Import")).addActionListener(new ds(this, application));
        panel.add(this.bS);
        this.a(panel);
        this.b(this.hi = new bO(application));
    }
    
    void w() {
        this.hi.w();
    }
    
    void x() {
        this.hi.x();
    }
    
    void y() {
        this.hi.y();
    }
    
    void z() {
        this.hi.z();
    }
    
    void A() {
        this.hi.A();
    }
    
    void a(final gt gt) {
        this.hi.a(gt);
    }
    
    gv[] aK() {
        return this.hj;
    }
    
    void a(final gv[] hj, final gB gb) {
        this.hj = hj;
        if (hj.length == 0) {
            this.ha.setSelectedIndex(-1);
        }
        else {
            int selectedIndex = (gb == null) ? 0 : gb.dU();
            if (selectedIndex >= hj.length) {
                selectedIndex = 0;
            }
            this.ha.setSelectedIndex(selectedIndex);
        }
        this.ha.updateUI();
    }
}
