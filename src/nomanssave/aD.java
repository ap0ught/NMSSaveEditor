// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import java.util.stream.Stream;
import java.awt.Container;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class aD extends JDialog
{
    private JComboBox cw;
    private JTextField cx;
    private boolean cy;
    public static aD cz;
    
    static {
        aD.cz = null;
    }
    
    private aD(final Frame owner) {
        super(owner);
        this.setMinimumSize(new Dimension(400, 10));
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Editor Settings");
        this.setModal(true);
        final ba contentPane = new ba();
        (this.cw = new JComboBox()).setModel(new aE(this));
        contentPane.a("Look & Feel", this.cw);
        contentPane.a("Inventory Scale", this.cx = new JTextField());
        contentPane.Y();
        final JPanel panel = new JPanel();
        contentPane.a(panel);
        final JButton comp = new JButton("Apply");
        comp.addActionListener(new aF(this));
        panel.add(comp);
        final JButton comp2 = new JButton("Cancel");
        comp2.addActionListener(new aG(this));
        panel.add(comp2);
        this.setContentPane(contentPane);
        this.pack();
    }
    
    private boolean S() {
        this.cw.setSelectedItem(Stream.of(aI.values()).filter(ai -> {
            aH.getProperty("LookAndFeel");
            return ai.name().equalsIgnoreCase(anotherString);
        }).findFirst().orElse(aI.cN));
        this.cx.setText(Double.toString(aH.a("InventoryScaling", 1.0)));
        this.setLocationRelativeTo(this.getParent());
        this.cy = false;
        this.setVisible(true);
        return this.cy;
    }
    
    public static boolean d(final Container parentComponent) {
        if (aD.cz == null) {
            aD.cz = new aD(JOptionPane.getFrameForComponent(parentComponent));
        }
        return aD.cz.S();
    }
}
