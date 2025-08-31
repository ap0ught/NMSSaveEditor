package nomanssave;

import java.util.Comparator;

// $VF: renamed from: nomanssave.gb
class class_51 implements Comparator {
   class_51(class_98 var1) {
      this.field_132 = var1;
   }

   // $VF: renamed from: a (nomanssave.fs, nomanssave.fs) int
   public int method_321(class_9 var1, class_9 var2) {
      long var3 = var2.lastModified() - var1.lastModified();
      if (var3 < -2147483648L) {
         return Integer.MIN_VALUE;
      } else {
         return var3 > 2147483647L ? Integer.MAX_VALUE : (int)var3;
      }
   }
}
