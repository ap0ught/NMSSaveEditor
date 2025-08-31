// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;
import javax.swing.KeyStroke;
import java.awt.FlowLayout;
import javax.swing.ComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.util.ArrayList;
import java.awt.Frame;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JDialog;

public class h extends JDialog
{
    private ey l;
    private JTextField m;
    private JButton n;
    private JComboBox o;
    private JComboBox p;
    private JComboBox q;
    private int r;
    private List s;
    private List t;
    private List u;
    private List v;
    private static h w;
    
    static {
        h.w = null;
    }
    
    private h(final Frame owner) {
        super(owner);
        this.l = null;
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Add Item");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel comp = new JPanel();
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("280px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        comp.add(new JLabel("Search:"), "2, 2, left, center");
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new BorderLayout(0, 0));
        (this.m = new JTextField()).setText("");
        comp2.add(this.m, "Center");
        (this.n = new JButton("Search")).addActionListener(new i(this));
        comp2.add(this.n, "East");
        comp.add(comp2, "4, 2, fill, default");
        comp.add(new JLabel("Type:"), "2, 4, left, center");
        (this.o = new JComboBox()).setModel(new j(this));
        comp.add(this.o, "4, 4, fill, default");
        comp.add(new JLabel("Category:"), "2, 6, left, center");
        (this.p = new JComboBox()).setModel(new k(this));
        comp.add(this.p, "4, 6, fill, default");
        comp.add(new JLabel("Item:"), "2, 8, left, center");
        (this.q = new JComboBox()).setModel(new l(this));
        comp.add(this.q, "4, 8, fill, default");
        contentPane.add(comp, "Center");
        final JPanel comp3 = new JPanel();
        comp3.setLayout(new FlowLayout(2));
        contentPane.add(comp3, "South");
        final JButton button = new JButton("Save");
        button.addActionListener(new m(this));
        comp3.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp4 = new JButton("Cancel");
        comp4.addActionListener(new n(this));
        comp3.add(comp4);
        this.getRootPane().registerKeyboardAction(new o(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    private void a() {
        this.t = (List)this.s.stream().map(ey::ba).distinct().sorted((eb, eb2) -> eb.name().compareTo(eb2.name())).collect(Collectors.toList());
        this.o.setSelectedIndex((this.t.size() == 1) ? 0 : -1);
        this.o.updateUI();
        this.b();
    }
    
    private void b() {
        this.u = (List)this.s.stream().filter(ey -> {
            final Object o = this.o.getSelectedItem();
            return ey.ba() == eb;
        }).map(ey::bc).distinct().sorted((ex, ex2) -> ex.name().compareTo(ex2.name())).collect(Collectors.toList());
        this.p.setSelectedIndex((this.u.size() == 1) ? 0 : -1);
        this.p.updateUI();
        this.c();
    }
    
    private void c() {
        this.v = (List)this.s.stream().filter(ey -> {
            final Object o = this.o.getSelectedItem();
            final Object o2 = this.p.getSelectedItem();
            return ey.ba() == eb && ey.bc() == ex && (ex != ex.iZ || !ey.be());
        }).sorted((ey2, ey3) -> ey2.getName().compareTo(ey3.getName())).collect(Collectors.toList());
        this.q.setSelectedIndex((this.v.size() == 1) ? 0 : -1);
        this.q.updateUI();
    }
    
    private ey a(final int r) {
        this.r = r;
        this.s = ey.b(r, this.m.getText());
        this.a();
        this.l = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.l;
    }
    
    public static ey a(final Container parentComponent, final int n) {
        if (h.w == null) {
            h.w = new h(JOptionPane.getFrameForComponent(parentComponent));
        }
        return h.w.a(n);
    }
}
