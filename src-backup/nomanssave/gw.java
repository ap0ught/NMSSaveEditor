package nomanssave;

public class gw extends gv {
   private final eY oI;

   gw(eY var1, eY var2) {
      super(0, null, var2);
      this.oI = var1;
   }

   @Override
   public String getName() {
      return this.oI.getValueAsString("PlayerWeaponName");
   }

   @Override
   public void setName(String var1) {
      this.oI.b("PlayerWeaponName", var1);
   }

   @Override
   public String cT() {
      return gx.qH.K();
   }

   @Override
   public void ag(String var1) {
      if (!gx.qH.K().equals(var1)) {
         throw new RuntimeException("Only standard types allowed");
      }
   }

   public gx dI() {
      return gx.qH;
   }

   public void a(gx var1) {
      if (var1 != gx.qH) {
         throw new RuntimeException("Only standard types allowed");
      }
   }

   @Override
   public String cK() {
      return this.oI.d("CurrentWeapon.GenerationSeed").X(1);
   }

   @Override
   public void aa(String var1) {
      this.oI.d("CurrentWeapon.GenerationSeed").a(1, var1);
   }

   @Override
   public String cW() {
      return this.oI.getValueAsString("WeaponInventory.Class.InventoryClass");
   }

   @Override
   public void aj(String var1) {
      this.oI.b("WeaponInventory.Class.InventoryClass", var1);
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Multitool";
   }
}
