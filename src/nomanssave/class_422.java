package nomanssave;

// $VF: renamed from: nomanssave.K
class class_422 extends class_374 {
   class_422(class_372 var1) {
      this.field_1413 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_46 var2 = (class_46)class_372.method_1304(this.field_1413).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         try {
            var1 = class_34.method_147(var1).toString();
            if (!var1.equals(var2.method_294())) {
               var2.method_295(var1);
            }

            return var1;
         } catch (RuntimeException var4) {
            return var2.method_294();
         }
      }
   }
}
