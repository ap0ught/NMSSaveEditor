package nomanssave;

// $VF: renamed from: nomanssave.ei
class class_375 extends class_374 {
   class_375(class_359 var1, int var2) {
      this.field_1359 = var1;
      this.field_1360 = var2;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      try {
         int var2 = Integer.parseInt(var1);
         if (var2 != class_367.method_1219(class_359.method_1155(this.field_1359))[this.field_1360].method_382()) {
            class_367.method_1219(class_359.method_1155(this.field_1359))[this.field_1360].method_383(var2);
         }

         return var1;
      } catch (RuntimeException var3) {
         return Integer.toString(class_367.method_1219(class_359.method_1155(this.field_1359))[this.field_1360].method_382());
      }
   }
}
