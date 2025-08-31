package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// $VF: renamed from: nomanssave.ax
class class_256 implements TableModel {
   class_256(class_363 var1) {
      this.field_663 = var1;
   }

   @Override
   public int getRowCount() {
      return class_144.method_754();
   }

   @Override
   public int getColumnCount() {
      return 7;
   }

   @Override
   public String getColumnName(int var1) {
      switch (var1) {
         case 0:
            return "Word";
         case 1:
            return "ID";
         case 2:
            return class_296.field_939.toString();
         case 3:
            return class_296.field_940.toString();
         case 4:
            return class_296.field_941.toString();
         case 5:
            return class_296.field_943.toString();
         case 6:
            return class_296.field_947.toString();
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
      if (var2 >= 2 && var2 < this.getColumnCount()) {
         class_144 var3 = class_144.method_755(var1);
         if (var3 == null) {
            return false;
         } else {
            switch (var2) {
               case 2:
                  return var3.method_751(class_296.field_939);
               case 3:
                  return var3.method_751(class_296.field_940);
               case 4:
                  return var3.method_751(class_296.field_941);
               case 5:
                  return var3.method_751(class_296.field_943);
               case 6:
                  return var3.method_751(class_296.field_947);
               default:
                  return false;
            }
         }
      } else {
         return false;
      }
   }

   @Override
   public Object getValueAt(int var1, int var2) {
      class_144 var3 = class_144.method_755(var1);
      class_80 var4 = class_363.method_1184(this.field_663).method_183(var3);
      switch (var2) {
         case 0:
            return var3 == null ? "" : var3.getText();
         case 1:
            return var4.getID();
         case 2:
            return var4.method_484(class_296.field_939);
         case 3:
            return var4.method_484(class_296.field_940);
         case 4:
            return var4.method_484(class_296.field_941);
         case 5:
            return var4.method_484(class_296.field_943);
         case 6:
            return var4.method_484(class_296.field_947);
         default:
            return null;
      }
   }

   @Override
   public void setValueAt(Object var1, int var2, int var3) {
      class_144 var4 = class_144.method_755(var2);
      class_80 var5 = class_363.method_1184(this.field_663).method_183(var4);
      switch (var3) {
         case 2:
            var5.method_485(class_296.field_939, Boolean.TRUE.equals(var1));
            break;
         case 3:
            var5.method_485(class_296.field_940, Boolean.TRUE.equals(var1));
            break;
         case 4:
            var5.method_485(class_296.field_941, Boolean.TRUE.equals(var1));
            break;
         case 5:
            var5.method_485(class_296.field_943, Boolean.TRUE.equals(var1));
            break;
         case 6:
            var5.method_485(class_296.field_947, Boolean.TRUE.equals(var1));
      }
   }

   @Override
   public void addTableModelListener(TableModelListener var1) {
   }

   @Override
   public void removeTableModelListener(TableModelListener var1) {
   }
}
