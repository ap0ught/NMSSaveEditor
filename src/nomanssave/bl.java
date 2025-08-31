// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import javax.swing.ListCellRenderer;
import javax.swing.ComboBoxModel;
import javax.swing.JComponent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPanel;

public class bl extends JPanel implements eo
{
    private static final int dQ = 50;
    private JTable dR;
    private JButton bQ;
    private JButton dS;
    private ba dT;
    private G dU;
    private JComboBox dV;
    private JTextField dW;
    private cN dX;
    private G dY;
    private G dZ;
    private G[] ea;
    private ba eb;
    private JComboBox ec;
    private JComboBox ed;
    private JComboBox ee;
    private JComboBox ef;
    private JComboBox eg;
    private G eh;
    private G ei;
    private G ej;
    private G ek;
    private JLabel el;
    private JButton em;
    private er[] en;
    private er[] eo;
    private gp[] ep;
    private int eq;
    
    bl(final Application application) {
        this.setLayout(new GridLayout(1, 3));
        final JScrollPane comp = new JScrollPane();
        comp.setMinimumSize(new Dimension(300, 0));
        comp.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        comp.setPreferredSize(new Dimension(300, 0));
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new BorderLayout());
        comp2.add(comp, "Center");
        final JPanel comp3 = new JPanel();
        (this.bQ = new JButton("Delete")).setEnabled(false);
        this.bQ.addActionListener(new bm(this, application));
        comp3.add(this.bQ);
        (this.dS = new JButton("Copy")).setEnabled(false);
        this.dS.addActionListener(new br(this, application));
        comp3.add(this.dS);
        comp2.add(comp3, "South");
        this.add(comp2);
        (this.dR = new JTable()).setSelectionMode(0);
        this.dR.setModel(new bs(this));
        this.dR.getColumnModel().getColumn(2).setMaxWidth(60);
        this.dR.getSelectionModel().addListSelectionListener(new bt(this, application));
        comp.setViewportView(this.dR);
        (this.dT = new ba(new int[] { aH.cJ, 0 })).setVisible(false);
        this.add(this.dT);
        this.dT.k("Frigate Info");
        this.dU = new bv(this);
        this.dT.a("Name", (JComponent)this.dU);
        (this.dV = new JComboBox()).setModel(new bw(this));
        this.dT.a("Type", this.dV);
        (this.dW = new JTextField()).setEditable(false);
        this.dT.a("Class", this.dW);
        (this.dX = new cN(gd.class)).a(s2 -> {
            if (this.eq >= 0) {
                this.ep[this.eq].am(s2);
            }
            return;
        });
        this.dT.a("NPC Race", this.dX);
        this.dY = new bx(this);
        this.dT.a("Home Seed", (JComponent)this.dY);
        this.dZ = new by(this);
        this.dT.a("Model Seed", this.dZ);
        this.dT.k("Traits");
        final bD renderer = new bD(this, null);
        (this.ec = new JComboBox()).setModel(new bB(this, null));
        this.ec.setRenderer(renderer);
        this.dT.a(this.ec);
        (this.ed = new JComboBox()).setModel(new bC(this, 1));
        this.ed.setRenderer(renderer);
        this.dT.a(this.ed);
        (this.ee = new JComboBox()).setModel(new bC(this, 2));
        this.ee.setRenderer(renderer);
        this.dT.a(this.ee);
        (this.ef = new JComboBox()).setModel(new bC(this, 3));
        this.ef.setRenderer(renderer);
        this.dT.a(this.ef);
        (this.eg = new JComboBox()).setModel(new bC(this, 4));
        this.eg.setRenderer(renderer);
        this.dT.a(this.eg);
        this.dT.Y();
        final JPanel panel = new JPanel();
        panel.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.GLUE_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.GLUE_COLSPEC }, new RowSpec[] { FormFactory.DEFAULT_ROWSPEC, FormFactory.DEFAULT_ROWSPEC }));
        panel.add(this.el = new JLabel(""), "2,1");
        (this.em = new JButton("Repair")).addActionListener(new bz(this));
        final JPanel comp4 = new JPanel();
        comp4.add(this.em);
        panel.add(comp4, "2,2");
        this.dT.a(panel);
        (this.eb = new ba(new int[] { aH.cJ, 0 })).setVisible(false);
        this.add(this.eb);
        this.eb.k("Stats");
        this.ea = new G[gq.values().length];
        for (int i = 0; i < this.ea.length; ++i) {
            this.ea[i] = new bA(this, i, null);
            this.eb.a(gq.values()[i].toString(), (JComponent)this.ea[i]);
        }
        this.eb.Y();
        this.eb.k("Totals");
        this.eh = new bn(this);
        this.eb.a("Expeditions", (JComponent)this.eh);
        this.ei = new bo(this);
        this.eb.a("Successful", (JComponent)this.ei);
        this.ej = new bp(this);
        this.eb.a("Failed", (JComponent)this.ej);
        this.ek = new bq(this);
        this.eb.a("Damaged", (JComponent)this.ek);
        nomanssave.en.a(this);
    }
    
    @Override
    public void a(final boolean b) {
        if (this.dR.getSelectedRow() >= 0) {
            this.dS.setEnabled(this.ep.length < 30 || nomanssave.en.aS());
        }
    }
    
    void a(final gp[] ep) {
        this.ep = ep;
        this.en = null;
        this.eo = null;
        this.dR.clearSelection();
        if (ep.length > 0) {
            this.dR.setRowSelectionInterval(0, 0);
        }
        this.dR.updateUI();
    }
}
