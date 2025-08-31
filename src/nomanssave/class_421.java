package nomanssave;

// $VF: renamed from: nomanssave.M
class class_421 extends class_374 {
   class_421(class_372 var1) {
      this.field_1412 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_48 var2 = (class_48)class_372.method_1310(this.field_1412).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            class_372.method_1306(this.field_1412).setText(var1);
         }

         return var1;
      }
   }
}
