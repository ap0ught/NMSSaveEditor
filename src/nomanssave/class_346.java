package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

// $VF: renamed from: nomanssave.bQ
class class_346 extends DefaultListCellRenderer {
   class_346(class_357 var1) {
      this.field_1133 = var1;
   }

   @Override
   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      if (var2 instanceof class_70) {
         var2 = ((class_70)var2).getSimpleName();
      }

      return super.getListCellRendererComponent(var1, var2, var3, var4, var5);
   }
}
