package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.ay
class class_255 implements ActionListener {
   class_255(class_363 var1) {
      this.field_662 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      for (class_144 var3 : class_144.method_756()) {
         class_80 var2 = class_363.method_1184(this.field_662).method_183(var3);
         if (var3.method_751(class_296.field_939)) {
            var2.method_485(class_296.field_939, true);
         }

         if (var3.method_751(class_296.field_940)) {
            var2.method_485(class_296.field_940, true);
         }

         if (var3.method_751(class_296.field_941)) {
            var2.method_485(class_296.field_941, true);
         }

         if (var3.method_751(class_296.field_943)) {
            var2.method_485(class_296.field_943, true);
         }

         if (var3.method_751(class_296.field_947)) {
            var2.method_485(class_296.field_947, true);
         }
      }

      class_363.method_1185(this.field_662).updateUI();
   }
}
