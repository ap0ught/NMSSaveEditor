package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// $VF: renamed from: nomanssave.au
class class_259 implements TableModel {
   class_259(class_363 var1) {
      this.field_666 = var1;
   }

   @Override
   public void addTableModelListener(TableModelListener var1) {
   }

   @Override
   public Class getColumnClass(int var1) {
      return var1 == 0 ? ImageIcon.class : String.class;
   }

   @Override
   public int getColumnCount() {
      return 4;
   }

   @Override
   public String getColumnName(int var1) {
      switch (var1) {
         case 0:
            return "";
         case 1:
            return "Name";
         case 2:
            return "Category";
         case 3:
            return "ID";
         default:
            return null;
      }
   }

   @Override
   public int getRowCount() {
      return class_363.method_1179(this.field_666) == null ? 0 : class_363.method_1179(this.field_666).size();
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      String var3 = (String)class_363.method_1179(this.field_666).get(var1);
      class_152 var4 = class_152.method_795(var3);
      switch (var2) {
         case 0:
            return var4 == null ? null : var4.method_786(3);
         case 1:
            return var4 == null ? "" : var4.getName();
         case 2:
            return var4 == null ? "" : var4.method_779().toString();
         case 3:
            return var3;
         default:
            return null;
      }
   }

   @Override
   public boolean isCellEditable(int var1, int var2) {
      return false;
   }

   @Override
   public void removeTableModelListener(TableModelListener var1) {
   }

   @Override
   public void setValueAt(Object var1, int var2, int var3) {
   }
}
