package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dc implements ActionListener {
   dc(cY var1) {
      this.gR = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.gR.setVisible(false);
   }
}
