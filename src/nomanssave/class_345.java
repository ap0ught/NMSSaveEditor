package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

// $VF: renamed from: nomanssave.cP
class class_345 extends DefaultListCellRenderer {
   class_345(class_333 var1) {
      this.field_1132 = var1;
   }

   @Override
   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      Component var6 = super.getListCellRendererComponent(var1, var2, var3, var4, var5);
      if (var2 == null && var6 instanceof JLabel) {
         JLabel var7 = (JLabel)var6;
         var7.setText(" ");
      }

      if (var6 instanceof JLabel) {
         boolean var12 = false;

         Enum[] var11;
         for (Enum var8 : var11 = class_333.method_992(this.field_1132)) {
            if (var8 == var2) {
               var12 = true;
               break;
            }
         }

         JLabel var13 = (JLabel)var6;
         if (!var12) {
            if (var4) {
               var13.setBackground(class_333.method_993());
            } else {
               var13.setForeground(class_333.method_994());
            }
         }
      }

      return var6;
   }
}
