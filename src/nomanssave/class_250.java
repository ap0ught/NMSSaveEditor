package nomanssave;

// $VF: renamed from: nomanssave.bF
class class_250 implements class_0 {
   class_250(class_362 var1) {
      this.field_654 = var1;
   }

   @Override
   public String getID() {
      return "ExtremeSurvival";
   }

   @Override
   public boolean isSpecial() {
      return false;
   }

   // $VF: renamed from: ab () java.lang.String
   @Override
   public String method_0() {
      return Double.toString(class_362.method_1172(this.field_654).method_186());
   }

   // $VF: renamed from: l (java.lang.String) void
   @Override
   public void method_1(String var1) {
      double var2 = Double.parseDouble(var1);
      class_362.method_1172(this.field_654).method_187(var2);
   }
}
