package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

class D implements ComboBoxModel {
   D(Application var1) {
      this.aZ = var1;
   }

   @Override
   public int getSize() {
      return Application.d(this.aZ).length;
   }

   public ft m(int var1) {
      return Application.d(this.aZ)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      if (Application.i(this.aZ)) {
         Application.n(this.aZ).hidePopup();
         int var2 = JOptionPane.showConfirmDialog(Application.h(this.aZ), "Save data before switching slots?", "Save", 1);
         if (var2 == 0) {
            Application.k(this.aZ);
         } else {
            if (var2 == 2) {
               return;
            }

            Application.f(this.aZ, false);
         }
      }

      int var6 = -1;
      synchronized (Application.n(this.aZ)) {
         for (int var4 = 0; var4 < Application.d(this.aZ).length; var4++) {
            if (Application.d(this.aZ)[var4] == var1) {
               var6 = var4;
               break;
            }
         }
      }

      Application.a(this.aZ, var6);
   }

   @Override
   public Object getSelectedItem() {
      return Application.c(this.aZ) < 0 ? null : Application.d(this.aZ)[Application.c(this.aZ)];
   }
}
