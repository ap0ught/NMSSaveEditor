package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.ab
class class_271 implements ComboBoxModel {
   class_271(class_364 var1) {
      this.field_680 = var1;
   }

   @Override
   public int getSize() {
      return class_287.values().length;
   }

   // $VF: renamed from: r (int) nomanssave.gl
   public class_287 method_842(int var1) {
      return class_287.values()[var1];
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
      return class_287.field_778;
   }
}
