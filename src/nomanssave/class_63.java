package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// $VF: renamed from: nomanssave.gV
public class class_63 {
   // $VF: renamed from: a (nomanssave.eY, java.lang.String) double[]
   private static double[] method_339(class_137 var0, String var1) {
      class_142 var2 = var0.method_703(var1);
      if (var2.size() != 3) {
         throw new RuntimeException("Invalid " + var1 + " coordinates");
      } else {
         return new double[]{var2.method_741(0), var2.method_741(1), var2.method_741(2)};
      }
   }

   // $VF: renamed from: a (nomanssave.eY, java.lang.String, double[]) void
   private static void method_340(class_137 var0, String var1, double[] var2) {
      var0.method_713(
         var1,
         new class_142(
            new Double(Double.isNaN(var2[0]) ? 0.0 : var2[0]),
            new Double(Double.isNaN(var2[1]) ? 0.0 : var2[1]),
            new Double(Double.isNaN(var2[2]) ? 0.0 : var2[2])
         )
      );
   }

   // $VF: renamed from: F (nomanssave.eY) boolean
   public static boolean method_341(class_137 var0) {
      return method_342(var0, "^BUILDSIGNAL");
   }

   // $VF: renamed from: b (nomanssave.eY, java.lang.String) boolean
   public static boolean method_342(class_137 var0, String var1) {
      class_142 var2 = var0.method_703("Objects");
      class_137 var3 = null;
      class_137 var4 = null;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         class_137 var6 = var2.method_736(var5);
         if ("^BASE_FLAG".equals(var6.getValueAsString("ObjectID"))) {
            if (var3 != null) {
               class_37.warn("  multiple base computers found");
               return false;
            }

            var3 = var6;
         } else if (var1.equals(var6.getValueAsString("ObjectID"))) {
            if (var4 != null) {
               class_37.warn("  multiple " + var1 + " objects found");
               return false;
            }

            var4 = var6;
         }
      }

      if (var3 == null) {
         class_37.warn("  no base computer found");
         return false;
      } else if (var4 == null) {
         class_37.warn("  no " + var1 + " object found");
         return false;
      } else {
         method_345(var0, var3, var4);
         return true;
      }
   }

   // $VF: renamed from: G (nomanssave.eY) java.util.List
   public static List method_343(class_137 var0) {
      ArrayList var1 = new ArrayList();
      boolean var2 = false;
      class_142 var3 = var0.method_703("Objects");

      for (int var4 = 0; var4 < var3.size(); var4++) {
         class_137 var5 = var3.method_736(var4);
         String var6 = var5.getValueAsString("ObjectID");
         if ("^BASE_FLAG".equals(var5.getValueAsString("ObjectID"))) {
            var2 = true;
         } else if ("^BUILDSIGNAL".equals(var6)) {
            var1.add(var5);
         } else if ("^BP_ANALYSER".equals(var6)) {
            var1.add(var5);
         } else if ("^BUILDBEACON".equals(var6)) {
            var1.add(var5);
         }
      }

      return (List)(var2 ? var1 : Collections.emptyList());
   }

   // $VF: renamed from: a (nomanssave.eY, nomanssave.eY) boolean
   public static boolean method_344(class_137 var0, class_137 var1) {
      class_142 var2 = var0.method_703("Objects");
      boolean var3 = false;
      class_137 var4 = null;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         class_137 var6 = var2.method_736(var5);
         if ("^BASE_FLAG".equals(var6.getValueAsString("ObjectID"))) {
            if (var4 != null) {
               class_37.warn("  multiple base computers found");
               return false;
            }

            var4 = var6;
         } else if (var6 == var1) {
            var3 = true;
         }
      }

      if (var4 == null) {
         class_37.warn("  no base computer found");
         return false;
      } else if (!var3) {
         class_37.warn("  replacement object found");
         return false;
      } else {
         method_345(var0, var4, var1);
         return true;
      }
   }

   // $VF: renamed from: a (nomanssave.eY, nomanssave.eY, nomanssave.eY) void
   private static void method_345(class_137 var0, class_137 var1, class_137 var2) {
      double[] var3 = method_339(var0, "Position");
      double[] var4 = method_339(var0, "Forward");
      double[] var5 = method_339(var2, "Position");
      class_65 var6 = new class_65(var3, var4);
      double[] var7 = var6.method_349(var5);
      var7[0] += var3[0];
      var7[1] += var3[1];
      var7[2] += var3[2];
      method_340(var0, "Position", var7);
      var7 = method_339(var1, "At");
      double[] var8 = method_339(var2, "At");
      method_340(var1, "At", var8);
      method_340(var2, "At", var7);
      var7 = new double[]{-var5[0], -var5[1], -var5[2]};
      method_340(var2, "Position", var7);
      class_142 var9 = var0.method_703("Objects");

      for (int var10 = 0; var10 < var9.size(); var10++) {
         class_137 var11 = var9.method_736(var10);
         if (var11 != var1 && var11 != var2) {
            var7 = method_339(var11, "Position");
            var7[0] -= var5[0];
            var7[1] -= var5[1];
            var7[2] -= var5[2];
            method_340(var11, "Position", var7);
         }
      }
   }
}
