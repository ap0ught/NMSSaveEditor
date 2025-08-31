package nomanssave;

// $VF: renamed from: nomanssave.aK
class class_420 extends class_374 {
   class_420(class_371 var1) {
      this.field_1411 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_371.method_1293(this.field_1411) == null) {
         return "";
      } else {
         int var2 = class_371.method_1293(this.field_1411).method_169();

         try {
            int var3 = class_35.method_149(var1, 1, 200);
            if (var3 != var2) {
               class_371.method_1293(this.field_1411).method_170(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
