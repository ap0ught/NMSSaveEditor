package nomanssave;

// $VF: renamed from: nomanssave.dU
class class_388 extends class_374 {
   class_388(class_369 var1) {
      this.field_1375 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_75 var2 = (class_75)class_369.method_1265(this.field_1375).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         try {
            var1 = class_34.method_147(var1).toString();
            if (!var1.equals(var2.method_439())) {
               var2.method_440(var1);
            }

            return var1;
         } catch (RuntimeException var4) {
            return var2.method_439();
         }
      }
   }
}
