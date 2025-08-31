package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.T
class class_309 implements ActionListener {
   class_309(class_330 var1) {
      this.field_988 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_330.method_983(
         this.field_988,
         new class_306(Integer.parseInt(class_330.method_978(this.field_988).getText()), Integer.parseInt(class_330.method_981(this.field_988).getText()))
      );
      this.field_988.setVisible(false);
   }
}
