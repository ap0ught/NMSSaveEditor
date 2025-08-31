package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

// $VF: renamed from: nomanssave.ap
public class class_363 extends JPanel {
   // $VF: renamed from: ci javax.swing.JTable
   private final JTable field_1245;
   // $VF: renamed from: cj javax.swing.table.TableRowSorter
   private final TableRowSorter field_1246;
   // $VF: renamed from: ck javax.swing.JTable
   private final JTable field_1247;
   // $VF: renamed from: cl javax.swing.table.TableRowSorter
   private final TableRowSorter field_1248;
   // $VF: renamed from: cm javax.swing.JCheckBox[]
   private final JCheckBox[] field_1249;
   // $VF: renamed from: cn javax.swing.JTable
   private final JTable field_1250;
   // $VF: renamed from: co javax.swing.table.TableRowSorter
   private final TableRowSorter field_1251;
   // $VF: renamed from: cp nomanssave.gz
   private class_38 field_1252;
   // $VF: renamed from: cq nomanssave.eV
   private class_142 field_1253;
   // $VF: renamed from: cr nomanssave.eV
   private class_142 field_1254;
   // $VF: renamed from: cs nomanssave.eV
   private class_142 field_1255;
   // $VF: renamed from: ct java.util.ArrayList
   private ArrayList field_1256 = new ArrayList();

