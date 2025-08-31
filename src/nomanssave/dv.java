package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dv implements ActionListener {
   dv(du var1, gF var2) {
      this.hp = var1;
      this.hq = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (this.hq != null) {
         cg.a(du.d(this.hp), this.hq);
         du.c(this.hp);
      }
   }
}
