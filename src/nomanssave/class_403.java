package nomanssave;

// $VF: renamed from: nomanssave.bi
class class_403 extends class_374 {
   class_403(class_370 var1) {
      this.field_1391 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_370.method_1281(this.field_1391) == null) {
         return "";
      } else {
         double var2 = class_370.method_1281(this.field_1391).method_267();

         try {
            double var4 = class_35.method_151(var1, 0.0, 1000.0);
            if (var4 != var2) {
               class_370.method_1281(this.field_1391).method_268(var4);
            }

            return Double.toString(var4);
         } catch (RuntimeException var6) {
            return Double.toString(var2);
         }
      }
   }
}
