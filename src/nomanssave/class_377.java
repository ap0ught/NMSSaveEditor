package nomanssave;

// $VF: renamed from: nomanssave.ef
class class_377 extends class_374 {
   class_377(class_359 var1, int var2) {
      this.field_1363 = var1;
      this.field_1364 = var2;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      try {
         var1 = class_34.method_147(var1).toString();
         if (!var1.equals(class_367.method_1219(class_359.method_1155(this.field_1363))[this.field_1364].method_376())) {
            class_367.method_1219(class_359.method_1155(this.field_1363))[this.field_1364].method_377(var1);
         }

         return var1;
      } catch (RuntimeException var3) {
         return class_367.method_1219(class_359.method_1155(this.field_1363))[this.field_1364].method_376();
      }
   }
}
