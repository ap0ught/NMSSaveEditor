package nomanssave;

// $VF: renamed from: nomanssave.be
class class_407 extends class_374 {
   class_407(class_370 var1) {
      this.field_1395 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_370.method_1281(this.field_1395) == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(class_370.method_1281(this.field_1395).getName())) {
            class_370.method_1281(this.field_1395).setName(var1);
            class_370.method_1282(this.field_1395).setText(var1);
         }

         return var1;
      }
   }
}
