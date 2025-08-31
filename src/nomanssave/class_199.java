package nomanssave;

// $VF: renamed from: nomanssave.cQ
class class_199 {
   final String value;

   class_199(class_333 var1, String var2) {
      this.field_575 = var1;
      this.value = var2;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return this.value.equals(var1);
      } else {
         return var1 instanceof class_198 ? this.value.equals(((class_198)var1).filename) : super.equals(var1);
      }
   }
}
