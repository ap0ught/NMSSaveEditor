package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dx
class class_163 implements ActionListener {
   class_163(class_351 var1, class_76 var2) {
      this.field_515 = var1;
      this.field_516 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (this.field_516 != null) {
         class_360.method_1161(class_351.method_1023(this.field_515), this.field_515);
      }
   }
}
