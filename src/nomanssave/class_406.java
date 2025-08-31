package nomanssave;

// $VF: renamed from: nomanssave.bf
class class_406 extends class_374 {
   class_406(class_370 var1) {
      this.field_1394 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_370.method_1281(this.field_1394) == null) {
         return "";
      } else {
         try {
            var1 = var1.trim();
            if (!var1.equals(class_370.method_1281(this.field_1394).method_256())) {
               class_370.method_1281(this.field_1394).method_257(var1);
               class_370.method_1283(this.field_1394).setText(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return class_370.method_1281(this.field_1394).method_256();
         }
      }
   }
}
