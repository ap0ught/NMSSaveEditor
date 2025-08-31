package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

// $VF: renamed from: nomanssave.cg
public class class_323 extends JDialog {
   // $VF: renamed from: fn javax.swing.JTextField
   private JTextField field_1041;
   // $VF: renamed from: fo javax.swing.JLabel
   private JLabel field_1042;
   // $VF: renamed from: fp javax.swing.JTextField
   private JTextField field_1043;
   // $VF: renamed from: fq javax.swing.JTextField
   private JTextField field_1044;
   // $VF: renamed from: fr javax.swing.JLabel
   private JLabel field_1045;
   // $VF: renamed from: fs javax.swing.JTextField
   private JTextField field_1046;
   // $VF: renamed from: ft nomanssave.G
   private class_374 field_1047;
   // $VF: renamed from: fu javax.swing.JLabel
   private JLabel field_1048;
   // $VF: renamed from: fv nomanssave.G
   private class_374 field_1049;
   // $VF: renamed from: fw javax.swing.JTextField
   private JTextField field_1050;
   // $VF: renamed from: fx javax.swing.JTextField
   private JTextField field_1051;
   // $VF: renamed from: fy javax.swing.JTextArea
   private JTextArea field_1052;
   // $VF: renamed from: fz javax.swing.JTextArea
   private JTextArea field_1053;
   // $VF: renamed from: fA nomanssave.ey
   private class_152 field_1054;
   // $VF: renamed from: fB nomanssave.gQ
   private class_12 field_1055;
   // $VF: renamed from: fC java.lang.Integer
   private Integer field_1056;
   // $VF: renamed from: fD java.lang.Integer
   private Integer field_1057;
   // $VF: renamed from: fE nomanssave.cg
   public static class_323 field_1058 = null;

