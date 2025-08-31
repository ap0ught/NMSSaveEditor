package nomanssave;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.fq
public interface class_7 {
   // $VF: renamed from: lz int
   int field_0 = 15;

   // $VF: renamed from: c (long) java.lang.String
   static String method_13(long var0) {
      int var2 = (int)(var0 % 60L);
      var0 /= 60L;
      int var3 = (int)(var0 % 60L);
      var0 /= 60L;
      int var4 = (int)var0;
      StringBuilder var5 = new StringBuilder();
      var5.append(var4);
      var5.append(':');
      if (var3 < 10) {
         var5.append(0);
      }

      var5.append(var3);
      return var5.toString();
   }

   // $VF: renamed from: c (nomanssave.fq) java.lang.String
   static String method_14(class_7 var0) {
      if (var0 instanceof class_113) {
         return "Steam";
      } else if (var0 instanceof class_104) {
         return "Xbox Game Pass";
      } else {
         return var0 instanceof class_122 ? "PS4 - Save Wizard" : null;
      }
   }

   // $VF: renamed from: a (java.io.File, nomanssave.fR) nomanssave.fq
   static class_7 method_15(File var0, class_3 var1) {
      if (!var0.exists()) {
         return null;
      } else {
         try {
            if (var0.isDirectory()) {
               if (var0.listFiles(fq::e).length > 0) {
                  return new class_104(var0, var1);
               }

               if (var0.listFiles(fq::f).length > 0) {
                  return new class_113(var0, var1);
               }

               if (var0.listFiles(fq::g).length > 0) {
                  return new class_122(var0, var1);
               }
            } else {
               if (var0.getName().equalsIgnoreCase("containers.index")) {
                  return new class_104(var0.getParentFile(), var1);
               }

               if (var0.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", var0.getName().toLowerCase())) {
                  return new class_113(var0.getParentFile(), var1);
               }

               if (Pattern.matches("savedata\\d{2}.hg", var0.getName().toLowerCase())) {
                  return new class_122(var0.getParentFile(), var1);
               }
            }
         } catch (IOException var3) {
            class_37.error("cannot load storage", var3);
         }

         return null;
      }
   }

   // $VF: renamed from: a (java.lang.String, java.io.File, nomanssave.fR) nomanssave.fq
   static class_7 method_16(String var0, File var1, class_3 var2) {
      if (!var1.exists()) {
         return null;
      } else if (var0 == null) {
         return method_15(var1, var2);
      } else {
         try {
            if ("Steam".equals(var0)) {
               return new class_113(var1, var2);
            }

            if ("Xbox Game Pass".equals(var0)) {
               return new class_104(var1, var2);
            }

            if ("PS4 - Save Wizard".equals(var0)) {
               return new class_122(var1, var2);
            }
         } catch (IOException var4) {
            class_37.error("cannot load storage", var4);
         }

         return null;
      }
   }

   // $VF: renamed from: bS () java.io.File
   File method_17();

   // $VF: renamed from: bT () nomanssave.fr
   class_8 method_18();

   // $VF: renamed from: bU () nomanssave.ft[]
   class_10[] method_19();

   // $VF: renamed from: bV () nomanssave.ft[]
   default class_10[] method_20() {
      return Arrays.asList(this.method_19()).stream().filter(fq::a).toArray(fq::af);
   }

   // $VF: renamed from: W (java.lang.String) int
   int method_21(String var1);

   // $VF: renamed from: bW () boolean
   default boolean method_22() {
      return false;
   }

   // $VF: renamed from: a (int, nomanssave.eY) java.lang.String
   default String method_23(int var1, class_137 var2) {
      throw new IOException("cannot create slot " + (var1 + 1));
   }

   // $VF: renamed from: X (java.lang.String) void
   void method_24(String var1);
}
