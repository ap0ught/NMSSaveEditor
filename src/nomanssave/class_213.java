package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.cm
class class_213 extends FileView {
   class_213(class_338 var1) {
      this.field_590 = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      String var2 = var1.getName();
      return (Icon)(!var2.endsWith(".pb3") && !var2.endsWith(".pb0") ? super.getIcon(var1) : class_338.method_1014());
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      return !var2.endsWith(".pb3") && !var2.endsWith(".pb0") ? var2 : var2.substring(0, var2.length() - 4);
   }
}
