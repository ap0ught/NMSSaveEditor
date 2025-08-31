package nomanssave;

// $VF: renamed from: nomanssave.gq
public enum class_285 {
   // $VF: renamed from: oS nomanssave.gq
   field_759("Combat"),
   // $VF: renamed from: oT nomanssave.gq
   field_760("Exploration"),
   // $VF: renamed from: oU nomanssave.gq
   field_761("Industry"),
   // $VF: renamed from: oV nomanssave.gq
   field_762("Trading"),
   // $VF: renamed from: oW nomanssave.gq
   field_763("Cost Per Warp"),
   // $VF: renamed from: oX nomanssave.gq
   field_764("Expedition Fuel Cost", -1),
   // $VF: renamed from: oY nomanssave.gq
   field_765("Expedition Duration", -1),
   // $VF: renamed from: oZ nomanssave.gq
   field_766("Loot"),
   // $VF: renamed from: pa nomanssave.gq
   field_767("Repair"),
   // $VF: renamed from: pb nomanssave.gq
   field_768("Damage Reduction"),
   // $VF: renamed from: pc nomanssave.gq
   field_769("Stealth");

   private String name;
   // $VF: renamed from: pd int
   private int field_770;

   private class_285(String var3) {
      this(var3, 1);
   }

   private class_285(String var3, int var4) {
      this.name = var3;
      this.field_770 = var4;
   }

   // $VF: renamed from: di () int
   public int method_849() {
      return this.field_770;
   }

   @Override
   public String toString() {
      return this.name;
   }
}
