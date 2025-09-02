package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aa implements ActionListener {
   private X bV;
   private Application bv;

   aa(X var1, Application var2) {
      this.bV = var1;
      this.bv = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      gj var2 = this.bv.j();
      if (var2 != null) {
         int var3 = -1;
         gj[] var4 = new gj[this.bV.a().length + 1];

         for (int var5 = 0; var5 < this.bV.a().length; var5++) {
            if (this.bV.a()[var5].getIndex() < var2.getIndex()) {
               var4[var5] = this.bV.a()[var5];
            } else {
               var4[var5 + 1] = this.bV.a()[var5];
               if (var3 < 0) {
                  var3 = var5;
               }
            }
         }

         if (var3 < 0) {
            var3 = this.bV.a().length;
         }

         var4[var3] = var2;
         this.bV.a(var4);
         hc.info("Imported " + var2.cL().name().toLowerCase() + ": " + var2.getIndex());
         this.bV.k().setSelectedIndex(var3);
         this.bV.k().updateUI();
      }
   }
}
