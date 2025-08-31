package nomanssave;

// $VF: renamed from: nomanssave.gB
public class class_79 {
   // $VF: renamed from: oI nomanssave.eY
   private final class_137 field_234;

   // $VF: renamed from: x (nomanssave.eY) nomanssave.gB
   public static class_79 method_481(class_137 var0) {
      return new class_79(var0);
   }

   private class_79(class_137 var1) {
      this.field_234 = var1;
   }

   // $VF: renamed from: dU () int
   public int method_482() {
      return this.field_234.method_705("ActiveMultioolIndex");
   }

   // $VF: renamed from: aF (int) void
   public void method_483(int var1) {
      class_137 var2 = this.field_234.method_702("Multitools[" + var1 + "]");
      if (var2 != null && var2.method_711("Seed[0]")) {
         this.field_234.method_713("ActiveMultioolIndex", var1);
         this.field_234.method_713("WeaponInventory", var2.method_702("Store").method_693());
         this.field_234.method_713("CurrentWeapon.GenerationSeed[1]", var2.method_704("Seed[1]"));
         this.field_234.method_713("CurrentWeapon.Filename", var2.getValueAsString("Resource.Filename"));
      } else {
         throw new RuntimeException("Cannot set current multitool");
      }
   }
}
