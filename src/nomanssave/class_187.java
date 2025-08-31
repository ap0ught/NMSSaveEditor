package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.dB
class class_187 implements ActionListener {
   class_187(class_320 var1) {
      this.field_554 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_320.method_907(this.field_554).getSelectedIndex();
      if (var2 < 0
         || class_320.method_906(this.field_554)[var2].isEmpty()
         || JOptionPane.showConfirmDialog(this.field_554, "You are about to overwrite this save slot, are you sure you want to do this?", "Warning", 2) == 0) {
         class_320.method_908(this.field_554, var2);
         this.field_554.setVisible(false);
      }
   }
}
