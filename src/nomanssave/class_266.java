package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.am
class class_266 implements ActionListener {
   class_266(class_325 var1) {
      this.field_673 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_325.method_951(this.field_673).getSelectedIndex();
      if (var2 < 0) {
         JOptionPane.showOptionDialog(this.field_673, "Invalid galaxy selected, please try again.", "Error", 0, 0, null, new Object[]{"Cancel"}, null);
      } else {
         if (JOptionPane.showOptionDialog(
               this.field_673,
               "This will warp your character and ship to the specified system (not the portal itself).",
               "Confirm",
               2,
               1,
               null,
               new String[]{"OK", "Cancel"},
               null
            )
            == 0) {
            class_325.method_955(this.field_673, true);
            this.field_673.setVisible(false);
         }
      }
   }
}
