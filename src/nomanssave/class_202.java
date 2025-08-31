package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// $VF: renamed from: nomanssave.cx
class class_202 extends FileFilter {
   class_202(class_335 var1) {
      this.field_579 = var1;
   }

   @Override
   public String getDescription() {
      return "Weapon Export File";
   }

   @Override
   public boolean accept(File var1) {
      return var1.isDirectory() ? !var1.isHidden() : var1.getName().endsWith(".wp0");
   }
}
