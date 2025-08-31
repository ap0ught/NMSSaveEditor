package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bU
class class_242 implements ActionListener {
   class_242(class_356 var1, int var2, int var3) {
      this.field_641 = var1;
      this.field_642 = var2;
      this.field_643 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_41 var2 = class_357.method_1114(class_356.method_1100(this.field_641)).method_399(this.field_642, this.field_643);
      if (var2 != null) {
         class_357.method_1118(class_356.method_1100(this.field_641), var2, this.field_641);
      }
   }
}
