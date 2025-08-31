package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

// $VF: renamed from: nomanssave.bl
public class class_355 extends JPanel implements class_2 {
   // $VF: renamed from: dQ int
   private static final int field_1169 = 50;
   // $VF: renamed from: dR javax.swing.JTable
   private JTable field_1170;
   // $VF: renamed from: bQ javax.swing.JButton
   private JButton field_1171;
   // $VF: renamed from: dS javax.swing.JButton
   private JButton field_1172;
   // $VF: renamed from: dT nomanssave.ba
   private class_358 field_1173;
   // $VF: renamed from: dU nomanssave.G
   private class_374 field_1174;
   // $VF: renamed from: dV javax.swing.JComboBox
   private JComboBox field_1175;
   // $VF: renamed from: dW javax.swing.JTextField
   private JTextField field_1176;
   // $VF: renamed from: dX nomanssave.cN
   private class_333 field_1177;
   // $VF: renamed from: dY nomanssave.G
   private class_374 field_1178;
   // $VF: renamed from: dZ nomanssave.G
   private class_374 field_1179;
   // $VF: renamed from: ea nomanssave.G[]
   private class_374[] field_1180;
   // $VF: renamed from: eb nomanssave.ba
   private class_358 field_1181;
   // $VF: renamed from: ec javax.swing.JComboBox
   private JComboBox field_1182;
   // $VF: renamed from: ed javax.swing.JComboBox
   private JComboBox field_1183;
   // $VF: renamed from: ee javax.swing.JComboBox
   private JComboBox field_1184;
   // $VF: renamed from: ef javax.swing.JComboBox
   private JComboBox field_1185;
   // $VF: renamed from: eg javax.swing.JComboBox
   private JComboBox field_1186;
   // $VF: renamed from: eh nomanssave.G
   private class_374 field_1187;
   // $VF: renamed from: ei nomanssave.G
   private class_374 field_1188;
   // $VF: renamed from: ej nomanssave.G
   private class_374 field_1189;
   // $VF: renamed from: ek nomanssave.G
   private class_374 field_1190;
   // $VF: renamed from: el javax.swing.JLabel
   private JLabel field_1191;
   // $VF: renamed from: em javax.swing.JButton
   private JButton field_1192;
   // $VF: renamed from: en nomanssave.er[]
   private class_128[] field_1193;
   // $VF: renamed from: eo nomanssave.er[]
   private class_128[] field_1194;
   // $VF: renamed from: ep nomanssave.gp[]
   private class_42[] field_1195;
   // $VF: renamed from: eq int
   private int field_1196;

