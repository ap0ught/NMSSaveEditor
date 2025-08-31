// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.table.TableCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class dE extends JPanel
{
    private ba hv;
    private ba hw;
    private JComboBox hx;
    private G hy;
    private G hz;
    private G[] ea;
    private JTable hA;
    private dt hB;
    private gE[] hC;
    
    dE(final Application application) {
        final GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] { aH.cI, 0, 0 };
        layout.rowHeights = new int[1];
        layout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
        layout.rowWeights = new double[] { 1.0 };
        this.setLayout(layout);
        this.hv = new ba();
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(this.hv, constraints);
        (this.hx = new JComboBox()).setModel(new dF(this));
        this.hv.a("Settlement", true, this.hx);
        this.hy = new dG(this);
        this.hv.a("Name", (JComponent)this.hy);
        this.hz = new dH(this);
        this.hv.a("Seed", this.hz);
        this.hv.Y();
        this.hv.k("Stats");
        this.ea = new G[gG.values().length];
        for (int i = 0; i < this.ea.length; ++i) {
            this.ea[i] = new dM(this, gG.values()[i], null);
            this.hv.a(gG.values()[i].toString(), (JComponent)this.ea[i]);
        }
        this.hw = new ba();
        final GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.insets = new Insets(0, 0, 0, 0);
        constraints2.fill = 1;
        constraints2.gridx = 2;
        constraints2.gridy = 0;
        this.add(this.hw, constraints2);
        this.hw.k("Perks");
        final JScrollPane scrollPane = new JScrollPane();
        this.hw.a(scrollPane);
        (this.hA = new JTable()).setCellSelectionEnabled(false);
        this.hA.setModel(new dI(this));
        this.hA.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new dJ(this)));
        scrollPane.setViewportView(this.hA);
        this.hB = new dt(application);
        final GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.insets = new Insets(0, 0, 0, 0);
        constraints3.fill = 1;
        constraints3.gridx = 1;
        constraints3.gridy = 0;
        this.add(this.hB, constraints3);
    }
    
    gE[] aN() {
        return this.hC;
    }
    
    void a(final gE[] hc) {
        if (hc.length == 0) {
            this.hC = new gE[0];
            this.hx.setSelectedIndex(-1);
        }
        else {
            this.hC = hc;
            this.hx.setSelectedIndex(0);
        }
        this.hx.updateUI();
    }
}
