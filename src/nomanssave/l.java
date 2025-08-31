package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class l implements ComboBoxModel {
   private ey C;

   l(h var1) {
      this.z = var1;
      this.C = null;
   }

   @Override
   public int getSize() {
      return h.i(this.z).size();
   }

   public ey d(int var1) {
      return (ey)h.i(this.z).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.C = (ey)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.C;
   }
}
