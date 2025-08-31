package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.bw
class class_225 implements ComboBoxModel {
   // $VF: renamed from: et nomanssave.gr
   class_284 field_605;

   class_225(class_355 var1) {
      this.field_606 = var1;
   }

   @Override
   public int getSize() {
      return class_284.values().length;
   }

   // $VF: renamed from: u (int) nomanssave.gr
   public class_284 method_836(int var1) {
      return class_284.values()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_605 = (class_284)var1;
      class_355.method_1064(this.field_606, class_355.method_1056(this.field_606) < 0 ? null : class_128.method_672(this.field_605));
      class_355.method_1065(this.field_606, class_355.method_1056(this.field_606) < 0 ? null : class_128.method_673(this.field_605));
      if (class_355.method_1056(this.field_606) >= 0
         && this.field_605 != null
         && !this.field_605.equals(class_355.method_1057(this.field_606)[class_355.method_1056(this.field_606)].method_224())) {
         class_355.method_1057(this.field_606)[class_355.method_1056(this.field_606)].method_225(this.field_605);
         if (class_355.method_1055(this.field_606) != null && class_355.method_1055(this.field_606).length > 0) {
            class_355.method_1057(this.field_606)[class_355.method_1056(this.field_606)].method_236(0, class_355.method_1055(this.field_606)[0]);
            class_355.method_1074(this.field_606).setSelectedItem(class_355.method_1055(this.field_606)[0]);
         } else {
            class_355.method_1074(this.field_606).setSelectedItem(null);
         }

         class_355.method_1075(this.field_606).setSelectedItem(null);
         class_355.method_1076(this.field_606).setSelectedItem(null);
         class_355.method_1077(this.field_606).setSelectedItem(null);
         class_355.method_1078(this.field_606).setSelectedItem(null);
      }

      class_355.method_1059(this.field_606).updateUI();
      class_355.method_1074(this.field_606).updateUI();
      class_355.method_1075(this.field_606).updateUI();
      class_355.method_1076(this.field_606).updateUI();
      class_355.method_1077(this.field_606).updateUI();
      class_355.method_1078(this.field_606).updateUI();
   }

   @Override
   public Object getSelectedItem() {
      return this.field_605;
   }
}
