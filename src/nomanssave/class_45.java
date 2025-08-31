package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

// $VF: renamed from: nomanssave.gj
public class class_45 {
   // $VF: renamed from: nF nomanssave.gl
   private final class_287 field_120;
   private final int index;
   // $VF: renamed from: bf nomanssave.eY
   private final class_137 field_121;

   // $VF: renamed from: n (nomanssave.eY) boolean
   public static boolean method_272(class_137 var0) {
      return var0.method_703("Pets") != null && var0.method_703("Eggs") != null;
   }

   // $VF: renamed from: o (nomanssave.eY) nomanssave.gj[]
   public static class_45[] method_273(class_137 var0) {
      ArrayList var1 = new ArrayList();
      class_142 var2 = var0.method_703("Pets");
      if (var2 != null) {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            class_137 var4 = var2.method_736(var3);
            if (var4.method_703("CreatureSeed").method_742(0)) {
               var1.add(new class_45(class_287.field_778, var3, var4));
            }
         }
      }

      var2 = var0.method_703("Eggs");
      if (var2 != null) {
         for (int var6 = 0; var6 < var2.size(); var6++) {
            class_137 var7 = var2.method_736(var6);
            if (var7.method_703("CreatureSeed").method_742(0)) {
               var1.add(new class_45(class_287.field_779, var6, var7));
            }
         }
      }

      return var1.toArray(new class_45[0]);
   }

   // $VF: renamed from: a (nomanssave.eY, java.io.File) nomanssave.gj
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static class_45 method_274(class_137 var0, File var1) {
      class_142 var2 = null;
      class_287 var3 = null;
      if (var1.getName().endsWith(".pet")) {
         var2 = var0.method_703("Pets");
         var3 = class_287.field_778;
      }

      if (var1.getName().endsWith(".egg")) {
         var2 = var0.method_703("Eggs");
         var3 = class_287.field_779;
      }

      if (var2 != null && var2.size() != 0) {
         int var4 = -1;

         for (int var5 = 0; var5 < var2.size(); var5++) {
            class_137 var6 = var2.method_736(var5);
            if (!var6.method_703("CreatureSeed").method_742(0)) {
               var4 = var5;
               break;
            }
         }

         if (var4 < 0) {
            throw new RuntimeException("Companion cannot be imported to current file!");
         } else {
            class_137 var15 = class_67.method_367("companion");
            Throwable var16 = null;
            Object var7 = null;

            try {
               class_96 var8 = new class_96(new FileInputStream(var1));

               try {
                  if (var15 == null) {
                     var15 = var8.method_558();
                  } else {
                     var15.method_697(var8.method_558());
                  }
               } finally {
                  if (var8 != null) {
                     var8.close();
                  }
               }
            } catch (Throwable var14) {
               if (var16 == null) {
                  var16 = var14;
               } else if (var16 != var14) {
                  var16.addSuppressed(var14);
               }

               throw var16;
            }

            class_142 var17 = var15.method_703("CreatureSeed");
            if (var17 != null && var17.method_742(0)) {
               var2.method_743(var4, var15);
               return new class_45(var3, var4, var15);
            } else {
               throw new RuntimeException("Invalid creature data");
            }
         }
      } else {
         throw new RuntimeException("Companion cannot be imported to current file!");
      }
   }

   private class_45(class_287 var1, int var2, class_137 var3) {
      this.field_120 = var1;
      this.index = var2;
      this.field_121 = var3;
   }

   public int getIndex() {
      return this.index;
   }

   // $VF: renamed from: cm () void
   public void method_275() {
      this.field_121.method_703("CreatureSeed").method_743(0, Boolean.FALSE);
      this.field_121.method_703("CreatureSeed").method_743(1, "0x0");
   }

   // $VF: renamed from: j (java.io.File) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void method_276(File var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_92 var4 = new class_92(new FileOutputStream(var1));

         try {
            class_137 var5 = this.field_121.method_693();
            var4.method_511(var5);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var11) {
         if (var2 == null) {
            var2 = var11;
         } else if (var2 != var11) {
            var2.addSuppressed(var11);
         }

         throw var2;
      }
   }

   // $VF: renamed from: cL () nomanssave.gl
   public class_287 method_277() {
      return this.field_120;
   }

   public String getName() {
      return this.field_121.getValueAsString("CustomName");
   }

   public void setName(String var1) {
      this.field_121.method_713("CustomName", var1);
   }

   // $VF: renamed from: cM () java.lang.String
   public String method_278() {
      return this.field_121.getValueAsString("CreatureID");
   }

   // $VF: renamed from: cK () java.lang.String
   public String method_279() {
      return this.field_121.method_703("CreatureSeed").method_738(1);
   }

   // $VF: renamed from: aa (java.lang.String) void
   public void method_280(String var1) {
      this.field_121.method_703("CreatureSeed").method_743(1, var1);
   }

   // $VF: renamed from: cN () java.lang.String
   public String method_281() {
      class_142 var1 = this.field_121.method_703("CreatureSecondarySeed");
      return var1.method_742(0) ? var1.method_738(1) : "";
   }

   // $VF: renamed from: ab (java.lang.String) void
   public void method_282(String var1) {
      class_142 var2 = this.field_121.method_703("CreatureSecondarySeed");
      if (var1 != null && var1.length() != 0) {
         var2.method_743(0, true);
         var2.method_743(1, var1);
      } else {
         var2.method_743(0, false);
         var2.method_743(1, "");
      }
   }

   // $VF: renamed from: cO () java.lang.String
   public String method_283() {
      return this.field_121.method_704("SpeciesSeed");
   }

   // $VF: renamed from: ac (java.lang.String) void
   public void method_284(String var1) {
      this.field_121.method_713("SpeciesSeed", var1);
   }

   // $VF: renamed from: cP () java.lang.String
   public String method_285() {
      return this.field_121.method_704("GenusSeed");
   }

   // $VF: renamed from: ad (java.lang.String) void
   public void method_286(String var1) {
      this.field_121.method_713("GenusSeed", var1);
   }

   // $VF: renamed from: cQ () boolean
   public boolean method_287() {
      return this.field_121.method_711("Predator");
   }

   // $VF: renamed from: d (boolean) void
   public void method_288(boolean var1) {
      this.field_121.method_713("Predator", var1);
   }

   // $VF: renamed from: cR () java.lang.String
   public String method_289() {
      return this.field_121.getValueAsString("Biome.Biome");
   }

   // $VF: renamed from: ae (java.lang.String) void
   public void method_290(String var1) {
      this.field_121.method_713("Biome.Biome", var1);
   }

   // $VF: renamed from: cS () java.lang.String
   public String method_291() {
      return this.field_121.getValueAsString("CreatureType.CreatureType");
   }

   // $VF: renamed from: af (java.lang.String) void
   public void method_292(String var1) {
      this.field_121.method_713("CreatureType.CreatureType", var1);
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : this.field_120.name() + " [" + this.index + "]";
   }
}
