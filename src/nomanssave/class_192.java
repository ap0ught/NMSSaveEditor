package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.cd
class class_192 implements ActionListener {
   class_192(class_356 var1, int var2, int var3) {
      this.field_563 = var1;
      this.field_564 = var2;
      this.field_565 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_41 var2 = class_357.method_1114(class_356.method_1100(this.field_563)).method_399(this.field_564, this.field_565);
      if (var2 != null) {
         class_323.method_932(class_356.method_1100(this.field_563), var2);
         class_356.method_1093(this.field_563);
      }
   }
}
