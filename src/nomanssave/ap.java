// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.table.TableCellEditor;
import javax.swing.DefaultCellEditor;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.RowSorter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JPanel;

public class ap extends JPanel
{
    private final JTable ci;
    private final TableRowSorter cj;
    private final JTable ck;
    private final TableRowSorter cl;
    private final JCheckBox[] cm;
    private final JTable cn;
    private final TableRowSorter co;
    private gz cp;
    private eV cq;
    private eV cr;
    private eV cs;
    private ArrayList ct;
    
    ap(final Application application) {
        this.ct = new ArrayList();
        this.setLayout(new GridLayout(2, 2));
        final JPanel comp = new JPanel();
        this.add(comp);
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp2 = new JLabel("Known Technology");
        comp2.putClientProperty("FlatLaf.styleClass", "semibold");
        comp.add(comp2, "2, 2");
        final JScrollPane comp3 = new JScrollPane();
        comp.add(comp3, "2, 4, fill, fill");
        (this.ci = new JTable()).setSelectionMode(2);
        this.ci.setModel(new aq(this));
        this.ci.getColumnModel().getColumn(0).setMaxWidth(24);
        this.ci.getColumnModel().getColumn(0).setCellRenderer(new aB(this, null));
        (this.cj = new TableRowSorter((M)this.ci.getModel())).setSortable(0, false);
        this.ci.setRowSorter(this.cj);
        comp3.setViewportView(this.ci);
        final JPanel comp4 = new JPanel();
        comp4.setLayout(new FlowLayout());
        comp.add(comp4, "2, 6, fill, default");
        final JButton comp5 = new JButton();
        comp5.setText("Add Technology");
        comp5.addActionListener(new as(this));
        comp4.add(comp5);
        final JButton comp6 = new JButton();
        comp6.setText("Remove Selected");
        comp6.addActionListener(new at(this));
        comp4.add(comp6);
        final JPanel comp7 = new JPanel();
        this.add(comp7);
        comp7.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp8 = new JLabel("Known Products");
        comp8.putClientProperty("FlatLaf.styleClass", "semibold");
        comp7.add(comp8, "2, 2");
        final JScrollPane comp9 = new JScrollPane();
        comp7.add(comp9, "2, 4, fill, fill");
        (this.ck = new JTable()).setSelectionMode(2);
        this.ck.setModel(new au(this));
        this.ck.getColumnModel().getColumn(0).setMaxWidth(24);
        this.ck.getColumnModel().getColumn(0).setCellRenderer(new aB(this, null));
        (this.cl = new TableRowSorter((M)this.ck.getModel())).setSortable(0, false);
        this.ck.setRowSorter(this.cl);
        comp9.setViewportView(this.ck);
        final JPanel comp10 = new JPanel();
        comp10.setLayout(new FlowLayout());
        comp7.add(comp10, "2, 6, fill, default");
        final JButton comp11 = new JButton();
        comp11.setText("Add Product");
        comp11.addActionListener(new av(this));
        comp10.add(comp11);
        final JButton comp12 = new JButton();
        comp12.setText("Remove Selected");
        comp12.addActionListener(new aw(this));
        comp10.add(comp12);
        final JPanel comp13 = new JPanel();
        this.add(comp13);
        comp13.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp14 = new JLabel("Known Words");
        comp14.putClientProperty("FlatLaf.styleClass", "semibold");
        comp13.add(comp14, "2, 2");
        final JScrollPane comp15 = new JScrollPane();
        comp13.add(comp15, "2, 4, fill, fill");
        (this.cn = new JTable()).setCellSelectionEnabled(false);
        this.cn.getColumnModel().setColumnMargin(2);
        this.cn.setModel(new ax(this));
        this.cn.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new aA(this.cn, 2));
        this.cn.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(new aA(this.cn, 2));
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setHorizontalAlignment(0);
        for (int i = 2; i < this.cn.getColumnCount(); ++i) {
            this.cn.getColumnModel().getColumn(i).setMaxWidth(80);
            this.cn.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(new aA(this.cn, 0));
            this.cn.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(checkBox));
            this.cn.getColumnModel().getColumn(i).setCellRenderer(new aC());
        }
        this.co = new TableRowSorter((M)this.cn.getModel());
        for (int j = 2; j < this.cn.getModel().getColumnCount(); ++j) {
            this.co.setSortable(j, false);
        }
        this.cn.setRowSorter(this.co);
        comp15.setViewportView(this.cn);
        final JPanel comp16 = new JPanel();
        comp16.setLayout(new FlowLayout());
        comp13.add(comp16, "2, 6, fill, default");
        final JButton comp17 = new JButton();
        comp17.setText("Learn All");
        comp17.addActionListener(new ay(this));
        comp16.add(comp17);
        final JButton comp18 = new JButton();
        comp18.setText("Unlearn All");
        comp18.addActionListener(new az(this));
        comp16.add(comp18);
        final JPanel comp19 = new JPanel();
        this.add(comp19);
        comp19.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp20 = new JLabel("Known Glyphs");
        comp20.putClientProperty("FlatLaf.styleClass", "semibold");
        comp19.add(comp20, "2, 2");
        final JPanel comp21 = new JPanel();
        comp21.putClientProperty("FlatLaf.styleClass", "glyphs");
        comp19.add(comp21, "2, 4, fill, fill");
        comp21.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC }));
        this.cm = new JCheckBox[16];
        for (int k = 0; k < 16; ++k) {
            final int l = k % 4 * 3 + 2;
            final int n = k / 4 * 2 + 2;
            (this.cm[k] = new JCheckBox()).setBackground(comp21.getBackground());
            this.cm[k].addActionListener(new ar(this));
            final ImageIcon a = Application.a("UI-GLYPH" + (k + 1) + ".PNG");
            JLabel comp22;
            if (a == null) {
                comp22 = new JLabel(Integer.toString(k + 1));
            }
            else {
                comp22 = new JLabel(a);
            }
            comp21.add(this.cm[k], String.valueOf(l) + ", " + n);
            comp21.add(comp22, String.valueOf(l + 1) + ", " + n);
        }
    }
    
    private void R() {
        if (this.cp == null) {
            return;
        }
        int n = 0;
        for (int i = 0; i < 16; ++i) {
            if (this.cm[i].isSelected()) {
                n |= 1 << i;
            }
        }
        this.cp.aE(n);
    }
    
    public void a(final gz cp) {
        this.cp = cp;
        this.cq = ((cp == null) ? null : cp.dQ());
        this.cr = ((cp == null) ? null : cp.dR());
        this.cs = ((cp == null) ? null : cp.dS());
        this.ct = new ArrayList();
        if (this.cr != null) {
            for (int i = 0; i < this.cr.size(); ++i) {
                final String x = this.cr.X(i);
                if (!this.ct.contains(x)) {
                    this.ct.add(x);
                }
            }
        }
        if (this.cs != null) {
            for (int j = 0; j < this.cs.size(); ++j) {
                final String x2 = this.cs.X(j);
                if (!this.ct.contains(x2)) {
                    this.ct.add(x2);
                }
            }
        }
        this.ci.clearSelection();
        this.cj.allRowsChanged();
        this.ci.updateUI();
        this.ck.clearSelection();
        this.cl.allRowsChanged();
        this.ck.updateUI();
        final int n = (cp == null) ? 0 : cp.dP();
        for (int k = 0; k < 16; ++k) {
            final int n2 = 1 << k;
            this.cm[k].setSelected((n & n2) == n2);
        }
        this.co.allRowsChanged();
        this.cn.updateUI();
    }
}
