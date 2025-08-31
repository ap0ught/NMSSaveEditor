package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.al
class class_267 implements ComboBoxModel {
   // $VF: renamed from: ch java.lang.String
   String field_674;

   class_267(class_325 var1) {
      this.field_675 = var1;
      this.field_674 = null;
   }

   @Override
   public int getSize() {
      return class_325.method_954().size();
   }

   // $VF: renamed from: s (int) java.lang.String
   public String method_841(int var1) {
      return (String)class_325.method_954().get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_674 = (String)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.field_674;
   }
}
