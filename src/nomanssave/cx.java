package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cx extends FileFilter {
   cx(cv var1) {
      this.fR = var1;
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
