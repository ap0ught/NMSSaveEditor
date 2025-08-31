package nomanssave;

import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.z
class class_14 implements Runnable {
   class_14(Application var1, String var2) {
      this.field_54 = var1;
      this.field_55 = var2;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      JOptionPane.showOptionDialog(Application.method_1388(this.field_54), this.field_55, "Error", 0, 0, null, new Object[]{"Cancel"}, null);
   }
}
