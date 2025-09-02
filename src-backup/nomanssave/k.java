package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class k implements ComboBoxModel {
   private ex B;

   k(h var1) {
      this.z = var1;
      this.B = null;
   }

   @Override
   public int getSize() {
      return h.g(this.z).size();
   }

   public ex c(int var1) {
      return (ex)h.g(this.z).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.B = (ex)var1;
      h.h(this.z);
   }

   @Override
   public Object getSelectedItem() {
      return this.B;
   }
}
