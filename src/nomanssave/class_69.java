package nomanssave;

// $VF: renamed from: nomanssave.gM
public class class_69 {
   // $VF: renamed from: rH nomanssave.eV
   private final class_142 field_180;
   // $VF: renamed from: rI nomanssave.eY
   private final class_137 field_181;
   private final int index;

   // $VF: renamed from: D (nomanssave.eY) nomanssave.gM[]
   public static class_69[] method_373(class_137 var0) {
      class_142 var1 = var0.method_703("SquadronUnlockedPilotSlots");
      class_142 var2 = var0.method_703("SquadronPilots");
      if (var1 != null && var2 != null) {
         class_69[] var3 = new class_69[Math.min(var1.size(), var2.size())];

         for (int var4 = 0; var4 < var3.length; var4++) {
            var3[var4] = new class_69(var1, var2.method_736(var4), var4);
         }

         return var3;
      } else {
         return new class_69[0];
      }
   }

   private class_69(class_142 var1, class_137 var2, int var3) {
      this.field_180 = var1;
      this.field_181 = var2;
      this.index = var3;
   }

   public boolean isEnabled() {
      return this.field_180.method_742(this.index);
   }

   public void setEnabled(boolean var1) {
      this.field_180.method_743(this.index, var1);
   }

   public boolean isValid() {
      return this.field_181.method_703("NPCResource.Seed").method_742(0) && this.field_181.method_703("ShipResource.Seed").method_742(0);
   }

   // $VF: renamed from: ed () nomanssave.gy
   public class_281 method_374() {
      return class_281.method_845(this.field_181.getValueAsString("NPCResource.Filename"));
   }

   // $VF: renamed from: a (nomanssave.gy) void
   public void method_375(class_281 var1) {
      this.field_181.method_713("NPCResource.Filename", var1.method_844());
   }

   // $VF: renamed from: ee () java.lang.String
   public String method_376() {
      class_142 var1 = this.field_181.method_703("NPCResource.Seed");
      return var1.method_742(0) ? var1.method_738(1) : "";
   }

   // $VF: renamed from: ax (java.lang.String) void
   public void method_377(String var1) {
      class_142 var2 = this.field_181.method_703("NPCResource.Seed");
      if (var1 != null && var1.length() != 0) {
         var2.method_743(0, true);
         var2.method_743(1, var1);
      } else {
         var2.method_743(0, false);
         var2.method_743(1, "0x0");
      }
   }

   // $VF: renamed from: ef () nomanssave.gL
   public class_292 method_378() {
      return class_292.method_852(this.field_181.getValueAsString("ShipResource.Filename"));
   }

   // $VF: renamed from: a (nomanssave.gL) void
   public void method_379(class_292 var1) {
      this.field_181.method_713("ShipResource.Filename", var1.method_39());
   }

   // $VF: renamed from: eg () java.lang.String
   public String method_380() {
      class_142 var1 = this.field_181.method_703("ShipResource.Seed");
      return var1.method_742(0) ? var1.method_738(1) : "";
   }

   // $VF: renamed from: ay (java.lang.String) void
   public void method_381(String var1) {
      class_142 var2 = this.field_181.method_703("ShipResource.Seed");
      if (var1 != null && var1.length() != 0) {
         var2.method_743(0, true);
         var2.method_743(1, var1);
      } else {
         var2.method_743(0, false);
         var2.method_743(1, "0x0");
      }
   }

   // $VF: renamed from: eh () int
   public int method_382() {
      return this.field_181.method_705("PilotRank");
   }

   // $VF: renamed from: aI (int) void
   public void method_383(int var1) {
      this.field_181.method_713("PilotRank", var1);
   }

   @Override
   public String toString() {
      return this.isEnabled() ? (this.isValid() ? "Wingman " + this.index : "EMPTY") : "LOCKED";
   }
}
