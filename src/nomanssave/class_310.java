package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// $VF: renamed from: nomanssave.S
class class_310 implements FocusListener {
   class_310(class_330 var1) {
      this.field_989 = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      int var2;
      try {
         var2 = Integer.parseInt(class_330.method_981(this.field_989).getText());
         if (var2 < class_330.method_982(this.field_989)) {
            var2 = class_330.method_982(this.field_989);
         }
      } catch (RuntimeException var4) {
         var2 = class_330.method_980(this.field_989).field_985;
      }

      class_330.method_981(this.field_989).setText(Integer.toString(var2));
   }
}
