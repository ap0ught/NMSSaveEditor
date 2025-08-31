// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class dN extends em
{
    private static final int cV = 500;
    private static final int cW = 200;
    private static final double gX = 1000.0;
    private static final double hI = 1000.0;
    private static final double dE = 1000.0;
    private static final double hJ = 1000.0;
    private JComboBox hK;
    private G hL;
    private cN hM;
    private cN hN;
    private G hO;
    private JCheckBox hP;
    private JButton bQ;
    private JButton bR;
    private JButton bS;
    private G hQ;
    private G hR;
    private G hS;
    private G hT;
    private G hU;
    private G hV;
    private bO hW;
    private gH[] hX;
    private gC hY;
    
    dN(final Application application) {
        (this.hK = new JComboBox()).setModel(new dO(this, application));
        this.a("Ship", true, this.hK);
        this.a("Name", (JComponent)(this.hL = new dT(this)));
        (this.hM = new cN(gL.class)).a(s2 -> {
            final gH gh = (gH)this.hK.getModel().getSelectedItem();
            if (gh != null) {
                gL.aw(s2);
                final gL gl;
                if (JOptionPane.showConfirmDialog(application2.g(), "You are about to change a ship type to " + ((gl == null) ? "Unknown" : gl.toString()) + ". Are you sure?\nNOTE: Any incompatible technology installed on the ship will be deleted.", "Change Ship Type", 0) != 0) {
                    this.hM.m(gh.cT());
                }
                else {
                    gh.ag(s2);
                    this.hW.a(gh.cC());
                    this.hK.updateUI();
                }
            }
            return;
        });
        this.a("Type", this.hM);
        (this.hN = new cN(gN.class)).a(s4 -> {
            final gH gh2 = (gH)this.hK.getModel().getSelectedItem();
            if (gh2 != null) {
                gh2.aj(s4);
            }
            return;
        });
        this.a("Class", this.hN);
        this.a("Seed", this.hO = new dU(this));
        (this.hP = new JCheckBox("Use Old Colours")).setEnabled(false);
        this.hP.addActionListener(new dV(this, application));
        this.a(null, this.hP);
        this.k("Base Stats");
        this.a("Health", (JComponent)(this.hQ = new dW(this)));
        this.a("Shield", (JComponent)(this.hR = new dX(this)));
        this.a("Damage", (JComponent)(this.hS = new dY(this)));
        this.a("Shields", (JComponent)(this.hT = new dZ(this)));
        this.a("Hyperdrive", (JComponent)(this.hU = new ea(this)));
        this.a("Maneuverability", (JComponent)(this.hV = new dP(this)));
        this.Y();
        final JPanel panel = new JPanel();
        (this.bQ = new JButton("Delete Ship")).addActionListener(new dQ(this, application));
        panel.add(this.bQ);
        (this.bR = new JButton("Export")).addActionListener(new dR(this, application));
        panel.add(this.bR);
        (this.bS = new JButton("Import")).addActionListener(new dS(this, application));
        panel.add(this.bS);
        this.a(panel);
        this.b(this.hW = new bO(application));
    }
    
    void w() {
        for (int i = 0; i < this.hX.length; ++i) {
            this.hX[i].cC().stream().forEach(obj -> {
                if (obj.dt()) {
                    hc.info(obj + ": technology recharged");
                }
                this.hW.a(obj);
                return;
            });
        }
    }
    
    void x() {
        for (int i = 0; i < this.hX.length; ++i) {
            this.hX[i].cC().stream().forEach(obj -> {
                if (obj.du()) {
                    hc.info(obj + ": items refilled");
                }
                this.hW.a(obj);
                return;
            });
        }
    }
    
    void y() {
        for (int i = 0; i < this.hX.length; ++i) {
            this.hX[i].cC().stream().forEach(obj -> {
                if (obj.dv()) {
                    hc.info(obj + ": all slots enabled");
                }
                this.hW.a(obj);
                return;
            });
        }
    }
    
    void z() {
        for (int i = 0; i < this.hX.length; ++i) {
            this.hX[i].cC().stream().forEach(obj -> {
                if (obj.ds()) {
                    hc.info(obj + ": all slots repaired");
                }
                this.hW.a(obj);
                return;
            });
        }
    }
    
    void A() {
        for (int i = 0; i < this.hX.length; ++i) {
            this.hX[i].cC().stream().forEach(obj -> {
                if (obj.dl()) {
                    hc.info(obj + ": inventory expanded");
                }
                this.hW.a(obj);
                return;
            });
        }
    }
    
    void a(final gt gt) {
        this.hW.a(gt);
    }
    
    gH[] aO() {
        return this.hX;
    }
    
    void a(final gH[] hx, final gC hy) {
        this.hX = hx;
        this.hY = hy;
        if (hx.length == 0) {
            this.hK.setSelectedIndex(-1);
        }
        else {
            int selectedIndex = (hy == null) ? 0 : hy.dV();
            if (selectedIndex >= hx.length) {
                selectedIndex = 0;
            }
            this.hK.setSelectedIndex(selectedIndex);
        }
        if (hy == null) {
            this.hQ.setText("");
            this.hR.setText("");
        }
        else {
            this.hQ.setText(Long.toString(hy.dM()));
            this.hR.setText(Long.toString(hy.dN()));
        }
        this.hK.updateUI();
    }
}
