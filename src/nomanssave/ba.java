// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.Icon;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.LayoutManager;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JPanel;

public class ba extends JPanel
{
    private final FormLayout dA;
    
    ba() {
        this(new int[] { aH.cH, 0 });
    }
    
    ba(final int... array) {
        this.dA = new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC });
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > 0) {
                this.dA.appendColumn(ColumnSpec.decode(String.valueOf(array[i]) + "px"));
            }
            else {
                this.dA.appendColumn(ColumnSpec.decode("default:grow"));
            }
            this.dA.appendColumn(FormFactory.LABEL_COMPONENT_GAP_COLSPEC);
        }
        this.setLayout(this.dA);
    }
    
    void k(final String s) {
        this.a(s, (ImageIcon)null);
    }
    
    void a(final String text, final ImageIcon image) {
        if (this.dA.getRowCount() == 1) {
            this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
            this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        }
        else {
            final int rowCount = this.dA.getRowCount();
            this.dA.insertRow(rowCount, FormFactory.DEFAULT_ROWSPEC);
            this.dA.insertRow(rowCount, RowSpec.decode("bottom:25px"));
        }
        final int n = this.dA.getColumnCount() - 2;
        final JLabel label = new JLabel(text);
        label.putClientProperty("FlatLaf.styleClass", "semibold");
        if (image == null) {
            this.add(label, "2, " + (this.dA.getRowCount() - 1) + ", " + n + ", 1, left, default");
        }
        else {
            final JPanel comp = new JPanel();
            comp.setLayout(new FlowLayout(0, 0, 0));
            comp.add(new JLabel(image));
            comp.add(label);
            this.add(comp, "2, " + (this.dA.getRowCount() - 1) + ", " + n + ", 1, left, default");
        }
    }
    
    void addText(final String text) {
        if (this.dA.getRowCount() == 1) {
            this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
            this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        }
        else {
            final int rowCount = this.dA.getRowCount();
            this.dA.insertRow(rowCount, FormFactory.DEFAULT_ROWSPEC);
            this.dA.insertRow(rowCount, RowSpec.decode("bottom:25px"));
        }
        this.add(new JLabel(text), "2, " + (this.dA.getRowCount() - 1) + ", " + (this.dA.getColumnCount() - 2) + ", 1, left, default");
    }
    
    void Y() {
        this.dA.appendRow(RowSpec.decode("bottom:10px"));
        this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
    }
    
    void a(final String s, final JComponent component) {
        this.a(s, false, component, 1);
    }
    
    void a(final String s, final JComponent component, final int n) {
        this.a(s, false, component, n);
    }
    
    void a(final String s, final boolean b, final JComponent component) {
        this.a(s, b, component, 1);
    }
    
    void a(final String obj, final boolean b, final JComponent comp, int i) {
        i = i * 2 - 1;
        this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
        this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        final int n = this.dA.getRowCount() - 1;
        if (obj != null) {
            final JLabel comp2 = new JLabel(String.valueOf(obj) + ":");
            if (b) {
                comp2.putClientProperty("FlatLaf.styleClass", "semibold");
            }
            this.add(comp2, "2, " + n + ", left, default");
        }
        this.add(comp, "4, " + n + ", " + i + ", 1, fill, default");
    }
    
    void a(final String s, final G comp) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        final JPanel comp2 = new JPanel();
        comp2.setLayout(new FlowLayout(2, 0, 0));
        final JButton comp3 = new JButton("Generate");
        comp3.setEnabled(comp.isEnabled());
        comp3.addActionListener(new bb(this, comp));
        comp.addPropertyChangeListener("enabled", new bc(this, comp3, comp));
        comp2.add(comp3);
        panel.add(comp, "Center");
        panel.add(comp2, "South");
        this.a(s, panel);
    }
    
    void a(final JComponent comp) {
        this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
        this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        this.add(comp, "2, " + (this.dA.getRowCount() - 1) + ", " + (this.dA.getColumnCount() - 2) + ", 1, fill, default");
    }
}
