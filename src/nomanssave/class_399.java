package nomanssave;

// $VF: renamed from: nomanssave.bq
class class_399 extends class_374 {
   class_399(class_355 var1) {
      this.field_1387 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1387) < 0) {
         return "";
      } else {
         int var2 = class_355.method_1057(this.field_1387)[class_355.method_1056(this.field_1387)].method_243();

         try {
            int var3 = class_35.method_149(var1, 0, Integer.MAX_VALUE);
            if (var3 != var2) {
               class_355.method_1057(this.field_1387)[class_355.method_1056(this.field_1387)].method_244(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
