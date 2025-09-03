package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class ab implements ComboBoxModel {
   ab(X var1) {
      this.bV = var1;
   }

   @Override
   public int getSize() {
      return gl.values().length;
   }

   public gl r(int var1) {
      return gl.values()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
   }

   @Override
   public Object getSelectedItem() {
      return gl.oF;
   }
}
