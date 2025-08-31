package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.dL
class class_344 extends DefaultListCellRenderer {
   class_344(class_332 var1) {
      this.field_1131 = var1;
   }

   @Override
   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      JLabel var6 = (JLabel)super.getListCellRendererComponent(var1, var2, var3, var4, var5);
      if (var2 == null) {
         var6.setText("");
      } else {
         class_147 var7 = (class_147)var2;
         if (var7.method_758()) {
            if (var4) {
               var6.setBackground(UIManager.getColor("Settlement.positivePerkHighlight"));
            } else {
               var6.setForeground(UIManager.getColor("Settlement.positivePerkColor"));
            }
         } else if (var4) {
            var6.setBackground(UIManager.getColor("Settlement.negativePerkHighlight"));
         } else {
            var6.setForeground(UIManager.getColor("Settlement.negativePerkColor"));
         }
      }

      return var6;
   }
}
