package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.ds
class class_166 implements ActionListener {
   class_166(class_368 var1, Application var2) {
      this.field_521 = var1;
      this.field_522 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_39 var2 = this.field_522.method_1332();
      if (var2 != null) {
         class_39[] var3 = new class_39[class_368.method_1229(this.field_521).length + 1];
         int var4 = -1;

         for (int var5 = 0; var5 < class_368.method_1229(this.field_521).length; var5++) {
            if (class_368.method_1229(this.field_521)[var5].getIndex() < var2.getIndex()) {
               var3[var5] = class_368.method_1229(this.field_521)[var5];
            } else {
               var3[var5 + 1] = class_368.method_1229(this.field_521)[var5];
               if (var4 < 0) {
                  var4 = var5;
               }
            }
         }

         if (var4 < 0) {
            var4 = class_368.method_1229(this.field_521).length;
         }

         var3[var4] = var2;
         class_368.method_1239(this.field_521, var3);
         class_368.method_1238(this.field_521).setSelectedIndex(var4);
         class_368.method_1238(this.field_521).updateUI();
      }
   }
}
