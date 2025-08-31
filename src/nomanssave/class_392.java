package nomanssave;

// $VF: renamed from: nomanssave.dH
class class_392 extends class_374 {
   class_392(class_352 var1) {
      this.field_1380 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_77 var2 = (class_77)class_352.method_1026(this.field_1380).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         try {
            var1 = class_34.method_147(var1).toString();
            if (!var1.equals(var2.method_469())) {
               var2.method_470(var1);
            }

            return var1;
         } catch (RuntimeException var4) {
            return var2.method_469();
         }
      }
   }
}
