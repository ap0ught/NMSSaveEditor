package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class db implements ActionListener {
   db(cY var1) {
      this.gR = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.gR.setVisible(false);
   }
}
