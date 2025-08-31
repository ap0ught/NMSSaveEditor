package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.dk
class class_169 implements ComboBoxModel {
   // $VF: renamed from: hk nomanssave.gv
   private class_39 field_527;

   class_169(class_368 var1) {
      this.field_528 = var1;
      this.field_527 = null;
   }

   @Override
   public int getSize() {
      return class_368.method_1229(this.field_528) == null ? 0 : class_368.method_1229(this.field_528).length;
   }

   // $VF: renamed from: D (int) nomanssave.gv
   public class_39 method_825(int var1) {
      return class_368.method_1229(this.field_528)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_527 = (class_39)var1;
      if (this.field_527 == null) {
         class_368.method_1230(this.field_528).setText("");
         class_368.method_1231(this.field_528).setSelectedIndex(-1);
         class_368.method_1232(this.field_528).setSelectedIndex(-1);
         class_368.method_1233(this.field_528).setText("");
         class_368.method_1234(this.field_528).setText("");
         class_368.method_1235(this.field_528).setText("");
         class_368.method_1236(this.field_528).setText("");
         class_368.method_1237(this.field_528).method_1109(Collections.emptyList());
      } else {
         class_368.method_1230(this.field_528).setText(this.field_527.getName());
         class_368.method_1231(this.field_528).method_985(this.field_527.method_199());
         class_368.method_1232(this.field_528).method_985(this.field_527.method_203());
         class_368.method_1233(this.field_528).setText(this.field_527.method_201());
         class_368.method_1234(this.field_528).setText(Double.toString(this.field_527.method_208()));
         class_368.method_1235(this.field_528).setText(Double.toString(this.field_527.method_210()));
         class_368.method_1236(this.field_528).setText(Double.toString(this.field_527.method_212()));
         class_368.method_1237(this.field_528).method_1109(Collections.singletonList(this.field_527.method_205()));
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_527;
   }
}
