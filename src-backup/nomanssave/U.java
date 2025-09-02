package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class U implements ActionListener {
   U(Q var1) {
      this.bD = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.bD.setVisible(false);
   }
}
