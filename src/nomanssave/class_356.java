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

// $VF: renamed from: nomanssave.bS
class class_356 extends JPanel {
   // $VF: renamed from: x int
   private final int field_1197;
   // $VF: renamed from: y int
   private final int field_1198;
   // $VF: renamed from: eY javax.swing.JCheckBoxMenuItem
   private JCheckBoxMenuItem field_1199;
   // $VF: renamed from: eZ javax.swing.JMenuItem
   private JMenuItem field_1200;
   // $VF: renamed from: fa javax.swing.JMenuItem
   private JMenuItem field_1201;
   // $VF: renamed from: fb javax.swing.JMenuItem
   private JMenuItem field_1202;
   // $VF: renamed from: fc javax.swing.JCheckBoxMenuItem
   private JCheckBoxMenuItem field_1203;
   // $VF: renamed from: fd javax.swing.JMenuItem
   private JMenuItem field_1204;
   // $VF: renamed from: fe javax.swing.JMenuItem
   private JMenuItem field_1205;
   // $VF: renamed from: ff javax.swing.JMenuItem
   private JMenuItem field_1206;
   // $VF: renamed from: fg javax.swing.JMenuItem
   private JMenuItem field_1207;
   // $VF: renamed from: fh javax.swing.JMenuItem
   private JMenuItem field_1208;
   // $VF: renamed from: fi javax.swing.JMenuItem
   private JMenuItem field_1209;
   // $VF: renamed from: fj javax.swing.JMenuItem
   private JMenuItem field_1210;

   private class_356(class_357 var1, int var2, int var3) {
      this.field_1211 = var1;
      this.field_1197 = var2;
      this.field_1198 = var3;
      this.setLayout(new GridBagLayout());
      JPopupMenu var4 = new JPopupMenu();
      this.field_1199 = new JCheckBoxMenuItem("Enabled");
      this.field_1199.addActionListener(new class_243(this, var2, var3));
      this.field_1199.setEnabled(class_357.method_1114(var1).method_411() || class_130.method_681());
      var4.add(this.field_1199);
      this.field_1200 = new JMenuItem("Enable All Slots");
      this.field_1200.addActionListener(new class_236(this));
      this.field_1200.setEnabled(class_357.method_1114(var1).method_411() || class_130.method_681());
      var4.add(this.field_1200);
      this.field_1201 = new JMenuItem("Repair Slot");
      this.field_1201.addActionListener(new class_235(this, var2, var3));
      this.field_1201.setVisible(class_357.method_1114(var1).method_412());
      var4.add(this.field_1201);
      this.field_1202 = new JMenuItem("Repair All Slots");
      this.field_1202.addActionListener(new class_195(this));
      this.field_1202.setVisible(class_357.method_1114(var1).method_412());
      var4.add(this.field_1202);
      this.field_1203 = new JCheckBoxMenuItem("Supercharged");
      this.field_1203.addActionListener(new class_194(this, var2, var3));
      this.field_1203.setVisible(class_357.method_1114(var1).method_410());
      var4.add(this.field_1203);
      this.field_1204 = new JMenuItem("Supercharge All Slots");
      this.field_1204.addActionListener(new class_193(this));
      this.field_1204.setVisible(class_357.method_1114(var1).method_410());
      var4.add(this.field_1204);
      var4.addSeparator();
      this.field_1205 = new JMenuItem("Item Details");
      this.field_1205.addActionListener(new class_192(this, var2, var3));
      var4.add(this.field_1205);
      this.field_1206 = new JMenuItem("Add Item");
      this.field_1206.addActionListener(new class_191(this, var2, var3));
      var4.add(this.field_1206);
      this.field_1207 = new JMenuItem("Repair Item");
      this.field_1207.addActionListener(new class_190(this, var2, var3));
      var4.add(this.field_1207);
      this.field_1208 = new JMenuItem("Move Item");
      this.field_1208.addActionListener(new class_242(this, var2, var3));
      var4.add(this.field_1208);
      this.field_1209 = new JMenuItem("Fill Stack");
      this.field_1209.addActionListener(new class_241(this, var2, var3));
      var4.add(this.field_1209);
      this.field_1210 = new JMenuItem("Delete Item");
      this.field_1210.addActionListener(new class_240(this, var2, var3));
      var4.add(this.field_1210);
      this.setComponentPopupMenu(var4);
      this.setBorder(class_357.field_1223);
      this.addMouseListener(new class_239(this, var2, var3));
      this.method_1089();
   }

   // $VF: renamed from: ao () boolean
   private boolean method_1087() {
      return class_357.method_1114(this.field_1211).method_407(this.field_1197, this.field_1198);
   }

   // $VF: renamed from: ap () boolean
   private boolean method_1088() {
      return class_357.method_1114(this.field_1211).method_416(this.field_1197, this.field_1198);
   }

