package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dS
class class_178 implements ActionListener {
   class_178(class_369 var1, Application var2) {
      this.field_538 = var1;
      this.field_539 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_75 var2 = this.field_539.method_1331();
      if (var2 != null) {
         class_75[] var3 = new class_75[class_369.method_1250(this.field_538).length + 1];
         int var4 = -1;

         for (int var5 = 0; var5 < class_369.method_1250(this.field_538).length; var5++) {
            if (class_369.method_1250(this.field_538)[var5].getIndex() < var2.getIndex()) {
               var3[var5] = class_369.method_1250(this.field_538)[var5];
            } else {
               var3[var5 + 1] = class_369.method_1250(this.field_538)[var5];
               if (var4 < 0) {
                  var4 = var5;
               }
            }
         }

         if (var4 < 0) {
            var4 = class_369.method_1250(this.field_538).length;
         }

         var3[var4] = var2;
         class_369.method_1266(this.field_538, var3);
         class_37.info("Imported ship: " + var2.getIndex());
         class_369.method_1265(this.field_538).setSelectedIndex(var4);
         class_369.method_1265(this.field_538).updateUI();
      }
   }
}
