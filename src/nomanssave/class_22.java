package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// $VF: renamed from: nomanssave.q
class class_22 implements TableModel {
   class_22(class_318 var1) {
      this.field_64 = var1;
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
      return class_318.method_878(this.field_64) == null ? 0 : class_318.method_878(this.field_64).size();
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      switch (var2) {
         case 0:
            return ((class_152)class_318.method_878(this.field_64).get(var1)).method_786(3);
         case 1:
            return ((class_152)class_318.method_878(this.field_64).get(var1)).getName();
         case 2:
            return ((class_152)class_318.method_878(this.field_64).get(var1)).method_779().toString();
         case 3:
            return ((class_152)class_318.method_878(this.field_64).get(var1)).getID();
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
