package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.az
class class_254 implements ActionListener {
   class_254(class_363 var1) {
      this.field_661 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      for (class_144 var3 : class_144.method_756()) {
         class_80 var2 = class_363.method_1184(this.field_661).method_183(var3);
         var2.method_485(class_296.field_939, false);
         var2.method_485(class_296.field_940, false);
         var2.method_485(class_296.field_941, false);
         var2.method_485(class_296.field_943, false);
         var2.method_485(class_296.field_947, false);
      }

      class_363.method_1185(this.field_661).updateUI();
   }
}
