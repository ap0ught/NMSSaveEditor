package nomanssave;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

// $VF: renamed from: nomanssave.f
class class_331 extends JTable {
   // $VF: renamed from: g nomanssave.eV
   class_142 field_1100;

   class_331(class_354 var1, Application var2, Supplier var3, Function var4) {
      this.field_1101 = var1;
      this.field_1100 = null;
      class_81 var5 = new class_81(this, var3, var4);
      this.setCellSelectionEnabled(false);
      this.getColumnModel().setColumnMargin(2);
      this.setModel(var5);
      TableRowSorter var6 = new TableRowSorter<>(var5);
      var6.setSortable(2, false);
      this.setRowSorter(var6);
      this.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new class_348(2));
      this.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(new class_348(2));
      JCheckBox var7 = new JCheckBox();
      var7.setHorizontalAlignment(0);
      this.getColumnModel().getColumn(2).setMaxWidth(80);
      this.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(new class_348(0));
      this.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(var7));
      this.getColumnModel().getColumn(2).setCellRenderer(new class_341(null));
   }

   // $VF: renamed from: a (nomanssave.eV) void
   void method_984(class_142 var1) {
      this.field_1100 = var1;
   }
}
