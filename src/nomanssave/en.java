package nomanssave;

import java.util.ArrayList;
import java.util.List;

public class en {
   private static boolean iu = false;
   private static List iv = new ArrayList();

   public static void a(eo var0) {
      iv.add(var0);
   }

   public static boolean aS() {
      return iu;
   }

   public static void c(boolean var0) {
      iu = var0;

      for (eo var1 : iv) {
         var1.a(var0);
      }
   }
}
