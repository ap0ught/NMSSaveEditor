package nomanssave;

// $VF: renamed from: nomanssave.dT
class class_389 extends class_374 {
   class_389(class_369 var1) {
      this.field_1376 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_75 var2 = (class_75)class_369.method_1265(this.field_1376).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            class_369.method_1251(this.field_1376).setText(var1);
         }

         return var1;
      }
   }
}
