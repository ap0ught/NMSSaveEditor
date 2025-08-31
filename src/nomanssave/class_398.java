package nomanssave;

// $VF: renamed from: nomanssave.bv
class class_398 extends class_374 {
   class_398(class_355 var1) {
      this.field_1386 = var1;
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_355.method_1056(this.field_1386) < 0) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(class_355.method_1057(this.field_1386)[class_355.method_1056(this.field_1386)].getName())) {
            class_355.method_1057(this.field_1386)[class_355.method_1056(this.field_1386)].setName(var1);
            class_355.method_1068(this.field_1386).setText(var1);
            class_355.method_1059(this.field_1386).updateUI();
         }

         return var1;
      }
   }
}
