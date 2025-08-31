package nomanssave;

import java.io.EOFException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

// $VF: renamed from: nomanssave.hi
public class class_32 {
   // $VF: renamed from: sI java.lang.String
   private static final String field_85 = "9710BD8FCF192837DC6DEF6037AB2837";
   // $VF: renamed from: sJ java.util.HashMap
   private static final HashMap field_86 = new HashMap();

   // $VF: renamed from: h (long) java.lang.String
   public static String method_123(long var0) {
      class_89 var2;
      synchronized (field_86) {
         if (field_86.containsKey(var0)) {
            var2 = (class_89)field_86.get(var0);
         } else {
            var2 = new class_89(var0);
         }
      }

      try {
         var2.join(500L);
      } catch (InterruptedException var4) {
      }

      return var2.field_270;
   }

   // $VF: renamed from: i (long) java.lang.String
   private static String method_124(long var0) {
      class_137 var2 = method_125("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=9710BD8FCF192837DC6DEF6037AB2837&steamids=" + var0);
      class_142 var3 = var2.method_703("response.players");
      if (var3 != null && var3.size() != 0) {
         for (int var4 = 0; var4 < var3.size(); var4++) {
            class_137 var5 = var3.method_736(var4);
            if (Long.toString(var0).equals(var5.getValueAsString("steamid"))) {
               return var5.getValueAsString("personaname");
            }
         }

         return null;
      } else {
         return null;
      }
   }

   // $VF: renamed from: aC (java.lang.String) nomanssave.eY
   private static class_137 method_125(String var0) {
      URLConnection var1 = new URL(var0).openConnection();
      int var2 = var1.getContentLength();
      int var3 = 0;
      InputStream var4 = var1.getInputStream();
      byte[] var5 = new byte[var2];

      int var6;
      while ((var6 = var4.read(var5, var3, var2)) >= 0) {
         var3 += var6;
         var2 -= var6;
      }

      if (var2 > 0) {
         throw new EOFException();
      } else {
         String var7 = var1.getContentEncoding();
         String var8 = new String(var5, var7 == null ? "UTF-8" : var7);
         return class_137.method_689(var8);
      }
   }
}
