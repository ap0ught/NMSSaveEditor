package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.U
class class_308 implements ActionListener {
   class_308(class_330 var1) {
      this.field_987 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.field_987.setVisible(false);
   }
}
