// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JList;
import javax.swing.JDialog;

public class dz extends JDialog
{
    private final JList hr;
    private ft[] hs;
    private int gU;
    private static dz ht;
    
    static {
        dz.ht = null;
    }
    
    private dz(final Frame owner) {
        super(owner);
        this.setSize(300, 400);
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Save File As");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JScrollPane comp = new JScrollPane();
        (this.hr = new JList()).setSelectionMode(0);
        this.hr.setModel(new dA(this));
        comp.setViewportView(this.hr);
        contentPane.add(comp);
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FlowLayout(2));
        contentPane.add(comp2, "South");
        final JButton button = new JButton("Replace/Save");
        button.addActionListener(new dB(this));
        comp2.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp3 = new JButton("Cancel");
        comp3.addActionListener(new dC(this));
        comp2.add(comp3);
        this.getRootPane().registerKeyboardAction(new dD(this), KeyStroke.getKeyStroke(27, 0), 2);
    }
    
    private int a(final ft[] hs, final int selectedIndex) {
        this.hs = hs;
        this.hr.updateUI();
        this.hr.setSelectedIndex(selectedIndex);
        this.gU = -1;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.gU;
    }
    
    public static int a(final Container parentComponent, final ft[] array, final int n) {
        if (dz.ht == null) {
            dz.ht = new dz(JOptionPane.getFrameForComponent(parentComponent));
        }
        return dz.ht.a(array, n);
    }
}
