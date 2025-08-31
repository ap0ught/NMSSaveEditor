package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// $VF: renamed from: nomanssave.cu
class class_203 extends FileFilter {
   class_203(class_336 var1) {
      this.field_580 = var1;
   }

   @Override
   public String getDescription() {
      return "Freighter Backup File";
   }

   @Override
   public boolean accept(File var1) {
      return var1.isDirectory() ? !var1.isHidden() : var1.getName().endsWith(".fb3");
   }
}
