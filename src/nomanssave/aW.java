// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JDialog;

public class aW extends JDialog
{
    private JTextField ds;
    private JCheckBox dt;
    private JCheckBox du;
    private JRadioButton dv;
    private JRadioButton dw;
    private static aW dx;
    
    private aW(final cy owner) {
        super(owner);
        this.setSize(400, 250);
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Find");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel comp = new JPanel();
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        comp.add(new JLabel("Find:"), "2, 2, left, center");
        comp.add(this.ds = new JTextField(), "4, 2, fill, default");
        contentPane.add(comp);
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new GridLayout(1, 2));
        comp2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Direction"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        (this.dv = new JRadioButton("Forward")).setSelected(true);
        comp2.add(this.dv);
        comp2.add(this.dw = new JRadioButton("Backward"));
        final ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.dv);
        buttonGroup.add(this.dw);
        comp.add(comp2, "2, 4, 3, 1");
        final JPanel comp3 = new JPanel();
        comp3.setLayout(new GridLayout(1, 2));
        comp3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Options"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        (this.dt = new JCheckBox("Case Sensitive")).setSelected(true);
        comp3.add(this.dt);
        comp3.add(this.du = new JCheckBox("Wrap Search"));
        comp.add(comp3, "2, 6, 3, 1");
        final JPanel comp4 = new JPanel();
        comp4.setLayout(new FlowLayout(2));
        contentPane.add(comp4, "South");
        final JButton button = new JButton("Find");
        button.setMnemonic(10);
        button.addActionListener(new aX(this, owner));
        comp4.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp5 = new JButton("Cancel");
        comp5.setMnemonic(27);
        comp5.addActionListener(new aY(this));
        comp4.add(comp5);
        this.getRootPane().registerKeyboardAction(new aZ(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    public static void a(final cy locationRelativeTo, final String text) {
        if (aW.dx == null) {
            aW.dx = new aW(locationRelativeTo);
        }
        aW.dx.setLocationRelativeTo(locationRelativeTo);
        if (text != null) {
            aW.dx.ds.setText(text);
        }
        aW.dx.ds.setSelectionStart(0);
        aW.dx.ds.setSelectionEnd(aW.dx.ds.getText().length());
        aW.dx.ds.requestFocus();
        aW.dx.setVisible(true);
    }
}
