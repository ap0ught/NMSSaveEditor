package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cM extends FileFilter {
   cM(cK var1) {
      this.gl = var1;
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
