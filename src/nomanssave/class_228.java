package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// $VF: renamed from: nomanssave.bs
class class_228 implements TableModel {
   class_228(class_355 var1) {
      this.field_611 = var1;
   }

   @Override
   public void addTableModelListener(TableModelListener var1) {
   }

   @Override
   public Class getColumnClass(int var1) {
      return String.class;
   }

   @Override
   public int getColumnCount() {
      return 3;
   }

   @Override
   public String getColumnName(int var1) {
      switch (var1) {
         case 0:
            return "Name";
         case 1:
            return "Type";
         case 2:
            return "Class";
         default:
            return null;
      }
   }

   @Override
   public int getRowCount() {
      return class_355.method_1057(this.field_611) == null ? 0 : class_355.method_1057(this.field_611).length;
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      switch (var2) {
         case 0:
            return class_355.method_1057(this.field_611) == null ? null : class_355.method_1057(this.field_611)[var1].toString();
         case 1:
            class_284 var3 = class_355.method_1057(this.field_611) == null ? null : class_355.method_1057(this.field_611)[var1].method_224();
            return var3 == null ? "Unknown" : var3.toString();
         case 2:
            return class_355.method_1057(this.field_611) == null ? null : class_355.method_1057(this.field_611)[var1].method_226().toString();
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
