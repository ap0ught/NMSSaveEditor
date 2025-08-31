package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.ai
class class_269 implements ActionListener {
   class_269(class_364 var1, Application var2) {
      this.field_677 = var1;
      this.field_678 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_364.method_1198(this.field_677).getSelectedIndex();
      if (var2 >= 0 && var2 < class_364.method_1188(this.field_677).length) {
         if (JOptionPane.showConfirmDialog(this.field_677, "Are you sure you want to delete this companion?", "Delete", 2) == 0) {
            this.field_678.method_1370(class_364.method_1188(this.field_677)[var2].method_277(), class_364.method_1188(this.field_677)[var2].getIndex());
         }
      }
   }
}
