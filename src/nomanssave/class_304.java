package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.Z
class class_304 implements ActionListener {
   class_304(class_364 var1, Application var2) {
      this.field_980 = var1;
      this.field_981 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_45 var2 = (class_45)class_364.method_1198(this.field_980).getSelectedItem();
      if (var2 != null) {
         this.field_981.method_1330(var2);
      }
   }
}
