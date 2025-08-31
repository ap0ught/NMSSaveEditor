package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.aQ
public class class_327 extends JDialog {
   // $VF: renamed from: dk java.awt.Dimension
   private Dimension field_1080;
   // $VF: renamed from: dl java.awt.Dimension
   private Dimension field_1081;
   // $VF: renamed from: dm java.awt.Dimension
   private Dimension field_1082;
   // $VF: renamed from: dn java.awt.Dimension
   private Dimension field_1083 = null;
   // $VF: renamed from: do javax.swing.JTextField
   private JTextField field_1084;
   // $VF: renamed from: dp javax.swing.JTextField
   private JTextField field_1085;
   // $VF: renamed from: dq nomanssave.aQ
   private static class_327 field_1086;

   private class_327(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Expand Inventory");
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
               ColumnSpec.decode("250px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC
            },
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Width:");
      var3.add(var4, "2, 2, left, center");
      this.field_1084 = new JTextField();
      this.field_1084.addFocusListener(new class_280(this));
      var3.add(this.field_1084, "4, 2, fill, default");
      JLabel var5 = new JLabel("Height:");
      var3.add(var5, "2, 4, left, center");
      this.field_1085 = new JTextField();
      this.field_1085.addFocusListener(new class_279(this));
      var3.add(this.field_1085, "4, 4, fill, default");
      var2.add(var3);
      JPanel var6 = new JPanel();
      var6.setLayout(new FlowLayout(2));
      var2.add(var6, "South");
      JButton var7 = new JButton("Save");
      var7.addActionListener(new class_278(this));
      var6.add(var7);
      this.getRootPane().setDefaultButton(var7);
      JButton var8 = new JButton("Cancel");
      var8.addActionListener(new class_277(this));
      var6.add(var8);
      this.getRootPane().registerKeyboardAction(new class_276(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: a (java.awt.Dimension, java.awt.Dimension, java.awt.Dimension) java.awt.Dimension
   private Dimension method_961(Dimension var1, Dimension var2, Dimension var3) {
      this.field_1080 = var1;
      this.field_1081 = var2;
      this.field_1082 = var3;
      this.field_1084.setText(Integer.toString(var1.width));
      this.field_1085.setText(Integer.toString(var1.height));
      this.field_1083 = null;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1083;
   }

   // $VF: renamed from: a (java.awt.Container, java.awt.Dimension, java.awt.Dimension, java.awt.Dimension) java.awt.Dimension
   public static Dimension method_962(Container var0, Dimension var1, Dimension var2, Dimension var3) {
      if (field_1086 == null) {
         Frame var4 = JOptionPane.getFrameForComponent(var0);
         field_1086 = new class_327(var4);
      }

      return field_1086.method_961(var1, var2, var3);
   }
}
