package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.at
class class_260 implements ActionListener {
   class_260(class_363 var1) {
      this.field_667 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int[] var2 = class_363.method_1178(this.field_667).getSelectedRows();
      boolean var3 = false;

      for (int var4 = var2.length - 1; var4 >= 0; var4--) {
         class_363.method_1176(this.field_667).method_745(class_363.method_1178(this.field_667).convertRowIndexToModel(var2[var4]));
         var3 = true;
      }

      if (var3) {
         class_363.method_1178(this.field_667).clearSelection();
         class_363.method_1177(this.field_667).sort();
         class_363.method_1178(this.field_667).updateUI();
      }
   }
}
