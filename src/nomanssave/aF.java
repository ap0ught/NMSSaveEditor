// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aF implements ActionListener
{
    final /* synthetic */ aD cB;
    
    aF(final aD cb) {
        this.cB = cb;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final aI ai = Stream.of(aI.values()).filter(ai3 -> {
            aH.getProperty("LookAndFeel");
            return ai3.name().equalsIgnoreCase(anotherString);
        }).findFirst().orElse(aI.cN);
        final aI ai2 = (aI)this.cB.cw.getSelectedItem();
        aD.a(this.cB, false);
        if (ai2 == null) {
            if (ai != null) {
                aH.setProperty("LookAndFeel", null);
                aD.a(this.cB, true);
            }
        }
        else if (ai == null || ai != ai2) {
            aH.setProperty("LookAndFeel", ai2.name());
            aD.a(this.cB, true);
        }
        final double double1 = Double.parseDouble(this.cB.cx.getText());
        if (double1 != aH.a("InventoryScaling", 1.0)) {
            aH.b("InventoryScaling", double1);
            aD.a(this.cB, true);
        }
        this.cB.setVisible(false);
    }
}
