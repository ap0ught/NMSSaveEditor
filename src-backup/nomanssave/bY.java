package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bY implements ActionListener {
   bY(bS var1) {
      this.fk = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (bO.a(bS.j(this.fk)).dp() || en.aS()) {
         if (bO.a(bS.j(this.fk)).dv()) {
            bO.c(bS.j(this.fk));
         }
      }
   }
}
