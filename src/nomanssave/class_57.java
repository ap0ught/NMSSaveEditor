package nomanssave;

import java.io.IOException;
import java.io.InputStream;

// $VF: renamed from: nomanssave.hn
class class_57 extends InputStream {
   // $VF: renamed from: sc int
   private int field_154;

   private class_57(class_59 var1, int var2) {
      this.field_155 = var1;
      this.field_154 = var2;
   }

   @Override
   public int read() {
      if (this.field_154 == 0) {
         return -1;
      } else {
         int var1 = class_59.method_332(this.field_155).read();
         if (var1 < 0) {
            throw new IOException("short read");
         } else {
            this.field_154--;
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
      if (this.field_154 == 0) {
         return -1;
      } else {
         if (var3 > this.field_154) {
            var3 = this.field_154;
         }

         var3 = class_59.method_332(this.field_155).read(var1, var2, var3);
         if (var3 <= 0) {
            throw new IOException("short read");
         } else {
            this.field_154 -= var3;
            return var3;
         }
      }
   }
}
