package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// $VF: renamed from: nomanssave.ck
class class_428 extends WindowAdapter {
   class_428(class_323 var1) {
      this.field_1422 = var1;
   }

   @Override
   public void windowClosing(WindowEvent var1) {
      class_323.method_939(this.field_1422).method_1313();
      class_323.method_940(this.field_1422).method_1313();
   }
}
