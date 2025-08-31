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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.Q
public class class_330 extends JDialog {
   // $VF: renamed from: bw nomanssave.W
   private class_306 field_1092;
   // $VF: renamed from: bx int
   private int field_1093;
   // $VF: renamed from: by int
   private int field_1094;
   // $VF: renamed from: bz nomanssave.W
   private class_306 field_1095 = null;
   // $VF: renamed from: bA javax.swing.JTextField
   private JTextField field_1096;
   // $VF: renamed from: bB javax.swing.JTextField
   private JTextField field_1097;
   // $VF: renamed from: bC nomanssave.Q
   private static class_330 field_1098;

   private class_330(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Change Stack Sizes");
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
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("20dlu"),
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Substances:");
      var3.add(var4, "2, 2, left, center");
      this.field_1096 = new JTextField();
      this.field_1096.addFocusListener(new class_311(this));
      var3.add(this.field_1096, "4, 2, fill, default");
      JLabel var5 = new JLabel("Products:");
      var3.add(var5, "2, 4, left, center");
      this.field_1097 = new JTextField();
      this.field_1097.addFocusListener(new class_310(this));
      var3.add(this.field_1097, "4, 4, fill, default");
      JLabel var6 = new JLabel("<html><font color=\"red\"><b>Please Note: No Man's Sky sometimes reverts these settings back to default.</b></font></html>");
      var3.add(var6, "2, 6, 3, 1, fill, center");
      var2.add(var3);
      JPanel var7 = new JPanel();
      var7.setLayout(new FlowLayout(2));
      var2.add(var7, "South");
      JButton var8 = new JButton("Save");
      var8.addActionListener(new class_309(this));
      var7.add(var8);
      this.getRootPane().setDefaultButton(var8);
      JButton var9 = new JButton("Cancel");
      var9.addActionListener(new class_308(this));
      var7.add(var9);
      this.getRootPane().registerKeyboardAction(new class_307(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: a (nomanssave.W, int, int) nomanssave.W
   private class_306 method_976(class_306 var1, int var2, int var3) {
      this.field_1092 = var1;
      this.field_1093 = var2;
      this.field_1094 = var3;
      this.field_1096.setText(Integer.toString(var1.field_984));
      this.field_1097.setText(Integer.toString(var1.field_985));
      this.field_1095 = null;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1095;
   }

   // $VF: renamed from: a (java.awt.Container, nomanssave.W, int, int) nomanssave.W
   public static class_306 method_977(Container var0, class_306 var1, int var2, int var3) {
      if (field_1098 == null) {
         Frame var4 = JOptionPane.getFrameForComponent(var0);
         field_1098 = new class_330(var4);
      }

      return field_1098.method_976(var1, var2, var3);
   }
}
