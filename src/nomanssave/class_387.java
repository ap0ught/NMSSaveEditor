package nomanssave;

// $VF: renamed from: nomanssave.dW
class class_387 extends class_374 {
   class_387(class_369 var1) {
      this.field_1374 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_369.method_1264(this.field_1374) == null) {
         return "";
      } else {
         int var2 = class_369.method_1264(this.field_1374).method_477();

         try {
            int var3 = class_35.method_149(var1, 1, 500);
            if (var3 != var2) {
               class_369.method_1264(this.field_1374).method_478(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
