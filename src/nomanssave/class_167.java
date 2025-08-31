package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dr
class class_167 implements ActionListener {
   class_167(class_368 var1, Application var2) {
      this.field_523 = var1;
      this.field_524 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_368.method_1238(this.field_523).getSelectedIndex();
      if (var2 >= 0 && var2 < class_368.method_1229(this.field_523).length) {
         this.field_524.method_1329(class_368.method_1229(this.field_523)[var2]);
      }
   }
}
