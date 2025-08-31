package nomanssave;

// $VF: renamed from: nomanssave.by
class class_396 extends class_374 {
   class_396(class_355 var1) {
      this.field_1384 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1384) < 0) {
         return "";
      } else {
         try {
            var1 = class_34.method_147(var1).toString();
            if (!var1.equals(class_355.method_1057(this.field_1384)[class_355.method_1056(this.field_1384)].method_229())) {
               class_355.method_1057(this.field_1384)[class_355.method_1056(this.field_1384)].method_230(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return class_355.method_1057(this.field_1384)[class_355.method_1056(this.field_1384)].method_229();
         }
      }
   }
}
