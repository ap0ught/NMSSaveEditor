package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.ah
class class_270 implements ActionListener {
   class_270(class_364 var1) {
      this.field_679 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_45 var2 = (class_45)class_364.method_1198(this.field_679).getSelectedItem();
      if (var2 != null) {
         if (class_364.method_1195(this.field_679).isSelected() ^ var2.method_287()) {
            var2.method_288(class_364.method_1195(this.field_679).isSelected());
         }
      }
   }
}
