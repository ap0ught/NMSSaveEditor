package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.hl
public class class_30 {
   // $VF: renamed from: sN java.util.regex.Pattern
   private static final Pattern field_75 = Pattern.compile("0x([0-9a-fA-F]{1,16})");
   // $VF: renamed from: sO java.util.regex.Pattern
   private static final Pattern field_76 = Pattern.compile("[0-9a-fA-F]{12}");
   // $VF: renamed from: sP java.util.regex.Pattern
   private static final Pattern field_77 = Pattern.compile("([0-9a-fA-F]{4}):([0-9a-fA-F]{4}):([0-9a-fA-F]{4}):([0-9a-fA-F]{4})");
   // $VF: renamed from: sQ int
   private int field_78;
   // $VF: renamed from: sR int
   private int field_79;
   // $VF: renamed from: sS int
   private int field_80;
   // $VF: renamed from: sT int
   private int field_81;
   // $VF: renamed from: sU int
   private int field_82;
   // $VF: renamed from: sV int
   private int field_83;

   // $VF: renamed from: aE (java.lang.String) long
   private static long method_95(String var0) {
      long var1 = 0L;

      for (int var4 = 0; var4 < var0.length(); var4++) {
         char var3 = var0.charAt(var4);
         var1 <<= 4;
         if (var3 >= 'A' && var3 <= 'F') {
            var1 |= (long)(var3 - '7');
         } else if (var3 >= 'a' && var3 <= 'f') {
            var1 |= (long)(var3 - 'W');
         } else {
            var1 |= (long)(var3 - '0');
         }
      }

      return var1;
   }

   // $VF: renamed from: a (long, int) int
   private static int method_96(long var0, int var2) {
      int var3 = -1 >>> 32 - var2;
      int var4 = Integer.MIN_VALUE >>> 32 - var2;
      int var5 = (int)(var0 & (long)var3);
      if ((var5 & var4) == var4) {
         var5 |= ~var3;
      }

      return var5;
   }

   // $VF: renamed from: b (long, int) int
   private static int method_97(long var0, int var2) {
      int var3 = -1 >>> 32 - var2;
      return (int)(var0 & (long)var3);
   }

   // $VF: renamed from: e (java.lang.String, int) nomanssave.hl
   public static class_30 method_98(String var0, int var1) {
      Matcher var2;
      if ((var2 = field_77.matcher(var0)).matches()) {
         long var11 = method_95(var2.group(1)) - 2047L;
         if (var11 > 2047L) {
            throw new RuntimeException("Invalid galactic coordinates");
         } else {
            long var12 = method_95(var2.group(2)) - 127L;
            if (var12 > 127L) {
               throw new RuntimeException("Invalid galactic coordinates");
            } else {
               long var13 = method_95(var2.group(3)) - 2047L;
               if (var13 > 2047L) {
                  throw new RuntimeException("Invalid galactic coordinates");
               } else {
                  long var14 = method_95(var2.group(4));
                  if (var14 > 65535L) {
                     throw new RuntimeException("Invalid galactic coordinates");
                  } else {
                     return new class_30((int)(var14 >> 12 & 15L), (int)(var14 & 4095L), var1, (int)var12, (int)var13, (int)var11);
                  }
               }
            }
         }
      } else if (field_76.matcher(var0).matches()) {
         long var3 = method_95(var0);
         int var5 = method_97(var3 >> 44, 4);
         int var6 = method_97(var3 >> 32, 12);
         int var7 = method_96(var3 >> 24, 8);
         int var8 = method_96(var3 >> 12, 12);
         int var9 = method_96(var3, 12);
         return new class_30(var5, var6, var1, var7, var8, var9);
      } else {
         throw new RuntimeException("Unable to decode value");
      }
   }

