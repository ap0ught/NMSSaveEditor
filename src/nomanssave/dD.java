package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dD implements ActionListener {
   dD(dz var1) {
      this.hu = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.hu.setVisible(false);
   }
}
