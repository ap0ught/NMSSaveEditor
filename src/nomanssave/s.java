package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class S implements FocusListener {
   S(Q var1) {
      this.bD = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      int var2;
      try {
         var2 = Integer.parseInt(Q.d(this.bD).getText());
         if (var2 < Q.e(this.bD)) {
            var2 = Q.e(this.bD);
         }
      } catch (RuntimeException var4) {
         var2 = Q.c(this.bD).bF;
      }

      Q.d(this.bD).setText(Integer.toString(var2));
   }
}
