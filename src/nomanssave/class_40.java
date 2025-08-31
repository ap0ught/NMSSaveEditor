package nomanssave;

// $VF: renamed from: nomanssave.gw
public class class_40 extends class_39 {
   // $VF: renamed from: oI nomanssave.eY
   private final class_137 field_111;

   class_40(class_137 var1, class_137 var2) {
      super(0, null, var2);
      this.field_111 = var1;
   }

   @Override
   public String getName() {
      return this.field_111.getValueAsString("PlayerWeaponName");
   }

   @Override
   public void setName(String var1) {
      this.field_111.method_713("PlayerWeaponName", var1);
   }

   // $VF: renamed from: cT () java.lang.String
   @Override
   public String method_199() {
      return class_282.field_705.method_39();
   }

   // $VF: renamed from: ag (java.lang.String) void
   @Override
   public void method_200(String var1) {
      if (!class_282.field_705.method_39().equals(var1)) {
         throw new RuntimeException("Only standard types allowed");
      }
   }

   // $VF: renamed from: dI () nomanssave.gx
   public class_282 method_216() {
      return class_282.field_705;
   }

   // $VF: renamed from: a (nomanssave.gx) void
   public void method_217(class_282 var1) {
      if (var1 != class_282.field_705) {
         throw new RuntimeException("Only standard types allowed");
      }
   }

   // $VF: renamed from: cK () java.lang.String
   @Override
   public String method_201() {
      return this.field_111.method_703("CurrentWeapon.GenerationSeed").method_738(1);
   }

   // $VF: renamed from: aa (java.lang.String) void
   @Override
   public void method_202(String var1) {
      this.field_111.method_703("CurrentWeapon.GenerationSeed").method_743(1, var1);
   }

   // $VF: renamed from: cW () java.lang.String
   @Override
   public String method_203() {
      return this.field_111.getValueAsString("WeaponInventory.Class.InventoryClass");
   }

   // $VF: renamed from: aj (java.lang.String) void
   @Override
   public void method_204(String var1) {
      this.field_111.method_713("WeaponInventory.Class.InventoryClass", var1);
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Multitool";
   }
}
