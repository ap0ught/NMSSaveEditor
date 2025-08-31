package nomanssave;

import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

// $VF: renamed from: nomanssave.I
public class class_372 extends class_365 {
   // $VF: renamed from: bh javax.swing.JComboBox
   private JComboBox field_1346 = new JComboBox();
   // $VF: renamed from: bi javax.swing.JTextField
   private JTextField field_1347;
   // $VF: renamed from: bj nomanssave.G
   private class_374 field_1348;
   // $VF: renamed from: bk javax.swing.JComboBox
   private JComboBox field_1349;
   // $VF: renamed from: bl nomanssave.G
   private class_374 field_1350;
   // $VF: renamed from: bm javax.swing.JTextField
   private JTextField field_1351;
   // $VF: renamed from: bn javax.swing.JButton
   private JButton field_1352;
   // $VF: renamed from: bo javax.swing.JButton
   private JButton field_1353;
   // $VF: renamed from: bp javax.swing.JButton
   private JButton field_1354;
   // $VF: renamed from: bq nomanssave.bO
   private class_357 field_1355;
   // $VF: renamed from: br nomanssave.ge
   private class_49 field_1356;

   class_372(Application var1) {
      this.field_1346.setModel(new class_316(this));
      this.a("Base NPC", true, this.field_1346);
      this.field_1347 = new JTextField();
      this.field_1347.setEnabled(false);
      this.a("Race", this.field_1347);
      this.field_1348 = new class_422(this);
      this.field_1348.setEnabled(false);
      this.a("Seed", this.field_1348);
      this.Y();
      this.field_1349 = new JComboBox();
      this.field_1349.setModel(new class_315(this));
      this.a("Base Info", true, this.field_1349);
      this.field_1350 = new class_421(this);
      this.a("Name", this.field_1350);
      this.field_1351 = new JTextField();
      this.field_1351.setEnabled(false);
      this.a("Items", this.field_1351);
      JPanel var2 = new JPanel();
      this.field_1352 = new JButton("Backup");
      this.field_1352.addActionListener(new class_314(this, var1));
      var2.add(this.field_1352);
      this.field_1353 = new JButton("Restore");
      this.field_1353.addActionListener(new class_313(this, var1));
      var2.add(this.field_1353);
      this.field_1354 = new JButton("Move Base Computer");
      this.field_1354.addActionListener(new class_312(this, var1));
      var2.add(this.field_1354);
      this.a(var2);
      this.field_1355 = new class_357(var1);
      this.b(this.field_1355);
   }

   // $VF: renamed from: w () void
   void method_1294() {
      this.field_1355.method_1102();
   }

   // $VF: renamed from: x () void
   void method_1295() {
      this.field_1355.method_1103();
   }

   // $VF: renamed from: y () void
   void method_1296() {
      this.field_1355.method_1104();
   }

   // $VF: renamed from: A () void
   void method_1297() {
      this.field_1355.method_1106();
   }

   // $VF: renamed from: a (nomanssave.gt) void
   void method_1298(class_70 var1) {
      this.field_1355.method_1101(var1);
   }

   // $VF: renamed from: O () nomanssave.ge
   class_49 method_1299() {
      return this.field_1356;
   }

   // $VF: renamed from: a (nomanssave.ge) void
   void method_1300(class_49 var1) {
      this.field_1356 = var1;
      List var2;
      if (var1 == null) {
         var2 = Collections.emptyList();
         this.field_1346.setSelectedIndex(-1);
         this.field_1349.setSelectedIndex(-1);
      } else {
         var2 = var1.method_304();
         this.field_1346.setSelectedIndex(var1.method_305().size() == 0 ? -1 : 0);
         this.field_1349.setSelectedIndex(var1.method_306().size() == 0 ? -1 : 0);
      }

      this.field_1346.updateUI();
      this.field_1349.updateUI();
      this.field_1355.method_1109(var2);
   }
}
