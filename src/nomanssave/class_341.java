package nomanssave;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

// $VF: renamed from: nomanssave.d
class class_341 extends JCheckBox implements TableCellRenderer {
   private class_341() {
   }

   @Override
   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.setBackground(var1.getBackground());
      this.setHorizontalAlignment(0);
      this.setSelected(Boolean.TRUE == var2);
      return this;
   }
}
