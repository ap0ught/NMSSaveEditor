package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bz
class class_224 implements ActionListener {
   class_224(class_355 var1) {
      this.field_604 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_355.method_1056(this.field_604) >= 0) {
         class_37.info("Repairing frigate damage");
         class_355.method_1057(this.field_604)[class_355.method_1056(this.field_604)].method_246(0);
         class_355.method_1057(this.field_604)[class_355.method_1056(this.field_604)].method_248(0);
         class_355.method_1083(this.field_604).setText("");
         class_355.method_1084(this.field_604).setVisible(false);
      }
   }
}
