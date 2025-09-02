package nomanssave;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

class du extends JPanel {
   final gF hm;
   private JMenuItem fh;
   private JMenuItem hn;
   private JMenuItem fe;

   private du(dt var1, gF var2) {
      this.ho = var1;
      this.hm = var2;
      int var3 = UIManager.getInt("Inventory.gridSize");
      Dimension var4 = new Dimension(var3, var3);
      this.setBackground(bO.eK);
      this.setMinimumSize(var4);
      this.setMaximumSize(var4);
      this.setPreferredSize(var4);
      this.setLayout(new GridBagLayout());
      this.setBorder(bO.eP);
      JPopupMenu var5 = new JPopupMenu();
      this.fe = new JMenuItem("Item Details");
      this.fe.addActionListener(new dv(this, var2));
      var5.add(this.fe);
      this.hn = new JMenuItem("Change Item");
      this.hn.addActionListener(new dw(this, var2));
      var5.add(this.hn);
      this.fh = new JMenuItem("Move Item");
      this.fh.addActionListener(new dx(this, var2));
      var5.add(this.fh);
      this.setComponentPopupMenu(var5);
      this.addMouseListener(new dy(this, var2));
      this.aM();
   }

   private void aM() {
      this.removeAll();
      int var1 = UIManager.getInt("Inventory.gridSize");
      Dimension var2 = new Dimension(var1, var1);
      this.setBackground(bO.eK);
      this.setMinimumSize(var2);
      this.setMaximumSize(var2);
      this.setPreferredSize(var2);
      if (this.hm != null && this.hm.isValid()) {
         this.fe.setEnabled(true);
         this.hn.setEnabled(true);
         this.fh.setEnabled(this.hm.dA() > 0);
         ey var3 = ey.d(this.hm.dz());
         String var4 = var3 == null ? this.hm.ei() : var3.getName();
         int var5 = UIManager.getInt("Inventory.iconSize");
         Font var6 = UIManager.getFont("Inventory.font");
         ImageIcon var7 = var3 == null ? null : var3.c(var5, var5);
         int var8 = 0;
         if (var7 != null) {
            JLabel var9 = new JLabel(var7);
            var9.setPreferredSize(new Dimension(var5, var5));
            GridBagConstraints var10 = new GridBagConstraints();
            var10.anchor = 10;
            var10.fill = 0;
            var10.insets = new Insets(5, 0, 5, 0);
            var10.gridx = 0;
            var10.gridy = var8++;
            this.add(var9, var10);
         }

         JLabel var13 = new JLabel();
         var13.setFont(var6);
         var13.setBackground(null);
         var13.setBorder(null);
         var13.setText(var4);
         var13.setForeground(bO.eO);
         GridBagConstraints var15 = new GridBagConstraints();
         var15.anchor = 10;
         var15.fill = 0;
         var15.insets = new Insets(var8 == 0 ? var5 + 10 : 0, 0, 0, 0);
         var15.gridx = 0;
         var15.gridy = var8++;
         this.add(var13, var15);
         var13 = new JLabel();
         var13.setFont(var6);
         var13.setBackground(null);
         var13.setBorder(null);
         var13.setText(Integer.toString(this.hm.dA()) + "/" + Integer.toString(this.hm.dB()));
         var13.setForeground(bO.eO);
         var15 = new GridBagConstraints();
         var15.anchor = 10;
         var15.fill = 0;
         var15.insets = new Insets(0, 0, 0, 0);
         var15.gridx = 0;
         var15.gridy = var8++;
         this.add(var13, var15);
      } else {
         this.fe.setEnabled(false);
         this.hn.setEnabled(false);
         this.fh.setEnabled(false);
      }

      this.revalidate();
      this.updateUI();
   }
}
