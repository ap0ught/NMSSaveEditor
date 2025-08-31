package nomanssave;

// $VF: renamed from: nomanssave.dM
class class_391 extends class_374 {
   // $VF: renamed from: hH nomanssave.gG
   private final class_293 field_1378;

   private class_391(class_352 var1, class_293 var2) {
      this.field_1379 = var1;
      this.field_1378 = var2;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_77 var2 = (class_77)class_352.method_1026(this.field_1379).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         int var3 = var2.method_462(this.field_1378.ordinal());

         try {
            int var4 = class_35.method_149(var1, 0, this.field_1378.method_853());
            if (var4 != var3) {
               var2.method_463(this.field_1378.ordinal(), var4);
            }

            return Integer.toString(var4);
         } catch (RuntimeException var5) {
            return Integer.toString(var3);
         }
      }
   }
}
