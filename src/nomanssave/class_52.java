package nomanssave;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

// $VF: renamed from: nomanssave.ga
class class_52 implements FileFilter {
   class_52(class_98 var1, ArrayList var2) {
      this.field_133 = var1;
      this.field_134 = var2;
   }

   @Override
   public boolean accept(File var1) {
      Matcher var2 = class_104.method_588().matcher(var1.getName());
      if (var2.matches()) {
         int var3 = var2.group(1).length() == 0 ? 0 : Integer.parseInt(var2.group(1)) - 1;
         if (var3 / 2 == this.field_133.field_301) {
            try {
               this.field_134.add(new class_100(class_98.method_571(this.field_133), var1.getName(), var3));
            } catch (IOException var5) {
               class_37.method_156("Cannot load " + var1.getName(), var5);
            }
         }
      }

      return false;
   }
}
