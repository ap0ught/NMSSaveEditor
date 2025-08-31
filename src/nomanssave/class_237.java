package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// $VF: renamed from: nomanssave.dy
class class_237 extends MouseAdapter {
   class_237(class_351 var1, class_76 var2) {
      this.field_629 = var1;
      this.field_630 = var2;
   }

   @Override
   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2 && this.field_630 != null) {
         class_323.method_932(class_351.method_1023(this.field_629), this.field_630);
         class_351.method_1022(this.field_629);
      }
   }
}
