package nomanssave;

// $VF: renamed from: nomanssave.go
public enum class_286 implements class_11 {
   // $VF: renamed from: oL nomanssave.go
   field_772("Tiny", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTERTINY_PROC.SCENE.MBIN"),
   // $VF: renamed from: oM nomanssave.go
   field_773("Small", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTERSMALL_PROC.SCENE.MBIN"),
   // $VF: renamed from: oN nomanssave.go
   field_774("Normal", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTER_PROC.SCENE.MBIN"),
   // $VF: renamed from: oO nomanssave.go
   field_775("Capital", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/CAPITALFREIGHTER_PROC.SCENE.MBIN"),
   // $VF: renamed from: oP nomanssave.go
   field_776("Pirate", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/PIRATEFREIGHTER.SCENE.MBIN");

   private String name;
   private String filename;

   private class_286(String var3, String var4) {
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

   // $VF: renamed from: al (java.lang.String) nomanssave.go
   public static class_286 method_850(String var0) {
      for (int var1 = 0; var1 < values().length; var1++) {
         if (var0.equals(values()[var1].filename)) {
            return values()[var1];
         }
      }

      return null;
   }
}
