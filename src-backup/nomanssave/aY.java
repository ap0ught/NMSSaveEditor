package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aY implements ActionListener {
   aY(aW var1) {
      this.dy = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.dy.setVisible(false);
   }
}
