package nomanssave;

// $VF: renamed from: nomanssave.ch
class class_395 extends class_374 {
   class_395(class_323 var1) {
      this.field_1383 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_323.method_933(this.field_1383) == null) {
         return "";
      } else {
         try {
            int var2 = class_35.method_149(var1, 0, 99999);
            if (class_323.method_933(this.field_1383) != var2) {
               class_323.method_934(this.field_1383).method_42(class_323.method_935(this.field_1383).method_776(var2));
               class_323.method_936(this.field_1383, new Integer(var2));
            }
         } catch (RuntimeException var3) {
         }

         return class_323.method_933(this.field_1383).toString();
      }
   }
}
