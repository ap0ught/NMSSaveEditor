package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.L
class class_315 implements ComboBoxModel {
   // $VF: renamed from: bu nomanssave.gf
   class_48 field_997;

   class_315(class_372 var1) {
      this.field_998 = var1;
      this.field_997 = null;
   }

   @Override
   public int getSize() {
      return class_372.method_1301(this.field_998) == null ? 0 : class_372.method_1301(this.field_998).method_306().size();
   }

   // $VF: renamed from: p (int) nomanssave.gf
   public class_48 method_873(int var1) {
      return class_372.method_1301(this.field_998) == null ? null : (class_48)class_372.method_1301(this.field_998).method_306().get(var1);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_997 = (class_48)var1;
      if (this.field_997 == null) {
         class_372.method_1305(this.field_998).setText("");
         class_372.method_1306(this.field_998).setText("");
         class_372.method_1306(this.field_998).setEnabled(false);
         class_372.method_1307(this.field_998).setEnabled(false);
         class_372.method_1308(this.field_998).setEnabled(false);
         class_372.method_1309(this.field_998).setEnabled(false);
      } else {
         class_372.method_1305(this.field_998).setText(Integer.toString(this.field_997.method_297()));
         class_372.method_1306(this.field_998).setText(this.field_997.getName());
         class_372.method_1306(this.field_998).setEnabled(true);
         class_372.method_1307(this.field_998).setEnabled(true);
         class_372.method_1308(this.field_998).setEnabled(true);
         class_372.method_1309(this.field_998).setEnabled(true);
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_997;
   }
}
