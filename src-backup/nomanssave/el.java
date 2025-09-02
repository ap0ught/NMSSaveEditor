package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

class el extends FileView {
   ej is;
   el(ej var1) {
      this.is = var1;
   }

   @Override
   public Icon getIcon(File var1) {
      if (var1.isFile()) {
         String var3 = var1.getName();
         if (var3.endsWith(".hg") && !var3.startsWith("mf_")) {
            return ej.as();
         } else {
            return var3.equals("containers.index") ? ej.au() : null;
         }
      } else {
         String var2 = ej.a(this.is, var1);
         return var2 == null ? null : ej.aR();
      }
   }

   @Override
   public String getName(File var1) {
      if (var1.isFile()) {
         return var1.getName();
      } else {
         String var2 = ej.a(this.is, var1);
         return var2 == null ? var1.getName() : "[" + var2 + "] " + var1.getName();
      }
   }
}
