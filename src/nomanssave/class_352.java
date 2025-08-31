package nomanssave;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

// $VF: renamed from: nomanssave.dE
public class class_352 extends JPanel {
   // $VF: renamed from: hv nomanssave.ba
   private class_358 field_1143;
   // $VF: renamed from: hw nomanssave.ba
   private class_358 field_1144;
   // $VF: renamed from: hx javax.swing.JComboBox
   private JComboBox field_1145;
   // $VF: renamed from: hy nomanssave.G
   private class_374 field_1146;
   // $VF: renamed from: hz nomanssave.G
   private class_374 field_1147;
   // $VF: renamed from: ea nomanssave.G[]
   private class_374[] field_1148;
   // $VF: renamed from: hA javax.swing.JTable
   private JTable field_1149;
   // $VF: renamed from: hB nomanssave.dt
   private class_360 field_1150;
   // $VF: renamed from: hC nomanssave.gE[]
   private class_77[] field_1151;

   class_352(Application var1) {
      GridBagLayout var2 = new GridBagLayout();
      var2.columnWidths = new int[]{class_300.field_971, 0, 0};
      var2.rowHeights = new int[1];
      var2.columnWeights = new double[]{0.0, 0.0, 1.0};
      var2.rowWeights = new double[]{1.0};
      this.setLayout(var2);
      this.field_1143 = new class_358();
      GridBagConstraints var3 = new GridBagConstraints();
      var3.insets = new Insets(0, 0, 0, 0);
      var3.fill = 1;
      var3.gridx = 0;
      var3.gridy = 0;
      this.add(this.field_1143, var3);
      this.field_1145 = new JComboBox();
      this.field_1145.setModel(new class_184(this));
      this.field_1143.method_1143("Settlement", true, this.field_1145);
      this.field_1146 = new class_393(this);
      this.field_1143.method_1141("Name", this.field_1146);
      this.field_1147 = new class_392(this);
      this.field_1143.method_1145("Seed", this.field_1147);
      this.field_1143.method_1140();
      this.field_1143.method_1138("Stats");
      this.field_1148 = new class_374[class_293.values().length];

      for (int var4 = 0; var4 < this.field_1148.length; var4++) {
         this.field_1148[var4] = new class_391(this, class_293.values()[var4], null);
         this.field_1143.method_1141(class_293.values()[var4].toString(), this.field_1148[var4]);
      }

      this.field_1144 = new class_358();
      var3 = new GridBagConstraints();
      var3.insets = new Insets(0, 0, 0, 0);
      var3.fill = 1;
      var3.gridx = 2;
      var3.gridy = 0;
      this.add(this.field_1144, var3);
      this.field_1144.method_1138("Perks");
      JScrollPane var7 = new JScrollPane();
      this.field_1144.method_1146(var7);
      this.field_1149 = new JTable();
      this.field_1149.setCellSelectionEnabled(false);
      this.field_1149.setModel(new class_183(this));
      this.field_1149.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new class_332(this)));
      var7.setViewportView(this.field_1149);
      this.field_1150 = new class_360(var1);
      var3 = new GridBagConstraints();
      var3.insets = new Insets(0, 0, 0, 0);
      var3.fill = 1;
      var3.gridx = 1;
      var3.gridy = 0;
      this.add(this.field_1150, var3);
   }

   // $VF: renamed from: aN () nomanssave.gE[]
   class_77[] method_1024() {
      return this.field_1151;
   }

   // $VF: renamed from: a (nomanssave.gE[]) void
   void method_1025(class_77[] var1) {
      if (var1.length == 0) {
         this.field_1151 = new class_77[0];
         this.field_1145.setSelectedIndex(-1);
      } else {
         this.field_1151 = var1;
         this.field_1145.setSelectedIndex(0);
      }

      this.field_1145.updateUI();
   }
}