   private class_323(Frame var1) {
      super(var1);
      this.setSize(600, 480);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Item Details");
      this.setModal(true);
      JPanel var2 = new JPanel();
      var2.setLayout(
         new FormLayout(
            new ColumnSpec[]{
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("100px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("default:grow"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("100px"),
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
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("64px"),
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("default:grow"),
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      var2.add(new JLabel("Type:"), "2, 2, left, center");
      this.field_1041 = new JTextField();
      this.field_1041.setEditable(false);
      var2.add(this.field_1041, "4, 2, fill, default");
      this.field_1042 = new JLabel("");
      var2.add(this.field_1042, "6, 2, 1, 7, center, fill");
      var2.add(new JLabel("Category:"), "2, 4, left, center");
      this.field_1043 = new JTextField();
      this.field_1043.setEditable(false);
      var2.add(this.field_1043, "4, 4, fill, default");
      var2.add(new JLabel("Name:"), "2, 6, left, center");
      this.field_1044 = new JTextField();
      this.field_1044.setEditable(false);
      var2.add(this.field_1044, "4, 6, fill, default");
      var2.add(new JLabel("ID:"), "2, 8, left, center");
      JPanel var3 = new JPanel();
      var3.setLayout(
         new FormLayout(
            new ColumnSpec[]{ColumnSpec.decode("default:grow"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px")},
            new RowSpec[]{FormFactory.DEFAULT_ROWSPEC}
         )
      );
      this.field_1046 = new JTextField();
      this.field_1046.setEditable(false);
      var3.add(this.field_1046, "1, 1");
      this.field_1045 = new JLabel("#");
      var3.add(this.field_1045, "2, 1");
      this.field_1047 = new class_395(this);
      this.field_1047.setEditable(false);
      var3.add(this.field_1047, "3, 1");
      var2.add(var3, "4, 8, fill, default");
      this.field_1048 = new JLabel("Quantity:");
      var2.add(this.field_1048, "2, 10, left, center");
      var3 = new JPanel();
      var3.setLayout(
         new FormLayout(
            new ColumnSpec[]{ColumnSpec.decode("100px"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px")}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC}
         )
      );
      this.field_1049 = new class_394(this);
      this.field_1049.setEditable(false);
      var3.add(this.field_1049, "1, 1");
      var3.add(new JLabel("/"), "2, 1");
      this.field_1050 = new JTextField();
      this.field_1050.setEditable(false);
      var3.add(this.field_1050, "3, 1");
      var2.add(var3, "4, 10, fill, default");
      var2.add(new JLabel("Subtitle:"), "2, 12, left, center");
      this.field_1051 = new JTextField();
      this.field_1051.setEditable(false);
      var2.add(this.field_1051, "4, 12, 3, 1, fill, default");
      var2.add(new JLabel("Build Cost:"), "2, 14, left, top");
      JScrollPane var4 = new JScrollPane();
      var4.setBorder(this.field_1051.getBorder());
      var4.setBackground(this.field_1051.getBackground());
      this.field_1052 = new JTextArea();
      this.field_1052.setEditable(false);
      this.field_1052.setBorder(null);
      this.field_1052.setBackground(null);
      this.field_1052.setFont(this.field_1051.getFont());
      var4.setViewportView(this.field_1052);
      var2.add(var4, "4, 14, 3, 1, fill, fill");
      var2.add(new JLabel("Description:"), "2, 16, left, top");
      this.field_1053 = new JTextArea();
      this.field_1053.setEditable(false);
      this.field_1053.setWrapStyleWord(true);
      this.field_1053.setLineWrap(true);
      this.field_1053.setBorder(this.field_1051.getBorder());
      this.field_1053.setBackground(this.field_1051.getBackground());
      this.field_1053.setFont(this.field_1051.getFont());
      var2.add(this.field_1053, "4, 16, 3, 1, fill, fill");
      this.setContentPane(var2);
      this.getRootPane().registerKeyboardAction(new class_189(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.addWindowListener(new class_428(this));
   }

   // $VF: renamed from: a (nomanssave.gQ) void
   private void method_931(class_12 var1) {
      this.field_1055 = var1;
      Object var2 = var1.method_40();
      this.field_1054 = class_152.method_795(var2);
      this.field_1056 = null;
      this.field_1057 = null;
      String var3 = this.field_1054 == null ? var1.getType() : this.field_1054.method_777().toString();
      this.field_1041.setText(var3);
      this.field_1042.setIcon(this.field_1054 == null ? null : this.field_1054.method_786(2));
      if (this.field_1054 != null && this.field_1054.method_778()) {
         String var4 = "";
         if (var2 instanceof class_95) {
            class_95 var5 = (class_95)var2;
            int var6 = var5.indexOf(35);
            if (var6 >= 0) {
               var4 = var5.substring(var6 + 1);
            }
         } else {
            String var9 = var2.toString();
            int var11 = var9.indexOf(35);
            if (var11 >= 0) {
               var4 = var9.substring(var11 + 1);
            }
         }

         this.field_1046.setText(this.field_1054.getID());
         this.field_1047.setText(var4);
         this.field_1045.setVisible(true);
         this.field_1047.setVisible(true);

         try {
            int var10 = class_35.method_149(var4, 0, 99999);
            this.field_1056 = new Integer(var10);
            this.field_1047.setEditable(true);
         } catch (RuntimeException var7) {
            class_37.warn("Error detected in item id: " + var2);
            this.field_1056 = null;
            this.field_1047.setEditable(false);
         }
      } else {
         this.field_1046.setText(var1.method_41());
         this.field_1047.setText("");
         this.field_1045.setVisible(false);
         this.field_1047.setVisible(false);
      }

      if (var3.equals("Technology") && var1.method_43() >= 0 && var1.method_43() < var1.method_45()) {
         this.field_1048.setText("Charge:");
         this.field_1057 = var1.method_43();
         this.field_1049.setText(Integer.toString(var1.method_43()));
         this.field_1050.setText(Integer.toString(var1.method_45()));
         this.field_1049.setEditable(true);
      } else if ((var3.equals("Product") || var3.equals("Substance")) && var1.method_45() > 1) {
         this.field_1048.setText("Quantity:");
         this.field_1057 = var1.method_43();
         this.field_1049.setText(Integer.toString(var1.method_43()));
         this.field_1050.setText(Integer.toString(var1.method_45()));
         this.field_1049.setEditable(true);
      } else {
         this.field_1048.setText("Quantity:");
         this.field_1049.setText("1");
         this.field_1050.setText("1");
         this.field_1049.setEditable(false);
      }

      this.field_1044.setText(this.field_1054 == null ? "[Unknown]" : this.field_1054.getName());
      this.field_1043.setText(this.field_1054 == null ? "[Unknown]" : this.field_1054.method_779().toString());
      this.field_1051.setText(this.field_1054 == null ? "" : this.field_1054.method_783());
      String var8 = this.field_1054 == null ? "" : this.field_1054.method_789().stream().<CharSequence>map(cg::a).collect(Collectors.joining("\n"));
      if (var8.length() == 0) {
         var8 = "N/A";
      }

      this.field_1052.setText(var8);
      this.field_1052.setCaretPosition(0);
      this.field_1053.setText(this.field_1054 == null ? "" : this.field_1054.getDescription());
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
   }

   // $VF: renamed from: a (java.awt.Container, nomanssave.gQ) void
   public static void method_932(Container var0, class_12 var1) {
      if (field_1058 == null) {
         Frame var2 = JOptionPane.getFrameForComponent(var0);
         field_1058 = new class_323(var2);
      }

      field_1058.method_931(var1);
   }
}
