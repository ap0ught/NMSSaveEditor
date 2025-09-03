package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Z implements ActionListener {
   Z(X var1, Application var2) {
      this.bV = var1;
      this.bv = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      gj var2 = (gj)X.k(this.bV).getSelectedItem();
      if (var2 != null) {
         this.bv.a(var2);
      }
   }
}
