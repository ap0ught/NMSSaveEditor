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

// $VF: renamed from: nomanssave.du
class class_351 extends JPanel {
   // $VF: renamed from: hm nomanssave.gF
   final class_76 field_1138;
   // $VF: renamed from: fh javax.swing.JMenuItem
   private JMenuItem field_1139;
   // $VF: renamed from: hn javax.swing.JMenuItem
   private JMenuItem field_1140;
   // $VF: renamed from: fe javax.swing.JMenuItem
   private JMenuItem field_1141;

   private class_351(class_360 var1, class_76 var2) {
      this.field_1142 = var1;
      this.field_1138 = var2;
      int var3 = UIManager.getInt("Inventory.gridSize");
      Dimension var4 = new Dimension(var3, var3);
      this.setBackground(class_357.field_1218);
      this.setMinimumSize(var4);
      this.setMaximumSize(var4);
      this.setPreferredSize(var4);
      this.setLayout(new GridBagLayout());
      this.setBorder(class_357.field_1223);
      JPopupMenu var5 = new JPopupMenu();
      this.field_1141 = new JMenuItem("Item Details");
      this.field_1141.addActionListener(new class_165(this, var2));
      var5.add(this.field_1141);
      this.field_1140 = new JMenuItem("Change Item");
      this.field_1140.addActionListener(new class_164(this, var2));
      var5.add(this.field_1140);
      this.field_1139 = new JMenuItem("Move Item");
      this.field_1139.addActionListener(new class_163(this, var2));
      var5.add(this.field_1139);
      this.setComponentPopupMenu(var5);
      this.addMouseListener(new class_237(this, var2));
      this.method_1021();
   }

   // $VF: renamed from: aM () void
   private void method_1021() {
      this.removeAll();
      int var1 = UIManager.getInt("Inventory.gridSize");
      Dimension var2 = new Dimension(var1, var1);
      this.setBackground(class_357.field_1218);
      this.setMinimumSize(var2);
      this.setMaximumSize(var2);
      this.setPreferredSize(var2);
      if (this.field_1138 != null && this.field_1138.isValid()) {
         this.field_1141.setEnabled(true);
         this.field_1140.setEnabled(true);
         this.field_1139.setEnabled(this.field_1138.method_43() > 0);
         class_152 var3 = class_152.method_795(this.field_1138.method_40());
         String var4 = var3 == null ? this.field_1138.ei() : var3.getName();
         int var5 = UIManager.getInt("Inventory.iconSize");
         Font var6 = UIManager.getFont("Inventory.font");
         ImageIcon var7 = var3 == null ? null : var3.method_787(var5, var5);
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
         var13.setForeground(class_357.field_1222);
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
         var13.setText(Integer.toString(this.field_1138.method_43()) + "/" + Integer.toString(this.field_1138.method_45()));
         var13.setForeground(class_357.field_1222);
         var15 = new GridBagConstraints();
         var15.anchor = 10;
         var15.fill = 0;
         var15.insets = new Insets(0, 0, 0, 0);
         var15.gridx = 0;
         var15.gridy = var8++;
         this.add(var13, var15);
      } else {
         this.field_1141.setEnabled(false);
         this.field_1140.setEnabled(false);
         this.field_1139.setEnabled(false);
      }

      this.revalidate();
      this.updateUI();
   }
}
