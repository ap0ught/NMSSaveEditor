package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class ee implements ComboBoxModel {
   ee(ec var1, int var2) {
      this.ik = var1;
      this.il = var2;
   }

   @Override
   public int getSize() {
      return eb.aP().length;
   }

   public gy H(int var1) {
      return eb.aP()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      gy var2 = (gy)var1;
      if (var2 != null && !var2.equals(eb.a(ec.h(this.ik))[this.il].ed())) {
         eb.a(ec.h(this.ik))[this.il].a(var2);
      }
   }

   @Override
   public Object getSelectedItem() {
      return eb.a(ec.h(this.ik))[this.il].ed();
   }
}
