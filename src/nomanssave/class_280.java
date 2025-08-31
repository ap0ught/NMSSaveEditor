package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// $VF: renamed from: nomanssave.aR
class class_280 implements FocusListener {
   class_280(class_327 var1) {
      this.field_691 = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      int var2;
      try {
         var2 = Integer.parseInt(class_327.method_963(this.field_691).getText());
         if (var2 != class_327.method_964(this.field_691).width) {
            if (var2 < class_327.method_965(this.field_691).width) {
               var2 = class_327.method_965(this.field_691).width;
            } else if (var2 > class_327.method_966(this.field_691).width && !class_130.method_681()) {
               var2 = class_327.method_966(this.field_691).width;
            }
         }
      } catch (RuntimeException var4) {
         var2 = class_327.method_964(this.field_691).width;
      }

      class_327.method_963(this.field_691).setText(Integer.toString(var2));
   }
}
