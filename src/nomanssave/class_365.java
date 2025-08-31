package nomanssave;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JPanel;

// $VF: renamed from: nomanssave.em
public class class_365 extends JPanel {
   // $VF: renamed from: it nomanssave.ba
   private final class_358 field_1271;

   class_365() {
      GridBagLayout var1 = new GridBagLayout();
      var1.columnWidths = new int[]{class_300.field_971, 0, 0};
      var1.rowHeights = new int[1];
      var1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
      var1.rowWeights = new double[]{1.0};
      this.setLayout(var1);
      this.field_1271 = new class_358();
      GridBagConstraints var2 = new GridBagConstraints();
      var2.insets = new Insets(0, 0, 0, 0);
      var2.fill = 1;
      var2.gridx = 0;
      var2.gridy = 0;
      this.add(this.field_1271, var2);
   }

   // $VF: renamed from: b (javax.swing.JComponent) void
   void method_1202(JComponent var1) {
      GridBagConstraints var2 = new GridBagConstraints();
      var2.fill = 1;
      var2.gridx = 1;
      var2.gridy = 0;
      this.add(var1, var2);
   }

   // $VF: renamed from: k (java.lang.String) void
   void method_1203(String var1) {
      this.field_1271.method_1138(var1);
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.G) void
   void method_1204(String var1, class_374 var2) {
      this.field_1271.method_1145(var1, var2);
   }

   // $VF: renamed from: a (java.lang.String, javax.swing.JComponent) void
   void method_1205(String var1, JComponent var2) {
      this.field_1271.method_1141(var1, var2);
   }

   // $VF: renamed from: a (java.lang.String, boolean, javax.swing.JComponent) void
   void method_1206(String var1, boolean var2, JComponent var3) {
      this.field_1271.method_1143(var1, var2, var3);
   }

   // $VF: renamed from: a (javax.swing.JComponent) void
   void method_1207(JComponent var1) {
      this.field_1271.method_1146(var1);
   }

   // $VF: renamed from: Y () void
   void method_1208() {
      this.field_1271.method_1140();
   }
}
