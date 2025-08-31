// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import java.awt.Container;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.ListCellRenderer;
import javax.swing.ComboBoxModel;
import java.util.Collections;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JPanel;

public class bO extends JPanel implements eo
{
    private static final Color eE;
    private static final Color eF;
    private static final Color eG;
    private static final Color eH;
    private static final Color eI;
    private static final Color eJ;
    public static final Color eK;
    private static final Color eL;
    private static final Color eM;
    private static final Color eN;
    public static final Color eO;
    public static final Border eP;
    private static final Border eQ;
    private final Application eR;
    private final JPanel eS;
    private final JComboBox eT;
    private final JButton eU;
    private List eV;
    private gt eW;
    
    static {
        eE = Color.GRAY;
        eF = new Color(255, 240, 240);
        eG = new Color(255, 255, 240);
        eH = new Color(240, 255, 250);
        eI = new Color(240, 250, 255);
        eJ = new Color(240, 255, 255);
        eK = Color.WHITE;
        eL = Color.BLACK;
        eM = Color.YELLOW;
        eN = Color.RED;
        eO = Color.BLACK;
        eP = BorderFactory.createLineBorder(bO.eL, 1);
        eQ = BorderFactory.createCompoundBorder(bO.eP, BorderFactory.createLineBorder(bO.eM, 2));
    }
    
    bO(final Application er) {
        this.eR = er;
        this.setLayout(new BorderLayout());
        final JPanel comp = new JPanel();
        comp.setLayout(new FlowLayout());
        (this.eS = new JPanel()).setLayout(new GridBagLayout());
        final int int1 = UIManager.getInt("Inventory.gridSize");
        this.setPreferredSize(new Dimension(int1 * 10 + 20, int1 * 8 + 50));
        this.add(comp, "North");
        final JScrollPane comp2 = new JScrollPane();
        comp2.setViewportView(this.eS);
        comp2.setBorder(new LineBorder(bO.eL));
        this.add(comp2, "Center");
        this.eV = Collections.emptyList();
        (this.eT = new JComboBox()).setVisible(false);
        this.eT.setModel(new bP(this));
        this.eT.setRenderer(new bQ(this));
        comp.add(this.eT);
        (this.eU = new JButton("Resize Inventory")).setVisible(false);
        this.eU.addActionListener(new bR(this));
        comp.add(this.eU);
        en.a(this);
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                EventQueue.invokeLater(this::af);
            }
        });
    }
    
    @Override
    public void a(final boolean b) {
        this.eU.setVisible(this.eW != null && (b || this.eW.dk()));
        final boolean b2 = this.eW != null && (b || this.eW.dp());
        synchronized (this.eS.getTreeLock()) {
            for (int i = 0; i < this.eS.getComponentCount(); ++i) {
                final Component component = this.eS.getComponent(i);
                if (component instanceof bS) {
                    final bS bs = (bS)component;
                    bs.eY.setEnabled(b2);
                    bs.eZ.setEnabled(b2);
                }
            }
            monitorexit(this.eS.getTreeLock());
        }
    }
    
    void a(final gt gt) {
        if (this.eW == gt) {
            this.af();
        }
    }
    
    void w() {
        this.eV.stream().forEach(gt -> {
            if (gt.dt() && this.eW == gt) {
                this.af();
            }
        });
    }
    
    void x() {
        this.eV.stream().forEach(gt -> {
            if (gt.du() && this.eW == gt) {
                this.af();
            }
        });
    }
    
    void y() {
        this.eV.stream().forEach(gt -> {
            if (gt.dp() && gt.dv() && this.eW == gt) {
                this.af();
            }
        });
    }
    
    void z() {
        this.eV.stream().forEach(gt -> {
            if (gt.dq() && gt.ds() && this.eW == gt) {
                this.af();
            }
        });
    }
    
    void A() {
        this.eV.stream().forEach(gt -> {
            if (gt.dk() && gt.dl() && this.eW == gt) {
                this.af();
            }
        });
    }
    
    void ae() {
        final int selectedIndex = this.eT.getSelectedIndex();
        if (selectedIndex >= 0) {
            this.eW = (gt)this.eV.get(selectedIndex);
            this.af();
        }
    }
    
    private void af() {
        synchronized (this.eS.getTreeLock()) {
            this.eS.removeAll();
            if (this.eW != null) {
                final int int1 = UIManager.getInt("Inventory.gridSize");
                final Dimension preferredSize = new Dimension(int1, int1);
                for (int i = 0; i < this.eW.getHeight(); ++i) {
                    for (int j = 0; j < this.eW.getWidth(); ++j) {
                        final bS comp = new bS(this, j, i, null);
                        comp.setMinimumSize(preferredSize);
                        comp.setMaximumSize(preferredSize);
                        comp.setPreferredSize(preferredSize);
                        final GridBagConstraints constraints = new GridBagConstraints();
                        constraints.fill = 1;
                        constraints.insets = new Insets(-1, -1, 0, 0);
                        constraints.gridx = j;
                        constraints.gridy = i;
                        this.eS.add(comp, constraints);
                    }
                }
            }
            monitorexit(this.eS.getTreeLock());
        }
        this.eS.revalidate();
        this.eS.updateUI();
    }
    
    void a(final List ev) {
        this.eV = ev;
        this.eW = null;
        this.eT.updateUI();
        if (this.eV.size() == 0) {
            this.eT.setVisible(false);
            this.eU.setVisible(false);
            this.af();
        }
        else {
            this.eT.setVisible(this.eV.size() != 1);
            this.eU.setVisible(false);
            this.eT.setSelectedIndex(0);
        }
    }
    
    private bS a(final int n, final int n2) {
        synchronized (this.eS.getTreeLock()) {
            for (int i = 0; i < this.eS.getComponentCount(); ++i) {
                final Component component = this.eS.getComponent(i);
                if (component instanceof bS) {
                    final bS bs = (bS)component;
                    if (bs.x == n && bs.y == n2) {
                        final bS bs2 = bs;
                        monitorexit(this.eS.getTreeLock());
                        return bs2;
                    }
                }
            }
            monitorexit(this.eS.getTreeLock());
        }
        return null;
    }
    
    private void a(final bS bs) {
        final ey a = h.a(this, this.eW.dj());
        if (a != null) {
            this.eW.a(bs.x, bs.y, a);
            bs.aq();
        }
    }
    
    private void a(final gu gu, final bS bs) {
        final ey d = ey.d(gu.dz());
        int a;
        if (d == null) {
            if ("Product".equals(gu.getType())) {
                a = 512;
            }
            else {
                if (!"Substance".equals(gu.getType())) {
                    this.eR.c("Item details not found!");
                    return;
                }
                a = 1024;
            }
        }
        else {
            a = gt.a(d.bc());
        }
        final List g = this.eR.g(a);
        final int index = g.indexOf(this.eW);
        final int a2 = dd.a(this, g, index);
        if (a2 != index) {
            final gt gt = g.get(a2);
            if (this.eW.a(bs.x, bs.y, gt)) {
                bs.aq();
                this.eR.a(gt);
            }
        }
    }
    
    private static String a(final Object o) {
        if (o instanceof fg) {
            return "Archived Tech";
        }
        return o.toString();
    }
}