   class_363(Application var1) {
      GridLayout var2 = new GridLayout(2, 2);
      this.setLayout(var2);
      JPanel var3 = new JPanel();
      this.add(var3);
      var3.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("200px:grow"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Known Technology");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var3.add(var4, "2, 2");
      JScrollPane var5 = new JScrollPane();
      var3.add(var5, "2, 4, fill, fill");
      this.field_1245 = new JTable();
      this.field_1245.setSelectionMode(2);
      this.field_1245.setModel(new class_263(this));
      this.field_1245.getColumnModel().getColumn(0).setMaxWidth(24);
      this.field_1245.getColumnModel().getColumn(0).setCellRenderer(new class_349(this, null));
      this.field_1246 = new TableRowSorter<>(this.field_1245.getModel());
      this.field_1246.setSortable(0, false);
      this.field_1245.setRowSorter(this.field_1246);
      var5.setViewportView(this.field_1245);
      JPanel var6 = new JPanel();
      var6.setLayout(new FlowLayout());
      var3.add(var6, "2, 6, fill, default");
      JButton var7 = new JButton();
      var7.setText("Add Technology");
      var7.addActionListener(new class_261(this));
      var6.add(var7);
      JButton var8 = new JButton();
      var8.setText("Remove Selected");
      var8.addActionListener(new class_260(this));
      var6.add(var8);
      JPanel var9 = new JPanel();
      this.add(var9);
      var9.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("200px:grow"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      var4 = new JLabel("Known Products");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var9.add(var4, "2, 2");
      JScrollPane var10 = new JScrollPane();
      var9.add(var10, "2, 4, fill, fill");
      this.field_1247 = new JTable();
      this.field_1247.setSelectionMode(2);
      this.field_1247.setModel(new class_259(this));
      this.field_1247.getColumnModel().getColumn(0).setMaxWidth(24);
      this.field_1247.getColumnModel().getColumn(0).setCellRenderer(new class_349(this, null));
      this.field_1248 = new TableRowSorter<>(this.field_1247.getModel());
      this.field_1248.setSortable(0, false);
      this.field_1247.setRowSorter(this.field_1248);
      var10.setViewportView(this.field_1247);
      var6 = new JPanel();
      var6.setLayout(new FlowLayout());
      var9.add(var6, "2, 6, fill, default");
      JButton var11 = new JButton();
      var11.setText("Add Product");
      var11.addActionListener(new class_258(this));
      var6.add(var11);
      JButton var12 = new JButton();
      var12.setText("Remove Selected");
      var12.addActionListener(new class_257(this));
      var6.add(var12);
      JPanel var13 = new JPanel();
      this.add(var13);
      var13.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("200px:grow"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      var4 = new JLabel("Known Words");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var13.add(var4, "2, 2");
      JScrollPane var14 = new JScrollPane();
      var13.add(var14, "2, 4, fill, fill");
      this.field_1250 = new JTable();
      this.field_1250.setCellSelectionEnabled(false);
      this.field_1250.getColumnModel().setColumnMargin(2);
      this.field_1250.setModel(new class_256(this));
      this.field_1250.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new class_350(this.field_1250, 2));
      this.field_1250.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(new class_350(this.field_1250, 2));
      JCheckBox var15 = new JCheckBox();
      var15.setHorizontalAlignment(0);

      for (int var16 = 2; var16 < this.field_1250.getColumnCount(); var16++) {
         this.field_1250.getColumnModel().getColumn(var16).setMaxWidth(80);
         this.field_1250.getTableHeader().getColumnModel().getColumn(var16).setHeaderRenderer(new class_350(this.field_1250, 0));
         this.field_1250.getColumnModel().getColumn(var16).setCellEditor(new DefaultCellEditor(var15));
         this.field_1250.getColumnModel().getColumn(var16).setCellRenderer(new class_342());
      }

      this.field_1251 = new TableRowSorter<>(this.field_1250.getModel());

      for (int var30 = 2; var30 < this.field_1250.getModel().getColumnCount(); var30++) {
         this.field_1251.setSortable(var30, false);
      }

      this.field_1250.setRowSorter(this.field_1251);
      var14.setViewportView(this.field_1250);
      var6 = new JPanel();
      var6.setLayout(new FlowLayout());
      var13.add(var6, "2, 6, fill, default");
      JButton var31 = new JButton();
      var31.setText("Learn All");
      var31.addActionListener(new class_255(this));
      var6.add(var31);
      JButton var17 = new JButton();
      var17.setText("Unlearn All");
      var17.addActionListener(new class_254(this));
      var6.add(var17);
      JPanel var18 = new JPanel();
      this.add(var18);
      var18.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      var4 = new JLabel("Known Glyphs");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var18.add(var4, "2, 2");
      JPanel var19 = new JPanel();
      var19.putClientProperty("FlatLaf.styleClass", "glyphs");
      var18.add(var19, "2, 4, fill, fill");
      var19.setLayout(
         new FormLayout(
            new ColumnSpec[]{
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               FormFactory.DEFAULT_COLSPEC,
               FormFactory.DEFAULT_COLSPEC
            },
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC
            }
         )
      );
      this.field_1249 = new JCheckBox[16];

      for (int var20 = 0; var20 < 16; var20++) {
         int var21 = var20 % 4 * 3 + 2;
         int var22 = var20 / 4 * 2 + 2;
         this.field_1249[var20] = new JCheckBox();
         this.field_1249[var20].setBackground(var19.getBackground());
         this.field_1249[var20].addActionListener(new class_262(this));
         ImageIcon var23 = Application.method_1324("UI-GLYPH" + (var20 + 1) + ".PNG");
         if (var23 == null) {
            var4 = new JLabel(Integer.toString(var20 + 1));
         } else {
            var4 = new JLabel(var23);
         }

         var19.add(this.field_1249[var20], var21 + ", " + var22);
         var19.add(var4, var21 + 1 + ", " + var22);
      }
   }

   // $VF: renamed from: R () void
   private void method_1174() {
      if (this.field_1252 != null) {
         int var1 = 0;

         for (int var2 = 0; var2 < 16; var2++) {
            if (this.field_1249[var2].isSelected()) {
               var1 |= 1 << var2;
            }
         }

         this.field_1252.method_177(var1);
      }
   }

   // $VF: renamed from: a (nomanssave.gz) void
   public void method_1175(class_38 var1) {
      this.field_1252 = var1;
      this.field_1253 = var1 == null ? null : var1.method_178();
      this.field_1254 = var1 == null ? null : var1.method_179();
      this.field_1255 = var1 == null ? null : var1.method_180();
      this.field_1256 = new ArrayList();
      if (this.field_1254 != null) {
         for (int var2 = 0; var2 < this.field_1254.size(); var2++) {
            String var3 = this.field_1254.method_738(var2);
            if (!this.field_1256.contains(var3)) {
               this.field_1256.add(var3);
            }
         }
      }

      if (this.field_1255 != null) {
         for (int var5 = 0; var5 < this.field_1255.size(); var5++) {
            String var7 = this.field_1255.method_738(var5);
            if (!this.field_1256.contains(var7)) {
               this.field_1256.add(var7);
            }
         }
      }

      this.field_1245.clearSelection();
      this.field_1246.allRowsChanged();
      this.field_1245.updateUI();
      this.field_1247.clearSelection();
      this.field_1248.allRowsChanged();
      this.field_1247.updateUI();
      int var6 = var1 == null ? 0 : var1.method_176();

      for (int var8 = 0; var8 < 16; var8++) {
         int var4 = 1 << var8;
         this.field_1249[var8].setSelected((var6 & var4) == var4);
      }

      this.field_1251.allRowsChanged();
      this.field_1250.updateUI();
   }
}
