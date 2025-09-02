package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aU implements ActionListener {
   aU(aQ var1) {
      this.dr = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.dr.setVisible(false);
   }
}
