package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// $VF: renamed from: nomanssave.H
class class_317 implements FocusListener {
   class_317(class_374 var1) {
      this.field_1001 = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      this.field_1001.method_1313();
   }
}
