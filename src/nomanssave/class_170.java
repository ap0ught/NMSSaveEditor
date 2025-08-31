package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.di
class class_170 implements ActionListener {
   class_170(class_321 var1) {
      this.field_529 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.field_529.setVisible(false);
   }
}
