package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bZ implements ActionListener {
   bZ(bS var1, int var2, int var3) {
      this.fk = var1;
      this.fl = var2;
      this.fm = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (bO.a(bS.j(this.fk)).dq()) {
         if (bO.a(bS.j(this.fk)).l(this.fl, this.fm)) {
            bO.a(bS.j(this.fk)).m(this.fl, this.fm);
            bS.c(this.fk);
         }
      }
   }
}
