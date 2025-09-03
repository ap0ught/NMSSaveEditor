package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cn extends FileFilter {
   cn(cl var1) {
      this.fI = var1;
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
