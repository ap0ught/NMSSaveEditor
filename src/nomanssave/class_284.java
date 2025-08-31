package nomanssave;

// $VF: renamed from: nomanssave.gr
public enum class_284 {
   // $VF: renamed from: pf nomanssave.gr
   field_748("Combat", false),
   // $VF: renamed from: pg nomanssave.gr
   field_749("Exploration", false),
   // $VF: renamed from: ph nomanssave.gr
   field_750("Mining", false),
   // $VF: renamed from: pi nomanssave.gr
   field_751("Diplomacy", false),
   // $VF: renamed from: pj nomanssave.gr
   field_752("Support", false),
   // $VF: renamed from: pk nomanssave.gr
   field_753("Normandy", true),
   // $VF: renamed from: pl nomanssave.gr
   field_754("DeepSpace", true),
   // $VF: renamed from: pm nomanssave.gr
   field_755("DeepSpaceCommon", true),
   // $VF: renamed from: pn nomanssave.gr
   field_756("Pirate", false),
   // $VF: renamed from: po nomanssave.gr
   field_757("GhostShip", true);

   private String name;
   private boolean special;

   private class_284(String var3, boolean var4) {
      this.name = var3;
      this.special = var4;
   }

   public boolean isSpecial() {
      return this.special;
   }

   @Override
   public String toString() {
      return this.name;
   }

   // $VF: renamed from: an (java.lang.String) nomanssave.gr
   public static class_284 method_848(String var0) {
      for (int var1 = 0; var1 < values().length; var1++) {
         if (var0.equalsIgnoreCase(values()[var1].name)) {
            return values()[var1];
         }
      }

      return null;
   }
}
