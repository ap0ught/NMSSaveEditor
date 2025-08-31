package nomanssave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

// $VF: renamed from: nomanssave.bO
public class class_357 extends JPanel implements class_2 {
   // $VF: renamed from: eE java.awt.Color
   private static final Color field_1212 = Color.GRAY;
   // $VF: renamed from: eF java.awt.Color
   private static final Color field_1213 = new Color(255, 240, 240);
   // $VF: renamed from: eG java.awt.Color
   private static final Color field_1214 = new Color(255, 255, 240);
   // $VF: renamed from: eH java.awt.Color
   private static final Color field_1215 = new Color(240, 255, 250);
   // $VF: renamed from: eI java.awt.Color
   private static final Color field_1216 = new Color(240, 250, 255);
   // $VF: renamed from: eJ java.awt.Color
   private static final Color field_1217 = new Color(240, 255, 255);
   // $VF: renamed from: eK java.awt.Color
   public static final Color field_1218 = Color.WHITE;
   // $VF: renamed from: eL java.awt.Color
   private static final Color field_1219 = Color.BLACK;
   // $VF: renamed from: eM java.awt.Color
   private static final Color field_1220 = Color.YELLOW;
   // $VF: renamed from: eN java.awt.Color
   private static final Color field_1221 = Color.RED;
   // $VF: renamed from: eO java.awt.Color
   public static final Color field_1222 = Color.BLACK;
   // $VF: renamed from: eP javax.swing.border.Border
   public static final Border field_1223 = BorderFactory.createLineBorder(field_1219, 1);
   // $VF: renamed from: eQ javax.swing.border.Border
   private static final Border field_1224 = BorderFactory.createCompoundBorder(field_1223, BorderFactory.createLineBorder(field_1220, 2));
   // $VF: renamed from: eR nomanssave.Application
   private final Application field_1225;
   // $VF: renamed from: eS javax.swing.JPanel
   private final JPanel field_1226;
   // $VF: renamed from: eT javax.swing.JComboBox
   private final JComboBox field_1227;
   // $VF: renamed from: eU javax.swing.JButton
   private final JButton field_1228;
   // $VF: renamed from: eV java.util.List
   private List field_1229;
   // $VF: renamed from: eW nomanssave.gt
   private class_70 field_1230;

   class_357(Application var1) {
      this.field_1225 = var1;
      this.setLayout(new BorderLayout());
      JPanel var2 = new JPanel();
      var2.setLayout(new FlowLayout());
      this.field_1226 = new JPanel();
      this.field_1226.setLayout(new GridBagLayout());
      int var3 = UIManager.getInt("Inventory.gridSize");
      this.setPreferredSize(new Dimension(var3 * 10 + 20, var3 * 8 + 50));
      this.add(var2, "North");
      JScrollPane var4 = new JScrollPane();
      var4.setViewportView(this.field_1226);
      var4.setBorder(new LineBorder(field_1219));
      this.add(var4, "Center");
      this.field_1229 = Collections.emptyList();
      this.field_1227 = new JComboBox();
      this.field_1227.setVisible(false);
      this.field_1227.setModel(new class_245(this));
      this.field_1227.setRenderer(new class_346(this));
      var2.add(this.field_1227);
      this.field_1228 = new JButton("Resize Inventory");
      this.field_1228.setVisible(false);
      this.field_1228.addActionListener(new class_244(this));
      var2.add(this.field_1228);
      class_130.method_680(this);
      UIManager.addPropertyChangeListener(this::a);
   }

