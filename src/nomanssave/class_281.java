package nomanssave;

// $VF: renamed from: nomanssave.gy
public enum class_281 {
   // $VF: renamed from: qR nomanssave.gy
   field_695("Vy’keen", "Warriors", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCVYKEEN.SCENE.MBIN"),
   // $VF: renamed from: qS nomanssave.gy
   field_696("Korvax", "Explorers", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCKORVAX.SCENE.MBIN"),
   // $VF: renamed from: qT nomanssave.gy
   field_697("Gek", "Traders", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCGEK.SCENE.MBIN"),
   // $VF: renamed from: qU nomanssave.gy
   field_698("Fourth Race", null, "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCFOURTH.SCENE.MBIN"),
   // $VF: renamed from: qV nomanssave.gy
   field_699("Vy’keen (Old)", null, "MODELS/PLANETS/NPCS/WARRIOR/WARRIOR.SCENE.MBIN"),
   // $VF: renamed from: qW nomanssave.gy
   field_700("Korvax (Old)", null, "MODELS/PLANETS/NPCS/EXPLORER/EXPLORERIPAD.SCENE.MBIN"),
   // $VF: renamed from: qX nomanssave.gy
   field_701("Gek (Old)", null, "MODELS/PLANETS/NPCS/LOWERORDER/LOWERORDER.SCENE.MBIN"),
   // $VF: renamed from: qY nomanssave.gy
   field_702("Fourth Race (Old)", null, "MODELS/PLANETS/NPCS/FOURTHRACE/FOURTHRACE.SCENE.MBIN");

   private String name;
   // $VF: renamed from: qZ java.lang.String
   private String field_703;
   private String filename;

   private class_281(String var3, String var4, String var5) {
      this.name = var3;
      this.field_703 = var4;
      this.filename = var5;
   }

   // $VF: renamed from: K () java.lang.String
   public String method_844() {
      return this.filename;
   }

   @Override
   public String toString() {
      return this.name;
   }

   // $VF: renamed from: as (java.lang.String) nomanssave.gy
   public static class_281 method_845(String var0) {
      for (int var1 = 0; var1 < values().length; var1++) {
         if (var0.equals(values()[var1].filename)) {
            return values()[var1];
         }
      }

      return null;
   }

   // $VF: renamed from: at (java.lang.String) nomanssave.gy
   public static class_281 method_846(String var0) {
      for (int var1 = 0; var1 < values().length; var1++) {
         if (var0.equals(values()[var1].field_703)) {
            return values()[var1];
         }
      }

      return null;
   }
}
