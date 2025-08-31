package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.bP
class class_245 implements ComboBoxModel {
   class_245(class_357 var1) {
      this.field_648 = var1;
   }

   @Override
   public int getSize() {
      return class_357.method_1129(this.field_648).size();
   }

   // $VF: renamed from: w (int) nomanssave.gt
   public class_70 method_838(int var1) {
      return (class_70)class_357.method_1129(this.field_648).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      class_357.method_1130(this.field_648, (class_70)var1);
      class_357.method_1131(this.field_648)
         .setVisible(class_357.method_1114(this.field_648) == null ? false : class_130.method_681() || class_357.method_1114(this.field_648).method_387());
      class_357.method_1116(this.field_648);
   }

   @Override
   public Object getSelectedItem() {
      return class_357.method_1114(this.field_648);
   }
}
