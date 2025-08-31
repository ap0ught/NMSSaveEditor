package nomanssave;

import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

// $VF: renamed from: nomanssave.bd
public class class_370 extends class_365 {
   // $VF: renamed from: dE double
   private static final double field_1318 = 1000.0;
   // $VF: renamed from: dF double
   private static final double field_1319 = 1000.0;
   // $VF: renamed from: dG nomanssave.G
   private class_374 field_1320;
   // $VF: renamed from: dH nomanssave.cN
   private class_333 field_1321;
   // $VF: renamed from: dI nomanssave.cN
   private class_333 field_1322;
   // $VF: renamed from: dJ nomanssave.G
   private class_374 field_1323;
   // $VF: renamed from: dK nomanssave.G
   private class_374 field_1324;
   // $VF: renamed from: dL nomanssave.G
   private class_374 field_1325;
   // $VF: renamed from: dM nomanssave.G
   private class_374 field_1326;
   // $VF: renamed from: bm javax.swing.JTextField
   private JTextField field_1327;
   // $VF: renamed from: bn javax.swing.JButton
   private JButton field_1328;
   // $VF: renamed from: bo javax.swing.JButton
   private JButton field_1329;
   // $VF: renamed from: dN nomanssave.bO
   private class_357 field_1330;
   // $VF: renamed from: dO nomanssave.gm
   private class_44 field_1331;

   class_370(Application var1) {
      this.k("Freighter");
      this.field_1320 = new class_407(this);
      this.a("Name", this.field_1320);
      this.field_1321 = new class_333(go.class);
      this.field_1321.method_986(this::h);
      this.a("Type", this.field_1321);
      this.field_1322 = new class_333(gN.class);
      this.field_1322.method_986(this::i);
      this.a("Class", this.field_1322);
      this.field_1323 = new class_406(this);
      this.a("Home Seed", this.field_1323);
      this.field_1324 = new class_405(this);
      this.a("Model Seed", this.field_1324);
      this.k("Base Stats");
      this.field_1325 = new class_404(this);
      this.a("Hyperdrive", this.field_1325);
      this.field_1326 = new class_403(this);
      this.a("Fleet Coordination", this.field_1326);
      this.Y();
      this.k("Base Info");
      this.field_1327 = new JTextField();
      this.field_1327.setEnabled(false);
      this.a("Items", this.field_1327);
      JPanel var2 = new JPanel();
      this.field_1328 = new JButton("Backup");
      this.field_1328.addActionListener(new class_232(this, var1));
      var2.add(this.field_1328);
      this.field_1329 = new JButton("Restore");
      this.field_1329.addActionListener(new class_231(this, var1));
      var2.add(this.field_1329);
      this.a(var2);
      this.field_1330 = new class_357(var1);
      this.b(this.field_1330);
   }

   // $VF: renamed from: w () void
   void method_1274() {
      this.field_1330.method_1102();
   }

   // $VF: renamed from: x () void
   void method_1275() {
      this.field_1330.method_1103();
   }

   // $VF: renamed from: y () void
   void method_1276() {
      this.field_1330.method_1104();
   }

   // $VF: renamed from: A () void
   void method_1277() {
      this.field_1330.method_1106();
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1278(class_70 var1) {
      this.field_1330.method_1101(var1);
   }

   // $VF: renamed from: Z () nomanssave.gm
   class_44 method_1279() {
      return this.field_1331;
   }

   // $VF: renamed from: c (nomanssave.gm) void
   void method_1280(class_44 var1) {
      if (var1 == null) {
         this.field_1331 = null;
         this.field_1320.setText("");
         this.field_1321.setSelectedIndex(-1);
         this.field_1321.updateUI();
         this.field_1322.setSelectedIndex(-1);
         this.field_1323.setText("");
         this.field_1324.setText("");
         this.field_1325.setText("");
         this.field_1326.setText("");
         this.field_1327.setText("");
         this.field_1328.setEnabled(false);
         this.field_1329.setEnabled(false);
         this.field_1330.method_1109(Collections.emptyList());
      } else {
         this.field_1331 = var1;
         this.field_1320.setText(var1.getName());
         this.field_1321.method_985(var1.method_254());
         this.field_1322.method_985(var1.method_260());
         this.field_1323.setText(var1.method_256());
         this.field_1324.setText(var1.method_258());
         this.field_1325.setText(Double.toString(var1.method_265()));
         this.field_1326.setText(Double.toString(var1.method_267()));
         class_43 var2 = var1.method_269();
         if (var2 == null) {
            this.field_1327.setText("");
            this.field_1328.setEnabled(false);
            this.field_1329.setEnabled(false);
         } else {
            this.field_1327.setText(Integer.toString(var2.method_250()));
            this.field_1328.setEnabled(true);
            this.field_1329.setEnabled(true);
         }

         this.field_1330.method_1109(var1.method_262());
      }
   }
}
