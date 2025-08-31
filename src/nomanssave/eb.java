// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;

public class eb extends em
{
    private ec[] ib;
    private gM[] ic;
    private static final gy[] ie;
    
    static {
        ie = new gy[] { gy.qR, gy.qS, gy.qT };
    }
    
    eb(final Application application) {
        final GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] { aH.cI, aH.cI, aH.cI, aH.cI, 0 };
        layout.rowHeights = new int[3];
        layout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        layout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        this.setLayout(layout);
        this.ic = new gM[0];
        this.ib = new ec[0];
    }
    
    void a(final gM[] ic) {
        this.ic = ic;
        for (int i = ic.length; i < this.ib.length; ++i) {
            this.remove(this.ib[i]);
        }
        int n;
        if (ic.length <= 4) {
            n = 2;
        }
        else if (ic.length <= 6) {
            n = 3;
        }
        else {
            n = 4;
        }
        final ec[] ib = new ec[ic.length];
        System.arraycopy(this.ib, 0, ib, 0, Math.min(ic.length, this.ib.length));
        for (int j = this.ib.length; j < ic.length; ++j) {
            ib[j] = new ec(this, j);
            final GridBagConstraints constraints = new GridBagConstraints();
            constraints.insets = new Insets(10, 10, 0, 0);
            constraints.fill = 2;
            constraints.anchor = 11;
            constraints.gridx = j % n;
            constraints.gridy = j / n;
            this.add(ib[j], constraints);
        }
        this.ib = ib;
        for (int k = 0; k < ic.length; ++k) {
            this.ib[k].aQ();
        }
        this.updateUI();
    }
}
