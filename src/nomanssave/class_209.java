package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// $VF: renamed from: nomanssave.el
class class_209 extends FileView {
   class_209(class_334 var1) {
      this.field_586 = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      if (var1.isFile()) {
         String var3 = var1.getName();
         if (var3.endsWith(".hg") && !var3.startsWith("mf_")) {
            return class_334.method_997();
         } else {
            return var3.equals("containers.index") ? class_334.method_998() : null;
         }
      } else {
         String var2 = class_334.method_999(this.field_586, var1);
         return var2 == null ? null : class_334.method_1000();
      }
   }

   @Override
   public String getName(File var1) {
      if (var1.isFile()) {
         return var1.getName();
      } else {
         String var2 = class_334.method_999(this.field_586, var1);
         return var2 == null ? var1.getName() : "[" + var2 + "] " + var1.getName();
      }
   }
}
