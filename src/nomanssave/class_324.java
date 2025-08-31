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
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.cY
public class class_324 extends JDialog {
   // $VF: renamed from: gM javax.swing.JComboBox
   private JComboBox field_1059;
   // $VF: renamed from: gN java.util.List
   private List field_1060 = Collections.emptyList();
   // $VF: renamed from: gO int
   private int field_1061 = -1;
   // $VF: renamed from: gP nomanssave.cY
   private static class_324 field_1062 = null;

   private class_324(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Move Base Computer");
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JPanel var3 = new JPanel();
      var3.setLayout(new FlowLayout(0));
      var3.add(new JLabel("Please select a base part to swap your base computer with."));
      var2.add(var3, "North");
      JPanel var4 = new JPanel();
      var4.setLayout(
         new FormLayout(
            new ColumnSpec[]{
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("100px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("250px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC
            },
            new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}
         )
      );
      JLabel var5 = new JLabel("Base Part:");
      var4.add(var5, "2, 2, left, center");
      this.field_1059 = new JComboBox();
      this.field_1059.setModel(new class_196(this));
      var4.add(this.field_1059, "4, 2, fill, default");
      var2.add(var4, "Center");
      JPanel var6 = new JPanel();
      var6.setLayout(new FlowLayout(2));
      var2.add(var6, "South");
      JButton var7 = new JButton("Save");
      var7.addActionListener(new class_176(this));
      var6.add(var7);
      this.getRootPane().setDefaultButton(var7);
      JButton var8 = new JButton("Cancel");
      var8.addActionListener(new class_175(this));
      var6.add(var8);
      this.getRootPane().registerKeyboardAction(new class_174(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: b (java.util.List) int
   private int method_942(List var1) {
      this.field_1060 = var1;
      this.setLocationRelativeTo(this.getParent());
      this.field_1059.setSelectedIndex(0);
      this.field_1059.updateUI();
      this.field_1061 = -1;
      this.setVisible(true);
      return this.field_1061;
   }

   // $VF: renamed from: a (java.awt.Container, java.util.List) int
   public static int method_943(Container var0, List var1) {
      if (field_1062 == null) {
         Frame var2 = JOptionPane.getFrameForComponent(var0);
         field_1062 = new class_324(var2);
      }

      return field_1062.method_942(var1);
   }
}
