package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cr extends FileFilter {
   cr(cp var1) {
      this.fM = var1;
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
