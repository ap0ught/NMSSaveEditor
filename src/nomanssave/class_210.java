package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.cw
class class_210 extends FileView {
   class_210(class_335 var1) {
      this.field_587 = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      String var2 = var1.getName();
      return (Icon)(var2.endsWith(".wp0") ? class_335.method_1003() : super.getIcon(var1));
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      return var2.endsWith(".wp0") ? var2.substring(0, var2.length() - 4) : var2;
   }
}
