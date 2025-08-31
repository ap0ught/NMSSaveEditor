package nomanssave;

// $VF: renamed from: nomanssave.ae
class class_412 extends class_374 {
   class_412(class_364 var1) {
      this.field_1402 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_45 var2 = (class_45)class_364.method_1198(this.field_1402).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.method_281())) {
            var2.method_282(var1);
            class_364.method_1192(this.field_1402).setText(var1);
         }

         return var1;
      }
   }
}
