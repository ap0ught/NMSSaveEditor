package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.ce
class class_191 implements ActionListener {
   class_191(class_356 var1, int var2, int var3) {
      this.field_560 = var1;
      this.field_561 = var2;
      this.field_562 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_357.method_1114(class_356.method_1100(this.field_560)).method_399(this.field_561, this.field_562) == null) {
         class_357.method_1117(class_356.method_1100(this.field_560), this.field_560);
      }
   }
}
