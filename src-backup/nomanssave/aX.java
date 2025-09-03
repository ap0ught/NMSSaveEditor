package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aX implements ActionListener {
   aX(aW var1, cy var2) {
      this.dy = var1;
      this.dz = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = aW.a(this.dy).getText();
      if (var2.length() > 0) {
         this.dz.a(var2, aW.b(this.dy).isSelected(), aW.c(this.dy).isSelected(), aW.d(this.dy).isSelected());
      }
   }
}
