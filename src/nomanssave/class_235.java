package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bZ
class class_235 implements ActionListener {
   class_235(class_356 var1, int var2, int var3) {
      this.field_625 = var1;
      this.field_626 = var2;
      this.field_627 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_357.method_1114(class_356.method_1100(this.field_625)).method_412()) {
         if (class_357.method_1114(class_356.method_1100(this.field_625)).method_416(this.field_626, this.field_627)) {
            class_357.method_1114(class_356.method_1100(this.field_625)).method_417(this.field_626, this.field_627);
            class_356.method_1093(this.field_625);
         }
      }
   }
}
