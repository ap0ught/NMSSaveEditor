package nomanssave;

import java.util.Comparator;

class fz implements Comparator {
   fz(fy var1) {
      this.lU = var1;
   }

   public int a(fs var1, fs var2) {
      long var3 = var2.lastModified() - var1.lastModified();
      if (var3 < -2147483648L) {
         return Integer.MIN_VALUE;
      } else {
         return var3 > 2147483647L ? Integer.MAX_VALUE : (int)var3;
      }
   }
}
