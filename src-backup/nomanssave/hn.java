package nomanssave;

import java.io.IOException;
import java.io.InputStream;

class hn extends InputStream {
   private int sc;

   private hn(hm var1, int var2) {
      this.sW = var1;
      this.sc = var2;
   }

   @Override
   public int read() {
      if (this.sc == 0) {
         return -1;
      } else {
         int var1 = hm.a(this.sW).read();
         if (var1 < 0) {
            throw new IOException("short read");
         } else {
            this.sc--;
            return var1;
         }
      }
   }

   @Override
   public int read(byte[] var1) {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) {
      if (this.sc == 0) {
         return -1;
      } else {
         if (var3 > this.sc) {
            var3 = this.sc;
         }

         var3 = hm.a(this.sW).read(var1, var2, var3);
         if (var3 <= 0) {
            throw new IOException("short read");
         } else {
            this.sc -= var3;
            return var3;
         }
      }
   }
}
