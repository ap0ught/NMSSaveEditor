package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.cp
public class class_337 extends JFileChooser {
   // $VF: renamed from: fJ nomanssave.cp
   private static class_337 field_1120 = null;
   private static final String name = "Companion Export File";
   // $VF: renamed from: fK javax.swing.ImageIcon
   private static final ImageIcon field_1121 = Application.method_1325("UI-PET.PNG", 16, 16);
   // $VF: renamed from: fL javax.swing.ImageIcon
   private static final ImageIcon field_1122 = Application.method_1325("UI-EGG.PNG", 16, 16);

   // $VF: renamed from: at () nomanssave.cp
   public static class_337 method_1009() {
      if (field_1120 == null) {
         field_1120 = new class_337();
      }

      return field_1120;
   }

   private class_337() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new class_212(this));
      this.setFileFilter(new class_204(this));
      this.setDialogTitle("Choose Companion Export File");
      UIManager.addPropertyChangeListener(this::a);
   }
}
