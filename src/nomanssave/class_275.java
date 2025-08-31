package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.aX
class class_275 implements ActionListener {
   class_275(class_326 var1, class_322 var2) {
      this.field_685 = var1;
      this.field_686 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = class_326.method_957(this.field_685).getText();
      if (var2.length() > 0) {
         this.field_686
            .method_919(
               var2,
               class_326.method_958(this.field_685).isSelected(),
               class_326.method_959(this.field_685).isSelected(),
               class_326.method_960(this.field_685).isSelected()
            );
      }
   }
}
