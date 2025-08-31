// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.Icon;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import java.awt.Container;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.LayoutManager;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDialog;

public class cg extends JDialog
{
    private JTextField fn;
    private JLabel fo;
    private JTextField fp;
    private JTextField fq;
    private JLabel fr;
    private JTextField fs;
    private G ft;
    private JLabel fu;
    private G fv;
    private JTextField fw;
    private JTextField fx;
    private JTextArea fy;
    private JTextArea fz;
    private ey fA;
    private gQ fB;
    private Integer fC;
    private Integer fD;
    public static cg fE;
    
    static {
        cg.fE = null;
    }
    
    private cg(final Frame owner) {
        super(owner);
        this.setSize(600, 480);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Item Details");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("64px"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormFactory.LINE_GAP_ROWSPEC }));
        contentPane.add(new JLabel("Type:"), "2, 2, left, center");
        (this.fn = new JTextField()).setEditable(false);
        contentPane.add(this.fn, "4, 2, fill, default");
        contentPane.add(this.fo = new JLabel(""), "6, 2, 1, 7, center, fill");
        contentPane.add(new JLabel("Category:"), "2, 4, left, center");
        (this.fp = new JTextField()).setEditable(false);
        contentPane.add(this.fp, "4, 4, fill, default");
        contentPane.add(new JLabel("Name:"), "2, 6, left, center");
        (this.fq = new JTextField()).setEditable(false);
        contentPane.add(this.fq, "4, 6, fill, default");
        contentPane.add(new JLabel("ID:"), "2, 8, left, center");
        final JPanel comp = new JPanel();
        comp.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px") }, new RowSpec[] { FormFactory.DEFAULT_ROWSPEC }));
        (this.fs = new JTextField()).setEditable(false);
        comp.add(this.fs, "1, 1");
        comp.add(this.fr = new JLabel("#"), "2, 1");
        (this.ft = new ch(this)).setEditable(false);
        comp.add(this.ft, "3, 1");
        contentPane.add(comp, "4, 8, fill, default");
        contentPane.add(this.fu = new JLabel("Quantity:"), "2, 10, left, center");
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("100px"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px") }, new RowSpec[] { FormFactory.DEFAULT_ROWSPEC }));
        (this.fv = new ci(this)).setEditable(false);
        comp2.add(this.fv, "1, 1");
        comp2.add(new JLabel("/"), "2, 1");
        (this.fw = new JTextField()).setEditable(false);
        comp2.add(this.fw, "3, 1");
        contentPane.add(comp2, "4, 10, fill, default");
        contentPane.add(new JLabel("Subtitle:"), "2, 12, left, center");
        (this.fx = new JTextField()).setEditable(false);
        contentPane.add(this.fx, "4, 12, 3, 1, fill, default");
        contentPane.add(new JLabel("Build Cost:"), "2, 14, left, top");
        final JScrollPane comp3 = new JScrollPane();
        comp3.setBorder(this.fx.getBorder());
        comp3.setBackground(this.fx.getBackground());
        (this.fy = new JTextArea()).setEditable(false);
        this.fy.setBorder(null);
        this.fy.setBackground(null);
        this.fy.setFont(this.fx.getFont());
        comp3.setViewportView(this.fy);
        contentPane.add(comp3, "4, 14, 3, 1, fill, fill");
        contentPane.add(new JLabel("Description:"), "2, 16, left, top");
        (this.fz = new JTextArea()).setEditable(false);
        this.fz.setWrapStyleWord(true);
        this.fz.setLineWrap(true);
        this.fz.setBorder(this.fx.getBorder());
        this.fz.setBackground(this.fx.getBackground());
        this.fz.setFont(this.fx.getFont());
        contentPane.add(this.fz, "4, 16, 3, 1, fill, fill");
        this.setContentPane(contentPane);
        this.getRootPane().registerKeyboardAction(new cj(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.addWindowListener(new ck(this));
    }
    
    private void a(final gQ fb) {
        this.fB = fb;
        final Object dz = fb.dz();
        this.fA = ey.d(dz);
        this.fC = null;
        this.fD = null;
        final String text = (this.fA == null) ? fb.getType() : this.fA.ba().toString();
        this.fn.setText(text);
        this.fo.setIcon((this.fA == null) ? null : this.fA.N(2));
        if (this.fA != null && this.fA.bb()) {
            String text2 = "";
            if (dz instanceof fg) {
                final fg fg = (fg)dz;
                final int index = fg.indexOf(35);
                if (index >= 0) {
                    text2 = fg.substring(index + 1);
                }
            }
            else {
                final String string = dz.toString();
                final int index2 = string.indexOf(35);
                if (index2 >= 0) {
                    text2 = string.substring(index2 + 1);
                }
            }
            this.fs.setText(this.fA.getID());
            this.ft.setText(text2);
            this.fr.setVisible(true);
            this.ft.setVisible(true);
            try {
                this.fC = new Integer(hf.b(text2, 0, 99999));
                this.ft.setEditable(true);
            }
            catch (final RuntimeException ex) {
                hc.warn("Error detected in item id: " + dz);
                this.fC = null;
                this.ft.setEditable(false);
            }
        }
        else {
            this.fs.setText(fb.ei());
            this.ft.setText("");
            this.fr.setVisible(false);
            this.ft.setVisible(false);
        }
        if (text.equals("Technology") && fb.dA() >= 0 && fb.dA() < fb.dB()) {
            this.fu.setText("Charge:");
            this.fD = fb.dA();
            this.fv.setText(Integer.toString(fb.dA()));
            this.fw.setText(Integer.toString(fb.dB()));
            this.fv.setEditable(true);
        }
        else if ((text.equals("Product") || text.equals("Substance")) && fb.dB() > 1) {
            this.fu.setText("Quantity:");
            this.fD = fb.dA();
            this.fv.setText(Integer.toString(fb.dA()));
            this.fw.setText(Integer.toString(fb.dB()));
            this.fv.setEditable(true);
        }
        else {
            this.fu.setText("Quantity:");
            this.fv.setText("1");
            this.fw.setText("1");
            this.fv.setEditable(false);
        }
        this.fq.setText((this.fA == null) ? "[Unknown]" : this.fA.getName());
        this.fp.setText((this.fA == null) ? "[Unknown]" : this.fA.bc().toString());
        this.fx.setText((this.fA == null) ? "" : this.fA.bg());
        String text3 = (String)((this.fA == null) ? "" : this.fA.bk().stream().map(ez -> {
            ey.d(ez.getID());
            final ey ey;
            if (ey != null) {
                return String.valueOf(ey.getName()) + " (x" + ez.bo() + ")";
            }
            else {
                return String.valueOf(ez.getID()) + " (x" + ez.bo() + ")";
            }
        }).collect(Collectors.joining("\n")));
        if (text3.length() == 0) {
            text3 = "N/A";
        }
        this.fy.setText(text3);
        this.fy.setCaretPosition(0);
        this.fz.setText((this.fA == null) ? "" : this.fA.getDescription());
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }
    
    public static void a(final Container parentComponent, final gQ gq) {
        if (cg.fE == null) {
            cg.fE = new cg(JOptionPane.getFrameForComponent(parentComponent));
        }
        cg.fE.a(gq);
    }
}
