package nomanssave;

// $VF: renamed from: nomanssave.aO
class class_416 extends class_374 {
   class_416(class_371 var1) {
      this.field_1406 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_371.method_1293(this.field_1406) == null) {
         return "";
      } else {
         long var2 = class_371.method_1293(this.field_1406).method_165();

         try {
            long var4 = class_35.method_150(var1, 0L, 4294967295L);
            if (var4 != var2) {
               class_371.method_1293(this.field_1406).method_166(var4);
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
