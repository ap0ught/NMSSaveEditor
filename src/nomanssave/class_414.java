package nomanssave;

// $VF: renamed from: nomanssave.ac
class class_414 extends class_374 {
   class_414(class_364 var1) {
      this.field_1404 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_45 var2 = (class_45)class_364.method_1198(this.field_1404).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            class_364.method_1190(this.field_1404).setText(var1);
         }

         return var1;
      }
   }
}
