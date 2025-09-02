package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cV extends FileFilter {
   cV(cT var1) {
      this.gw = var1;
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
