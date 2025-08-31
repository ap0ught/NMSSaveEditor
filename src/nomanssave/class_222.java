package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.cC
class class_222 implements ActionListener {
   class_222(class_322 var1) {
      this.field_602 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = class_322.method_926(this.field_602).getText().trim();

      try {
         class_322.method_927(this.field_602).setText(var2);
         ((class_217)class_322.method_928(this.field_602).getModel()).method_835(class_322.method_927(this.field_602));
         class_322.method_928(this.field_602).setSelectionRow(0);
         class_322.method_928(this.field_602).setVisible(true);
         class_322.method_929(this.field_602).setVisible(false);
      } catch (class_140 var4) {
         JOptionPane.showOptionDialog(
            this.field_602, "Error on line #" + var4.getLineNumber() + ": " + var4.getMessage(), "Error", 0, 0, null, new Object[]{"Cancel"}, null
         );
         class_322.method_926(this.field_602).setCaretPosition(var4.method_723());
         class_322.method_926(this.field_602).requestFocus();
      }
   }
}
