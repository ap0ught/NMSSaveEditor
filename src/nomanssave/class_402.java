package nomanssave;

// $VF: renamed from: nomanssave.bn
class class_402 extends class_374 {
   class_402(class_355 var1) {
      this.field_1390 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1390) < 0) {
         return "";
      } else {
         int var2 = class_355.method_1057(this.field_1390)[class_355.method_1056(this.field_1390)].method_237();

         try {
            int var3 = class_35.method_149(var1, 0, Integer.MAX_VALUE);
            if (var3 != var2) {
               class_355.method_1057(this.field_1390)[class_355.method_1056(this.field_1390)].method_238(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
