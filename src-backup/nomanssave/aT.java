package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aT implements ActionListener {
   aT(aQ var1) {
      this.dr = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      aQ.a(this.dr, new Dimension(Integer.parseInt(aQ.a(this.dr).getText()), Integer.parseInt(aQ.e(this.dr).getText())));
      this.dr.setVisible(false);
   }
}
