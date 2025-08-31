package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.ee
class class_132 implements ComboBoxModel {
   class_132(class_359 var1, int var2) {
      this.field_436 = var1;
      this.field_437 = var2;
   }

   @Override
   public int getSize() {
      return class_367.method_1220().length;
   }

   // $VF: renamed from: H (int) nomanssave.gy
   public class_281 method_684(int var1) {
      return class_367.method_1220()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      class_281 var2 = (class_281)var1;
      if (var2 != null && !var2.equals(class_367.method_1219(class_359.method_1155(this.field_436))[this.field_437].method_374())) {
         class_367.method_1219(class_359.method_1155(this.field_436))[this.field_437].method_375(var2);
      }
   }

   @Override
   public Object getSelectedItem() {
      return class_367.method_1219(class_359.method_1155(this.field_436))[this.field_437].method_374();
   }
}
