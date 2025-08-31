package nomanssave;

// $VF: renamed from: nomanssave.bx
class class_397 extends class_374 {
   class_397(class_355 var1) {
      this.field_1385 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1385) < 0) {
         return "";
      } else {
         try {
            var1 = var1.trim();
            if (!var1.equals(class_355.method_1057(this.field_1385)[class_355.method_1056(this.field_1385)].method_227())) {
               class_355.method_1057(this.field_1385)[class_355.method_1056(this.field_1385)].method_228(var1);
               class_355.method_1072(this.field_1385).setText(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return class_355.method_1057(this.field_1385)[class_355.method_1056(this.field_1385)].method_227();
         }
      }
   }
}
