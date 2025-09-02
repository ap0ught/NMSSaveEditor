package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ar implements ActionListener {
   ar(ap var1) {
      this.cu = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      ap.k(this.cu);
   }
}
