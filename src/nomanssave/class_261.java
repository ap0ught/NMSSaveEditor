package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.as
class class_261 implements ActionListener {
   class_261(class_363 var1) {
      this.field_668 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String[] var2 = class_318.method_876(this.field_668);
      boolean var3 = false;

      for (int var4 = 0; var4 < var2.length; var4++) {
         if (!class_363.method_1176(this.field_668).hasValue(var2[var4])) {
            class_363.method_1176(this.field_668).method_744(var2[var4]);
            var3 = true;
         }
      }

      if (var3) {
         class_363.method_1177(this.field_668).sort();
         class_363.method_1178(this.field_668).updateUI();
      }
   }
}
