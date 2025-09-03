package nomanssave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

class bS extends JPanel {
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

   private bS(bO var1, int var2, int var3) {
      this.eX = var1;
      this.x = var2;
      this.y = var3;
      this.setLayout(new GridBagLayout());
      JPopupMenu var4 = new JPopupMenu();
      this.eY = new JCheckBoxMenuItem("Enabled");
      this.eY.addActionListener(new bT(this, var2, var3));
      this.eY.setEnabled(bO.a(var1).dp() || en.aS());
      var4.add(this.eY);
      this.eZ = new JMenuItem("Enable All Slots");
      this.eZ.addActionListener(new bY(this));
      this.eZ.setEnabled(bO.a(var1).dp() || en.aS());
      var4.add(this.eZ);
      this.fa = new JMenuItem("Repair Slot");
      this.fa.addActionListener(new bZ(this, var2, var3));
      this.fa.setVisible(bO.a(var1).dq());
      var4.add(this.fa);
      this.fb = new JMenuItem("Repair All Slots");
      this.fb.addActionListener(new ca(this));
      this.fb.setVisible(bO.a(var1).dq());
      var4.add(this.fb);
      this.fc = new JCheckBoxMenuItem("Supercharged");
      this.fc.addActionListener(new cb(this, var2, var3));
      this.fc.setVisible(bO.a(var1).doMethod());
      var4.add(this.fc);
      this.fd = new JMenuItem("Supercharge All Slots");
      this.fd.addActionListener(new cc(this));
      this.fd.setVisible(bO.a(var1).doMethod());
      var4.add(this.fd);
      var4.addSeparator();
      this.fe = new JMenuItem("Item Details");
      this.fe.addActionListener(new cd(this, var2, var3));
      var4.add(this.fe);
      this.ff = new JMenuItem("Add Item");
      this.ff.addActionListener(new ce(this, var2, var3));
      var4.add(this.ff);
      this.fg = new JMenuItem("Repair Item");
      this.fg.addActionListener(new cf(this, var2, var3));
      var4.add(this.fg);
      this.fh = new JMenuItem("Move Item");
      this.fh.addActionListener(new bU(this, var2, var3));
      var4.add(this.fh);
      this.fi = new JMenuItem("Fill Stack");
      this.fi.addActionListener(new bV(this, var2, var3));
      var4.add(this.fi);
      this.fj = new JMenuItem("Delete Item");
      this.fj.addActionListener(new bW(this, var2, var3));
      var4.add(this.fj);
      this.setComponentPopupMenu(var4);
      this.setBorder(bO.eP);
      this.addMouseListener(new bX(this, var2, var3));
      this.aq();
   }

   private boolean ao() {
      return bO.a(this.eX).h(this.x, this.y);
   }

   private boolean ap() {
      return bO.a(this.eX).l(this.x, this.y);
   }

