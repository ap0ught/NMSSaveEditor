package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.k
class class_27 implements ComboBoxModel {
   // $VF: renamed from: B nomanssave.ex
   private class_295 field_70;

   class_27(class_319 var1) {
      this.field_71 = var1;
      this.field_70 = null;
   }

   @Override
   public int getSize() {
      return class_319.method_894(this.field_71).size();
   }

   // $VF: renamed from: c (int) nomanssave.ex
   public class_295 method_93(int var1) {
      return (class_295)class_319.method_894(this.field_71).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_70 = (class_295)var1;
      class_319.method_895(this.field_71);
   }

   @Override
   public Object getSelectedItem() {
      return this.field_70;
   }
}
