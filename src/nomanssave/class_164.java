package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dw
class class_164 implements ActionListener {
   class_164(class_351 var1, class_76 var2) {
      this.field_517 = var1;
      this.field_518 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (this.field_518 != null) {
         class_360.method_1160(class_351.method_1023(this.field_517), this.field_517);
      }
   }
}
