package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class eq implements ComboBoxModel {
   private gO iz;

   eq(ep var1) {
      this.iA = var1;
      this.iz = null;
   }

   @Override
   public int getSize() {
      return ep.a(this.iA) == null ? 0 : ep.a(this.iA).length;
   }

   public gO J(int var1) {
      return ep.a(this.iA)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.iz = (gO)var1;
      if (this.iz == null) {
         ep.b(this.iA).a(Collections.emptyList());
      } else {
         ep.b(this.iA).a(this.iz.cC());
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.iz;
   }
}
