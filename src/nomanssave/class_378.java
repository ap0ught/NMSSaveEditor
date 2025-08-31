package nomanssave;

// $VF: renamed from: nomanssave.ea
class class_378 extends class_374 {
   class_378(class_369 var1) {
      this.field_1365 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      class_75 var2 = (class_75)class_369.method_1265(this.field_1365).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         double var3 = var2.method_452();

         try {
            double var5 = class_35.method_151(var1, 0.0, 1000.0);
            if (var5 != var3) {
               var2.method_453(var5);
            }

            return Double.toString(var5);
         } catch (RuntimeException var7) {
            return Double.toString(var3);
         }
      }
   }
}
