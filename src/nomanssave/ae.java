package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class aE implements ComboBoxModel {
   aI cA;

   aE(aD var1) {
      this.cB = var1;
      this.cA = null;
   }

   @Override
   public int getSize() {
      return aI.values().length;
   }

   public aI t(int var1) {
      return aI.values()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.cA = (aI)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.cA;
   }
}
