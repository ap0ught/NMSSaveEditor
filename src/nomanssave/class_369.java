package nomanssave;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

// $VF: renamed from: nomanssave.dN
public class class_369 extends class_365 {
   // $VF: renamed from: cV int
   private static final int field_1294 = 500;
   // $VF: renamed from: cW int
   private static final int field_1295 = 200;
   // $VF: renamed from: gX double
   private static final double field_1296 = 1000.0;
   // $VF: renamed from: hI double
   private static final double field_1297 = 1000.0;
   // $VF: renamed from: dE double
   private static final double field_1298 = 1000.0;
   // $VF: renamed from: hJ double
   private static final double field_1299 = 1000.0;
   // $VF: renamed from: hK javax.swing.JComboBox
   private JComboBox field_1300 = new JComboBox();
   // $VF: renamed from: hL nomanssave.G
   private class_374 field_1301;
   // $VF: renamed from: hM nomanssave.cN
   private class_333 field_1302;
   // $VF: renamed from: hN nomanssave.cN
   private class_333 field_1303;
   // $VF: renamed from: hO nomanssave.G
   private class_374 field_1304;
   // $VF: renamed from: hP javax.swing.JCheckBox
   private JCheckBox field_1305;
   // $VF: renamed from: bQ javax.swing.JButton
   private JButton field_1306;
   // $VF: renamed from: bR javax.swing.JButton
   private JButton field_1307;
   // $VF: renamed from: bS javax.swing.JButton
   private JButton field_1308;
   // $VF: renamed from: hQ nomanssave.G
   private class_374 field_1309;
   // $VF: renamed from: hR nomanssave.G
   private class_374 field_1310;
   // $VF: renamed from: hS nomanssave.G
   private class_374 field_1311;
   // $VF: renamed from: hT nomanssave.G
   private class_374 field_1312;
   // $VF: renamed from: hU nomanssave.G
   private class_374 field_1313;
   // $VF: renamed from: hV nomanssave.G
   private class_374 field_1314;
   // $VF: renamed from: hW nomanssave.bO
   private class_357 field_1315;
   // $VF: renamed from: hX nomanssave.gH[]
   private class_75[] field_1316;
   // $VF: renamed from: hY nomanssave.gC
   private class_78 field_1317;

   class_369(Application var1) {
      this.field_1300.setModel(new class_181(this, var1));
      this.a("Ship", true, this.field_1300);
      this.field_1301 = new class_389(this);
      this.a("Name", this.field_1301);
      this.field_1302 = new class_333(gL.class);
      this.field_1302.method_986(this::a);
      this.a("Type", this.field_1302);
      this.field_1303 = new class_333(gN.class);
      this.field_1303.method_986(this::i);
      this.a("Class", this.field_1303);
      this.field_1304 = new class_388(this);
      this.a("Seed", this.field_1304);
      this.field_1305 = new JCheckBox("Use Old Colours");
      this.field_1305.setEnabled(false);
      this.field_1305.addActionListener(new class_177(this, var1));
      this.a(null, this.field_1305);
      this.k("Base Stats");
      this.field_1309 = new class_387(this);
      this.a("Health", this.field_1309);
      this.field_1310 = new class_386(this);
      this.a("Shield", this.field_1310);
      this.field_1311 = new class_385(this);
      this.a("Damage", this.field_1311);
      this.field_1312 = new class_384(this);
      this.a("Shields", this.field_1312);
      this.field_1313 = new class_378(this);
      this.a("Hyperdrive", this.field_1313);
      this.field_1314 = new class_390(this);
      this.a("Maneuverability", this.field_1314);
      this.Y();
      JPanel var2 = new JPanel();
      this.field_1306 = new JButton("Delete Ship");
      this.field_1306.addActionListener(new class_180(this, var1));
      var2.add(this.field_1306);
      this.field_1307 = new JButton("Export");
      this.field_1307.addActionListener(new class_179(this, var1));
      var2.add(this.field_1307);
      this.field_1308 = new JButton("Import");
      this.field_1308.addActionListener(new class_178(this, var1));
      var2.add(this.field_1308);
      this.a(var2);
      this.field_1315 = new class_357(var1);
      this.b(this.field_1315);
   }

   // $VF: renamed from: w () void
   void method_1242() {
      for (int var1 = 0; var1 < this.field_1316.length; var1++) {
         this.field_1316[var1].method_444().stream().forEach(this::c);
      }
   }

   // $VF: renamed from: x () void
   void method_1243() {
      for (int var1 = 0; var1 < this.field_1316.length; var1++) {
         this.field_1316[var1].method_444().stream().forEach(this::d);
      }
   }

   // $VF: renamed from: y () void
   void method_1244() {
      for (int var1 = 0; var1 < this.field_1316.length; var1++) {
         this.field_1316[var1].method_444().stream().forEach(this::e);
      }
   }

   // $VF: renamed from: z () void
   void method_1245() {
      for (int var1 = 0; var1 < this.field_1316.length; var1++) {
         this.field_1316[var1].method_444().stream().forEach(this::f);
      }
   }

   // $VF: renamed from: A () void
   void method_1246() {
      for (int var1 = 0; var1 < this.field_1316.length; var1++) {
         this.field_1316[var1].method_444().stream().forEach(this::g);
      }
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1247(class_70 var1) {
      this.field_1315.method_1101(var1);
   }

   // $VF: renamed from: aO () nomanssave.gH[]
   class_75[] method_1248() {
      return this.field_1316;
   }

   // $VF: renamed from: a (nomanssave.gH[], nomanssave.gC) void
   void method_1249(class_75[] var1, class_78 var2) {
      this.field_1316 = var1;
      this.field_1317 = var2;
      if (var1.length == 0) {
         this.field_1300.setSelectedIndex(-1);
      } else {
         int var3 = var2 == null ? 0 : var2.method_475();
         if (var3 >= var1.length) {
            var3 = 0;
         }

         this.field_1300.setSelectedIndex(var3);
      }

      if (var2 == null) {
         this.field_1309.setText("");
         this.field_1310.setText("");
      } else {
         this.field_1309.setText(Long.toString((long)var2.method_477()));
         this.field_1310.setText(Long.toString((long)var2.method_479()));
      }

      this.field_1300.updateUI();
   }
}
