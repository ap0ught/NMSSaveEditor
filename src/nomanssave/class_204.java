package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// $VF: renamed from: nomanssave.cr
class class_204 extends FileFilter {
   class_204(class_337 var1) {
      this.field_581 = var1;
   }

   @Override
   public String getDescription() {
      return "Companion Export File";
   }

   @Override
   public boolean accept(File var1) {
      return var1.isDirectory() ? !var1.isHidden() : var1.getName().endsWith(".pet") || var1.getName().endsWith(".egg");
   }
}
