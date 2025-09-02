package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cb implements ActionListener {
   cb(bS var1, int var2, int var3) {
      this.fk = var1;
      this.fl = var2;
      this.fm = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      boolean var2 = bS.d(this.fk).getState();
      bO.a(bS.j(this.fk)).a(this.fl, this.fm, var2);
      bS.c(this.fk);
   }
}
