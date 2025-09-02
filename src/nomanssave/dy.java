package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dy extends MouseAdapter {
   dy(du var1, gF var2) {
      this.hp = var1;
      this.hq = var2;
   }

   @Override
   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2 && this.hq != null) {
         cg.a(du.d(this.hp), this.hq);
         du.c(this.hp);
      }
   }
}
