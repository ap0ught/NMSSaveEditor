package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// $VF: renamed from: nomanssave.cV
class class_207 extends FileFilter {
   class_207(class_339 var1) {
      this.field_584 = var1;
   }

   @Override
   public String getDescription() {
      return "Ship Export File";
   }

   @Override
   public boolean accept(File var1) {
      return var1.isDirectory() ? !var1.isHidden() : var1.getName().endsWith(".sh0");
   }
}
