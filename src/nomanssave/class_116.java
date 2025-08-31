package nomanssave;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

// $VF: renamed from: nomanssave.fF
class class_116 implements FileFilter {
   class_116(class_117 var1, ArrayList var2) {
      this.field_391 = var1;
      this.field_392 = var2;
   }

   @Override
   public boolean accept(File var1) {
      Matcher var2 = class_122.method_662().matcher(var1.getName());
      if (var2.matches()) {
         int var3 = var2.group(1).length() == 0 ? 0 : Integer.parseInt(var2.group(1)) - 1;
         if (var3 / 2 == this.field_391.field_393) {
            try {
               this.field_392.add(new class_118(class_117.method_651(this.field_391), var1.getName(), var3));
            } catch (IOException var5) {
               class_37.method_156("Cannot load " + var1.getName(), var5);
            }
         }
      }

      return false;
   }
}
