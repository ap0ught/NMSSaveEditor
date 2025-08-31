package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.cl
public class class_338 extends JFileChooser {
   // $VF: renamed from: fG nomanssave.cl
   private static class_338 field_1123 = null;
   private static final String name = "Planetary Base Backup File";
   // $VF: renamed from: fH javax.swing.ImageIcon
   private static final ImageIcon field_1124 = Application.method_1325("UI-BASEICON.PNG", 16, 16);

   // $VF: renamed from: ar () nomanssave.cl
   public static class_338 method_1013() {
      if (field_1123 == null) {
         field_1123 = new class_338();
      }

      return field_1123;
   }

   private class_338() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new class_213(this));
      this.setFileFilter(new class_206(this));
      this.addChoosableFileFilter(new class_205(this));
      this.setDialogTitle("Choose Backup File");
      UIManager.addPropertyChangeListener(this::a);
   }
}
