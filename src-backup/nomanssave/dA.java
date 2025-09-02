package nomanssave;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

class dA implements ListModel {
   dA(dz var1) {
      this.hu = var1;
   }

   @Override
   public int getSize() {
      return dz.a(this.hu).length;
   }

   public ft m(int var1) {
      return dz.a(this.hu)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }
}
