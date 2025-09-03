package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class eg implements ComboBoxModel {
   eg(ec var1, int var2) {
      this.ik = var1;
      this.il = var2;
   }

   @Override
   public int getSize() {
      return gL.values().length;
   }

   public gL I(int var1) {
      return gL.values()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      gL var2 = (gL)var1;
      if (var2 != null && !var2.equals(eb.a(ec.h(this.ik))[this.il].ef())) {
         eb.a(ec.h(this.ik))[this.il].a(var2);
      }
   }

   @Override
   public Object getSelectedItem() {
      return eb.a(ec.h(this.ik))[this.il].ef();
   }
}
