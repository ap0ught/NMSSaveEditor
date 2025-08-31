package nomanssave;

// $VF: renamed from: nomanssave.gx
public enum class_282 implements class_11 {
   // $VF: renamed from: qH nomanssave.gx
   field_705("Standard", "MODELS/COMMON/WEAPONS/MULTITOOL/MULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qI nomanssave.gx
   field_706("Royal", "MODELS/COMMON/WEAPONS/MULTITOOL/ROYALMULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qJ nomanssave.gx
   field_707("Sentinel", "MODELS/COMMON/WEAPONS/MULTITOOL/SENTINELMULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qK nomanssave.gx
   field_708("Sentinel B", "MODELS/COMMON/WEAPONS/MULTITOOL/SENTINELMULTITOOLB.SCENE.MBIN"),
   // $VF: renamed from: qL nomanssave.gx
   field_709("Switch", "MODELS/COMMON/WEAPONS/MULTITOOL/SWITCHMULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qM nomanssave.gx
   field_710("Staff", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFMULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qN nomanssave.gx
   field_711("Staff NPC", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFNPCMULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qO nomanssave.gx
   field_712("Atlas", "MODELS/COMMON/WEAPONS/MULTITOOL/ATLASMULTITOOL.SCENE.MBIN"),
   // $VF: renamed from: qP nomanssave.gx
   field_713("Atlas Scepter", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFMULTITOOLATLAS.SCENE.MBIN");

   private String name;
   private String filename;

   private class_282(String var3, String var4) {
      this.name = var3;
      this.filename = var4;
   }

   // $VF: renamed from: K () java.lang.String
   @Override
   public String method_39() {
      return this.filename;
   }

   @Override
   public String toString() {
      return this.name;
   }

   // $VF: renamed from: ar (java.lang.String) nomanssave.gx
   public static class_282 method_847(String var0) {
      if (var0 == null) {
         return null;
      } else {
         for (int var1 = 0; var1 < values().length; var1++) {
            if (var0.equals(values()[var1].filename)) {
               return values()[var1];
            }
         }

         return null;
      }
   }
}
