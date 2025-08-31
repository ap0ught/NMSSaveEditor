package nomanssave;

import java.util.Collections;

// $VF: renamed from: nomanssave.aJ
public class class_371 extends class_365 {
   // $VF: renamed from: cV int
   private static final int field_1332 = 200;
   // $VF: renamed from: cW int
   private static final int field_1333 = 100;
   // $VF: renamed from: cX int
   private static final int field_1334 = 100;
   // $VF: renamed from: cY long
   private static final long field_1335 = 4294967295L;
   // $VF: renamed from: cZ long
   private static final long field_1336 = 4294967295L;
   // $VF: renamed from: da long
   private static final long field_1337 = 4294967295L;
   // $VF: renamed from: db nomanssave.G
   private class_374 field_1338;
   // $VF: renamed from: dc nomanssave.G
   private class_374 field_1339;
   // $VF: renamed from: dd nomanssave.G
   private class_374 field_1340;
   // $VF: renamed from: de nomanssave.G
   private class_374 field_1341;
   // $VF: renamed from: df nomanssave.G
   private class_374 field_1342;
   // $VF: renamed from: dg nomanssave.G
   private class_374 field_1343;
   // $VF: renamed from: dh nomanssave.bO
   private class_357 field_1344;
   // $VF: renamed from: di nomanssave.gz
   private class_38 field_1345;

   class_371(Application var1) {
      this.k("Main Stats");
      this.field_1341 = new class_420(this);
      this.a("Health", this.field_1341);
      this.field_1342 = new class_419(this);
      this.a("Shield", this.field_1342);
      this.field_1343 = new class_418(this);
      this.a("Energy", this.field_1343);
      this.field_1338 = new class_417(this, var1);
      this.a("Units", this.field_1338);
      this.field_1339 = new class_416(this);
      this.a("Nanites", this.field_1339);
      this.field_1340 = new class_415(this);
      this.a("Quicksilver", this.field_1340);
      this.field_1344 = new class_357(var1);
      this.b(this.field_1344);
   }

   // $VF: renamed from: w () void
   void method_1286() {
      this.field_1344.method_1102();
   }

   // $VF: renamed from: x () void
   void method_1287() {
      this.field_1344.method_1103();
   }

   // $VF: renamed from: y () void
   void method_1288() {
      this.field_1344.method_1104();
   }

   // $VF: renamed from: A () void
   void method_1289() {
      this.field_1344.method_1106();
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1290(class_70 var1) {
      this.field_1344.method_1101(var1);
   }

   // $VF: renamed from: X () nomanssave.gz
   class_38 method_1291() {
      return this.field_1345;
   }

   // $VF: renamed from: a (nomanssave.gz) void
   void method_1292(class_38 var1) {
      if (var1 == null) {
         this.field_1345 = null;
         this.field_1338.setText("");
         this.field_1339.setText("");
         this.field_1340.setText("");
         this.field_1341.setText("");
         this.field_1342.setText("");
         this.field_1343.setText("");
         this.field_1344.method_1109(Collections.emptyList());
      } else {
         this.field_1345 = var1;
         this.field_1338.setText(Long.toString(var1.method_163()));
         this.field_1339.setText(Long.toString(var1.method_165()));
         this.field_1340.setText(Long.toString(var1.method_167()));
         this.field_1341.setText(Integer.toString(var1.method_169()));
         this.field_1342.setText(Integer.toString(var1.method_171()));
         this.field_1343.setText(Integer.toString(var1.method_173()));
         this.field_1344.method_1109(var1.method_175());
      }
   }
}
