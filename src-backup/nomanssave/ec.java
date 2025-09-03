package nomanssave;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

class ec extends ba {
   private final int index;
   private JCheckBox ifField;
   private JComboBox ig;
   private G bj;
   private JComboBox ih;
   private G hO;
   private G ii;

   ec(eb var1, int var2) {
      super(aH.cH, aH.cH * 2);
      this.ij = var1;
      this.index = var2;
      this.k("Wingman " + (var2 + 1));
      this.ifField = new JCheckBox("Enabled");
      this.ifField.addActionListener(new ed(this, var2));
      this.a(null, this.ifField);
      this.setBorder(new LineBorder(Color.DARK_GRAY));
      this.ig = new JComboBox();
      this.ig.setModel(new ee(this, var2));
      this.a("NPC Race", this.ig);
      this.bj = new ef(this, var2);
      this.a("NPC Seed", this.bj);
      this.ih = new JComboBox();
      this.ih.setModel(new eg(this, var2));
      this.a("Ship Type", this.ih);
      this.hO = new eh(this, var2);
      this.a("Ship Seed", this.hO);
      this.ii = new ei(this, var2);
      this.a("Pilot Rank", (JComponent)this.ii);
   }

   private void aQ() {
      this.ifField.setSelected(eb.a(this.ij)[this.index].isEnabled());
      this.ig.setEnabled(eb.a(this.ij)[this.index].isEnabled());
      this.ig.setSelectedItem(eb.a(this.ij)[this.index].ed());
      this.bj.setEnabled(eb.a(this.ij)[this.index].isEnabled());
      this.bj.setText(eb.a(this.ij)[this.index].ee());
      this.ih.setEnabled(eb.a(this.ij)[this.index].isEnabled());
      this.ih.setSelectedItem(eb.a(this.ij)[this.index].ef());
      this.hO.setEnabled(eb.a(this.ij)[this.index].isEnabled());
      this.hO.setText(eb.a(this.ij)[this.index].eg());
      this.ii.setEnabled(eb.a(this.ij)[this.index].isEnabled());
      this.ii.setText(Integer.toString(eb.a(this.ij)[this.index].eh()));
   }
}
