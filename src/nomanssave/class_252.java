package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.bB
class class_252 implements ComboBoxModel {
   // $VF: renamed from: eu nomanssave.er
   class_128 field_658;

   private class_252(class_355 var1) {
      this.field_659 = var1;
   }

   @Override
   public int getSize() {
      return class_355.method_1055(this.field_659) == null ? 0 : class_355.method_1055(this.field_659).length;
   }

   // $VF: renamed from: v (int) nomanssave.er
   public class_128 method_840(int var1) {
      return class_355.method_1055(this.field_659) == null ? null : class_355.method_1055(this.field_659)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_658 = (class_128)var1;
      if (class_355.method_1056(this.field_659) >= 0) {
         class_128 var2 = class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_235(0);
         if (this.field_658 != var2) {
            if (var2 != null) {
               int var3 = var2.method_669().ordinal();
               int var4 = class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_233(var3) - var2.method_670();
               if (var4 < 0) {
                  var4 = 0;
               }

               class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_234(var3, var4);
               class_355.method_1058(this.field_659)[var3].setText(Integer.toString(var4));
            }

            if (this.field_658 == null) {
               class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_236(0, null);
            } else {
               class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_236(0, this.field_658);
               int var5 = this.field_658.method_669().ordinal();
               int var6 = class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_233(var5) + this.field_658.method_670();
               if (var6 < 0) {
                  var6 = 0;
               }

               class_355.method_1057(this.field_659)[class_355.method_1056(this.field_659)].method_234(var5, var6);
               class_355.method_1058(this.field_659)[var5].setText(Integer.toString(var6));
            }

            class_355.method_1059(this.field_659).updateUI();
         }
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_658;
   }
}
