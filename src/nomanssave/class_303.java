package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.aE
class class_303 implements ComboBoxModel {
   // $VF: renamed from: cA nomanssave.aI
   class_299 field_978;

   class_303(class_328 var1) {
      this.field_979 = var1;
      this.field_978 = null;
   }

   @Override
   public int getSize() {
      return class_299.values().length;
   }

   // $VF: renamed from: t (int) nomanssave.aI
   public class_299 method_871(int var1) {
      return class_299.values()[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_978 = (class_299)var1;
   }

   @Override
   public Object getSelectedItem() {
      return this.field_978;
   }
}
