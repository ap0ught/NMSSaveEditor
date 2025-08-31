package nomanssave;

// $VF: renamed from: nomanssave.dG
class class_393 extends class_374 {
   class_393(class_352 var1) {
      this.field_1381 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_77 var2 = (class_77)class_352.method_1026(this.field_1381).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            class_352.method_1028(this.field_1381).setText(var1);
         }

         return var1;
      }
   }
}
