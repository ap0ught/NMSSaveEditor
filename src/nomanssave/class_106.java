package nomanssave;

import java.util.Comparator;

// $VF: renamed from: nomanssave.fP
class class_106 implements Comparator {
   class_106(class_108 var1) {
      this.field_356 = var1;
   }

   // $VF: renamed from: a (nomanssave.fs, nomanssave.fs) int
   public int method_613(class_9 var1, class_9 var2) {
      long var3 = var2.lastModified() - var1.lastModified();
      if (var3 < -2147483648L) {
         return Integer.MIN_VALUE;
      } else {
         return var3 > 2147483647L ? Integer.MAX_VALUE : (int)var3;
      }
   }
}
