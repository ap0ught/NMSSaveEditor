package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.aw
class class_257 implements ActionListener {
   class_257(class_363 var1) {
      this.field_664 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int[] var2 = class_363.method_1183(this.field_664).getSelectedRows();
      boolean var3 = false;

      for (int var4 = var2.length - 1; var4 >= 0; var4--) {
         int var5 = class_363.method_1183(this.field_664).convertRowIndexToModel(var2[var4]);
         String var6 = (String)class_363.method_1179(this.field_664).get(var5);
         class_363.method_1179(this.field_664).remove(var5);

         while ((var5 = class_363.method_1180(this.field_664).indexOf(var6)) >= 0) {
            class_363.method_1180(this.field_664).method_745(var5);
         }

         while ((var5 = class_363.method_1181(this.field_664).indexOf(var6)) >= 0) {
            class_363.method_1181(this.field_664).method_745(var5);
         }

         var3 = true;
      }

      if (var3) {
         class_363.method_1183(this.field_664).clearSelection();
         class_363.method_1182(this.field_664).sort();
         class_363.method_1183(this.field_664).updateUI();
      }
   }
}
