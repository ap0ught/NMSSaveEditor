package nomanssave;

// $VF: renamed from: nomanssave.hf
public class class_35 {
   // $VF: renamed from: b (java.lang.String, int, int) int
   public static int method_149(String var0, int var1, int var2) {
      var0 = var0.trim();
      if (var0.length() == 0) {
         throw new RuntimeException("No digits found");
      } else {
         long var3 = 0L;

         for (int var6 = 0; var6 < var0.length(); var6++) {
            var3 *= 10L;
            char var5 = var0.charAt(var6);
            if (var5 < '0' || var5 > '9') {
               throw new RuntimeException("Invalid digit: " + var5);
            }

            var3 += (long)(var5 - '0');
            if (var3 > (long)var2) {
               return var2;
            }
         }

         return var3 < (long)var1 ? var1 : (int)var3;
      }
   }

   // $VF: renamed from: a (java.lang.String, long, long) long
   public static long method_150(String var0, long var1, long var3) {
      var0 = var0.trim();
      if (var0.length() == 0) {
         throw new RuntimeException("No digits found");
      } else {
         long var5 = 0L;

         for (int var8 = 0; var8 < var0.length(); var8++) {
            var5 *= 10L;
            char var7 = var0.charAt(var8);
            if (var7 < '0' || var7 > '9') {
               throw new RuntimeException("Invalid digit: " + var7);
            }

            var5 += (long)(var7 - '0');
            if (var5 > var3) {
               return var3;
            }
         }

         return var5 < var1 ? var1 : var5;
      }
   }

   // $VF: renamed from: a (java.lang.String, double, double) double
   public static double method_151(String var0, double var1, double var3) {
      var0 = var0.trim();
      double var5 = Double.parseDouble(var0);
      if (var5 < var1) {
         return var1;
      } else {
         return var5 > var3 ? var3 : var5;
      }
   }
}
