package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.dq
class class_168 implements ActionListener {
   class_168(class_368 var1, Application var2) {
      this.field_525 = var1;
      this.field_526 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_368.method_1238(this.field_525).getSelectedIndex();
      if (var2 >= 0 && var2 < class_368.method_1229(this.field_525).length) {
         if (class_368.method_1229(this.field_525).length == 1) {
            this.field_526.method_1342("You cannot delete the only multitool you have!");
         } else if (JOptionPane.showConfirmDialog(
               this.field_525, "Are you sure you want to delete this multitool?\nAll technology in the multitool will be lost!", "Delete", 2
            )
            == 0) {
            this.field_526.method_1368(class_368.method_1229(this.field_525)[var2].getIndex());
         }
      }
   }
}