   // $VF: renamed from: n (java.lang.Object) nomanssave.hl
   public static class_30 method_99(Object var0) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof Number) {
         long var6 = ((Number)var0).longValue();
         return new class_30(var6);
      } else if (var0 instanceof String) {
         String var5 = (String)var0;
         Matcher var2;
         if ((var2 = field_75.matcher(var5)).matches()) {
            long var3 = method_95(var2.group(1));
            return new class_30(var3);
         } else {
            return method_98(var5, 0);
         }
      } else {
         if (var0 instanceof class_137) {
            class_137 var1 = (class_137)var0;
            if (var1.contains("GalacticAddress")) {
               return new class_30((class_137)var0);
            }
         }

         return null;
      }
   }

   private class_30(class_137 var1) {
      this.field_78 = var1.method_706("GalacticAddress.PlanetIndex", 0);
      this.field_79 = var1.method_706("GalacticAddress.SolarSystemIndex", 0);
      this.field_80 = var1.method_706("RealityIndex", 0);
      this.field_81 = var1.method_706("GalacticAddress.VoxelY", 0);
      this.field_82 = var1.method_706("GalacticAddress.VoxelZ", 0);
      this.field_83 = var1.method_706("GalacticAddress.VoxelX", 0);
   }

   public class_30(long var1) {
      this.field_78 = method_97(var1 >> 52, 12);
      this.field_79 = method_97(var1 >> 40, 12);
      this.field_80 = method_97(var1 >> 32, 8);
      this.field_81 = method_96(var1 >> 24, 8);
      this.field_82 = method_96(var1 >> 12, 12);
      this.field_83 = method_96(var1 >> 0, 12);
   }

   private class_30(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.field_78 = var1;
      this.field_79 = var2;
      this.field_80 = var3;
      this.field_81 = var4;
      this.field_82 = var5;
      this.field_83 = var6;
   }

   // $VF: renamed from: eq () int
   public int method_100() {
      return this.field_78;
   }

   // $VF: renamed from: aL (int) void
   public void method_101(int var1) {
      if (var1 >= 0 && var1 <= 15) {
         this.field_78 = var1;
      } else {
         throw new RuntimeException("Invalid planet index: " + var1);
      }
   }

   // $VF: renamed from: er () int
   public int method_102() {
      return this.field_79;
   }

   // $VF: renamed from: aM (int) void
   public void method_103(int var1) {
      if (var1 >= 0 && var1 <= 4095) {
         this.field_79 = var1;
      } else {
         throw new RuntimeException("Invalid solar system index: " + var1);
      }
   }

   // $VF: renamed from: es () int
   public int method_104() {
      return this.field_80;
   }

   // $VF: renamed from: aN (int) void
   public void method_105(int var1) {
      if (var1 >= 0 && var1 <= 255) {
         this.field_80 = var1;
      } else {
         throw new RuntimeException("Invalid reality index: " + var1);
      }
   }

   // $VF: renamed from: et () int
   public int method_106() {
      return this.field_81;
   }

   // $VF: renamed from: aO (int) void
   public void method_107(int var1) {
      if (var1 >= -127 && var1 <= 127) {
         this.field_81 = var1;
      } else {
         throw new RuntimeException("Invalid voxelY coordinate: " + var1);
      }
   }

   // $VF: renamed from: eu () int
   public int method_108() {
      return this.field_82;
   }

   // $VF: renamed from: aP (int) void
   public void method_109(int var1) {
      if (var1 >= -2047 && var1 <= 2047) {
         this.field_82 = var1;
      } else {
         throw new RuntimeException("Invalid voxelZ coordinate: " + var1);
      }
   }

   // $VF: renamed from: ev () int
   public int method_110() {
      return this.field_83;
   }

   // $VF: renamed from: aQ (int) void
   public void method_111(int var1) {
      if (var1 >= -2047 && var1 <= 2047) {
         this.field_83 = var1;
      } else {
         throw new RuntimeException("Invalid voxelX coordinate: " + var1);
      }
   }

   // $VF: renamed from: ew () nomanssave.eY
   public class_137 method_112() {
      return new class_97()
         .method_569("RealityIndex", this.field_80)
         .method_569(
            "GalacticAddress",
            new class_97()
               .method_569("VoxelX", this.field_83)
               .method_569("VoxelY", this.field_81)
               .method_569("VoxelZ", this.field_82)
               .method_569("SolarSystemIndex", this.field_79)
               .method_569("PlanetIndex", this.field_78)
               .method_570()
         )
         .method_570();
   }

   // $VF: renamed from: ex () long
   public long method_113() {
      return ((long)this.field_78 & 15L) << 52
         | ((long)this.field_79 & 4095L) << 40
         | ((long)this.field_80 & 255L) << 32
         | ((long)this.field_81 & 255L) << 24
         | ((long)this.field_82 & 4095L) << 12
         | (long)this.field_83 & 4095L;
   }

   // $VF: renamed from: ey () java.lang.String
   public String method_114() {
      StringBuilder var1 = new StringBuilder();
      var1.append(Integer.toString(this.field_78 & 15, 16));
      var1.append(Integer.toString(this.field_79 & 4095, 16));

      while (var1.length() < 4) {
         var1.insert(1, '0');
      }

      var1.append(Integer.toString(this.field_81 & 0xFF, 16));

      while (var1.length() < 6) {
         var1.insert(4, '0');
      }

      var1.append(Integer.toString(this.field_82 & 4095, 16));

      while (var1.length() < 9) {
         var1.insert(6, '0');
      }

      var1.append(Integer.toString(this.field_83 & 4095, 16));

      while (var1.length() < 12) {
         var1.insert(9, '0');
      }

      return var1.toString().toUpperCase();
   }

   // $VF: renamed from: ez () java.lang.String
   public String method_115() {
      StringBuilder var1 = new StringBuilder();
      var1.append(Integer.toString(this.field_83 + 2047, 16));

      while (var1.length() < 4) {
         var1.insert(0, '0');
      }

      var1.append(':');
      var1.append(Integer.toString(this.field_81 + 127, 16));

      while (var1.length() < 9) {
         var1.insert(5, '0');
      }

      var1.append(':');
      var1.append(Integer.toString(this.field_82 + 2047, 16));

      while (var1.length() < 14) {
         var1.insert(10, '0');
      }

      var1.append(':');
      var1.append(Integer.toString(this.field_78 << 12 | this.field_79, 16));

      while (var1.length() < 19) {
         var1.insert(15, '0');
      }

      return var1.toString().toUpperCase();
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof class_30) {
         class_30 var2 = (class_30)var1;
         if (this.field_78 != var2.field_78) {
            return false;
         } else if (this.field_79 != var2.field_79) {
            return false;
         } else if (this.field_80 != var2.field_80) {
            return false;
         } else if (this.field_81 != var2.field_81) {
            return false;
         } else {
            return this.field_82 != var2.field_82 ? false : this.field_83 == var2.field_83;
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return (int)this.method_113();
   }

   @Override
   public String toString() {
      return "0x" + Long.toString(this.method_113(), 16);
   }
}
