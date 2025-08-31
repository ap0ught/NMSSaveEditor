// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JComponent;
import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class em extends JPanel
{
    private final ba it;
    
    em() {
        final GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] { aH.cI, 0, 0 };
        layout.rowHeights = new int[1];
        layout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        layout.rowWeights = new double[] { 1.0 };
        this.setLayout(layout);
        this.it = new ba();
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(this.it, constraints);
    }
    
    void b(final JComponent comp) {
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(comp, constraints);
    }
    
    void k(final String s) {
        this.it.k(s);
    }
    
    void a(final String s, final G g) {
        this.it.a(s, g);
    }
    
    void a(final String s, final JComponent component) {
        this.it.a(s, component);
    }
    
    void a(final String s, final boolean b, final JComponent component) {
        this.it.a(s, b, component);
    }
    
    void a(final JComponent component) {
        this.it.a(component);
    }
    
    void Y() {
        this.it.Y();
    }
}
