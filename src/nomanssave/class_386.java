package nomanssave;

// $VF: renamed from: nomanssave.dX
class class_386 extends class_374 {
   class_386(class_369 var1) {
      this.field_1373 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_369.method_1264(this.field_1373) == null) {
         return "";
      } else {
         int var2 = class_369.method_1264(this.field_1373).method_479();

         try {
            int var3 = class_35.method_149(var1, 1, 200);
            if (var3 != var2) {
               class_369.method_1264(this.field_1373).method_480(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
