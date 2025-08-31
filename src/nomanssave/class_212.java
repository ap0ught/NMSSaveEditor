package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.cq
class class_212 extends FileView {
   class_212(class_337 var1) {
      this.field_589 = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      String var2 = var1.getName();
      if (var2.endsWith(".pet")) {
         return class_337.method_1010();
      } else {
         return (Icon)(var2.endsWith(".egg") ? class_337.method_1011() : super.getIcon(var1));
      }
   }

   @Override
   public String getName(File var1) {
      String var2 = var1.getName();
      if (var2.endsWith(".pet")) {
         return var2.substring(0, var2.length() - 4);
      } else {
         return var2.endsWith(".egg") ? var2.substring(0, var2.length() - 4) : var2;
      }
   }
}
