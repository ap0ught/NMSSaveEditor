// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;

class bS extends JPanel
{
    private final int x;
    private final int y;
    private JCheckBoxMenuItem eY;
    private JMenuItem eZ;
    private JMenuItem fa;
    private JMenuItem fb;
    private JCheckBoxMenuItem fc;
    private JMenuItem fd;
    private JMenuItem fe;
    private JMenuItem ff;
    private JMenuItem fg;
    private JMenuItem fh;
    private JMenuItem fi;
    private JMenuItem fj;
    final /* synthetic */ bO eX;
    
    private bS(final bO ex, final int x, final int y) {
        this.eX = ex;
        this.x = x;
        this.y = y;
        this.setLayout(new GridBagLayout());
        final JPopupMenu componentPopupMenu = new JPopupMenu();
        (this.eY = new JCheckBoxMenuItem("Enabled")).addActionListener(new bT(this, x, y));
        this.eY.setEnabled(ex.eW.dp() || en.aS());
        componentPopupMenu.add(this.eY);
        (this.eZ = new JMenuItem("Enable All Slots")).addActionListener(new bY(this));
        this.eZ.setEnabled(ex.eW.dp() || en.aS());
        componentPopupMenu.add(this.eZ);
        (this.fa = new JMenuItem("Repair Slot")).addActionListener(new bZ(this, x, y));
        this.fa.setVisible(ex.eW.dq());
        componentPopupMenu.add(this.fa);
        (this.fb = new JMenuItem("Repair All Slots")).addActionListener(new ca(this));
        this.fb.setVisible(ex.eW.dq());
        componentPopupMenu.add(this.fb);
        (this.fc = new JCheckBoxMenuItem("Supercharged")).addActionListener(new cb(this, x, y));
        this.fc.setVisible(ex.eW.do());
        componentPopupMenu.add(this.fc);
        (this.fd = new JMenuItem("Supercharge All Slots")).addActionListener(new cc(this));
        this.fd.setVisible(ex.eW.do());
        componentPopupMenu.add(this.fd);
        componentPopupMenu.addSeparator();
        (this.fe = new JMenuItem("Item Details")).addActionListener(new cd(this, x, y));
        componentPopupMenu.add(this.fe);
        (this.ff = new JMenuItem("Add Item")).addActionListener(new ce(this, x, y));
        componentPopupMenu.add(this.ff);
        (this.fg = new JMenuItem("Repair Item")).addActionListener(new cf(this, x, y));
        componentPopupMenu.add(this.fg);
        (this.fh = new JMenuItem("Move Item")).addActionListener(new bU(this, x, y));
        componentPopupMenu.add(this.fh);
        (this.fi = new JMenuItem("Fill Stack")).addActionListener(new bV(this, x, y));
        componentPopupMenu.add(this.fi);
        (this.fj = new JMenuItem("Delete Item")).addActionListener(new bW(this, x, y));
        componentPopupMenu.add(this.fj);
        this.setComponentPopupMenu(componentPopupMenu);
        this.setBorder(bO.eP);
        this.addMouseListener(new bX(this, x, y));
        this.aq();
    }
    
    private boolean ao() {
        return this.eX.eW.h(this.x, this.y);
    }
    
    private boolean ap() {
        return this.eX.eW.l(this.x, this.y);
    }
    
