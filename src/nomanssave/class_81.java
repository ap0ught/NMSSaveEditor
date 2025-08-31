package nomanssave;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// $VF: renamed from: nomanssave.g
class class_81 implements TableModel {
   class_81(class_331 var1, Supplier var2, Function var3) {
      this.field_237 = var1;
      this.field_238 = var2;
      this.field_239 = var3;
   }

   @Override
   public int getRowCount() {
      return (Integer)this.field_238.get();
   }

   @Override
   public int getColumnCount() {
      return 3;
   }

   @Override
   public String getColumnName(int var1) {
      switch (var1) {
         case 0:
            return "ID";
         case 1:
            return "Name";
         case 2:
            return "Unlocked";
         default:
            return null;
      }
   }

   @Override
   public Class getColumnClass(int var1) {
      switch (var1) {
         case 0:
         case 1:
            return String.class;
         default:
            return Boolean.class;
      }
   }

   @Override
   public boolean isCellEditable(int var1, int var2) {
      return var2 == 2 && this.field_237.field_1100 != null;
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      class_151 var3 = (class_151)this.field_239.apply(var1);
      switch (var2) {
         case 0:
            return var3 == null ? "" : var3.getID();
         case 1:
            return var3 == null ? "" : var3.getName();
         case 2:
            return var3 != null && this.field_237.field_1100 != null ? this.field_237.field_1100.indexOf(var3.getID()) >= 0 : false;
         default:
            return null;
      }
   }

   @Override
   public void setValueAt(Object var1, int var2, int var3) {
      if (this.field_237.field_1100 != null) {
         class_151 var4 = (class_151)this.field_239.apply(var2);
         if (var3 == 2) {
            int var5 = this.field_237.field_1100.indexOf(var4.getID());
            if (Boolean.TRUE.equals(var1)) {
               if (var5 < 0) {
                  this.field_237.field_1100.method_744(var4.getID());
               }
            } else if (var5 >= 0) {
               this.field_237.field_1100.method_745(var5);
            }
         }
      }
   }

   @Override
   public void addTableModelListener(TableModelListener var1) {
   }

   @Override
   public void removeTableModelListener(TableModelListener var1) {
   }
}
