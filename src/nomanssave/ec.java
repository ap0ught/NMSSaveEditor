// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

class ec extends ba
{
    private final int index;
    private JCheckBox if;
    private JComboBox ig;
    private G bj;
    private JComboBox ih;
    private G hO;
    private G ii;
    final /* synthetic */ eb ij;
    
    ec(final eb ij, final int index) {
        this.ij = ij;
        super(new int[] { aH.cH, aH.cH * 2 });
        this.index = index;
        this.k("Wingman " + (index + 1));
        (this.if = new JCheckBox("Enabled")).addActionListener(new ed(this, index));
        this.a(null, this.if);
        this.setBorder(new LineBorder(Color.DARK_GRAY));
        (this.ig = new JComboBox()).setModel(new ee(this, index));
        this.a("NPC Race", this.ig);
        this.a("NPC Seed", this.bj = new ef(this, index));
        (this.ih = new JComboBox()).setModel(new eg(this, index));
        this.a("Ship Type", this.ih);
        this.a("Ship Seed", this.hO = new eh(this, index));
        this.a("Pilot Rank", (JComponent)(this.ii = new ei(this, index)));
    }
    
    private void aQ() {
        this.if.setSelected(this.ij.ic[this.index].isEnabled());
        this.ig.setEnabled(this.ij.ic[this.index].isEnabled());
        this.ig.setSelectedItem(this.ij.ic[this.index].ed());
        this.bj.setEnabled(this.ij.ic[this.index].isEnabled());
        this.bj.setText(this.ij.ic[this.index].ee());
        this.ih.setEnabled(this.ij.ic[this.index].isEnabled());
        this.ih.setSelectedItem(this.ij.ic[this.index].ef());
        this.hO.setEnabled(this.ij.ic[this.index].isEnabled());
        this.hO.setText(this.ij.ic[this.index].eg());
        this.ii.setEnabled(this.ij.ic[this.index].isEnabled());
        this.ii.setText(Integer.toString(this.ij.ic[this.index].eh()));
    }
}
