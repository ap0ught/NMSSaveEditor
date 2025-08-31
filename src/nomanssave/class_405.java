package nomanssave;

// $VF: renamed from: nomanssave.bg
class class_405 extends class_374 {
   class_405(class_370 var1) {
      this.field_1393 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_370.method_1281(this.field_1393) == null) {
         return "";
      } else {
         try {
            var1 = class_34.method_147(var1).toString();
            if (!var1.equals(class_370.method_1281(this.field_1393).method_258())) {
               class_370.method_1281(this.field_1393).method_259(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return class_370.method_1281(this.field_1393).method_258();
         }
      }
   }
}
