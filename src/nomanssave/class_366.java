package nomanssave;

import javax.swing.JComboBox;

// $VF: renamed from: nomanssave.ep
public class class_366 extends class_365 {
   // $VF: renamed from: iw javax.swing.JComboBox
   private JComboBox field_1272 = new JComboBox();
   // $VF: renamed from: ix nomanssave.bO
   private class_357 field_1273;
   // $VF: renamed from: iy nomanssave.gO[]
   private class_68[] field_1274;

   class_366(Application var1) {
      this.field_1272.setModel(new class_129(this));
      this.a("Vehicle", true, this.field_1272);
      this.field_1273 = new class_357(var1);
      this.b(this.field_1273);
   }

   // $VF: renamed from: w () void
   void method_1209() {
      this.field_1273.method_1102();
   }

   // $VF: renamed from: x () void
   void method_1210() {
      this.field_1273.method_1103();
   }

   // $VF: renamed from: y () void
   void method_1211() {
      this.field_1273.method_1104();
   }

   // $VF: renamed from: A () void
   void method_1212() {
      this.field_1273.method_1106();
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1213(class_70 var1) {
      this.field_1273.method_1101(var1);
   }

   // $VF: renamed from: aT () nomanssave.gO[]
   class_68[] method_1214() {
      return this.field_1274;
   }

   // $VF: renamed from: a (nomanssave.gO[]) void
   void method_1215(class_68[] var1) {
      if (var1.length == 0) {
         this.field_1274 = new class_68[0];
         this.field_1272.setSelectedIndex(-1);
      } else {
         this.field_1274 = var1;
         this.field_1272.setSelectedIndex(0);
      }

      this.field_1272.updateUI();
   }
}
