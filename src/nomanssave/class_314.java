package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.N
class class_314 implements ActionListener {
   class_314(class_372 var1, Application var2) {
      this.field_995 = var1;
      this.field_996 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_48 var2 = (class_48)class_372.method_1310(this.field_995).getSelectedItem();
      if (var2 != null) {
         this.field_996.method_1334(var2);
      }
   }
}
