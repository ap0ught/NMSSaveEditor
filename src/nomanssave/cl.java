package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileView;

class cL extends FileView {
   cL(cK var1) {
      this.gl = var1;
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      return var2.endsWith(".json") ? var2.substring(0, var2.length() - 5) : var2;
   }
}
