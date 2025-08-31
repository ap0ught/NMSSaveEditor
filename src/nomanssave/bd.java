// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.Collections;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class bd extends em
{
    private static final double dE = 1000.0;
    private static final double dF = 1000.0;
    private G dG;
    private cN dH;
    private cN dI;
    private G dJ;
    private G dK;
    private G dL;
    private G dM;
    private JTextField bm;
    private JButton bn;
    private JButton bo;
    private bO dN;
    private gm dO;
    
    bd(final Application application) {
        this.k("Freighter");
        this.a("Name", (JComponent)(this.dG = new be(this)));
        (this.dH = new cN(go.class)).a(s2 -> {
            if (this.dO != null) {
                this.dO.ag(s2);
            }
            return;
        });
        this.a("Type", this.dH);
        (this.dI = new cN(gN.class)).a(s4 -> {
            if (this.dO != null) {
                this.dO.aj(s4);
            }
            return;
        });
        this.a("Class", this.dI);
        this.a("Home Seed", (JComponent)(this.dJ = new bf(this)));
        this.a("Model Seed", this.dK = new bg(this));
        this.k("Base Stats");
        this.a("Hyperdrive", (JComponent)(this.dL = new bh(this)));
        this.a("Fleet Coordination", (JComponent)(this.dM = new bi(this)));
        this.Y();
        this.k("Base Info");
        (this.bm = new JTextField()).setEnabled(false);
        this.a("Items", this.bm);
        final JPanel panel = new JPanel();
        (this.bn = new JButton("Backup")).addActionListener(new bj(this, application));
        panel.add(this.bn);
        (this.bo = new JButton("Restore")).addActionListener(new bk(this, application));
        panel.add(this.bo);
        this.a(panel);
        this.b(this.dN = new bO(application));
    }
    
    void w() {
        this.dN.w();
    }
    
    void x() {
        this.dN.x();
    }
    
    void y() {
        this.dN.y();
    }
    
    void A() {
        this.dN.A();
    }
    
    void a(final gt gt) {
        this.dN.a(gt);
    }
    
    gm Z() {
        return this.dO;
    }
    
    void c(final gm do1) {
        if (do1 == null) {
            this.dO = null;
            this.dG.setText("");
            this.dH.setSelectedIndex(-1);
            this.dH.updateUI();
            this.dI.setSelectedIndex(-1);
            this.dJ.setText("");
            this.dK.setText("");
            this.dL.setText("");
            this.dM.setText("");
            this.bm.setText("");
            this.bn.setEnabled(false);
            this.bo.setEnabled(false);
            this.dN.a(Collections.emptyList());
        }
        else {
            this.dO = do1;
            this.dG.setText(do1.getName());
            this.dH.m(do1.cT());
            this.dI.m(do1.cW());
            this.dJ.setText(do1.cU());
            this.dK.setText(do1.cV());
            this.dL.setText(Double.toString(do1.cX()));
            this.dM.setText(Double.toString(do1.cY()));
            final gn cz = do1.cZ();
            if (cz == null) {
                this.bm.setText("");
                this.bn.setEnabled(false);
                this.bo.setEnabled(false);
            }
            else {
                this.bm.setText(Integer.toString(cz.cG()));
                this.bn.setEnabled(true);
                this.bo.setEnabled(true);
            }
            this.dN.a(do1.cC());
        }
    }
}
