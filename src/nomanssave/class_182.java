package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.dK
class class_182 implements ComboBoxModel {
   // $VF: renamed from: hF nomanssave.eM
   class_147 field_547;

   class_182(class_332 var1) {
      this.field_548 = var1;
   }

   @Override
   public int getSize() {
      return 1 + class_147.getCount();
   }

   // $VF: renamed from: F (int) nomanssave.eM
   public class_147 method_828(int var1) {
      return var1 == 0 ? null : class_147.method_760(var1 - 1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_547 = (class_147)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.field_547;
   }
}
