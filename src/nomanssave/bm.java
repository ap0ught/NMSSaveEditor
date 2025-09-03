package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

class bM implements FocusListener {
   bM(bL var1, bK var2) {
      this.eC = var1;
      this.eD = var2;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      if (bE.a(bL.a(this.eC)) != null) {
         JTextField var2 = (JTextField)var1.getComponent();
         String var3 = this.eD.ab();
         String var4 = var2.getText();
         if (!var4.equals(var3)) {
            try {
               this.eD.l(var4);
            } catch (RuntimeException var6) {
               var2.setText(var3);
            }
         }
      }
   }
}
