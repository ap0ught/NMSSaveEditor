package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dh implements ActionListener {
   dh(dd var1) {
      this.gW = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.gW.setVisible(false);
   }
}
