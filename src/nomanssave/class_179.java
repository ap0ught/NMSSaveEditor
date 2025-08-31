package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dR
class class_179 implements ActionListener {
   class_179(class_369 var1, Application var2) {
      this.field_540 = var1;
      this.field_541 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_369.method_1265(this.field_540).getSelectedIndex();
      if (var2 >= 0 && var2 < class_369.method_1250(this.field_540).length) {
         this.field_541.method_1328(class_369.method_1250(this.field_540)[var2]);
      }
   }
}
