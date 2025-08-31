package nomanssave;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.dz
public class class_320 extends JDialog {
   // $VF: renamed from: hr javax.swing.JList
   private final JList field_1019;
   // $VF: renamed from: hs nomanssave.ft[]
   private class_10[] field_1020;
   // $VF: renamed from: gU int
   private int field_1021;
   // $VF: renamed from: ht nomanssave.dz
   private static class_320 field_1022 = null;

   private class_320(Frame var1) {
      super(var1);
      this.setSize(300, 400);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Save File As");
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JScrollPane var3 = new JScrollPane();
      this.field_1019 = new JList();
      this.field_1019.setSelectionMode(0);
      this.field_1019.setModel(new class_188(this));
      var3.setViewportView(this.field_1019);
      var2.add(var3);
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(2));
      var2.add(var4, "South");
      JButton var5 = new JButton("Replace/Save");
      var5.addActionListener(new class_187(this));
      var4.add(var5);
      this.getRootPane().setDefaultButton(var5);
      JButton var6 = new JButton("Cancel");
      var6.addActionListener(new class_186(this));
      var4.add(var6);
      this.getRootPane().registerKeyboardAction(new class_185(this), KeyStroke.getKeyStroke(27, 0), 2);
   }

   // $VF: renamed from: a (nomanssave.ft[], int) int
   private int method_904(class_10[] var1, int var2) {
      this.field_1020 = var1;
      this.field_1019.updateUI();
      this.field_1019.setSelectedIndex(var2);
      this.field_1021 = -1;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1021;
   }

   // $VF: renamed from: a (java.awt.Container, nomanssave.ft[], int) int
   public static int method_905(Container var0, class_10[] var1, int var2) {
      if (field_1022 == null) {
         Frame var3 = JOptionPane.getFrameForComponent(var0);
         field_1022 = new class_320(var3);
      }

      return field_1022.method_904(var1, var2);
   }
}
