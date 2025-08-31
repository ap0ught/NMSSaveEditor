// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.util.Collections;
import java.awt.Frame;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class cY extends JDialog
{
    private JComboBox gM;
    private List gN;
    private int gO;
    private static cY gP;
    
    static {
        cY.gP = null;
    }
    
    private cY(final Frame owner) {
        super(owner);
        this.gN = Collections.emptyList();
        this.gO = -1;
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Move Base Computer");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel comp = new JPanel();
        comp.setLayout(new FlowLayout(0));
        comp.add(new JLabel("Please select a base part to swap your base computer with."));
        contentPane.add(comp, "North");
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        comp2.add(new JLabel("Base Part:"), "2, 2, left, center");
        (this.gM = new JComboBox()).setModel(new cZ(this));
        comp2.add(this.gM, "4, 2, fill, default");
        contentPane.add(comp2, "Center");
        final JPanel comp3 = new JPanel();
        comp3.setLayout(new FlowLayout(2));
        contentPane.add(comp3, "South");
        final JButton button = new JButton("Save");
        button.addActionListener(new da(this));
        comp3.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp4 = new JButton("Cancel");
        comp4.addActionListener(new db(this));
        comp3.add(comp4);
        this.getRootPane().registerKeyboardAction(new dc(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    private int b(final List gn) {
        this.gN = gn;
        this.setLocationRelativeTo(this.getParent());
        this.gM.setSelectedIndex(0);
        this.gM.updateUI();
        this.gO = -1;
        this.setVisible(true);
        return this.gO;
    }
    
    public static int a(final Container parentComponent, final List list) {
        if (cY.gP == null) {
            cY.gP = new cY(JOptionPane.getFrameForComponent(parentComponent));
        }
        return cY.gP.b(list);
    }
}
