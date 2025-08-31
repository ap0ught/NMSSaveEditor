package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.br
class class_229 implements ActionListener {
   class_229(class_355 var1, Application var2) {
      this.field_612 = var1;
      this.field_613 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_355.method_1056(this.field_612) >= 0) {
         String var2 = class_34.method_148().toString();
         class_355.method_1061(
            this.field_612, this.field_613.method_1373(class_355.method_1057(this.field_612)[class_355.method_1056(this.field_612)].getIndex(), var2)
         );
         class_355.method_1062(this.field_612).setEnabled(class_355.method_1057(this.field_612).length < 30 || class_130.method_681());
         class_355.method_1059(this.field_612).updateUI();
      }
   }
}
