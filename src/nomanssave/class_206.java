package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// $VF: renamed from: nomanssave.cn
class class_206 extends FileFilter {
   class_206(class_338 var1) {
      this.field_583 = var1;
   }

   @Override
   public String getDescription() {
      return "Planetary Base Backup File";
   }

   @Override
   public boolean accept(File var1) {
      return var1.isDirectory() ? !var1.isHidden() : var1.getName().endsWith(".pb3");
   }
}