   // $VF: renamed from: aq () void
   private void method_1089() {
      this.removeAll();
      this.field_1199.setEnabled(class_357.method_1114(this.field_1211).method_411() || class_130.method_681());
      this.field_1200.setEnabled(class_357.method_1114(this.field_1211).method_411() || class_130.method_681());
      this.field_1201.setVisible(class_357.method_1114(this.field_1211).method_412());
      this.field_1202.setVisible(class_357.method_1114(this.field_1211).method_412());
      if (!class_357.method_1114(this.field_1211).method_407(this.field_1197, this.field_1198)) {
         this.field_1199.setSelected(false);
         this.field_1201.setEnabled(false);
         this.field_1205.setVisible(false);
         this.field_1207.setVisible(false);
         this.field_1206.setVisible(true);
         this.field_1206.setEnabled(false);
         this.field_1208.setVisible(false);
         this.field_1209.setVisible(false);
         this.field_1210.setVisible(false);
         this.field_1203.setVisible(false);
         this.setBorder(class_357.field_1223);
         this.setBackground(class_357.method_1120());
         this.setToolTipText(null);
      } else if (class_357.method_1114(this.field_1211).method_416(this.field_1197, this.field_1198)) {
         this.field_1199.setSelected(true);
         this.field_1201.setEnabled(true);
         this.field_1205.setVisible(false);
         this.field_1207.setVisible(false);
         this.field_1206.setVisible(true);
         this.field_1206.setEnabled(false);
         this.field_1208.setVisible(false);
         this.field_1209.setVisible(false);
         this.field_1210.setVisible(false);
         this.field_1203.setVisible(class_357.method_1114(this.field_1211).method_410());
         if (class_357.method_1114(this.field_1211).method_413(this.field_1197, this.field_1198)) {
            this.setBorder(class_357.method_1121());
            this.field_1203.setState(true);
         } else {
            this.setBorder(class_357.field_1223);
            this.field_1203.setState(false);
         }

         this.setBackground(class_357.method_1122());
         class_41 var1 = class_357.method_1114(this.field_1211).method_399(this.field_1197, this.field_1198);
         if (var1 == null) {
            this.setToolTipText(null);
         } else {
            class_152 var2 = class_152.method_795(var1.method_40());
            boolean var3 = var2 instanceof class_154 && var1.method_218() != 0.0;
            String var4 = var2 == null ? class_357.method_1123(var1.method_40()) : var2.getName();
            int var5 = UIManager.getInt("Inventory.iconSize");
            ImageIcon var6 = var2 == null ? null : var2.method_787(var5, var5);
            int var7 = 0;
            if (var6 != null) {
               this.method_1090(var6, var5, var7++);
            }

            Color var8 = var3 ? class_357.method_1124() : class_357.field_1222;
            this.method_1091(var4, var7++, var8);
            this.method_1091(var1.method_43() < 0 ? "" : var1.method_43() + "/" + var1.method_45(), var7++, var8);
            this.setToolTipText(var4);
         }
      } else {
         this.field_1199.setSelected(true);
         this.field_1201.setEnabled(false);
         this.field_1203.setVisible(class_357.method_1114(this.field_1211).method_410());
         if (class_357.method_1114(this.field_1211).method_413(this.field_1197, this.field_1198)) {
            this.setBorder(class_357.method_1121());
            this.field_1203.setState(true);
         } else {
            this.setBorder(class_357.field_1223);
            this.field_1203.setState(false);
         }

         class_41 var10 = class_357.method_1114(this.field_1211).method_399(this.field_1197, this.field_1198);
         if (var10 == null) {
            this.field_1205.setVisible(false);
            this.field_1207.setVisible(false);
            this.field_1206.setVisible(true);
            this.field_1206.setEnabled(true);
            this.field_1208.setVisible(false);
            this.field_1209.setVisible(false);
            this.field_1210.setVisible(false);
            this.setBackground(class_357.field_1218);
            this.setToolTipText(null);
         } else {
            class_152 var11 = class_152.method_795(var10.method_40());
            boolean var12 = var11 instanceof class_154 && var10.method_218() != 0.0;
            this.field_1205.setVisible(true);
            this.field_1207.setVisible(var12);
            this.field_1206.setVisible(false);
            this.field_1206.setEnabled(false);
            this.field_1208.setVisible(true);
            this.field_1209.setVisible(false);
            this.field_1210.setVisible(true);
            String var13 = var10.getType();
            if (var13.equals("Technology")) {
               this.setBackground(class_357.method_1125());
               if (var10.method_43() >= 0 && var10.method_43() < var10.method_45()) {
                  this.field_1209.setText("Recharge");
                  this.field_1209.setVisible(true);
               }
            } else if (var13.equals("Product")) {
               this.setBackground(class_357.method_1126());
               if (var10.method_45() > 1) {
                  this.field_1209.setText("Fill Stack");
                  this.field_1209.setVisible(true);
               }
            } else if (var13.equals("Substance")) {
               this.setBackground(class_357.method_1127());
               if (var10.method_45() > 1) {
                  this.field_1209.setText("Fill Stack");
                  this.field_1209.setVisible(true);
               }
            } else {
               this.setBackground(class_357.method_1128());
            }

            this.field_1205.setEnabled(var11 != null);
            String var14 = var11 == null ? class_357.method_1123(var10.method_40()) : var11.getName();
            int var15 = UIManager.getInt("Inventory.iconSize");
            ImageIcon var18 = var11 == null ? null : var11.method_787(var15, var15);
            int var19 = 0;
            if (var18 != null) {
               this.method_1090(var18, var15, var19++);
            }

            Color var9 = var12 ? class_357.method_1124() : class_357.field_1222;
            this.method_1091(var14, var19++, var9);
            this.method_1091(var10.method_43() < 0 ? " " : var10.method_43() + "/" + var10.method_45(), var19++, var9);
            this.setToolTipText(var14);
         }
      }

      this.revalidate();
      this.updateUI();
   }

   // $VF: renamed from: a (javax.swing.ImageIcon, int, int) void
   private void method_1090(ImageIcon var1, int var2, int var3) {
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

   // $VF: renamed from: a (java.lang.String, int, java.awt.Color) void
   private void method_1091(String var1, int var2, Color var3) {
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
