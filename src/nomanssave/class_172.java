package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dg
class class_172 implements ActionListener {
   class_172(class_321 var1) {
      this.field_531 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_321.method_913(this.field_531, class_321.method_912(this.field_531).getSelectedIndex());
      this.field_531.setVisible(false);
   }
}
