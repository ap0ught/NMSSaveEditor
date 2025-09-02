package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class da implements ActionListener {
   da(cY var1) {
      this.gR = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      cY.a(this.gR, cY.b(this.gR).getSelectedIndex());
      this.gR.setVisible(false);
   }
}
