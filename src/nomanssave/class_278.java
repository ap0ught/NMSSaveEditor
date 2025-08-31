package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.aT
class class_278 implements ActionListener {
   class_278(class_327 var1) {
      this.field_689 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_327.method_968(
         this.field_689,
         new Dimension(Integer.parseInt(class_327.method_963(this.field_689).getText()), Integer.parseInt(class_327.method_967(this.field_689).getText()))
      );
      this.field_689.setVisible(false);
   }
}
