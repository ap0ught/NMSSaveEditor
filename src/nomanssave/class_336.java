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

// $VF: renamed from: nomanssave.cs
public class class_336 extends JFileChooser {
   // $VF: renamed from: fN nomanssave.cs
   private static class_336 field_1117 = null;
   private static final String name = "Freighter Backup File";
   // $VF: renamed from: fH javax.swing.ImageIcon
   private static final ImageIcon field_1118 = Application.method_1325("UI-FREIGHTERICON.PNG", 16, 16);
   // $VF: renamed from: fO javax.swing.JCheckBox
   private JCheckBox field_1119;

   // $VF: renamed from: av () nomanssave.cs
   public static class_336 method_1005() {
      if (field_1117 == null) {
         field_1117 = new class_336();
      }

      return field_1117;
   }

   private class_336() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new class_211(this));
      this.setFileFilter(new class_203(this));
      this.setDialogTitle("Choose Backup File");
      JPanel var1 = new JPanel();
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2));
      var1.add(new JLabel("Export Options:"));
      this.field_1119 = new JCheckBox("Products/Substances");
      var1.add(this.field_1119);
      this.setAccessory(var1);
      UIManager.addPropertyChangeListener(this::a);
   }

   // $VF: renamed from: aw () boolean
   public boolean method_1006() {
      return this.field_1119.isSelected();
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
