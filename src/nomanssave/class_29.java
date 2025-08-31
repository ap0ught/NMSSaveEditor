package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.i
class class_29 implements ActionListener {
   class_29(class_319 var1) {
      this.field_74 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = class_319.method_887(this.field_74).getText();
      class_319.method_889(this.field_74, class_152.method_792(class_319.method_888(this.field_74), var2));
      class_319.method_890(this.field_74);
      if (class_319.method_891(this.field_74).size() == 0) {
         JOptionPane.showOptionDialog(this.field_74, "Item not found.", "Warning", 0, 2, null, new Object[]{"OK"}, null);
      }
   }
}
