package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.ct
class class_211 extends FileView {
   class_211(class_336 var1) {
      this.field_588 = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      String var2 = var1.getName();
      return (Icon)(var2.endsWith(".fb3") ? class_336.method_1007() : super.getIcon(var1));
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      return var2.endsWith(".fb3") ? var2.substring(0, var2.length() - 4) : var2;
   }
}
