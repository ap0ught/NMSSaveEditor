package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;

// $VF: renamed from: nomanssave.eC
public class class_161 {
   // $VF: renamed from: jS nomanssave.eD[]
   private static class_160[] field_510 = new class_160[2];
   // $VF: renamed from: jT nomanssave.eD
   private final class_160 field_511;
   // $VF: renamed from: jU nomanssave.eE
   private final class_159 field_512;

   static {
      field_510[0] = method_815("db/jsonmap.txt", "NMS 5.21 (savegame)");
      field_510[1] = method_815("db/jsonmapac.txt", "NMS 5.21 (account)");
   }

   public static void main(String[] var0) {
      for (int var1 = 0; var1 < field_510.length; var1++) {
         if (field_510[var1] != null) {
            for (class_157 var2 : field_510[var1]) {
               String var4 = hashName(var2.name);
               if (!var2.field_508.equals(var4)) {
                  System.out.println(var2.name + " = " + var2.field_508 + " incorrect, should be " + var4);
               }
            }
         }
      }
   }

   private static String hashName(String var0) {
      long[] var1 = new long[]{8268756125562466087L, 8268756125562466087L};
      class_33.method_138(var0.getBytes("UTF-8"), var1);
      String var2 = "0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
      long var3 = 4294967295L & var1[0] >> 32;
      var3 = var3 % 68L << 32 | 4294967295L & var1[0];
      int var5 = (int)(var3 % 68L);
      int var6 = (int)((8796093022207L & var1[0] >> 21) % 68L);
      int var7 = (int)((4194303L & var1[0] >> 42) % 68L);
      return new String(new char[]{var2.charAt(var5), var2.charAt(var6), var2.charAt(var7)});
   }

   // $VF: renamed from: a (nomanssave.eG, java.lang.String) nomanssave.eC
   public static class_161 method_814(class_297 var0, String var1) {
      class_160 var2 = field_510[var0.ordinal()];
      return var2 != null && var2.s(var1) ? new class_161(var2) : null;
   }

   // $VF: renamed from: c (java.lang.String, java.lang.String) nomanssave.eD
   private static class_160 method_815(String var0, String var1) {
      InputStream var2 = Application.class.getResourceAsStream(var0);
      if (var2 == null) {
         return null;
      } else {
         try {
            return new class_160(var2, var1, null);
         } catch (IOException var4) {
            class_37.error("Could not load key mapping file: " + var0, var4);
            return null;
         }
      }
   }

   private class_161(class_160 var1) {
      this.field_511 = var1;
      this.field_512 = new class_159(null, null);
   }

   // $VF: renamed from: bp () java.util.Map
   public Map method_816() {
      return this.field_512.stream().collect(Collectors.toMap(eC::a, eC::b));
   }

   // $VF: renamed from: q (java.lang.String) java.lang.String
   public String method_817(String var1) {
      String var2;
      class_157 var3;
      if ((var3 = this.field_512.method_811(var1)) != null) {
         var2 = var3.name;
      } else if ((var3 = this.field_511.t(var1)) != null) {
         var2 = var3.name;
      } else {
         if ((var3 = this.field_511.v(var1)) != null) {
            var2 = var3.name;
         } else {
            class_37.warn("  name mapping not found: " + var1);
            var2 = var1;
         }

         this.field_512.method_809(var1, var2);
      }

      return var2;
   }

   // $VF: renamed from: r (java.lang.String) java.lang.String
   public String method_818(String var1) {
      String var2;
      class_157 var3;
      if ((var3 = this.field_512.method_812(var1)) != null) {
         var2 = var3.field_508;
      } else if ((var3 = this.field_511.u(var1)) != null) {
         var2 = var3.field_508;
      } else {
         var2 = var1;
         if (this.field_511.t(var1) == null) {
            class_37.warn("  reverse mapping not found: " + var1);
         }
      }

      return var2;
   }

   @Override
   public String toString() {
      return this.field_511.toString();
   }
}
