package nomanssave;

import java.io.IOException;
import java.io.InputStream;

class gY extends InputStream {
   private int sc;

   private gY(gX var1, int var2) {
      this.sd = var1;
      this.sc = var2;
   }

   @Override
   public int read() {
      if (this.sc == 0) {
         return -1;
      } else {
         int var1 = gX.a(this.sd).read();
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

         var3 = gX.a(this.sd).read(var1, var2, var3);
         if (var3 <= 0) {
            throw new IOException("short read");
         } else {
            this.sc -= var3;
            return var3;
         }
      }
   }
}
