package nomanssave;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.de
class class_173 implements ListModel {
   class_173(class_321 var1) {
      this.field_532 = var1;
   }

   @Override
   public int getSize() {
      return class_321.method_911(this.field_532).size();
   }

   // $VF: renamed from: w (int) nomanssave.gt
   public class_70 method_826(int var1) {
      return (class_70)class_321.method_911(this.field_532).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }
}
