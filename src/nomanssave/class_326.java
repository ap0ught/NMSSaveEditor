package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.aW
public class class_326 extends JDialog {
   // $VF: renamed from: ds javax.swing.JTextField
   private JTextField field_1074;
   // $VF: renamed from: dt javax.swing.JCheckBox
   private JCheckBox field_1075;
   // $VF: renamed from: du javax.swing.JCheckBox
   private JCheckBox field_1076;
   // $VF: renamed from: dv javax.swing.JRadioButton
   private JRadioButton field_1077;
   // $VF: renamed from: dw javax.swing.JRadioButton
   private JRadioButton field_1078;
   // $VF: renamed from: dx nomanssave.aW
   private static class_326 field_1079;

   private class_326(class_322 var1) {
      super((Dialog)var1);
      this.setSize(400, 250);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Find");
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
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Find:");
      var3.add(var4, "2, 2, left, center");
      this.field_1074 = new JTextField();
      var3.add(this.field_1074, "4, 2, fill, default");
      var2.add(var3);
      JPanel var5 = new JPanel();
      var5.setLayout(new GridLayout(1, 2));
      var5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Direction"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      this.field_1077 = new JRadioButton("Forward");
      this.field_1077.setSelected(true);
      var5.add(this.field_1077);
      this.field_1078 = new JRadioButton("Backward");
      var5.add(this.field_1078);
      ButtonGroup var6 = new ButtonGroup();
      var6.add(this.field_1077);
      var6.add(this.field_1078);
      var3.add(var5, "2, 4, 3, 1");
      JPanel var7 = new JPanel();
      var7.setLayout(new GridLayout(1, 2));
      var7.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Options"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      this.field_1075 = new JCheckBox("Case Sensitive");
      this.field_1075.setSelected(true);
      var7.add(this.field_1075);
      this.field_1076 = new JCheckBox("Wrap Search");
      var7.add(this.field_1076);
      var3.add(var7, "2, 6, 3, 1");
      JPanel var8 = new JPanel();
      var8.setLayout(new FlowLayout(2));
      var2.add(var8, "South");
      JButton var9 = new JButton("Find");
      var9.setMnemonic(10);
      var9.addActionListener(new class_275(this, var1));
      var8.add(var9);
      this.getRootPane().setDefaultButton(var9);
      JButton var10 = new JButton("Cancel");
      var10.setMnemonic(27);
      var10.addActionListener(new class_274(this));
      var8.add(var10);
      this.getRootPane().registerKeyboardAction(new class_273(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: a (nomanssave.cy, java.lang.String) void
   public static void method_956(class_322 var0, String var1) {
      if (field_1079 == null) {
         field_1079 = new class_326(var0);
      }

      field_1079.setLocationRelativeTo(var0);
      if (var1 != null) {
         field_1079.field_1074.setText(var1);
      }

      field_1079.field_1074.setSelectionStart(0);
      field_1079.field_1074.setSelectionEnd(field_1079.field_1074.getText().length());
      field_1079.field_1074.requestFocus();
      field_1079.setVisible(true);
   }
}
