package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.j
class class_28 implements ComboBoxModel {
   // $VF: renamed from: A nomanssave.eB
   private class_298 field_72;

   class_28(class_319 var1) {
      this.field_73 = var1;
      this.field_72 = null;
   }

   @Override
   public int getSize() {
      return class_319.method_892(this.field_73).size();
   }

   // $VF: renamed from: b (int) nomanssave.eB
   public class_298 method_94(int var1) {
      return (class_298)class_319.method_892(this.field_73).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_72 = (class_298)var1;
      class_319.method_893(this.field_73);
   }

   @Override
   public Object getSelectedItem() {
      return this.field_72;
   }
}
