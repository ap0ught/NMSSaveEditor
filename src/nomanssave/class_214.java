package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.cU
class class_214 extends FileView {
   class_214(class_339 var1) {
      this.field_591 = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      String var2 = var1.getName();
      return (Icon)(var2.endsWith(".sh0") ? class_339.method_1018() : super.getIcon(var1));
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      return var2.endsWith(".sh0") ? var2.substring(0, var2.length() - 4) : var2;
   }
}
