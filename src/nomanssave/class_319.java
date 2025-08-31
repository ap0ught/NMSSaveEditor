package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.h
public class class_319 extends JDialog {
   // $VF: renamed from: l nomanssave.ey
   private class_152 field_1007 = null;
   // $VF: renamed from: m javax.swing.JTextField
   private JTextField field_1008;
   // $VF: renamed from: n javax.swing.JButton
   private JButton field_1009;
   // $VF: renamed from: o javax.swing.JComboBox
   private JComboBox field_1010;
   // $VF: renamed from: p javax.swing.JComboBox
   private JComboBox field_1011;
   // $VF: renamed from: q javax.swing.JComboBox
   private JComboBox field_1012;
   // $VF: renamed from: r int
   private int field_1013;
   // $VF: renamed from: s java.util.List
   private List field_1014 = new ArrayList();
   // $VF: renamed from: t java.util.List
   private List field_1015 = new ArrayList();
   // $VF: renamed from: u java.util.List
   private List field_1016 = new ArrayList();
   // $VF: renamed from: v java.util.List
   private List field_1017 = new ArrayList();
   // $VF: renamed from: w nomanssave.h
   private static class_319 field_1018 = null;

   private class_319(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Add Item");
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JPanel var3 = new JPanel();
      var3.setLayout(
         new FormLayout(
            new ColumnSpec[]{
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("100px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("280px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC
            },
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Search:");
      var3.add(var4, "2, 2, left, center");
      JPanel var5 = new JPanel();
      var5.setLayout(new BorderLayout(0, 0));
      this.field_1008 = new JTextField();
      this.field_1008.setText("");
      var5.add(this.field_1008, "Center");
      this.field_1009 = new JButton("Search");
      this.field_1009.addActionListener(new class_29(this));
      var5.add(this.field_1009, "East");
      var3.add(var5, "4, 2, fill, default");
      JLabel var6 = new JLabel("Type:");
      var3.add(var6, "2, 4, left, center");
      this.field_1010 = new JComboBox();
      this.field_1010.setModel(new class_28(this));
      var3.add(this.field_1010, "4, 4, fill, default");
      JLabel var7 = new JLabel("Category:");
      var3.add(var7, "2, 6, left, center");
      this.field_1011 = new JComboBox();
      this.field_1011.setModel(new class_27(this));
      var3.add(this.field_1011, "4, 6, fill, default");
      JLabel var8 = new JLabel("Item:");
      var3.add(var8, "2, 8, left, center");
      this.field_1012 = new JComboBox();
      this.field_1012.setModel(new class_26(this));
      var3.add(this.field_1012, "4, 8, fill, default");
      var2.add(var3, "Center");
      JPanel var9 = new JPanel();
      var9.setLayout(new FlowLayout(2));
      var2.add(var9, "South");
      JButton var10 = new JButton("Save");
      var10.addActionListener(new class_25(this));
      var9.add(var10);
      this.getRootPane().setDefaultButton(var10);
      JButton var11 = new JButton("Cancel");
      var11.addActionListener(new class_24(this));
      var9.add(var11);
      this.getRootPane().registerKeyboardAction(new class_23(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: a () void
   private void method_882() {
      this.field_1015 = this.field_1014.stream().map(ey::ba).distinct().sorted(h::a).collect(Collectors.toList());
      this.field_1010.setSelectedIndex(this.field_1015.size() == 1 ? 0 : -1);
      this.field_1010.updateUI();
      this.method_883();
   }

   // $VF: renamed from: b () void
   private void method_883() {
      class_298 var1 = (class_298)this.field_1010.getSelectedItem();
      this.field_1016 = this.field_1014.stream().filter(h::a).map(ey::bc).distinct().sorted(h::a).collect(Collectors.toList());
      this.field_1011.setSelectedIndex(this.field_1016.size() == 1 ? 0 : -1);
      this.field_1011.updateUI();
      this.method_884();
   }

   // $VF: renamed from: c () void
   private void method_884() {
      class_298 var1 = (class_298)this.field_1010.getSelectedItem();
      class_295 var2 = (class_295)this.field_1011.getSelectedItem();
      this.field_1017 = this.field_1014.stream().filter(h::a).sorted(h::a).collect(Collectors.toList());
      this.field_1012.setSelectedIndex(this.field_1017.size() == 1 ? 0 : -1);
      this.field_1012.updateUI();
   }

   // $VF: renamed from: a (int) nomanssave.ey
   private class_152 method_885(int var1) {
      this.field_1013 = var1;
      this.field_1014 = class_152.method_792(var1, this.field_1008.getText());
      this.method_882();
      this.field_1007 = null;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1007;
   }

   // $VF: renamed from: a (java.awt.Container, int) nomanssave.ey
   public static class_152 method_886(Container var0, int var1) {
      if (field_1018 == null) {
         Frame var2 = JOptionPane.getFrameForComponent(var0);
         field_1018 = new class_319(var2);
      }

      return field_1018.method_885(var1);
   }
}
