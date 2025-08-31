package nomanssave;

// $VF: renamed from: nomanssave.dm
class class_382 extends class_374 {
   class_382(class_368 var1) {
      this.field_1369 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_39 var2 = (class_39)class_368.method_1238(this.field_1369).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         try {
            var1 = class_34.method_147(var1).toString();
            if (!var1.equals(var2.method_201())) {
               var2.method_202(var1);
            }

            return var1;
         } catch (RuntimeException var4) {
            return var2.method_201();
         }
      }
   }
}
