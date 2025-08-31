package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bj
class class_232 implements ActionListener {
   class_232(class_370 var1, Application var2) {
      this.field_618 = var1;
      this.field_619 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_370.method_1281(this.field_618) != null) {
         this.field_619.method_1336(class_370.method_1281(this.field_618));
      }
   }
}
