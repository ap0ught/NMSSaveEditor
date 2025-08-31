package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bW
class class_240 implements ActionListener {
   class_240(class_356 var1, int var2, int var3) {
      this.field_635 = var1;
      this.field_636 = var2;
      this.field_637 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_357.method_1114(class_356.method_1100(this.field_635)).method_401(this.field_636, this.field_637)) {
         class_357.method_1114(class_356.method_1100(this.field_635)).method_401(this.field_636, this.field_637);
         class_356.method_1093(this.field_635);
      }
   }
}
