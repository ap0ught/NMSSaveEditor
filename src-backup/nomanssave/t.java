package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class t implements ActionListener {
   t(p var1) {
      this.I = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.I.setVisible(false);
   }
}
