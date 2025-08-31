package nomanssave;

// $VF: renamed from: nomanssave.eU
public enum class_296 {
   // $VF: renamed from: kr nomanssave.eU
   field_939("Gek"),
   // $VF: renamed from: ks nomanssave.eU
   field_940("Vy'keen"),
   // $VF: renamed from: kt nomanssave.eU
   field_941("Korvax"),
   // $VF: renamed from: ku nomanssave.eU
   field_942("Robot"),
   // $VF: renamed from: kv nomanssave.eU
   field_943("Atlas"),
   // $VF: renamed from: kw nomanssave.eU
   field_944("Diplomats"),
   // $VF: renamed from: kx nomanssave.eU
   field_945("Exotics"),
   // $VF: renamed from: ky nomanssave.eU
   field_946("None"),
   // $VF: renamed from: kz nomanssave.eU
   field_947("Autophage");

   private String name;

   private class_296(String var3) {
      this.name = var3;
   }

   @Override
   public String toString() {
      return this.name;
   }

   // $VF: renamed from: C (java.lang.String) nomanssave.eU
   public static class_296 method_857(String var0) {
      class_296[] var4;
      for (class_296 var1 : var4 = values()) {
         if (var1.name().equals(var0)) {
            return var1;
         }
      }

      return null;
   }
}
