package nomanssave;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

// $VF: renamed from: nomanssave.ec
class class_359 extends class_358 {
   private final int index;
   // $VF: renamed from: if javax.swing.JCheckBox
   private JCheckBox field_1232;
   // $VF: renamed from: ig javax.swing.JComboBox
   private JComboBox field_1233;
   // $VF: renamed from: bj nomanssave.G
   private class_374 field_1234;
   // $VF: renamed from: ih javax.swing.JComboBox
   private JComboBox field_1235;
   // $VF: renamed from: hO nomanssave.G
   private class_374 field_1236;
   // $VF: renamed from: ii nomanssave.G
   private class_374 field_1237;

   class_359(class_367 var1, int var2) {
      super(class_300.field_970, class_300.field_970 * 2);
      this.field_1238 = var1;
      this.index = var2;
      this.k("Wingman " + (var2 + 1));
      this.field_1232 = new JCheckBox("Enabled");
      this.field_1232.addActionListener(new class_133(this, var2));
      this.a(null, this.field_1232);
      this.setBorder(new LineBorder(Color.DARK_GRAY));
      this.field_1233 = new JComboBox();
      this.field_1233.setModel(new class_132(this, var2));
      this.a("NPC Race", this.field_1233);
      this.field_1234 = new class_377(this, var2);
      this.a("NPC Seed", this.field_1234);
      this.field_1235 = new JComboBox();
      this.field_1235.setModel(new class_131(this, var2));
      this.a("Ship Type", this.field_1235);
      this.field_1236 = new class_376(this, var2);
      this.a("Ship Seed", this.field_1236);
      this.field_1237 = new class_375(this, var2);
      this.a("Pilot Rank", this.field_1237);
   }

   // $VF: renamed from: aQ () void
   private void method_1147() {
      this.field_1232.setSelected(class_367.method_1219(this.field_1238)[this.index].isEnabled());
      this.field_1233.setEnabled(class_367.method_1219(this.field_1238)[this.index].isEnabled());
      this.field_1233.setSelectedItem(class_367.method_1219(this.field_1238)[this.index].method_374());
      this.field_1234.setEnabled(class_367.method_1219(this.field_1238)[this.index].isEnabled());
      this.field_1234.setText(class_367.method_1219(this.field_1238)[this.index].method_376());
      this.field_1235.setEnabled(class_367.method_1219(this.field_1238)[this.index].isEnabled());
      this.field_1235.setSelectedItem(class_367.method_1219(this.field_1238)[this.index].method_378());
      this.field_1236.setEnabled(class_367.method_1219(this.field_1238)[this.index].isEnabled());
      this.field_1236.setText(class_367.method_1219(this.field_1238)[this.index].method_380());
      this.field_1237.setEnabled(class_367.method_1219(this.field_1238)[this.index].isEnabled());
      this.field_1237.setText(Integer.toString(class_367.method_1219(this.field_1238)[this.index].method_382()));
   }
}
