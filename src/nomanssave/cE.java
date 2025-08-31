// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class cE extends WindowAdapter
{
    final /* synthetic */ cy gg;
    
    cE(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        boolean b = true;
        if (this.gg.ga && this.gg.fZ != null) {
            try {
                final String trim = this.gg.fX.getText().trim();
                if (trim.length() == 0 && JOptionPane.showConfirmDialog(this.gg, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.gg.getTitle(), 0) == 0) {
                    this.gg.fZ.remove();
                }
                else if (JOptionPane.showConfirmDialog(this.gg, "The JSON data has changed, do you wish to apply these changes to the save file?", this.gg.getTitle(), 0) == 0) {
                    this.gg.fZ.setText(trim);
                }
            }
            catch (final eX ex) {
                JOptionPane.showOptionDialog(this.gg, "Error on line #" + ex.getLineNumber() + ": " + ex.getMessage(), "Error", 0, 0, null, new Object[] { "Cancel" }, null);
                this.gg.fX.setCaretPosition(ex.bD());
                this.gg.fX.requestFocus();
                b = false;
            }
        }
        if (b) {
            this.gg.setVisible(false);
        }
    }
}
