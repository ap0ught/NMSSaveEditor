package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dC implements ActionListener {
   dC(dz var1) {
      this.hu = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.hu.setVisible(false);
   }
}
