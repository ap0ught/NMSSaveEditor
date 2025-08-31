package nomanssave;

// $VF: renamed from: nomanssave.aL
class class_419 extends class_374 {
   class_419(class_371 var1) {
      this.field_1410 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_371.method_1293(this.field_1410) == null) {
         return "";
      } else {
         int var2 = class_371.method_1293(this.field_1410).method_171();

         try {
            int var3 = class_35.method_149(var1, 0, 100);
            if (var3 != var2) {
               class_371.method_1293(this.field_1410).method_172(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
