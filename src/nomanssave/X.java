// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class X extends JPanel
{
    private JComboBox bG;
    private JComboBox bH;
    private G bI;
    private G bJ;
    private G bK;
    private G bL;
    private G bM;
    private JCheckBox bN;
    private cN bO;
    private cN bP;
    private JButton bQ;
    private JButton bR;
    private JButton bS;
    private gj[] bT;
    
    X(final Application application) {
        this.setLayout(new GridLayout(1, 3));
        final ba comp = new ba(new int[] { aH.cJ, 0 });
        this.add(comp);
        this.add(new JPanel());
        this.add(new JPanel());
        (this.bG = new JComboBox()).setModel(new Y(this));
        comp.a("Companion", true, this.bG);
        (this.bH = new JComboBox()).setModel(new ab(this));
        this.bH.setEnabled(false);
        comp.a("Type", this.bH);
        comp.a("Name", (JComponent)(this.bI = new ac(this)));
        comp.a("Creature Seed", this.bJ = new ad(this));
        comp.a("Secondary Seed", (JComponent)(this.bK = new ae(this)));
        comp.a("Species Seed", (JComponent)(this.bL = new af(this)));
        comp.a("Genus Seed", (JComponent)(this.bM = new ag(this)));
        (this.bN = new JCheckBox("Predator")).setEnabled(false);
        this.bN.addActionListener(new ah(this));
        comp.a(null, this.bN);
        (this.bO = new cN(gi.class)).a(s2 -> {
            final gj gj = (gj)this.bG.getSelectedItem();
            if (gj != null) {
                gj.ae(s2);
            }
            return;
        });
        comp.a("Biome", this.bO);
        (this.bP = new cN(gk.class)).a(s4 -> {
            final gj gj2 = (gj)this.bG.getSelectedItem();
            if (gj2 != null) {
                gj2.af(s4);
            }
            return;
        });
        comp.a("Type", this.bP);
        comp.Y();
        final JPanel panel = new JPanel();
        (this.bQ = new JButton("Delete")).addActionListener(new ai(this, application));
        panel.add(this.bQ);
        (this.bR = new JButton("Export")).addActionListener(new Z(this, application));
        panel.add(this.bR);
        (this.bS = new JButton("Import")).addActionListener(new aa(this, application));
        panel.add(this.bS);
        comp.a(panel);
    }
    
    void a(final gj[] bt) {
        this.bT = bt;
        if (bt.length == 0) {
            this.bG.setSelectedIndex(-1);
        }
        else {
            this.bG.setSelectedIndex(0);
        }
        this.bG.updateUI();
    }
}
