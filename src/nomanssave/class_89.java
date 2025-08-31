package nomanssave;

import java.io.IOException;
import java.util.Arrays;

// $VF: renamed from: nomanssave.hj
class class_89 extends Thread {
   // $VF: renamed from: sK long
   final long field_269;
   // $VF: renamed from: sL java.lang.String
   String field_270;

   class_89(long var1) {
      this.field_269 = var1;
      this.field_270 = class_300.getProperty("KnownPlayers." + var1);
      class_32.method_126().put(var1, this);
      this.start();
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      String var1;
      try {
         var1 = class_32.method_127(this.field_269);
      } catch (IOException var7) {
         class_37.method_156("Steam lookup error", var7);
         var1 = null;
      }

      synchronized (class_32.method_126()) {
         if (var1 != null) {
            Long[] var3 = (Long[])class_300.method_863("SteamIDs", Long.class);
            boolean var4 = Arrays.asList(var3).stream().anyMatch(this::a);
            if (!var4) {
               Long[] var5 = new Long[var3.length + 1];
               System.arraycopy(var3, 0, var5, 0, var3.length);
               var5[var3.length] = this.field_269;
               class_300.method_864("SteamIDs", var5);
            }

            if (!var1.equals(this.field_270)) {
               class_300.setProperty("KnownPlayers." + this.field_269, var1);
               this.field_270 = var1;
            }
         }
      }
   }
}
