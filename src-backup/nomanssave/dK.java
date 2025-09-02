package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class dK implements ComboBoxModel {
   eM hF;

   dK(dJ var1) {
      this.hG = var1;
   }

   @Override
   public int getSize() {
      return 1 + eM.getCount();
   }

   public eM F(int var1) {
      return var1 == 0 ? null : eM.S(var1 - 1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.hF = (eM)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.hF;
   }
}
