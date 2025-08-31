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
import java.awt.event.MouseListener;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.List;
import javax.swing.JList;
import javax.swing.JDialog;

public class dd extends JDialog
{
    private final JList gS;
    private List gT;
    private int gU;
    private static dd gV;
    
    static {
        dd.gV = null;
    }
    
    private dd(final Frame owner) {
        super(owner);
        this.setSize(300, 300);
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Move Item");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JScrollPane comp = new JScrollPane();
        (this.gS = new JList()).setSelectionMode(0);
        this.gS.setModel(new de(this));
        this.gS.addMouseListener(new df(this));
        comp.setViewportView(this.gS);
        contentPane.add(comp);
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FlowLayout(2));
        contentPane.add(comp2, "South");
        final JButton button = new JButton("Move");
        button.addActionListener(new dg(this));
        comp2.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp3 = new JButton("Cancel");
        comp3.addActionListener(new dh(this));
        comp2.add(comp3);
        this.getRootPane().registerKeyboardAction(new di(this), KeyStroke.getKeyStroke(27, 0), 2);
    }
    
    private int a(final List gt, final int gu) {
        this.gT = gt;
        this.gS.updateUI();
        this.gS.setSelectedIndex(this.gU);
        this.gU = gu;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.gU;
    }
    
    public static int a(final Container parentComponent, final List list, final int n) {
        if (dd.gV == null) {
            dd.gV = new dd(JOptionPane.getFrameForComponent(parentComponent));
        }
        return dd.gV.a(list, n);
    }
}
