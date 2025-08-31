package nomanssave;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

// $VF: renamed from: nomanssave.dj
public class class_368 extends class_365 {
   // $VF: renamed from: gX double
   private static final double field_1278 = 1000.0;
   // $VF: renamed from: gY double
   private static final double field_1279 = 1000.0;
   // $VF: renamed from: gZ double
   private static final double field_1280 = 1000.0;
   // $VF: renamed from: ha javax.swing.JComboBox
   private JComboBox field_1281 = new JComboBox();
   // $VF: renamed from: hb nomanssave.G
   private class_374 field_1282;
   // $VF: renamed from: hc nomanssave.cN
   private class_333 field_1283;
   // $VF: renamed from: hd nomanssave.cN
   private class_333 field_1284;
   // $VF: renamed from: he nomanssave.G
   private class_374 field_1285;
   // $VF: renamed from: hf nomanssave.G
   private class_374 field_1286;
   // $VF: renamed from: hg nomanssave.G
   private class_374 field_1287;
   // $VF: renamed from: hh nomanssave.G
   private class_374 field_1288;
   // $VF: renamed from: bQ javax.swing.JButton
   private JButton field_1289;
   // $VF: renamed from: bR javax.swing.JButton
   private JButton field_1290;
   // $VF: renamed from: bS javax.swing.JButton
   private JButton field_1291;
   // $VF: renamed from: hi nomanssave.bO
   private class_357 field_1292;
   // $VF: renamed from: hj nomanssave.gv[]
   private class_39[] field_1293;

   class_368(Application var1) {
      this.field_1281.setModel(new class_169(this));
      this.a("Multitool", true, this.field_1281);
      this.field_1282 = new class_383(this);
      this.a("Name", this.field_1282);
      this.field_1283 = new class_333(gx.class);
      this.field_1283.method_986(this::h);
      this.a("Type", this.field_1283);
      this.field_1284 = new class_333(gN.class);
      this.field_1284.method_986(this::i);
      this.a("Class", this.field_1284);
      this.field_1285 = new class_382(this);
      this.a("Seed", this.field_1285);
      this.k("Base Stats");
      this.field_1286 = new class_381(this);
      this.a("Damage", this.field_1286);
      this.field_1287 = new class_380(this);
      this.a("Mining", this.field_1287);
      this.field_1288 = new class_379(this);
      this.a("Scan", this.field_1288);
      this.Y();
      JPanel var2 = new JPanel();
      this.field_1289 = new JButton("Delete Multitool");
      this.field_1289.addActionListener(new class_168(this, var1));
      var2.add(this.field_1289);
      this.field_1290 = new JButton("Export");
      this.field_1290.addActionListener(new class_167(this, var1));
      var2.add(this.field_1290);
      this.field_1291 = new JButton("Import");
      this.field_1291.addActionListener(new class_166(this, var1));
      var2.add(this.field_1291);
      this.a(var2);
      this.field_1292 = new class_357(var1);
      this.b(this.field_1292);
   }

   // $VF: renamed from: w () void
   void method_1221() {
      this.field_1292.method_1102();
   }

   // $VF: renamed from: x () void
   void method_1222() {
      this.field_1292.method_1103();
   }

   // $VF: renamed from: y () void
   void method_1223() {
      this.field_1292.method_1104();
   }

   // $VF: renamed from: z () void
   void method_1224() {
      this.field_1292.method_1105();
   }

   // $VF: renamed from: A () void
   void method_1225() {
      this.field_1292.method_1106();
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1226(class_70 var1) {
      this.field_1292.method_1101(var1);
   }

   // $VF: renamed from: aK () nomanssave.gv[]
   class_39[] method_1227() {
      return this.field_1293;
   }

   // $VF: renamed from: a (nomanssave.gv[], nomanssave.gB) void
   void method_1228(class_39[] var1, class_79 var2) {
      this.field_1293 = var1;
      if (var1.length == 0) {
         this.field_1281.setSelectedIndex(-1);
      } else {
         int var3 = var2 == null ? 0 : var2.method_482();
         if (var3 >= var1.length) {
            var3 = 0;
         }

         this.field_1281.setSelectedIndex(var3);
      }

      this.field_1281.updateUI();
   }
}
