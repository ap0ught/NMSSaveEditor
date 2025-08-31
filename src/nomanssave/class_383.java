package nomanssave;

// $VF: renamed from: nomanssave.dl
class class_383 extends class_374 {
   class_383(class_368 var1) {
      this.field_1370 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_39 var2 = (class_39)class_368.method_1238(this.field_1370).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            class_368.method_1230(this.field_1370).setText(var1);
         }

         return var1;
      }
   }
}
