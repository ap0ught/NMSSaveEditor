package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.m
class class_25 implements ActionListener {
   class_25(class_319 var1) {
      this.field_67 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_319.method_898(this.field_67, (class_152)class_319.method_897(this.field_67).getSelectedItem());
      this.field_67.setVisible(false);
   }
}
