package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

// $VF: renamed from: nomanssave.bM
class class_246 implements FocusListener {
   class_246(class_373 var1, class_0 var2) {
      this.field_649 = var1;
      this.field_650 = var2;
   }

   @Override
   public void focusGained(FocusEvent var1) {
   }

   @Override
   public void focusLost(FocusEvent var1) {
      if (class_362.method_1172(class_373.method_1312(this.field_649)) != null) {
         JTextField var2 = (JTextField)var1.getComponent();
         String var3 = this.field_650.method_0();
         String var4 = var2.getText();
         if (!var4.equals(var3)) {
            try {
               this.field_650.method_1(var4);
            } catch (RuntimeException var6) {
               var2.setText(var3);
            }
         }
      }
   }
}
