package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// $VF: renamed from: nomanssave.df
class class_238 extends MouseAdapter {
   class_238(class_321 var1) {
      this.field_631 = var1;
   }

   @Override
   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2) {
         class_321.method_913(this.field_631, class_321.method_912(this.field_631).getSelectedIndex());
         this.field_631.setVisible(false);
      }
   }
}
