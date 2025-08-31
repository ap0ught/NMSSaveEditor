package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// $VF: renamed from: nomanssave.R
class class_311 implements FocusListener {
   class_311(class_330 var1) {
      this.field_990 = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      int var2;
      try {
         var2 = Integer.parseInt(class_330.method_978(this.field_990).getText());
         if (var2 % 250 != 0) {
            var2 = (int)Math.round((double)var2 / 250.0);
         }

         if (var2 < class_330.method_979(this.field_990)) {
            var2 = class_330.method_979(this.field_990);
         }
      } catch (RuntimeException var4) {
         var2 = class_330.method_980(this.field_990).field_984;
      }

      class_330.method_978(this.field_990).setText(Integer.toString(var2));
   }
}
