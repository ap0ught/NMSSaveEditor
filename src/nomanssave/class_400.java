package nomanssave;

// $VF: renamed from: nomanssave.bp
class class_400 extends class_374 {
   class_400(class_355 var1) {
      this.field_1388 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1388) < 0) {
         return "";
      } else {
         int var2 = class_355.method_1057(this.field_1388)[class_355.method_1056(this.field_1388)].method_241();

         try {
            int var3 = class_35.method_149(var1, 0, Integer.MAX_VALUE);
            if (var3 != var2) {
               class_355.method_1057(this.field_1388)[class_355.method_1056(this.field_1388)].method_242(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
