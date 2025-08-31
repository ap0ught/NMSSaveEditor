package nomanssave;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableRowSorter;

// $VF: renamed from: nomanssave.p
public class class_318 extends JDialog {
   // $VF: renamed from: D javax.swing.JTable
   private final JTable field_1002;
   // $VF: renamed from: E javax.swing.table.TableRowSorter
   private final TableRowSorter field_1003;
   // $VF: renamed from: F java.util.List
   private List field_1004;
   // $VF: renamed from: G java.util.List
   private List field_1005 = null;
   // $VF: renamed from: H nomanssave.p
   private static class_318 field_1006 = null;

   private class_318(Frame var1) {
      super(var1);
      this.setSize(class_300.field_971 * 2, class_300.field_971 + class_300.field_970);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JScrollPane var3 = new JScrollPane();
      this.field_1002 = new JTable();
      this.field_1002.setSelectionMode(2);
      this.field_1002.setModel(new class_22(this));
      this.field_1002.getColumnModel().getColumn(0).setMaxWidth(24);
      this.field_1003 = new TableRowSorter<>(this.field_1002.getModel());
      this.field_1003.setSortable(0, false);
      this.field_1002.setRowSorter(this.field_1003);
      var3.setViewportView(this.field_1002);
      var2.add(var3);
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(2));
      var2.add(var4, "South");
      JButton var5 = new JButton("Add");
      var5.addActionListener(new class_21(this));
      var4.add(var5);
      this.getRootPane().setDefaultButton(var5);
      JButton var6 = new JButton("Cancel");
      var6.addActionListener(new class_20(this));
      var4.add(var6);
      this.getRootPane().registerKeyboardAction(new class_19(this), KeyStroke.getKeyStroke(27, 0), 2);
   }

   // $VF: renamed from: d () java.lang.String[]
   private String[] method_875() {
      this.field_1002.clearSelection();
      this.field_1003.setSortKeys(Collections.emptyList());
      this.field_1003.sort();
      this.field_1002.updateUI();
      this.field_1005 = null;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1005 == null ? new String[0] : this.field_1005.toArray(new String[0]);
   }

   // $VF: renamed from: b (java.awt.Container) java.lang.String[]
   public static String[] method_876(Container var0) {
      if (field_1006 == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         field_1006 = new class_318(var1);
      }

      field_1006.field_1004 = class_152.method_793();
      field_1006.setTitle("Add Known Technologies");
      return field_1006.method_875();
   }

   // $VF: renamed from: c (java.awt.Container) java.lang.String[]
   public static String[] method_877(Container var0) {
      if (field_1006 == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         field_1006 = new class_318(var1);
      }

      field_1006.field_1004 = class_152.method_794();
      field_1006.setTitle("Add Known Products");
      return field_1006.method_875();
   }
}
