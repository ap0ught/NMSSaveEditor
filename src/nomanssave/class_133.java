package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.ed
class class_133 implements ActionListener {
   class_133(class_359 var1, int var2) {
      this.field_438 = var1;
      this.field_439 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_359.method_1148(this.field_438).isSelected() ^ class_367.method_1219(class_359.method_1155(this.field_438))[this.field_439].isEnabled()) {
         boolean var2 = class_359.method_1148(this.field_438).isSelected();
         class_367.method_1219(class_359.method_1155(this.field_438))[this.field_439].setEnabled(var2);
         class_359.method_1149(this.field_438).setEnabled(var2);
         class_359.method_1150(this.field_438).setEnabled(var2);
         class_359.method_1151(this.field_438).setEnabled(var2);
         class_359.method_1152(this.field_438).setEnabled(var2);
         class_359.method_1153(this.field_438).setEnabled(var2);
      }
   }
}
