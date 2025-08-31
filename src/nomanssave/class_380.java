package nomanssave;

// $VF: renamed from: nomanssave.do
class class_380 extends class_374 {
   class_380(class_368 var1) {
      this.field_1367 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_39 var2 = (class_39)class_368.method_1238(this.field_1367).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         double var3 = var2.method_210();

         try {
            double var5 = class_35.method_151(var1, 0.0, 1000.0);
            if (var5 != var3) {
               var2.method_211(var5);
            }

            return Double.toString(var5);
         } catch (RuntimeException var7) {
            return Double.toString(var3);
         }
      }
   }
}
