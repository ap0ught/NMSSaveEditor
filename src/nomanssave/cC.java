// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cC implements ActionListener
{
    final /* synthetic */ cy gg;
    
    cC(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String trim = this.gg.fX.getText().trim();
        try {
            this.gg.fZ.setText(trim);
            ((cI)this.gg.fV.getModel()).a(this.gg.fZ);
            this.gg.fV.setSelectionRow(0);
            this.gg.fV.setVisible(true);
            this.gg.fU.setVisible(false);
        }
        catch (final eX ex) {
            JOptionPane.showOptionDialog(this.gg, "Error on line #" + ex.getLineNumber() + ": " + ex.getMessage(), "Error", 0, 0, null, new Object[] { "Cancel" }, null);
            this.gg.fX.setCaretPosition(ex.bD());
            this.gg.fX.requestFocus();
        }
    }
}
