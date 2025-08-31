// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class du extends JPanel
{
    final gF hm;
    private JMenuItem fh;
    private JMenuItem hn;
    private JMenuItem fe;
    final /* synthetic */ dt ho;
    
    private du(final dt ho, final gF hm) {
        this.ho = ho;
        this.hm = hm;
        final int int1 = UIManager.getInt("Inventory.gridSize");
        final Dimension preferredSize = new Dimension(int1, int1);
        this.setBackground(bO.eK);
        this.setMinimumSize(preferredSize);
        this.setMaximumSize(preferredSize);
        this.setPreferredSize(preferredSize);
        this.setLayout(new GridBagLayout());
        this.setBorder(bO.eP);
        final JPopupMenu componentPopupMenu = new JPopupMenu();
        (this.fe = new JMenuItem("Item Details")).addActionListener(new dv(this, hm));
        componentPopupMenu.add(this.fe);
        (this.hn = new JMenuItem("Change Item")).addActionListener(new dw(this, hm));
        componentPopupMenu.add(this.hn);
        (this.fh = new JMenuItem("Move Item")).addActionListener(new dx(this, hm));
        componentPopupMenu.add(this.fh);
        this.setComponentPopupMenu(componentPopupMenu);
        this.addMouseListener(new dy(this, hm));
        this.aM();
    }
    
    private void aM() {
        this.removeAll();
        final int int1 = UIManager.getInt("Inventory.gridSize");
        final Dimension preferredSize = new Dimension(int1, int1);
        this.setBackground(bO.eK);
        this.setMinimumSize(preferredSize);
        this.setMaximumSize(preferredSize);
        this.setPreferredSize(preferredSize);
        if (this.hm == null || !this.hm.isValid()) {
            this.fe.setEnabled(false);
            this.hn.setEnabled(false);
            this.fh.setEnabled(false);
        }
        else {
            this.fe.setEnabled(true);
            this.hn.setEnabled(true);
            this.fh.setEnabled(this.hm.dA() > 0);
            final ey d = ey.d(this.hm.dz());
            final String text = (d == null) ? this.hm.ei() : d.getName();
            final int int2 = UIManager.getInt("Inventory.iconSize");
            final Font font = UIManager.getFont("Inventory.font");
            final ImageIcon image = (d == null) ? null : d.c(int2, int2);
            int n = 0;
            if (image != null) {
                final JLabel comp = new JLabel(image);
                comp.setPreferredSize(new Dimension(int2, int2));
                final GridBagConstraints constraints = new GridBagConstraints();
                constraints.anchor = 10;
                constraints.fill = 0;
                constraints.insets = new Insets(5, 0, 5, 0);
                constraints.gridx = 0;
                constraints.gridy = n++;
                this.add(comp, constraints);
            }
            final JLabel comp2 = new JLabel();
            comp2.setFont(font);
            comp2.setBackground(null);
            comp2.setBorder(null);
            comp2.setText(text);
            comp2.setForeground(bO.eO);
            final GridBagConstraints constraints2 = new GridBagConstraints();
            constraints2.anchor = 10;
            constraints2.fill = 0;
            constraints2.insets = new Insets((n == 0) ? (int2 + 10) : 0, 0, 0, 0);
            constraints2.gridx = 0;
            constraints2.gridy = n++;
            this.add(comp2, constraints2);
            final JLabel comp3 = new JLabel();
            comp3.setFont(font);
            comp3.setBackground(null);
            comp3.setBorder(null);
            comp3.setText(String.valueOf(Integer.toString(this.hm.dA())) + "/" + Integer.toString(this.hm.dB()));
            comp3.setForeground(bO.eO);
            final GridBagConstraints constraints3 = new GridBagConstraints();
            constraints3.anchor = 10;
            constraints3.fill = 0;
            constraints3.insets = new Insets(0, 0, 0, 0);
            constraints3.gridx = 0;
            constraints3.gridy = n++;
            this.add(comp3, constraints3);
        }
        this.revalidate();
        this.updateUI();
    }
}
