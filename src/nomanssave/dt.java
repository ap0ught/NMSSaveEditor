// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.awt.Container;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.EventQueue;
import javax.swing.JComponent;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class dt extends ba
{
    private final Application eR;
    private final JPanel eS;
    
    dt(final Application er) {
        super(new int[] { aH.cJ, 0 });
        this.eR = er;
        this.k("Production");
        (this.eS = new JPanel()).setLayout(new GridBagLayout());
        this.a(this.eS);
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                EventQueue.invokeLater(this::aL);
            }
        });
    }
    
    private void aL() {
        synchronized (this.eS.getTreeLock()) {
            Component[] components;
            for (int length = (components = this.eS.getComponents()).length, i = 0; i < length; ++i) {
                ((du)components[i]).aM();
            }
            monitorexit(this.eS.getTreeLock());
        }
        this.eS.revalidate();
        this.eS.updateUI();
    }
    
    public void a(final gF[] array) {
        synchronized (this.eS.getTreeLock()) {
            this.eS.removeAll();
            for (int i = 0; i < array.length; ++i) {
                final du comp = new du(this, array[i], null);
                final GridBagConstraints constraints = new GridBagConstraints();
                constraints.fill = 1;
                constraints.insets = new Insets(10, 10, 10, 10);
                constraints.gridx = i % 3;
                constraints.gridy = i / 3;
                this.eS.add(comp, constraints);
            }
            monitorexit(this.eS.getTreeLock());
        }
        this.eS.revalidate();
        this.eS.updateUI();
    }
    
    private void a(final du du) {
        final ey a = h.a(this, 28160);
        if (a != null) {
            du.hm.m(a.aZ());
            du.hm.aA(0);
            du.aM();
        }
    }
    
    private void b(final du du) {
        if (ey.d(du.hm.dz()) == null) {
            this.eR.c("Item details not found!");
            return;
        }
        final List g = this.eR.g(3584);
        final int a = dd.a(this, g, -1);
        if (a != -1) {
            final gt gt = g.get(a);
            du.hm.aA(gt.a(ey.d(du.hm.dz()), du.hm.dA()));
            du.aM();
            this.eR.a(gt);
        }
    }
}
