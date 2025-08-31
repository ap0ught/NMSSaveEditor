package nomanssave;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// $VF: renamed from: nomanssave.aD
public class class_328 extends JDialog {
   // $VF: renamed from: cw javax.swing.JComboBox
   private JComboBox field_1087;
   // $VF: renamed from: cx javax.swing.JTextField
   private JTextField field_1088;
   // $VF: renamed from: cy boolean
   private boolean field_1089;
   // $VF: renamed from: cz nomanssave.aD
   public static class_328 field_1090 = null;

   private class_328(Frame var1) {
      super(var1);
      this.setMinimumSize(new Dimension(400, 10));
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Editor Settings");
      this.setModal(true);
      class_358 var2 = new class_358();
      this.field_1087 = new JComboBox();
      this.field_1087.setModel(new class_303(this));
      var2.method_1141("Look & Feel", this.field_1087);
      this.field_1088 = new JTextField();
      var2.method_1141("Inventory Scale", this.field_1088);
      var2.method_1140();
      JPanel var3 = new JPanel();
      var2.method_1146(var3);
      JButton var4 = new JButton("Apply");
      var4.addActionListener(new class_302(this));
      var3.add(var4);
      JButton var5 = new JButton("Cancel");
      var5.addActionListener(new class_301(this));
      var3.add(var5);
      this.setContentPane(var2);
      this.pack();
   }

   // $VF: renamed from: S () boolean
   private boolean method_969() {
      String var1 = class_300.getProperty("LookAndFeel");
      class_299 var2 = Stream.of(class_299.values()).filter(aD::a).findFirst().orElse(class_299.field_957);
      this.field_1087.setSelectedItem(var2);
      this.field_1088.setText(Double.toString(class_300.method_861("InventoryScaling", 1.0)));
      this.setLocationRelativeTo(this.getParent());
      this.field_1089 = false;
      this.setVisible(true);
      return this.field_1089;
   }

   // $VF: renamed from: d (java.awt.Container) boolean
   public static boolean method_970(Container var0) {
      if (field_1090 == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         field_1090 = new class_328(var1);
      }

      return field_1090.method_969();
   }
}
