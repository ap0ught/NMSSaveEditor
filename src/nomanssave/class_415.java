package nomanssave;

// $VF: renamed from: nomanssave.aP
class class_415 extends class_374 {
   class_415(class_371 var1) {
      this.field_1405 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_371.method_1293(this.field_1405) == null) {
         return "";
      } else {
         long var2 = class_371.method_1293(this.field_1405).method_167();

         try {
            long var4 = class_35.method_150(var1, 0L, 4294967295L);
            if (var4 != var2) {
               class_371.method_1293(this.field_1405).method_168(var4);
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
