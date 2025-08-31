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
import java.awt.Dimension;
import javax.swing.JDialog;

public class aQ extends JDialog
{
    private Dimension dk;
    private Dimension dl;
    private Dimension dm;
    private Dimension dn;
    private JTextField do;
    private JTextField dp;
    private static aQ dq;
    
    private aQ(final Frame owner) {
        super(owner);
        this.dn = null;
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Expand Inventory");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel comp = new JPanel();
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        comp.add(new JLabel("Width:"), "2, 2, left, center");
        (this.do = new JTextField()).addFocusListener(new aR(this));
        comp.add(this.do, "4, 2, fill, default");
        comp.add(new JLabel("Height:"), "2, 4, left, center");
        (this.dp = new JTextField()).addFocusListener(new aS(this));
        comp.add(this.dp, "4, 4, fill, default");
        contentPane.add(comp);
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FlowLayout(2));
        contentPane.add(comp2, "South");
        final JButton button = new JButton("Save");
        button.addActionListener(new aT(this));
        comp2.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp3 = new JButton("Cancel");
        comp3.addActionListener(new aU(this));
        comp2.add(comp3);
        this.getRootPane().registerKeyboardAction(new aV(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    private Dimension a(final Dimension dk, final Dimension dl, final Dimension dm) {
        this.dk = dk;
        this.dl = dl;
        this.dm = dm;
        this.do.setText(Integer.toString(dk.width));
        this.dp.setText(Integer.toString(dk.height));
        this.dn = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.dn;
    }
    
    public static Dimension a(final Container parentComponent, final Dimension dimension, final Dimension dimension2, final Dimension dimension3) {
        if (aQ.dq == null) {
            aQ.dq = new aQ(JOptionPane.getFrameForComponent(parentComponent));
        }
        return aQ.dq.a(dimension, dimension2, dimension3);
    }
}
