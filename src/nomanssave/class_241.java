package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bV
class class_241 implements ActionListener {
   class_241(class_356 var1, int var2, int var3) {
      this.field_638 = var1;
      this.field_639 = var2;
      this.field_640 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_41 var2 = class_357.method_1114(class_356.method_1100(this.field_638)).method_399(this.field_639, this.field_640);
      if (var2 != null && var2.method_43() >= 0 && var2.method_45() > 0) {
         var2.method_44(var2.method_45());
         class_356.method_1093(this.field_638);
      }
   }
}