   // $VF: renamed from: a (boolean) void
   @Override
   public void method_2(boolean var1) {
      this.field_1228.setVisible(this.field_1230 == null ? false : var1 || this.field_1230.method_387());
      boolean var2 = this.field_1230 == null ? false : var1 || this.field_1230.method_411();
      synchronized (this.field_1226.getTreeLock()) {
         for (int var4 = 0; var4 < this.field_1226.getComponentCount(); var4++) {
            Component var5 = this.field_1226.getComponent(var4);
            if (var5 instanceof class_356) {
               class_356 var6 = (class_356)var5;
               class_356.method_1092(var6).setEnabled(var2);
               class_356.method_1097(var6).setEnabled(var2);
            }
         }
      }
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1101(class_70 var1) {
      if (this.field_1230 == var1) {
         this.method_1108();
      }
   }

   // $VF: renamed from: w () void
   void method_1102() {
      this.field_1229.stream().forEach(this::b);
   }

   // $VF: renamed from: x () void
   void method_1103() {
      this.field_1229.stream().forEach(this::c);
   }

   // $VF: renamed from: y () void
   void method_1104() {
      this.field_1229.stream().forEach(this::d);
   }

   // $VF: renamed from: z () void
   void method_1105() {
      this.field_1229.stream().forEach(this::e);
   }

   // $VF: renamed from: A () void
   void method_1106() {
      this.field_1229.stream().forEach(this::f);
   }

   // $VF: renamed from: ae () void
   void method_1107() {
      int var1 = this.field_1227.getSelectedIndex();
      if (var1 >= 0) {
         this.field_1230 = (class_70)this.field_1229.get(var1);
         this.method_1108();
      }
   }

   // $VF: renamed from: af () void
   private void method_1108() {
      synchronized (this.field_1226.getTreeLock()) {
         this.field_1226.removeAll();
         if (this.field_1230 != null) {
            int var2 = UIManager.getInt("Inventory.gridSize");
            Dimension var3 = new Dimension(var2, var2);

            for (int var4 = 0; var4 < this.field_1230.getHeight(); var4++) {
               for (int var5 = 0; var5 < this.field_1230.getWidth(); var5++) {
                  class_356 var6 = new class_356(this, var5, var4, null);
                  var6.setMinimumSize(var3);
                  var6.setMaximumSize(var3);
                  var6.setPreferredSize(var3);
                  GridBagConstraints var7 = new GridBagConstraints();
                  var7.fill = 1;
                  var7.insets = new Insets(-1, -1, 0, 0);
                  var7.gridx = var5;
                  var7.gridy = var4;
                  this.field_1226.add(var6, var7);
               }
            }
         }
      }

      this.field_1226.revalidate();
      this.field_1226.updateUI();
   }

   // $VF: renamed from: a (java.util.List) void
   void method_1109(List var1) {
      this.field_1229 = var1;
      this.field_1230 = null;
      this.field_1227.updateUI();
      if (this.field_1229.size() == 0) {
         this.field_1227.setVisible(false);
         this.field_1228.setVisible(false);
         this.method_1108();
      } else {
         this.field_1227.setVisible(this.field_1229.size() != 1);
         this.field_1228.setVisible(false);
         this.field_1227.setSelectedIndex(0);
      }
   }

   // $VF: renamed from: a (int, int) nomanssave.bS
   private class_356 method_1110(int var1, int var2) {
      synchronized (this.field_1226.getTreeLock()) {
         for (int var4 = 0; var4 < this.field_1226.getComponentCount(); var4++) {
            Component var5 = this.field_1226.getComponent(var4);
            if (var5 instanceof class_356) {
               class_356 var6 = (class_356)var5;
               if (class_356.method_1098(var6) == var1 && class_356.method_1099(var6) == var2) {
                  return var6;
               }
            }
         }

         return null;
      }
   }

   // $VF: renamed from: a (nomanssave.bS) void
   private void method_1111(class_356 var1) {
      class_152 var2 = class_319.method_886(this, this.field_1230.method_385());
      if (var2 != null) {
         this.field_1230.method_404(class_356.method_1098(var1), class_356.method_1099(var1), var2);
         class_356.method_1093(var1);
      }
   }

   // $VF: renamed from: a (nomanssave.gu, nomanssave.bS) void
   private void method_1112(class_41 var1, class_356 var2) {
      class_152 var3 = class_152.method_795(var1.method_40());
      int var4;
      if (var3 == null) {
         if ("Product".equals(var1.getType())) {
            var4 = 512;
         } else {
            if (!"Substance".equals(var1.getType())) {
               this.field_1225.method_1342("Item details not found!");
               return;
            }

            var4 = 1024;
         }
      } else {
         var4 = class_70.method_384(var3.method_779());
      }

      List var5 = this.field_1225.method_1347(var4);
      int var6 = var5.indexOf(this.field_1230);
      int var7 = class_321.method_910(this, var5, var6);
      if (var7 != var6) {
         class_70 var8 = (class_70)var5.get(var7);
         if (this.field_1230.method_402(class_356.method_1098(var2), class_356.method_1099(var2), var8)) {
            class_356.method_1093(var2);
            this.field_1225.method_1361(var8);
         }
      }
   }

   // $VF: renamed from: a (java.lang.Object) java.lang.String
   private static String method_1113(Object var0) {
      return var0 instanceof class_95 ? "Archived Tech" : var0.toString();
   }
}
