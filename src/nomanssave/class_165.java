package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dv
class class_165 implements ActionListener {
   class_165(class_351 var1, class_76 var2) {
      this.field_519 = var1;
      this.field_520 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (this.field_520 != null) {
         class_323.method_932(class_351.method_1023(this.field_519), this.field_520);
         class_351.method_1022(this.field_519);
      }
   }
}
