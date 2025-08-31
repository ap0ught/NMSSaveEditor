package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class j implements ComboBoxModel {
   private eB A;

   j(h var1) {
      this.z = var1;
      this.A = null;
   }

   @Override
   public int getSize() {
      return h.e(this.z).size();
   }

   public eB b(int var1) {
      return (eB)h.e(this.z).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.A = (eB)var1;
      h.f(this.z);
   }

   @Override
   public Object getSelectedItem() {
      return this.A;
   }
}
