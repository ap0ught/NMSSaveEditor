package nomanssave;

// $VF: renamed from: nomanssave.gh
public class class_46 {
   final String name;
   // $VF: renamed from: nn nomanssave.eY
   final class_137 field_122;

   private class_46(class_49 var1, String var2, class_137 var3) {
      this.field_123 = var1;
      this.name = var2;
      this.field_122 = var3;
   }

   // $VF: renamed from: cJ () nomanssave.gy
   public class_281 method_293() {
      return class_281.method_845(this.field_122.getValueAsString("ResourceElement.Filename"));
   }

   // $VF: renamed from: cK () java.lang.String
   public String method_294() {
      return this.field_122.method_703("ResourceElement.Seed").method_738(1);
   }

   // $VF: renamed from: aa (java.lang.String) void
   public void method_295(String var1) {
      this.field_122.method_703("ResourceElement.Seed").method_743(1, var1);
   }

   @Override
   public String toString() {
      return this.name;
   }
}
