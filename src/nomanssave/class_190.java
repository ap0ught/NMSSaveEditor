package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.cf
class class_190 implements ActionListener {
   class_190(class_356 var1, int var2, int var3) {
      this.field_557 = var1;
      this.field_558 = var2;
      this.field_559 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_41 var2 = class_357.method_1114(class_356.method_1100(this.field_557)).method_399(this.field_558, this.field_559);
      if (var2 != null) {
         var2.method_219(0.0);
         var2.method_221(true);
         class_356.method_1093(this.field_557);
      }
   }
}
