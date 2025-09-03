package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cc implements ActionListener {
   cc(bS var1) {
      this.fk = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (bO.a(bS.j(this.fk)).dr()) {
         bO.c(bS.j(this.fk));
      }
   }
}
