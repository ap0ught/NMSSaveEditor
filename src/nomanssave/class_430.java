package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.B
class class_430 extends WindowAdapter {
   class_430(Application var1) {
      this.field_1424 = var1;
   }

   @Override
   public void windowClosing(WindowEvent var1) {
      if (Application.method_1390(this.field_1424) || Application.method_1391(this.field_1424)) {
         int var2 = JOptionPane.showConfirmDialog(Application.method_1388(this.field_1424), "Save data before closing?", "Save", 0);
         if (var2 == 0) {
            if (Application.method_1390(this.field_1424)) {
               Application.method_1392(this.field_1424);
            }

            if (Application.method_1391(this.field_1424)) {
               Application.method_1393(this.field_1424);
            }
         }
      }

      if (class_300.method_865()) {
         class_300.method_866();
      }

      Application.method_1388(this.field_1424).dispose();
   }

   @Override
   public void windowDeactivated(WindowEvent var1) {
      Application.method_1394(this.field_1424, true);
   }

   @Override
   public void windowActivated(WindowEvent var1) {
      Application.method_1394(this.field_1424, false);
      Application.method_1395(this.field_1424);
   }
}
