package nomanssave;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

// $VF: renamed from: nomanssave.e
class class_348 extends DefaultTableCellRenderer {
   // $VF: renamed from: f int
   final int field_1135;

   class_348(int var1) {
      this.field_1135 = var1;
   }

   @Override
   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      JLabel var7 = (JLabel)super.getTableCellRendererComponent(var1, var2, var3, var4, var5, var6);
      var7.setHorizontalAlignment(this.field_1135);
      return var7;
   }
}
