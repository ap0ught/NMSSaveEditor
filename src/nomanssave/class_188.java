package nomanssave;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.dA
class class_188 implements ListModel {
   class_188(class_320 var1) {
      this.field_555 = var1;
   }

   @Override
   public int getSize() {
      return class_320.method_906(this.field_555).length;
   }

   // $VF: renamed from: m (int) nomanssave.ft
   public class_10 method_830(int var1) {
      return class_320.method_906(this.field_555)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }
}
