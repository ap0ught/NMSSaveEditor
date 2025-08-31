package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.eq
class class_129 implements ComboBoxModel {
   // $VF: renamed from: iz nomanssave.gO
   private class_68 field_430;

   class_129(class_366 var1) {
      this.field_431 = var1;
      this.field_430 = null;
   }

   @Override
   public int getSize() {
      return class_366.method_1216(this.field_431) == null ? 0 : class_366.method_1216(this.field_431).length;
   }

   // $VF: renamed from: J (int) nomanssave.gO
   public class_68 method_679(int var1) {
      return class_366.method_1216(this.field_431)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_430 = (class_68)var1;
      if (this.field_430 == null) {
         class_366.method_1217(this.field_431).method_1109(Collections.emptyList());
      } else {
         class_366.method_1217(this.field_431).method_1109(this.field_430.method_370());
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_430;
   }
}
