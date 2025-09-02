package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class s implements ActionListener {
   s(p var1) {
      this.I = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.I.setVisible(false);
   }
}
