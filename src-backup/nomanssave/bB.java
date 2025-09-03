package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class bB implements ComboBoxModel {
   er eu;

   private bB(bl var1) {
      this.er = var1;
   }

   @Override
   public int getSize() {
      return bl.a(this.er) == null ? 0 : bl.a(this.er).length;
   }

   public er v(int var1) {
      return bl.a(this.er) == null ? null : bl.a(this.er)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.eu = (er)var1;
      if (bl.b(this.er) >= 0) {
         er var2 = bl.c(this.er)[bl.b(this.er)].ar(0);
         if (this.eu != var2) {
            if (var2 != null) {
               int var3 = var2.aU().ordinal();
               int var4 = bl.c(this.er)[bl.b(this.er)].aq(var3) - var2.aV();
               if (var4 < 0) {
                  var4 = 0;
               }

               bl.c(this.er)[bl.b(this.er)].e(var3, var4);
               bl.d(this.er)[var3].setText(Integer.toString(var4));
            }

            if (this.eu == null) {
               bl.c(this.er)[bl.b(this.er)].a(0, null);
            } else {
               bl.c(this.er)[bl.b(this.er)].a(0, this.eu);
               int var5 = this.eu.aU().ordinal();
               int var6 = bl.c(this.er)[bl.b(this.er)].aq(var5) + this.eu.aV();
               if (var6 < 0) {
                  var6 = 0;
               }

               bl.c(this.er)[bl.b(this.er)].e(var5, var6);
               bl.d(this.er)[var5].setText(Integer.toString(var6));
            }

            bl.e(this.er).updateUI();
         }
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.eu;
   }
}