    private void aq() {
        this.removeAll();
        this.eY.setEnabled(this.eX.eW.dp() || en.aS());
        this.eZ.setEnabled(this.eX.eW.dp() || en.aS());
        this.fa.setVisible(this.eX.eW.dq());
        this.fb.setVisible(this.eX.eW.dq());
        if (!this.eX.eW.h(this.x, this.y)) {
            this.eY.setSelected(false);
            this.fa.setEnabled(false);
            this.fe.setVisible(false);
            this.fg.setVisible(false);
            this.ff.setVisible(true);
            this.ff.setEnabled(false);
            this.fh.setVisible(false);
            this.fi.setVisible(false);
            this.fj.setVisible(false);
            this.fc.setVisible(false);
            this.setBorder(bO.eP);
            this.setBackground(bO.eE);
            this.setToolTipText(null);
        }
        else if (this.eX.eW.l(this.x, this.y)) {
            this.eY.setSelected(true);
            this.fa.setEnabled(true);
            this.fe.setVisible(false);
            this.fg.setVisible(false);
            this.ff.setVisible(true);
            this.ff.setEnabled(false);
            this.fh.setVisible(false);
            this.fi.setVisible(false);
            this.fj.setVisible(false);
            this.fc.setVisible(this.eX.eW.do());
            if (this.eX.eW.k(this.x, this.y)) {
                this.setBorder(bO.eQ);
                this.fc.setState(true);
            }
            else {
                this.setBorder(bO.eP);
                this.fc.setState(false);
            }
            this.setBackground(bO.eF);
            final gu f = this.eX.eW.f(this.x, this.y);
            if (f == null) {
                this.setToolTipText(null);
            }
            else {
                final ey d = ey.d(f.dz());
                final boolean b = d instanceof eQ && f.dC() != 0.0;
                final String toolTipText = (d == null) ? a(f.dz()) : d.getName();
                final int int1 = UIManager.getInt("Inventory.iconSize");
                final ImageIcon imageIcon = (d == null) ? null : d.c(int1, int1);
                int n = 0;
                if (imageIcon != null) {
                    this.a(imageIcon, int1, n++);
                }
                final Color color = b ? bO.eN : bO.eO;
                this.a(toolTipText, n++, color);
                this.a((f.dA() < 0) ? "" : (String.valueOf(f.dA()) + "/" + f.dB()), n++, color);
                this.setToolTipText(toolTipText);
            }
        }
        else {
            this.eY.setSelected(true);
            this.fa.setEnabled(false);
            this.fc.setVisible(this.eX.eW.do());
            if (this.eX.eW.k(this.x, this.y)) {
                this.setBorder(bO.eQ);
                this.fc.setState(true);
            }
            else {
                this.setBorder(bO.eP);
                this.fc.setState(false);
            }
            final gu f2 = this.eX.eW.f(this.x, this.y);
            if (f2 == null) {
                this.fe.setVisible(false);
                this.fg.setVisible(false);
                this.ff.setVisible(true);
                this.ff.setEnabled(true);
                this.fh.setVisible(false);
                this.fi.setVisible(false);
                this.fj.setVisible(false);
                this.setBackground(bO.eK);
                this.setToolTipText(null);
            }
            else {
                final ey d2 = ey.d(f2.dz());
                final boolean visible = d2 instanceof eQ && f2.dC() != 0.0;
                this.fe.setVisible(true);
                this.fg.setVisible(visible);
                this.ff.setVisible(false);
                this.ff.setEnabled(false);
                this.fh.setVisible(true);
                this.fi.setVisible(false);
                this.fj.setVisible(true);
                final String type = f2.getType();
                if (type.equals("Technology")) {
                    this.setBackground(bO.eG);
                    if (f2.dA() >= 0 && f2.dA() < f2.dB()) {
                        this.fi.setText("Recharge");
                        this.fi.setVisible(true);
                    }
                }
                else if (type.equals("Product")) {
                    this.setBackground(bO.eH);
                    if (f2.dB() > 1) {
                        this.fi.setText("Fill Stack");
                        this.fi.setVisible(true);
                    }
                }
                else if (type.equals("Substance")) {
                    this.setBackground(bO.eI);
                    if (f2.dB() > 1) {
                        this.fi.setText("Fill Stack");
                        this.fi.setVisible(true);
                    }
                }
                else {
                    this.setBackground(bO.eJ);
                }
                this.fe.setEnabled(d2 != null);
                final String toolTipText2 = (d2 == null) ? a(f2.dz()) : d2.getName();
                final int int2 = UIManager.getInt("Inventory.iconSize");
                final ImageIcon imageIcon2 = (d2 == null) ? null : d2.c(int2, int2);
                int n2 = 0;
                if (imageIcon2 != null) {
                    this.a(imageIcon2, int2, n2++);
                }
                final Color color2 = visible ? bO.eN : bO.eO;
                this.a(toolTipText2, n2++, color2);
                this.a((f2.dA() < 0) ? " " : (String.valueOf(f2.dA()) + "/" + f2.dB()), n2++, color2);
                this.setToolTipText(toolTipText2);
            }
        }
        this.revalidate();
        this.updateUI();
    }
    
    private void a(final ImageIcon image, final int n, final int gridy) {
        final JLabel comp = new JLabel(image);
        comp.setPreferredSize(new Dimension(n, n));
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 10;
        constraints.fill = 0;
        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        this.add(comp, constraints);
    }
    
    private void a(final String text, final int gridy, final Color foreground) {
        final JLabel comp = new JLabel();
        comp.setFont(UIManager.getFont("Inventory.font"));
        comp.setBackground(null);
        comp.setBorder(null);
        comp.setText(text);
        comp.setForeground(foreground);
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 10;
        constraints.fill = 0;
        final int int1 = UIManager.getInt("Inventory.iconSize");
        constraints.insets = new Insets((gridy == 0) ? (int1 + 10) : 0, 0, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        this.add(comp, constraints);
    }
}
