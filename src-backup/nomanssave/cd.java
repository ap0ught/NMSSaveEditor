package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cd implements ActionListener {
   cd(bS var1, int var2, int var3) {
      this.fk = var1;
      this.fl = var2;
      this.fm = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      gu var2 = bO.a(bS.j(this.fk)).f(this.fl, this.fm);
      if (var2 != null) {
         cg.a(bS.j(this.fk), var2);
         bS.c(this.fk);
      }
   }
}
