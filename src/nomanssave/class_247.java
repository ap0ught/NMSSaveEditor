package nomanssave;

// $VF: renamed from: nomanssave.bI
class class_247 implements class_0 {
   class_247(class_362 var1) {
      this.field_651 = var1;
   }

   @Override
   public String getID() {
      return "TWordsLearnt";
   }

   @Override
   public boolean isSpecial() {
      return true;
   }

   // $VF: renamed from: ab () java.lang.String
   @Override
   public String method_0() {
      return Integer.toString(class_362.method_1172(this.field_651).method_182(class_296.field_941));
   }

   // $VF: renamed from: l (java.lang.String) void
   @Override
   public void method_1(String var1) {
      throw new RuntimeException("Cannot set words learnt");
   }
}
