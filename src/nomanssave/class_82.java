package nomanssave;

import java.util.Comparator;

// $VF: renamed from: nomanssave.fz
class class_82 implements Comparator {
   class_82(class_83 var1) {
      this.field_240 = var1;
   }

   // $VF: renamed from: a (nomanssave.fs, nomanssave.fs) int
   public int method_486(class_9 var1, class_9 var2) {
      long var3 = var2.lastModified() - var1.lastModified();
      if (var3 < -2147483648L) {
         return Integer.MIN_VALUE;
      } else {
         return var3 > 2147483647L ? Integer.MAX_VALUE : (int)var3;
      }
   }
}
