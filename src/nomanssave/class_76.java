package nomanssave;

// $VF: renamed from: nomanssave.gF
public class class_76 implements class_12 {
   // $VF: renamed from: kM nomanssave.eY
   private final class_137 field_230;

   private class_76(class_77 var1, class_137 var2) {
      this.field_231 = var1;
      this.field_230 = var2;
   }

   public boolean isValid() {
      String var1 = this.field_230.getValueAsString("ElementId");
      return var1 != null && var1.length() > 1;
   }

   @Override
   public String getType() {
      return "Product";
   }

   // $VF: renamed from: dz () java.lang.Object
   @Override
   public Object method_40() {
      return this.field_230.getValue("ElementId");
   }

   // $VF: renamed from: m (java.lang.Object) void
   @Override
   public void method_42(Object var1) {
      this.field_230.method_713("ElementId", var1);
      this.field_230.method_713("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
   }

   // $VF: renamed from: dA () int
   @Override
   public int method_43() {
      return this.field_230.method_705("Amount");
   }

   // $VF: renamed from: aA (int) void
   @Override
   public void method_44(int var1) {
      this.field_230.method_713("Amount", var1);
      this.field_230.method_713("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
   }

   // $VF: renamed from: dB () int
   @Override
   public int method_45() {
      return 999;
   }
}
