package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.cv
public class class_335 extends JFileChooser {
   // $VF: renamed from: fQ nomanssave.cv
   private static class_335 field_1115 = null;
   private static final String name = "Weapon Export File";
   // $VF: renamed from: fH javax.swing.ImageIcon
   private static final ImageIcon field_1116 = Application.method_1325("UI-WEAPONICON.PNG", 16, 16);

   // $VF: renamed from: ax () nomanssave.cv
   public static class_335 method_1002() {
      if (field_1115 == null) {
         field_1115 = new class_335();
      }

      return field_1115;
   }

   private class_335() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new class_210(this));
      this.setFileFilter(new class_202(this));
      this.setDialogTitle("Choose Weapon Export File");
      UIManager.addPropertyChangeListener(this::a);
   }
}
