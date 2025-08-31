package nomanssave;

import javax.swing.JTextField;

// $VF: renamed from: nomanssave.bL
class class_373 extends JTextField {
   // $VF: renamed from: eB nomanssave.bK
   final class_0 field_1357;

   class_373(class_362 var1, class_0 var2, boolean var3) {
      this.field_1358 = var1;
      this.field_1357 = var2;
      this.setEnabled(var3);
      this.addFocusListener(new class_246(this, var2));
   }

   // $VF: renamed from: ac () void
   void method_1311() {
      String var1;
      if (class_362.method_1172(this.field_1358) == null) {
         var1 = "";
      } else {
         var1 = this.field_1357.method_0();
      }

      this.setText(var1);
   }
}
