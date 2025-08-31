package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.cZ
class class_196 implements ComboBoxModel {
   // $VF: renamed from: gQ nomanssave.gg
   private class_47 field_571;

   class_196(class_324 var1) {
      this.field_572 = var1;
      this.field_571 = null;
   }

   @Override
   public int getSize() {
      return class_324.method_944(this.field_572).size();
   }

   // $VF: renamed from: C (int) nomanssave.gg
   public class_47 method_831(int var1) {
      return (class_47)class_324.method_944(this.field_572).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_571 = (class_47)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.field_571;
   }
}
