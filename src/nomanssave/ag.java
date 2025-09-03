package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aG implements ActionListener {
   aG(aD var1) {
      this.cB = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.cB.setVisible(false);
   }
}
