package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum fn {
   lm,
   ln,
   lo,
   lp,
   lq,
   lr,
   ls,
   lt;

   private static final Pattern lu = Pattern.compile("\"((?:XTp)|(?:ActiveContext))\":\"([^\"]+)\",");
   private static final Pattern lv = Pattern.compile("\"((?:vLc)|(?:BaseContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
   private static final Pattern lw = Pattern.compile("\"((?:2YS)|(?:ExpeditionContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
   private static final Pattern lx = Pattern.compile("\"((?:7ND)|(?:DifficultyPresetType))\":\"(\\w+)\"");

   private static fn S(String var0) {
      fn[] var4;
      for (fn var1 : var4 = values()) {
         if (var0.equalsIgnoreCase(var1.name())) {
            return var1;
         }
      }

      return null;
   }

   public static fn T(String var0) {
      Matcher var1 = lu.matcher(var0);
      if (var1.find()) {
         String var2 = var1.group(2);
         if ("Main".equals(var2)) {
            var1 = lv.matcher(var0);
         } else if ("Season".equals(var2)) {
            var1 = lw.matcher(var0);
         }

         if (var1.find()) {
            int var3 = Integer.parseInt(var1.group(3));
            if (var3 > 0 && var3 <= values().length) {
               return values()[var3 - 1];
            }
         }
      }

      var1 = lx.matcher(var0);
      return var1.find() ? S(var1.group(2)) : null;
   }

   public static fn i(eY var0) {
      String var1 = var0.getValueAsString("ActiveContext");
      if ("Main".equals(var1)) {
         int var2 = var0.J("BaseContext.GameMode");
         if (var2 > 0 && var2 <= values().length) {
            return values()[var2 - 1];
         }
      } else if ("Season".equals(var1)) {
         int var3 = var0.J("ExpeditionContext.GameMode");
         if (var3 > 0 && var3 <= values().length) {
            return values()[var3 - 1];
         }
      }

      String var4 = var0.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
      return var4 != null ? S(var4) : null;
   }
}
