package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.O
class class_313 implements ActionListener {
   class_313(class_372 var1, Application var2) {
      this.field_993 = var1;
      this.field_994 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_48 var2 = (class_48)class_372.method_1310(this.field_993).getSelectedItem();
      if (var2 != null && this.field_994.method_1335(var2)) {
         class_372.method_1305(this.field_993).setText(Integer.toString(var2.method_297()));
      }
   }
}
