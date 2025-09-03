package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class ek extends FileFilter {
   ek(ej var1) {
      this.is = var1;
   }

   @Override
   public String getDescription() {
      return "Saved Game";
   }

   @Override
   public boolean accept(File var1) {
      if (var1.isDirectory()) {
         return true;
      } else {
         String var2 = var1.getName();
         return var2.endsWith(".hg") && !var2.startsWith("mf_") ? true : var2.equals("containers.index");
      }
   }
}
