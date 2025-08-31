package nomanssave;

import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.A
class class_431 implements Runnable {
   class_431(Application var1, String var2) {
      this.field_1493 = var1;
      this.field_1494 = var2;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      JOptionPane.showOptionDialog(Application.method_1388(this.field_1493), this.field_1494, "Warning", 0, 2, null, new Object[]{"OK"}, null);
   }
}
