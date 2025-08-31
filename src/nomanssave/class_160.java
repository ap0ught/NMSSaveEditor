package nomanssave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// $VF: renamed from: nomanssave.eD
class class_160 extends class_159 {
   private final String version;

   private class_160(InputStream var1, String var2) {
      super(null);
      this.version = var2;
      ArrayList var3 = new ArrayList();
      BufferedReader var4 = new BufferedReader(new InputStreamReader(var1));

      String var5;
      try {
         while ((var5 = var4.readLine()) != null) {
            try {
               if (var5.length() != 0) {
                  int var9 = var5.indexOf("\t");
                  if (var9 < 0) {
                     class_37.debug("Mapping not available: " + var5);
                     var3.add(var5);
                  } else {
                     String var6 = var5.substring(0, var9);
                     String var7 = var5.substring(var9 + 1, var5.length());
                     class_157 var8;
                     if ((var8 = this.t(var6)) != null) {
                        if (!var7.equals(var8.name)) {
                           throw new IOException("Mapping error: " + var6);
                        }

                        class_37.debug("Mapping duplicated: " + var6);
                     } else if ((var8 = this.u(var7)) != null) {
                        if (!var6.equals(var8.field_508)) {
                           throw new IOException("Reverse error: " + var7);
                        }

                        class_37.debug("Reverse duplicated: " + var7);
                     } else {
                        this.add(var6, var7);
                     }
                  }
               }
            } catch (RuntimeException var13) {
               class_37.method_156("Ignoring: " + var5, var13);
            }
         }
      } finally {
         var4.close();
      }

      for (String var15 : var3) {
         if (this.t(var15) != null) {
            throw new IOException("Mapping error: " + var15);
         }

         if (this.u(var15) != null) {
            throw new IOException("Reverse error: " + var15);
         }

         this.add(var15, var15);
      }
   }

   @Override
   public String toString() {
      return this.version;
   }
}
