package nomanssave;

// $VF: renamed from: nomanssave.bA
class class_409 extends class_374 {
   private final int index;

   private class_409(class_355 var1, int var2) {
      this.field_1399 = var1;
      this.index = var2;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1399) < 0) {
         return "";
      } else {
         int var2 = class_355.method_1057(this.field_1399)[class_355.method_1056(this.field_1399)].method_233(this.index);

         try {
            int var3 = class_35.method_149(var1, 0, 50);
            if (var3 != var2) {
               class_355.method_1057(this.field_1399)[class_355.method_1056(this.field_1399)].method_234(this.index, var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
