package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class dF implements ComboBoxModel {
   private gE hD;

   dF(dE var1) {
      this.hE = var1;
      this.hD = null;
   }

   @Override
   public int getSize() {
      return dE.b(this.hE) == null ? 0 : dE.b(this.hE).length;
   }

   public gE E(int var1) {
      return dE.b(this.hE)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.hD = (gE)var1;
      if (this.hD == null) {
         dE.c(this.hE).setText("");
         dE.d(this.hE).setText("");

         for (int var2 = 0; var2 < dE.e(this.hE).length; var2++) {
            dE.e(this.hE)[var2].setText("");
         }

         dE.f(this.hE).a(new gF[0]);
      } else {
         dE.c(this.hE).setText(this.hD.getName());
         dE.d(this.hE).setText(this.hD.cK());

         for (int var3 = 0; var3 < dE.e(this.hE).length; var3++) {
            dE.e(this.hE)[var3].setText(Integer.toString(this.hD.aq(var3)));
         }

         dE.f(this.hE).a(this.hD.dX());
      }

      dE.g(this.hE).revalidate();
   }

   @Override
   public Object getSelectedItem() {
      return this.hD;
   }
}
