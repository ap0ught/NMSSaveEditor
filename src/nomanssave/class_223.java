package nomanssave;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// $VF: renamed from: nomanssave.cB
class class_223 implements DocumentListener {
   class_223(class_322 var1) {
      this.field_603 = var1;
   }

   @Override
   public void insertUpdate(DocumentEvent var1) {
      class_322.method_924(this.field_603, true);
   }

   @Override
   public void removeUpdate(DocumentEvent var1) {
      class_322.method_924(this.field_603, true);
   }

   @Override
   public void changedUpdate(DocumentEvent var1) {
   }
}
