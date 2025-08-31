package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// $VF: renamed from: nomanssave.cM
class class_208 extends FileFilter {
   class_208(class_340 var1) {
      this.field_585 = var1;
   }

   @Override
   public String getDescription() {
      return "JSON File";
   }

   @Override
   public boolean accept(File var1) {
      return var1.isDirectory() ? !var1.isHidden() : var1.getName().endsWith(".json");
   }
}
