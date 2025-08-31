package nomanssave;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

// $VF: renamed from: nomanssave.fO
class class_107 implements FileFilter {
   class_107(class_108 var1, ArrayList var2) {
      this.field_357 = var1;
      this.field_358 = var2;
   }

   @Override
   public boolean accept(File var1) {
      Matcher var2 = class_113.method_626().matcher(var1.getName());
      if (var2.matches()) {
         int var3 = var2.group(1).length() == 0 ? 0 : Integer.parseInt(var2.group(1)) - 1;
         if (var3 / 2 == this.field_357.field_359) {
            try {
               this.field_358.add(new class_109(class_108.method_614(this.field_357), var1.getName(), var3));
            } catch (IOException var5) {
               class_37.method_156("Cannot load " + var1.getName(), var5);
            }
         }
      }

      return false;
   }
}
