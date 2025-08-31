package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.av
class class_258 implements ActionListener {
   class_258(class_363 var1) {
      this.field_665 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String[] var2 = class_318.method_877(this.field_665);
      boolean var3 = false;

      for (int var4 = 0; var4 < var2.length; var4++) {
         class_152 var5 = class_152.method_795(var2[var4]);
         if (!class_363.method_1179(this.field_665).contains(var2[var4])) {
            if (var5.method_781()) {
               class_363.method_1180(this.field_665).method_744(var2[var4]);
            }

            if (var5.method_780()) {
               class_363.method_1181(this.field_665).method_744(var2[var4]);
            }

            class_363.method_1179(this.field_665).add(var2[var4]);
            var3 = true;
         }
      }

      if (var3) {
         class_363.method_1182(this.field_665).sort();
         class_363.method_1183(this.field_665).updateUI();
      }
   }
}
