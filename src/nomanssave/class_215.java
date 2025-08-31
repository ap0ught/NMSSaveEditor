package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.cL
class class_215 extends FileView {
   class_215(class_340 var1) {
      this.field_592 = var1;
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      return var2.endsWith(".json") ? var2.substring(0, var2.length() - 5) : var2;
   }
}
