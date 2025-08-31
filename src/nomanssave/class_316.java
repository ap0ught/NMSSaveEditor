package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.J
class class_316 implements ComboBoxModel {
   // $VF: renamed from: bs nomanssave.gh
   class_46 field_999;

   class_316(class_372 var1) {
      this.field_1000 = var1;
      this.field_999 = null;
   }

   @Override
   public int getSize() {
      return class_372.method_1301(this.field_1000) == null ? 0 : class_372.method_1301(this.field_1000).method_305().size();
   }

   // $VF: renamed from: o (int) nomanssave.gh
   public class_46 method_874(int var1) {
      return class_372.method_1301(this.field_1000) == null ? null : (class_46)class_372.method_1301(this.field_1000).method_305().get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_999 = (class_46)var1;
      if (this.field_999 == null) {
         class_372.method_1302(this.field_1000).setText("");
         class_372.method_1303(this.field_1000).setText("");
         class_372.method_1303(this.field_1000).setEnabled(false);
      } else {
         class_281 var2 = this.field_999.method_293();
         class_372.method_1302(this.field_1000).setText(var2 == null ? "" : var2.toString());
         class_372.method_1303(this.field_1000).setText(this.field_999.method_294());
         class_372.method_1303(this.field_1000).setEnabled(true);
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_999;
   }
}
