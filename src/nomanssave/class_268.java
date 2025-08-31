package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.ak
class class_268 implements ActionListener {
   class_268(class_325 var1) {
      this.field_676 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      try {
         class_325.method_952(
            this.field_676, class_30.method_98(class_325.method_950(this.field_676).getText().trim(), class_325.method_951(this.field_676).getSelectedIndex())
         );
         class_325.method_953(this.field_676);
      } catch (RuntimeException var3) {
         JOptionPane.showOptionDialog(this.field_676, "Invalid address value, please try again.", "Error", 0, 0, null, new Object[]{"Cancel"}, null);
      }
   }
}
