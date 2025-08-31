package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class az implements ActionListener {
   az(ap var1) {
      this.cu = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      for (eS var3 : eS.by()) {
         gA var2 = ap.i(this.cu).a(var3);
         var2.a(eU.kr, false);
         var2.a(eU.ks, false);
         var2.a(eU.kt, false);
         var2.a(eU.kv, false);
         var2.a(eU.kz, false);
      }

      ap.j(this.cu).updateUI();
   }
}
