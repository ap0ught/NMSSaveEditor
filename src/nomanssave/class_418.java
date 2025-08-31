package nomanssave;

// $VF: renamed from: nomanssave.aM
class class_418 extends class_374 {
   class_418(class_371 var1) {
      this.field_1409 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_371.method_1293(this.field_1409) == null) {
         return "";
      } else {
         int var2 = class_371.method_1293(this.field_1409).method_173();

         try {
            int var3 = class_35.method_149(var1, 0, 100);
            if (var3 != var2) {
               class_371.method_1293(this.field_1409).method_174(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
