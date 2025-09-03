package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class cZ implements ComboBoxModel {
   private gg gQ;

   cZ(cY var1) {
      this.gR = var1;
      this.gQ = null;
   }

   @Override
   public int getSize() {
      return cY.a(this.gR).size();
   }

   public gg C(int var1) {
      return (gg)cY.a(this.gR).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.gQ = (gg)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.gQ;
   }
}
