package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// $VF: renamed from: nomanssave.aS
class class_279 implements FocusListener {
   class_279(class_327 var1) {
      this.field_690 = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      int var2;
      try {
         var2 = Integer.parseInt(class_327.method_967(this.field_690).getText());
         if (var2 != class_327.method_964(this.field_690).height) {
            if (var2 < class_327.method_965(this.field_690).height) {
               var2 = class_327.method_965(this.field_690).height;
            } else if (var2 > class_327.method_966(this.field_690).height && !class_130.method_681()) {
               var2 = class_327.method_966(this.field_690).height;
            }
         }
      } catch (RuntimeException var4) {
         var2 = class_327.method_964(this.field_690).height;
      }

      class_327.method_967(this.field_690).setText(Integer.toString(var2));
   }
}
