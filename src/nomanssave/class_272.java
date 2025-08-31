package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.aa
class class_272 implements ActionListener {
   class_272(class_364 var1, Application var2) {
      this.field_681 = var1;
      this.field_682 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_45 var2 = this.field_682.method_1333();
      if (var2 != null) {
         int var3 = -1;
         class_45[] var4 = new class_45[class_364.method_1188(this.field_681).length + 1];

         for (int var5 = 0; var5 < class_364.method_1188(this.field_681).length; var5++) {
            if (class_364.method_1188(this.field_681)[var5].getIndex() < var2.getIndex()) {
               var4[var5] = class_364.method_1188(this.field_681)[var5];
            } else {
               var4[var5 + 1] = class_364.method_1188(this.field_681)[var5];
               if (var3 < 0) {
                  var3 = var5;
               }
            }
         }

         if (var3 < 0) {
            var3 = class_364.method_1188(this.field_681).length;
         }

         var4[var3] = var2;
         class_364.method_1199(this.field_681, var4);
         class_37.info("Imported " + var2.method_277().name().toLowerCase() + ": " + var2.getIndex());
         class_364.method_1198(this.field_681).setSelectedIndex(var3);
         class_364.method_1198(this.field_681).updateUI();
      }
   }
}
