package nomanssave;

// $VF: renamed from: nomanssave.gL
public enum class_292 implements class_11 {
   // $VF: renamed from: rs nomanssave.gL
   field_858("Hauler", "MODELS/COMMON/SPACECRAFT/DROPSHIPS/DROPSHIP_PROC.SCENE.MBIN", 4),
   // $VF: renamed from: rt nomanssave.gL
   field_859("Explorer", "MODELS/COMMON/SPACECRAFT/SCIENTIFIC/SCIENTIFIC_PROC.SCENE.MBIN", 4),
   // $VF: renamed from: ru nomanssave.gL
   field_860("Shuttle", "MODELS/COMMON/SPACECRAFT/SHUTTLE/SHUTTLE_PROC.SCENE.MBIN", 4),
   // $VF: renamed from: rv nomanssave.gL
   field_861("Fighter", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTER_PROC.SCENE.MBIN", 4),
   // $VF: renamed from: rw nomanssave.gL
   field_862("Exotic", "MODELS/COMMON/SPACECRAFT/S-CLASS/S-CLASS_PROC.SCENE.MBIN", 4),
   // $VF: renamed from: rx nomanssave.gL
   field_863("Living", "MODELS/COMMON/SPACECRAFT/S-CLASS/BIOPARTS/BIOSHIP_PROC.SCENE.MBIN", 64),
   // $VF: renamed from: ry nomanssave.gL
   field_864("Solar", "MODELS/COMMON/SPACECRAFT/SAILSHIP/SAILSHIP_PROC.SCENE.MBIN", 4),
   // $VF: renamed from: rz nomanssave.gL
   field_865("Utopia Speeder", "MODELS/COMMON/SPACECRAFT/FIGHTERS/VRSPEEDER.SCENE.MBIN", 4),
   // $VF: renamed from: rA nomanssave.gL
   field_866("Golden Vector", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTERCLASSICGOLD.SCENE.MBIN", 4),
   // $VF: renamed from: rB nomanssave.gL
   field_867("Horizon Vector NX (Switch)", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTERSPECIALSWITCH.SCENE.MBIN", 4),
   // $VF: renamed from: rC nomanssave.gL
   field_868("Robot", "MODELS/COMMON/SPACECRAFT/SENTINELSHIP/SENTINELSHIP_PROC.SCENE.MBIN", 256),
   // $VF: renamed from: rD nomanssave.gL
   field_869("Starborn Runner", "MODELS/COMMON/SPACECRAFT/FIGHTERS/WRACER.SCENE.MBIN", 4),
   // $VF: renamed from: rE nomanssave.gL
   field_870("Corvette", "MODELS/COMMON/SPACECRAFT/BIGGS/BIGGS.SCENE.MBIN", 4);

   private String name;
   private String filename;
   // $VF: renamed from: rF int
   private int field_871;

   private class_292(String var3, String var4, int var5) {
      this.name = var3;
      this.filename = var4;
      this.field_871 = var5;
   }

   // $VF: renamed from: K () java.lang.String
   @Override
   public String method_39() {
      return this.filename;
   }

   // $VF: renamed from: ea () int
   public int method_851() {
      return this.field_871;
   }

   @Override
   public String toString() {
      return this.name;
   }

   // $VF: renamed from: aw (java.lang.String) nomanssave.gL
   public static class_292 method_852(String var0) {
      for (int var1 = 0; var1 < values().length; var1++) {
         if (var0.equals(values()[var1].filename)) {
            return values()[var1];
         }
      }

      return null;
   }
}
