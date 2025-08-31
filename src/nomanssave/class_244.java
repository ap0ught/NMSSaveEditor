package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bR
class class_244 implements ActionListener {
   class_244(class_357 var1) {
      this.field_647 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_357.method_1114(this.field_647) != null) {
         Dimension var2 = class_327.method_962(
            this.field_647,
            class_357.method_1114(this.field_647).getSize(),
            class_357.method_1114(this.field_647).method_394(),
            class_357.method_1114(this.field_647).method_395()
         );
         if (var2 != null && class_357.method_1114(this.field_647).method_392(var2)) {
            class_357.method_1116(this.field_647);
         }
      }
   }
}
