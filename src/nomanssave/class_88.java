package nomanssave;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

// $VF: renamed from: nomanssave.x
class class_88 extends Thread {
   class_88(Application var1, boolean var2) {
      this.field_267 = var1;
      this.field_268 = var2;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      try {
         long var1 = Math.round((double)Runtime.getRuntime().totalMemory() / 1000000.0);
         long var3 = Math.round((double)Runtime.getRuntime().maxMemory() / 1000000.0);
         class_37.debug("Mem Usage: " + var1 + "/" + var3 + " MB");
         URL var5 = new URL("https://github.com/goatfungus/NMSSaveEditor/raw/master/VERSION.txt");
         URLConnection var6 = var5.openConnection();
         int var7 = var6.getContentLength();
         InputStream var8 = var6.getInputStream();
         byte[] var9 = new byte[var7];
         int var11 = 0;

         int var10;
         while ((var10 = var8.read(var9, var11, var7)) > 0) {
            var11 += var10;
            var7 -= var10;
         }

         if (var7 > 0) {
            throw new IOException("short read");
         }

         String var12 = new String(var9, 0, var9.length);
         if (var12.endsWith("\r\n")) {
            var12 = var12.substring(0, var12.length() - 2);
         } else if (var12.endsWith("\n")) {
            var12 = var12.substring(0, var12.length() - 1);
         }

         class_37.debug("Latest version: \"" + var12 + "\"");
         class_37.debug("Current version: \"1.19.0\"");
         if (!"1.19.0".equals(var12)) {
            EventQueue.invokeLater(new class_15(this, this.field_268));
         }
      } catch (IOException var13) {
      }
   }
}
