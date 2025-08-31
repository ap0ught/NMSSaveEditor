package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

// $VF: renamed from: nomanssave.ba
public class class_358 extends JPanel {
   // $VF: renamed from: dA com.jgoodies.forms.layout.FormLayout
   private final FormLayout field_1231 = new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC});

   class_358() {
      this(class_300.field_970, 0);
   }

   class_358(int... var1) {
      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2] > 0) {
            this.field_1231.appendColumn(ColumnSpec.decode(var1[var2] + "px"));
         } else {
            this.field_1231.appendColumn(ColumnSpec.decode("default:grow"));
         }

         this.field_1231.appendColumn(FormFactory.LABEL_COMPONENT_GAP_COLSPEC);
      }

      this.setLayout(this.field_1231);
   }

   // $VF: renamed from: k (java.lang.String) void
   void method_1138(String var1) {
      this.method_1139(var1, null);
   }

   // $VF: renamed from: a (java.lang.String, javax.swing.ImageIcon) void
   void method_1139(String var1, ImageIcon var2) {
      if (this.field_1231.getRowCount() == 1) {
         this.field_1231.appendRow(FormFactory.DEFAULT_ROWSPEC);
         this.field_1231.appendRow(FormFactory.LINE_GAP_ROWSPEC);
      } else {
         int var3 = this.field_1231.getRowCount();
         this.field_1231.insertRow(var3, FormFactory.DEFAULT_ROWSPEC);
         this.field_1231.insertRow(var3, RowSpec.decode("bottom:25px"));
      }

      int var6 = this.field_1231.getColumnCount() - 2;
      JLabel var4 = new JLabel(var1);
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      if (var2 == null) {
         this.add(var4, "2, " + (this.field_1231.getRowCount() - 1) + ", " + var6 + ", 1, left, default");
      } else {
         JPanel var5 = new JPanel();
         var5.setLayout(new FlowLayout(0, 0, 0));
         var5.add(new JLabel(var2));
         var5.add(var4);
         this.add(var5, "2, " + (this.field_1231.getRowCount() - 1) + ", " + var6 + ", 1, left, default");
      }
   }

   void addText(String var1) {
      if (this.field_1231.getRowCount() == 1) {
         this.field_1231.appendRow(FormFactory.DEFAULT_ROWSPEC);
         this.field_1231.appendRow(FormFactory.LINE_GAP_ROWSPEC);
      } else {
         int var2 = this.field_1231.getRowCount();
         this.field_1231.insertRow(var2, FormFactory.DEFAULT_ROWSPEC);
         this.field_1231.insertRow(var2, RowSpec.decode("bottom:25px"));
      }

      int var4 = this.field_1231.getColumnCount() - 2;
      JLabel var3 = new JLabel(var1);
      this.add(var3, "2, " + (this.field_1231.getRowCount() - 1) + ", " + var4 + ", 1, left, default");
   }

   // $VF: renamed from: Y () void
   void method_1140() {
      this.field_1231.appendRow(RowSpec.decode("bottom:10px"));
      this.field_1231.appendRow(FormFactory.LINE_GAP_ROWSPEC);
   }

   // $VF: renamed from: a (java.lang.String, javax.swing.JComponent) void
   void method_1141(String var1, JComponent var2) {
      this.method_1144(var1, false, var2, 1);
   }

   // $VF: renamed from: a (java.lang.String, javax.swing.JComponent, int) void
   void method_1142(String var1, JComponent var2, int var3) {
      this.method_1144(var1, false, var2, var3);
   }

   // $VF: renamed from: a (java.lang.String, boolean, javax.swing.JComponent) void
   void method_1143(String var1, boolean var2, JComponent var3) {
      this.method_1144(var1, var2, var3, 1);
   }

   // $VF: renamed from: a (java.lang.String, boolean, javax.swing.JComponent, int) void
   void method_1144(String var1, boolean var2, JComponent var3, int var4) {
      var4 = var4 * 2 - 1;
      this.field_1231.appendRow(FormFactory.DEFAULT_ROWSPEC);
      this.field_1231.appendRow(FormFactory.LINE_GAP_ROWSPEC);
      int var5 = this.field_1231.getRowCount() - 1;
      if (var1 != null) {
         JLabel var6 = new JLabel(var1 + ":");
         if (var2) {
            var6.putClientProperty("FlatLaf.styleClass", "semibold");
         }

         this.add(var6, "2, " + var5 + ", left, default");
      }

      this.add(var3, "4, " + var5 + ", " + var4 + ", 1, fill, default");
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.G) void
   void method_1145(String var1, class_374 var2) {
      JPanel var3 = new JPanel();
      var3.setLayout(new BorderLayout(0, 0));
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(2, 0, 0));
      JButton var5 = new JButton("Generate");
      var5.setEnabled(var2.isEnabled());
      var5.addActionListener(new class_234(this, var2));
      var2.addPropertyChangeListener("enabled", new class_233(this, var5, var2));
      var4.add(var5);
      var3.add(var2, "Center");
      var3.add(var4, "South");
      this.method_1141(var1, var3);
   }

   // $VF: renamed from: a (javax.swing.JComponent) void
   void method_1146(JComponent var1) {
      this.field_1231.appendRow(FormFactory.DEFAULT_ROWSPEC);
      this.field_1231.appendRow(FormFactory.LINE_GAP_ROWSPEC);
      int var2 = this.field_1231.getColumnCount() - 2;
      int var3 = this.field_1231.getRowCount() - 1;
      this.add(var1, "2, " + var3 + ", " + var2 + ", 1, fill, default");
   }
}
