package nomanssave;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.cT
public class class_339 extends JFileChooser {
   // $VF: renamed from: gv nomanssave.cT
   private static class_339 field_1125 = null;
   private static final String name = "Ship Export File";
   // $VF: renamed from: fH javax.swing.ImageIcon
   private static final ImageIcon field_1126 = Application.method_1325("UI-SHIPICON.PNG", 16, 16);
   // $VF: renamed from: fO javax.swing.JCheckBox
   private JCheckBox field_1127;

   // $VF: renamed from: aC () nomanssave.cT
   public static class_339 method_1016() {
      if (field_1125 == null) {
         field_1125 = new class_339();
      }

      return field_1125;
   }

   private class_339() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new class_214(this));
      this.setFileFilter(new class_207(this));
      this.setDialogTitle("Choose Ship Export File");
      JPanel var1 = new JPanel();
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2));
      var1.add(new JLabel("Export Options:"));
      this.field_1127 = new JCheckBox("Products/Substances");
      var1.add(this.field_1127);
      this.setAccessory(var1);
      UIManager.addPropertyChangeListener(this::a);
   }

   // $VF: renamed from: aw () boolean
   public boolean method_1017() {
      return this.field_1127.isSelected();
   }

   @Override
   public int showSaveDialog(Component var1) {
      this.getAccessory().setVisible(true);
      return super.showSaveDialog(var1);
   }

   @Override
   public int showOpenDialog(Component var1) {
      this.getAccessory().setVisible(false);
      return super.showOpenDialog(var1);
   }
}
