package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class H implements FocusListener {
   H(G var1) {
      this.bg = var1;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      this.bg.N();
   }
}
