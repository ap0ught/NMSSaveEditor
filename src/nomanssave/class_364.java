package nomanssave;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

// $VF: renamed from: nomanssave.X
public class class_364 extends JPanel {
   // $VF: renamed from: bG javax.swing.JComboBox
   private JComboBox field_1257;
   // $VF: renamed from: bH javax.swing.JComboBox
   private JComboBox field_1258;
   // $VF: renamed from: bI nomanssave.G
   private class_374 field_1259;
   // $VF: renamed from: bJ nomanssave.G
   private class_374 field_1260;
   // $VF: renamed from: bK nomanssave.G
   private class_374 field_1261;
   // $VF: renamed from: bL nomanssave.G
   private class_374 field_1262;
   // $VF: renamed from: bM nomanssave.G
   private class_374 field_1263;
   // $VF: renamed from: bN javax.swing.JCheckBox
   private JCheckBox field_1264;
   // $VF: renamed from: bO nomanssave.cN
   private class_333 field_1265;
   // $VF: renamed from: bP nomanssave.cN
   private class_333 field_1266;
   // $VF: renamed from: bQ javax.swing.JButton
   private JButton field_1267;
   // $VF: renamed from: bR javax.swing.JButton
   private JButton field_1268;
   // $VF: renamed from: bS javax.swing.JButton
   private JButton field_1269;
   // $VF: renamed from: bT nomanssave.gj[]
   private class_45[] field_1270;

   class_364(Application var1) {
      GridLayout var2 = new GridLayout(1, 3);
      this.setLayout(var2);
      class_358 var3 = new class_358(class_300.field_972, 0);
      this.add(var3);
      this.add(new JPanel());
      this.add(new JPanel());
      this.field_1257 = new JComboBox();
      this.field_1257.setModel(new class_305(this));
      var3.method_1143("Companion", true, this.field_1257);
      this.field_1258 = new JComboBox();
      this.field_1258.setModel(new class_271(this));
      this.field_1258.setEnabled(false);
      var3.method_1141("Type", this.field_1258);
      this.field_1259 = new class_414(this);
      var3.method_1141("Name", this.field_1259);
      this.field_1260 = new class_413(this);
      var3.method_1145("Creature Seed", this.field_1260);
      this.field_1261 = new class_412(this);
      var3.method_1141("Secondary Seed", this.field_1261);
      this.field_1262 = new class_411(this);
      var3.method_1141("Species Seed", this.field_1262);
      this.field_1263 = new class_410(this);
      var3.method_1141("Genus Seed", this.field_1263);
      this.field_1264 = new JCheckBox("Predator");
      this.field_1264.setEnabled(false);
      this.field_1264.addActionListener(new class_270(this));
      var3.method_1141(null, this.field_1264);
      this.field_1265 = new class_333(gi.class);
      this.field_1265.method_986(this::h);
      var3.method_1141("Biome", this.field_1265);
      this.field_1266 = new class_333(gk.class);
      this.field_1266.method_986(this::i);
      var3.method_1141("Type", this.field_1266);
      var3.method_1140();
      JPanel var4 = new JPanel();
      this.field_1267 = new JButton("Delete");
      this.field_1267.addActionListener(new class_269(this, var1));
      var4.add(this.field_1267);
      this.field_1268 = new JButton("Export");
      this.field_1268.addActionListener(new class_304(this, var1));
      var4.add(this.field_1268);
      this.field_1269 = new JButton("Import");
      this.field_1269.addActionListener(new class_272(this, var1));
      var4.add(this.field_1269);
      var3.method_1146(var4);
   }

   // $VF: renamed from: a (nomanssave.gj[]) void
   void method_1187(class_45[] var1) {
      this.field_1270 = var1;
      if (var1.length == 0) {
         this.field_1257.setSelectedIndex(-1);
      } else {
         this.field_1257.setSelectedIndex(0);
      }

      this.field_1257.updateUI();
   }
}
