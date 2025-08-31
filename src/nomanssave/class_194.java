package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.cb
class class_194 implements ActionListener {
   class_194(class_356 var1, int var2, int var3) {
      this.field_567 = var1;
      this.field_568 = var2;
      this.field_569 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      boolean var2 = class_356.method_1094(this.field_567).getState();
      class_357.method_1114(class_356.method_1100(this.field_567)).method_414(this.field_568, this.field_569, var2);
      class_356.method_1093(this.field_567);
   }
}
