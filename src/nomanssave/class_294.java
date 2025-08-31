package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.fn
public enum class_294 {
   // $VF: renamed from: lm nomanssave.fn
   field_882,
   // $VF: renamed from: ln nomanssave.fn
   field_883,
   // $VF: renamed from: lo nomanssave.fn
   field_884,
   // $VF: renamed from: lp nomanssave.fn
   field_885,
   // $VF: renamed from: lq nomanssave.fn
   field_886,
   // $VF: renamed from: lr nomanssave.fn
   field_887,
   // $VF: renamed from: ls nomanssave.fn
   field_888,
   // $VF: renamed from: lt nomanssave.fn
   field_889;

   // $VF: renamed from: lu java.util.regex.Pattern
   private static final Pattern field_890 = Pattern.compile("\"((?:XTp)|(?:ActiveContext))\":\"([^\"]+)\",");
   // $VF: renamed from: lv java.util.regex.Pattern
   private static final Pattern field_891 = Pattern.compile("\"((?:vLc)|(?:BaseContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
   // $VF: renamed from: lw java.util.regex.Pattern
   private static final Pattern field_892 = Pattern.compile("\"((?:2YS)|(?:ExpeditionContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
   // $VF: renamed from: lx java.util.regex.Pattern
   private static final Pattern field_893 = Pattern.compile("\"((?:7ND)|(?:DifficultyPresetType))\":\"(\\w+)\"");

   // $VF: renamed from: S (java.lang.String) nomanssave.fn
   private static class_294 method_854(String var0) {
      class_294[] var4;
      for (class_294 var1 : var4 = values()) {
         if (var0.equalsIgnoreCase(var1.name())) {
            return var1;
         }
      }

      return null;
   }

   // $VF: renamed from: T (java.lang.String) nomanssave.fn
   public static class_294 method_855(String var0) {
      Matcher var1 = field_890.matcher(var0);
      if (var1.find()) {
         String var2 = var1.group(2);
         if ("Main".equals(var2)) {
            var1 = field_891.matcher(var0);
         } else if ("Season".equals(var2)) {
            var1 = field_892.matcher(var0);
         }

         if (var1.find()) {
            int var3 = Integer.parseInt(var1.group(3));
            if (var3 > 0 && var3 <= values().length) {
               return values()[var3 - 1];
            }
         }
      }

      var1 = field_893.matcher(var0);
      return var1.find() ? method_854(var1.group(2)) : null;
   }

   // $VF: renamed from: i (nomanssave.eY) nomanssave.fn
   public static class_294 method_856(class_137 var0) {
      String var1 = var0.getValueAsString("ActiveContext");
      if ("Main".equals(var1)) {
         int var2 = var0.method_705("BaseContext.GameMode");
         if (var2 > 0 && var2 <= values().length) {
            return values()[var2 - 1];
         }
      } else if ("Season".equals(var1)) {
         int var3 = var0.method_705("ExpeditionContext.GameMode");
         if (var3 > 0 && var3 <= values().length) {
            return values()[var3 - 1];
         }
      }

      String var4 = var0.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
      return var4 != null ? method_854(var4) : null;
   }
}
