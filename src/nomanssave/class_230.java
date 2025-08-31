package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.bm
class class_230 implements ActionListener {
   class_230(class_355 var1, Application var2) {
      this.field_614 = var1;
      this.field_615 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_355.method_1056(this.field_614) >= 0) {
         if (JOptionPane.showConfirmDialog(this.field_614, "Are you sure you want to delete this frigate?", "Delete", 2) == 0) {
            class_355.method_1061(
               this.field_614, this.field_615.method_1372(class_355.method_1057(this.field_614)[class_355.method_1056(this.field_614)].getIndex())
            );
            if (class_355.method_1057(this.field_614).length > 0) {
               class_355.method_1059(this.field_614).setRowSelectionInterval(0, 0);
            } else {
               class_355.method_1059(this.field_614).clearSelection();
            }

            class_355.method_1059(this.field_614).updateUI();
         }
      }
   }
}
