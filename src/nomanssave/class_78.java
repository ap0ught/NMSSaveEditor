package nomanssave;

// $VF: renamed from: nomanssave.gC
public class class_78 {
   // $VF: renamed from: oI nomanssave.eY
   private final class_137 field_233;

   // $VF: renamed from: y (nomanssave.eY) nomanssave.gC
   public static class_78 method_474(class_137 var0) {
      return new class_78(var0);
   }

   private class_78(class_137 var1) {
      this.field_233 = var1;
   }

   // $VF: renamed from: dV () int
   public int method_475() {
      return this.field_233.method_705("PrimaryShip");
   }

   // $VF: renamed from: aG (int) void
   public void method_476(int var1) {
      this.field_233.method_713("PrimaryShip", var1);
   }

   // $VF: renamed from: dM () int
   public int method_477() {
      return this.field_233.method_705("ShipHealth");
   }

   // $VF: renamed from: aB (int) void
   public void method_478(int var1) {
      this.field_233.method_713("ShipHealth", new Integer(var1));
   }

   // $VF: renamed from: dN () int
   public int method_479() {
      return this.field_233.method_705("ShipShield");
   }

   // $VF: renamed from: aC (int) void
   public void method_480(int var1) {
      this.field_233.method_713("ShipShield", new Integer(var1));
   }
}
