package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.bD
class class_347 extends DefaultListCellRenderer {
   private class_347(class_355 var1) {
      this.field_1134 = var1;
   }

   @Override
   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      Component var6 = super.getListCellRendererComponent(var1, var2, var3, var4, var5);
      if (var2 == null && var6 instanceof JLabel) {
         JLabel var7 = (JLabel)var6;
         var7.setText(" ");
      }

      if (var2 instanceof class_128 && var6 instanceof JLabel) {
         class_128 var9 = (class_128)var2;
         JLabel var8 = (JLabel)var6;
         if (var9.method_671()) {
            if (var4) {
               var8.setBackground(UIManager.getColor("Frigate.positiveTraitHighlight"));
            } else {
               var8.setForeground(UIManager.getColor("Frigate.positiveTraitColor"));
            }
         } else if (var4) {
            var8.setBackground(UIManager.getColor("Frigate.negativeTraitHighlight"));
         } else {
            var8.setForeground(UIManager.getColor("Frigate.negativeTraitColor"));
         }
      }

      return var6;
   }
}
