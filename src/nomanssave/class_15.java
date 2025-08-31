package nomanssave;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.y
class class_15 implements Runnable {
   class_15(class_88 var1, boolean var2) {
      this.field_56 = var1;
      this.field_57 = var2;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      String var1 = "A newer version of the save editor is available.\n";
      if (!this.field_57) {
         var1 = var1 + "Please visit https://github.com/goatfungus/NMSSaveEditor to download the latest release.";
         JOptionPane.showOptionDialog(
            Application.method_1388(class_88.method_498(this.field_56)), var1, "New Version Available", 0, 1, null, new Object[]{"OK"}, null
         );
      } else {
         var1 = var1 + "Would you like to download and install? (will require app restart)";
         int var2 = JOptionPane.showConfirmDialog(Application.method_1388(class_88.method_498(this.field_56)), var1, "New Version Available", 0);
         if (var2 == 0) {
            Application.method_1388(class_88.method_498(this.field_56)).dispose();
            class_37.info("Starting download...");
            File var3 = new File("~NMSSaveEditor.dl");

            try {
               URL var4 = new URL("https://github.com/goatfungus/NMSSaveEditor/raw/master/NMSSaveEditor.jar");
               URLConnection var5 = var4.openConnection();
               int var6 = var5.getContentLength();
               InputStream var7 = var5.getInputStream();
               FileOutputStream var8 = new FileOutputStream(var3);

               try {
                  byte[] var9 = new byte[4096];

                  int var10;
                  while ((var10 = var7.read(var9)) > 0) {
                     var8.write(var9, 0, var10);
                     var6 -= var10;
                  }

                  if (var6 != 0) {
                     throw new IOException("invalid file size");
                  }
               } finally {
                  var8.close();
               }

               class_37.info("Restarting editor...");
               System.exit(2);
            } catch (IOException var15) {
               var15.printStackTrace();
               var3.delete();
               System.exit(1);
            }
         }
      }
   }
}
