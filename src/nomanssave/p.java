// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import java.util.Collections;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.List;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JDialog;

public class p extends JDialog
{
    private final JTable D;
    private final TableRowSorter E;
    private List F;
    private List G;
    private static p H;
    
    static {
        p.H = null;
    }
    
    private p(final Frame owner) {
        super(owner);
        this.G = null;
        this.setSize(aH.cI * 2, aH.cI + aH.cH);
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JScrollPane comp = new JScrollPane();
        (this.D = new JTable()).setSelectionMode(2);
        this.D.setModel(new q(this));
        this.D.getColumnModel().getColumn(0).setMaxWidth(24);
        (this.E = new TableRowSorter((M)this.D.getModel())).setSortable(0, false);
        this.D.setRowSorter(this.E);
        comp.setViewportView(this.D);
        contentPane.add(comp);
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FlowLayout(2));
        contentPane.add(comp2, "South");
        final JButton button = new JButton("Add");
        button.addActionListener(new r(this));
        comp2.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp3 = new JButton("Cancel");
        comp3.addActionListener(new s(this));
        comp2.add(comp3);
        this.getRootPane().registerKeyboardAction(new t(this), KeyStroke.getKeyStroke(27, 0), 2);
    }
    
    private String[] d() {
        this.D.clearSelection();
        this.E.setSortKeys(Collections.emptyList());
        this.E.sort();
        this.D.updateUI();
        this.G = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return (this.G == null) ? new String[0] : this.G.toArray(new String[0]);
    }
    
    public static String[] b(final Container parentComponent) {
        if (p.H == null) {
            p.H = new p(JOptionPane.getFrameForComponent(parentComponent));
        }
        p.H.F = ey.bl();
        p.H.setTitle("Add Known Technologies");
        return p.H.d();
    }
    
    public static String[] c(final Container parentComponent) {
        if (p.H == null) {
            p.H = new p(JOptionPane.getFrameForComponent(parentComponent));
        }
        p.H.F = ey.bm();
        p.H.setTitle("Add Known Products");
        return p.H.d();
    }
}
