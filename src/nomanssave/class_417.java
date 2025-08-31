package nomanssave;

// $VF: renamed from: nomanssave.aN
class class_417 extends class_374 {
   class_417(class_371 var1, Application var2) {
      this.field_1407 = var1;
      this.field_1408 = var2;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_371.method_1293(this.field_1407) == null) {
         return "";
      } else {
         long var2 = class_371.method_1293(this.field_1407).method_163();

         try {
            long var4 = class_35.method_150(var1, 0L, 4294967295L);
            if (var4 != var2) {
               class_371.method_1293(this.field_1407).method_164(var4);
               this.field_1408.method_1363();
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
