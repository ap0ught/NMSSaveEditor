package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class bs implements TableModel {
   bs(bl var1) {
      this.er = var1;
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
      return bl.c(this.er) == null ? 0 : bl.c(this.er).length;
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      switch (var2) {
         case 0:
            return bl.c(this.er) == null ? null : bl.c(this.er)[var1].toString();
         case 1:
            gr var3 = bl.c(this.er) == null ? null : bl.c(this.er)[var1].da();
            return var3 == null ? "Unknown" : var3.toString();
         case 2:
            return bl.c(this.er) == null ? null : bl.c(this.er)[var1].cW().toString();
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
