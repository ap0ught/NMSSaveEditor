package nomanssave;

// $VF: renamed from: nomanssave.ci
class class_394 extends class_374 {
   class_394(class_323 var1) {
      this.field_1382 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_323.method_937(this.field_1382) == null) {
         return "";
      } else {
         try {
            int var2 = class_35.method_149(var1, 1, class_323.method_934(this.field_1382).method_45());
            if (class_323.method_937(this.field_1382) != var2) {
               class_323.method_934(this.field_1382).method_44(var2);
               class_323.method_938(this.field_1382, new Integer(var2));
            }
         } catch (RuntimeException var3) {
         }

         return class_323.method_937(this.field_1382).toString();
      }
   }
}