   class_355(Application var1) {
      GridLayout var2 = new GridLayout(1, 3);
      this.setLayout(var2);
      JScrollPane var3 = new JScrollPane();
      var3.setMinimumSize(new Dimension(300, 0));
      var3.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
      var3.setPreferredSize(new Dimension(300, 0));
      JPanel var4 = new JPanel();
      var4.setLayout(new BorderLayout());
      var4.add(var3, "Center");
      JPanel var5 = new JPanel();
      this.field_1171 = new JButton("Delete");
      this.field_1171.setEnabled(false);
      this.field_1171.addActionListener(new class_230(this, var1));
      var5.add(this.field_1171);
      this.field_1172 = new JButton("Copy");
      this.field_1172.setEnabled(false);
      this.field_1172.addActionListener(new class_229(this, var1));
      var5.add(this.field_1172);
      var4.add(var5, "South");
      this.add(var4);
      this.field_1170 = new JTable();
      this.field_1170.setSelectionMode(0);
      this.field_1170.setModel(new class_228(this));
      this.field_1170.getColumnModel().getColumn(2).setMaxWidth(60);
      this.field_1170.getSelectionModel().addListSelectionListener(new class_227(this, var1));
      var3.setViewportView(this.field_1170);
      this.field_1173 = new class_358(class_300.field_972, 0);
      this.field_1173.setVisible(false);
      this.add(this.field_1173);
      this.field_1173.method_1138("Frigate Info");
      this.field_1174 = new class_398(this);
      this.field_1173.method_1141("Name", this.field_1174);
      this.field_1175 = new JComboBox();
      this.field_1175.setModel(new class_225(this));
      this.field_1173.method_1141("Type", this.field_1175);
      this.field_1176 = new JTextField();
      this.field_1176.setEditable(false);
      this.field_1173.method_1141("Class", this.field_1176);
      this.field_1177 = new class_333(gd.class);
      this.field_1177.method_986(this::h);
      this.field_1173.method_1141("NPC Race", this.field_1177);
      this.field_1178 = new class_397(this);
      this.field_1173.method_1141("Home Seed", this.field_1178);
      this.field_1179 = new class_396(this);
      this.field_1173.method_1145("Model Seed", this.field_1179);
      this.field_1173.method_1138("Traits");
      class_347 var6 = new class_347(this, null);
      this.field_1182 = new JComboBox();
      this.field_1182.setModel(new class_252(this, null));
      this.field_1182.setRenderer(var6);
      this.field_1173.method_1146(this.field_1182);
      this.field_1183 = new JComboBox();
      this.field_1183.setModel(new class_251(this, 1));
      this.field_1183.setRenderer(var6);
      this.field_1173.method_1146(this.field_1183);
      this.field_1184 = new JComboBox();
      this.field_1184.setModel(new class_251(this, 2));
      this.field_1184.setRenderer(var6);
      this.field_1173.method_1146(this.field_1184);
      this.field_1185 = new JComboBox();
      this.field_1185.setModel(new class_251(this, 3));
      this.field_1185.setRenderer(var6);
      this.field_1173.method_1146(this.field_1185);
      this.field_1186 = new JComboBox();
      this.field_1186.setModel(new class_251(this, 4));
      this.field_1186.setRenderer(var6);
      this.field_1173.method_1146(this.field_1186);
      this.field_1173.method_1140();
      JPanel var7 = new JPanel();
      var7.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.GLUE_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.GLUE_COLSPEC},
            new RowSpec[]{FormFactory.DEFAULT_ROWSPEC, FormFactory.DEFAULT_ROWSPEC}
         )
      );
      this.field_1191 = new JLabel("");
      var7.add(this.field_1191, "2,1");
      this.field_1192 = new JButton("Repair");
      this.field_1192.addActionListener(new class_224(this));
      JPanel var8 = new JPanel();
      var8.add(this.field_1192);
      var7.add(var8, "2,2");
      this.field_1173.method_1146(var7);
      this.field_1181 = new class_358(class_300.field_972, 0);
      this.field_1181.setVisible(false);
      this.add(this.field_1181);
      this.field_1181.method_1138("Stats");
      this.field_1180 = new class_374[class_285.values().length];

      for (int var9 = 0; var9 < this.field_1180.length; var9++) {
         this.field_1180[var9] = new class_409(this, var9, null);
         this.field_1181.method_1141(class_285.values()[var9].toString(), this.field_1180[var9]);
      }

      this.field_1181.method_1140();
      this.field_1181.method_1138("Totals");
      this.field_1187 = new class_402(this);
      this.field_1181.method_1141("Expeditions", this.field_1187);
      this.field_1188 = new class_401(this);
      this.field_1181.method_1141("Successful", this.field_1188);
      this.field_1189 = new class_400(this);
      this.field_1181.method_1141("Failed", this.field_1189);
      this.field_1190 = new class_399(this);
      this.field_1181.method_1141("Damaged", this.field_1190);
      class_130.method_680(this);
   }

   // $VF: renamed from: a (boolean) void
   @Override
   public void method_2(boolean var1) {
      if (this.field_1170.getSelectedRow() >= 0) {
         this.field_1172.setEnabled(this.field_1195.length < 30 || class_130.method_681());
      }
   }

   // $VF: renamed from: a (nomanssave.gp[]) void
   void method_1054(class_42[] var1) {
      this.field_1195 = var1;
      this.field_1193 = null;
      this.field_1194 = null;
      this.field_1170.clearSelection();
      if (var1.length > 0) {
         this.field_1170.setRowSelectionInterval(0, 0);
      }

      this.field_1170.updateUI();
   }
}
