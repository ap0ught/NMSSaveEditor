package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class al implements ComboBoxModel {
   String ch;

   al(aj var1) {
      this.cg = var1;
      this.ch = null;
   }

   @Override
   public int getSize() {
      return aj.Q().size();
   }

   public String s(int var1) {
      return (String)aj.Q().get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.ch = (String)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.ch;
   }
}
