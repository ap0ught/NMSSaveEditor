package nomanssave;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

// $VF: renamed from: nomanssave.cA
class class_343 extends DefaultTreeCellRenderer {
   class_343(class_322 var1) {
      this.field_1130 = var1;
   }

   @Override
   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      JLabel var8 = (JLabel)super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      if (((class_216)var2).field_593 == null) {
         var8.setIcon(Application.method_1325("UI-FILEICON.PNG", 20, 20));
      } else if (var5) {
         var8.setIcon(UIManager.getIcon("Tree.leafIcon"));
      } else if (var4) {
         var8.setIcon(UIManager.getIcon("Tree.openIcon"));
      } else {
         var8.setIcon(UIManager.getIcon("Tree.closedIcon"));
      }

      return var8;
   }
}
