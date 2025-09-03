package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cu extends FileFilter {
   cu(cs var1) {
      this.fP = var1;
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
