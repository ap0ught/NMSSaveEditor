// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.FocusListener;
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
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.JDialog;

public class Q extends JDialog
{
    private W bw;
    private int bx;
    private int by;
    private W bz;
    private JTextField bA;
    private JTextField bB;
    private static Q bC;
    
    private Q(final Frame owner) {
        super(owner);
        this.bz = null;
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Change Stack Sizes");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel comp = new JPanel();
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20dlu"), FormFactory.LINE_GAP_ROWSPEC }));
        comp.add(new JLabel("Substances:"), "2, 2, left, center");
        (this.bA = new JTextField()).addFocusListener(new R(this));
        comp.add(this.bA, "4, 2, fill, default");
        comp.add(new JLabel("Products:"), "2, 4, left, center");
        (this.bB = new JTextField()).addFocusListener(new S(this));
        comp.add(this.bB, "4, 4, fill, default");
        comp.add(new JLabel("<html><font color=\"red\"><b>Please Note: No Man's Sky sometimes reverts these settings back to default.</b></font></html>"), "2, 6, 3, 1, fill, center");
        contentPane.add(comp);
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FlowLayout(2));
        contentPane.add(comp2, "South");
        final JButton button = new JButton("Save");
        button.addActionListener(new T(this));
        comp2.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp3 = new JButton("Cancel");
        comp3.addActionListener(new U(this));
        comp2.add(comp3);
        this.getRootPane().registerKeyboardAction(new V(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    private W a(final W bw, final int bx, final int by) {
        this.bw = bw;
        this.bx = bx;
        this.by = by;
        this.bA.setText(Integer.toString(bw.bE));
        this.bB.setText(Integer.toString(bw.bF));
        this.bz = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.bz;
    }
    
    public static W a(final Container parentComponent, final W w, final int n, final int n2) {
        if (Q.bC == null) {
            Q.bC = new Q(JOptionPane.getFrameForComponent(parentComponent));
        }
        return Q.bC.a(w, n, n2);
    }
}
