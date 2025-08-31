package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class bC implements ComboBoxModel {
   final int ev;
   er eu;

   bC(bl var1, int var2) {
      this.er = var1;
      this.ev = var2;
   }

   @Override
   public int getSize() {
      return 1 + (bl.f(this.er) == null ? 0 : bl.f(this.er).length);
   }

   public er v(int var1) {
      if (var1 == 0) {
         return null;
      } else {
         return bl.f(this.er) == null ? null : bl.f(this.er)[var1 - 1];
      }
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
         er var2 = bl.c(this.er)[bl.b(this.er)].ar(this.ev);
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
               bl.c(this.er)[bl.b(this.er)].a(this.ev, null);
            } else {
               bl.c(this.er)[bl.b(this.er)].a(this.ev, this.eu);
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
