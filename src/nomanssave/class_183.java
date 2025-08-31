package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// $VF: renamed from: nomanssave.dI
class class_183 implements TableModel {
   class_183(class_352 var1) {
      this.field_549 = var1;
   }

   @Override
   public void addTableModelListener(TableModelListener var1) {
   }

   @Override
   public Class getColumnClass(int var1) {
      return var1 == 1 ? eM.class : String.class;
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
            return "Description";
         default:
            return null;
      }
   }

   @Override
   public int getRowCount() {
      class_77 var1 = (class_77)class_352.method_1026(this.field_549).getSelectedItem();
      return var1 == null ? 0 : var1.method_466();
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      class_77 var3 = (class_77)class_352.method_1026(this.field_549).getSelectedItem();
      String var4 = var3 == null ? null : var3.method_467(var1);
      class_147 var5 = class_147.method_762(var4);
      switch (var2) {
         case 0:
            return var4;
         case 1:
            return var5;
         case 2:
            return var5 == null ? "" : var5.getDescription();
         default:
            return null;
      }
   }

   @Override
   public boolean isCellEditable(int var1, int var2) {
      return var2 == 1;
   }

   @Override
   public void removeTableModelListener(TableModelListener var1) {
   }

   @Override
   public void setValueAt(Object var1, int var2, int var3) {
      class_77 var4 = (class_77)class_352.method_1026(this.field_549).getSelectedItem();
      if (var4 != null && var3 == 1) {
         class_147 var5 = (class_147)var1;
         String var6 = var4.method_467(var2);
         if (var5.method_759()) {
            int var7 = var6.indexOf("#");
            if (var7 >= 0 && var6.substring(0, var7).equals(var5.getID())) {
               return;
            }

            String var8 = "#" + (int)Math.floor(Math.random() * 100000.0);
            var4.method_468(var2, var5.getID() + var8);
         } else {
            if (var6.endsWith(var5.getID())) {
               return;
            }

            var4.method_468(var2, var5.getID());
         }
      }
   }
}