   private void aq() {
      this.removeAll();
      this.eY.setEnabled(bO.a(this.eX).dp() || en.aS());
      this.eZ.setEnabled(bO.a(this.eX).dp() || en.aS());
      this.fa.setVisible(bO.a(this.eX).dq());
      this.fb.setVisible(bO.a(this.eX).dq());
      if (!bO.a(this.eX).h(this.x, this.y)) {
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
         this.setBackground(bO.ag());
         this.setToolTipText(null);
      } else if (bO.a(this.eX).l(this.x, this.y)) {
         this.eY.setSelected(true);
         this.fa.setEnabled(true);
         this.fe.setVisible(false);
         this.fg.setVisible(false);
         this.ff.setVisible(true);
         this.ff.setEnabled(false);
         this.fh.setVisible(false);
         this.fi.setVisible(false);
         this.fj.setVisible(false);
         this.fc.setVisible(bO.a(this.eX).doMethod());
         if (bO.a(this.eX).k(this.x, this.y)) {
            this.setBorder(bO.ah());
            this.fc.setState(true);
         } else {
            this.setBorder(bO.eP);
            this.fc.setState(false);
         }

         this.setBackground(bO.ai());
         gu var1 = bO.a(this.eX).f(this.x, this.y);
         if (var1 == null) {
            this.setToolTipText(null);
         } else {
            ey var2 = ey.d(var1.dz());
            boolean var3 = var2 instanceof eQ && var1.dC() != 0.0;
            String var4 = var2 == null ? bO.b(var1.dz()) : var2.getName();
            int var5 = UIManager.getInt("Inventory.iconSize");
            ImageIcon var6 = var2 == null ? null : var2.c(var5, var5);
            int var7 = 0;
            if (var6 != null) {
               this.a(var6, var5, var7++);
            }

            Color var8 = var3 ? bO.aj() : bO.eO;
            this.a(var4, var7++, var8);
            this.a(var1.dA() < 0 ? "" : var1.dA() + "/" + var1.dB(), var7++, var8);
            this.setToolTipText(var4);
         }
      } else {
         this.eY.setSelected(true);
         this.fa.setEnabled(false);
         this.fc.setVisible(bO.a(this.eX).doMethod());
         if (bO.a(this.eX).k(this.x, this.y)) {
            this.setBorder(bO.ah());
            this.fc.setState(true);
         } else {
            this.setBorder(bO.eP);
            this.fc.setState(false);
         }

         gu var10 = bO.a(this.eX).f(this.x, this.y);
         if (var10 == null) {
            this.fe.setVisible(false);
            this.fg.setVisible(false);
            this.ff.setVisible(true);
            this.ff.setEnabled(true);
            this.fh.setVisible(false);
            this.fi.setVisible(false);
            this.fj.setVisible(false);
            this.setBackground(bO.eK);
            this.setToolTipText(null);
         } else {
            ey var11 = ey.d(var10.dz());
            boolean var12 = var11 instanceof eQ && var10.dC() != 0.0;
            this.fe.setVisible(true);
            this.fg.setVisible(var12);
            this.ff.setVisible(false);
            this.ff.setEnabled(false);
            this.fh.setVisible(true);
            this.fi.setVisible(false);
            this.fj.setVisible(true);
            String var13 = var10.getType();
            if (var13.equals("Technology")) {
               this.setBackground(bO.ak());
               if (var10.dA() >= 0 && var10.dA() < var10.dB()) {
                  this.fi.setText("Recharge");
                  this.fi.setVisible(true);
               }
            } else if (var13.equals("Product")) {
               this.setBackground(bO.al());
               if (var10.dB() > 1) {
                  this.fi.setText("Fill Stack");
                  this.fi.setVisible(true);
               }
            } else if (var13.equals("Substance")) {
               this.setBackground(bO.am());
               if (var10.dB() > 1) {
                  this.fi.setText("Fill Stack");
                  this.fi.setVisible(true);
               }
            } else {
               this.setBackground(bO.an());
            }

            this.fe.setEnabled(var11 != null);
            String var14 = var11 == null ? bO.b(var10.dz()) : var11.getName();
            int var15 = UIManager.getInt("Inventory.iconSize");
            ImageIcon var18 = var11 == null ? null : var11.c(var15, var15);
            int var19 = 0;
            if (var18 != null) {
               this.a(var18, var15, var19++);
            }

            Color var9 = var12 ? bO.aj() : bO.eO;
            this.a(var14, var19++, var9);
            this.a(var10.dA() < 0 ? " " : var10.dA() + "/" + var10.dB(), var19++, var9);
            this.setToolTipText(var14);
         }
      }

      this.revalidate();
      this.updateUI();
   }

   private void a(ImageIcon var1, int var2, int var3) {
      JLabel var4 = new JLabel(var1);
      var4.setPreferredSize(new Dimension(var2, var2));
      GridBagConstraints var5 = new GridBagConstraints();
      var5.anchor = 10;
      var5.fill = 0;
      var5.insets = new Insets(5, 0, 5, 0);
      var5.gridx = 0;
      var5.gridy = var3;
      this.add(var4, var5);
   }

   private void a(String var1, int var2, Color var3) {
      JLabel var4 = new JLabel();
      var4.setFont(UIManager.getFont("Inventory.font"));
      var4.setBackground(null);
      var4.setBorder(null);
      var4.setText(var1);
      var4.setForeground(var3);
      GridBagConstraints var5 = new GridBagConstraints();
      var5.anchor = 10;
      var5.fill = 0;
      int var6 = UIManager.getInt("Inventory.iconSize");
      var5.insets = new Insets(var2 == 0 ? var6 + 10 : 0, 0, 0, 0);
      var5.gridx = 0;
      var5.gridy = var2;
      this.add(var4, var5);
   }
}
