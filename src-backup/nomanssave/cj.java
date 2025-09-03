package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cj implements ActionListener {
   cj(cg var1) {
      this.fF = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      cg.fE.setVisible(false);
   }
}
