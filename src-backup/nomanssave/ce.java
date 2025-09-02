package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ce implements ActionListener {
   ce(bS var1, int var2, int var3) {
      this.fk = var1;
      this.fl = var2;
      this.fm = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (bO.a(bS.j(this.fk)).f(this.fl, this.fm) == null) {
         bO.a(bS.j(this.fk), this.fk);
      }
   }
}
