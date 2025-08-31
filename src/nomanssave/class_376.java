package nomanssave;

// $VF: renamed from: nomanssave.eh
class class_376 extends class_374 {
   class_376(class_359 var1, int var2) {
      this.field_1361 = var1;
      this.field_1362 = var2;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      try {
         var1 = class_34.method_147(var1).toString();
         if (!var1.equals(class_367.method_1219(class_359.method_1155(this.field_1361))[this.field_1362].method_380())) {
            class_367.method_1219(class_359.method_1155(this.field_1361))[this.field_1362].method_381(var1);
         }

         return var1;
      } catch (RuntimeException var3) {
         return class_367.method_1219(class_359.method_1155(this.field_1361))[this.field_1362].method_380();
      }
   }
}
