package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.da
class class_176 implements ActionListener {
   class_176(class_324 var1) {
      this.field_535 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_324.method_946(this.field_535, class_324.method_945(this.field_535).getSelectedIndex());
      this.field_535.setVisible(false);
   }
}
