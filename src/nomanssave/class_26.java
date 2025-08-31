package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.l
class class_26 implements ComboBoxModel {
   // $VF: renamed from: C nomanssave.ey
   private class_152 field_68;

   class_26(class_319 var1) {
      this.field_69 = var1;
      this.field_68 = null;
   }

   @Override
   public int getSize() {
      return class_319.method_896(this.field_69).size();
   }

   // $VF: renamed from: d (int) nomanssave.ey
   public class_152 method_92(int var1) {
      return (class_152)class_319.method_896(this.field_69).get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_68 = (class_152)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.field_68;
   }
}
