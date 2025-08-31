package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.eg
class class_131 implements ComboBoxModel {
   class_131(class_359 var1, int var2) {
      this.field_434 = var1;
      this.field_435 = var2;
   }

   @Override
   public int getSize() {
      return class_292.values().length;
   }

   // $VF: renamed from: I (int) nomanssave.gL
   public class_292 method_683(int var1) {
      return class_292.values()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      class_292 var2 = (class_292)var1;
      if (var2 != null && !var2.equals(class_367.method_1219(class_359.method_1155(this.field_434))[this.field_435].method_378())) {
         class_367.method_1219(class_359.method_1155(this.field_434))[this.field_435].method_379(var2);
      }
   }

   @Override
   public Object getSelectedItem() {
      return class_367.method_1219(class_359.method_1155(this.field_434))[this.field_435].method_378();
   }
}
