package nomanssave;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

// $VF: renamed from: nomanssave.cF
class class_220 extends AbstractAction {
   class_220(class_322 var1) {
      this.field_600 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_322.method_926(this.field_600).getSelectionStart();
      int var3 = class_322.method_926(this.field_600).getSelectionEnd();
      String var4 = var3 > var2 ? class_322.method_926(this.field_600).getText().substring(var2, var3) : null;
      class_326.method_956(this.field_600, var4);
   }
}
