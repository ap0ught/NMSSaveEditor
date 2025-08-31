package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.bC
class class_251 implements ComboBoxModel {
   // $VF: renamed from: ev int
   final int field_655;
   // $VF: renamed from: eu nomanssave.er
   class_128 field_656;

   class_251(class_355 var1, int var2) {
      this.field_657 = var1;
      this.field_655 = var2;
   }

   @Override
   public int getSize() {
      return 1 + (class_355.method_1060(this.field_657) == null ? 0 : class_355.method_1060(this.field_657).length);
   }

   // $VF: renamed from: v (int) nomanssave.er
   public class_128 method_839(int var1) {
      if (var1 == 0) {
         return null;
      } else {
         return class_355.method_1060(this.field_657) == null ? null : class_355.method_1060(this.field_657)[var1 - 1];
      }
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_656 = (class_128)var1;
      if (class_355.method_1056(this.field_657) >= 0) {
         class_128 var2 = class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_235(this.field_655);
         if (this.field_656 != var2) {
            if (var2 != null) {
               int var3 = var2.method_669().ordinal();
               int var4 = class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_233(var3) - var2.method_670();
               if (var4 < 0) {
                  var4 = 0;
               }

               class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_234(var3, var4);
               class_355.method_1058(this.field_657)[var3].setText(Integer.toString(var4));
            }

            if (this.field_656 == null) {
               class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_236(this.field_655, null);
            } else {
               class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_236(this.field_655, this.field_656);
               int var5 = this.field_656.method_669().ordinal();
               int var6 = class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_233(var5) + this.field_656.method_670();
               if (var6 < 0) {
                  var6 = 0;
               }

               class_355.method_1057(this.field_657)[class_355.method_1056(this.field_657)].method_234(var5, var6);
               class_355.method_1058(this.field_657)[var5].setText(Integer.toString(var6));
            }

            class_355.method_1059(this.field_657).updateUI();
         }
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_656;
   }
}
