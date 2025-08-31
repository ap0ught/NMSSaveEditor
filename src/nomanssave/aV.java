package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aV implements ActionListener {
   aV(aQ var1) {
      this.dr = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.dr.setVisible(false);
   }
}
