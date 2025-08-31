package nomanssave;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.dd
public class class_321 extends JDialog {
   // $VF: renamed from: gS javax.swing.JList
   private final JList field_1023;
   // $VF: renamed from: gT java.util.List
   private List field_1024;
   // $VF: renamed from: gU int
   private int field_1025;
   // $VF: renamed from: gV nomanssave.dd
   private static class_321 field_1026 = null;

   private class_321(Frame var1) {
      super(var1);
      this.setSize(300, 300);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Move Item");
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JScrollPane var3 = new JScrollPane();
      this.field_1023 = new JList();
      this.field_1023.setSelectionMode(0);
      this.field_1023.setModel(new class_173(this));
      this.field_1023.addMouseListener(new class_238(this));
      var3.setViewportView(this.field_1023);
      var2.add(var3);
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(2));
      var2.add(var4, "South");
      JButton var5 = new JButton("Move");
      var5.addActionListener(new class_172(this));
      var4.add(var5);
      this.getRootPane().setDefaultButton(var5);
      JButton var6 = new JButton("Cancel");
      var6.addActionListener(new class_171(this));
      var4.add(var6);
      this.getRootPane().registerKeyboardAction(new class_170(this), KeyStroke.getKeyStroke(27, 0), 2);
   }

   // $VF: renamed from: a (java.util.List, int) int
   private int method_909(List var1, int var2) {
      this.field_1024 = var1;
      this.field_1023.updateUI();
      this.field_1023.setSelectedIndex(this.field_1025);
      this.field_1025 = var2;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1025;
   }

   // $VF: renamed from: a (java.awt.Container, java.util.List, int) int
   public static int method_910(Container var0, List var1, int var2) {
      if (field_1026 == null) {
         Frame var3 = JOptionPane.getFrameForComponent(var0);
         field_1026 = new class_321(var3);
      }

      return field_1026.method_909(var1, var2);
   }
}
