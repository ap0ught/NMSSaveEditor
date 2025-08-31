package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bk
class class_231 implements ActionListener {
   class_231(class_370 var1, Application var2) {
      this.field_616 = var1;
      this.field_617 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_370.method_1281(this.field_616) != null) {
         this.field_617.method_1337(class_370.method_1281(this.field_616));
      }
   }
}
