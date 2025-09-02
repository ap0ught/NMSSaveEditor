package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aZ implements ActionListener {
   aZ(aW var1) {
      this.dy = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.dy.setVisible(false);
   }
}
