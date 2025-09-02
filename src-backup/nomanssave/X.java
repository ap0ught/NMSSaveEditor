package nomanssave;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class X extends JPanel {
   private JComboBox bG;
   private JComboBox bH;
   private G bI;
   private G bJ;
   private G bK;
   private G bL;
   private G bM;
   private JCheckBox bN;
   private cN bO;
   private cN bP;
   private JButton bQ;
   private JButton bR;
   private JButton bS;
   private gj[] bT;

   X(Application var1) {
      GridLayout var2 = new GridLayout(1, 3);
      this.setLayout(var2);
      ba var3 = new ba(aH.cJ, 0);
      this.add(var3);
      this.add(new JPanel());
      this.add(new JPanel());
      this.bG = new JComboBox();
      this.bG.setModel(new Y(this));
      var3.a("Companion", true, this.bG);
      this.bH = new JComboBox();
      this.bH.setModel(new ab(this));
      this.bH.setEnabled(false);
      var3.a("Type", this.bH);
      this.bI = new ac(this);
      var3.a("Name", (JComponent)this.bI);
      this.bJ = new ad(this);
      var3.a("Creature Seed", this.bJ);
      this.bK = new ae(this);
      var3.a("Secondary Seed", (JComponent)this.bK);
      this.bL = new af(this);
      var3.a("Species Seed", (JComponent)this.bL);
      this.bM = new ag(this);
      var3.a("Genus Seed", (JComponent)this.bM);
      this.bN = new JCheckBox("Predator");
      this.bN.setEnabled(false);
      this.bN.addActionListener(new ah(this));
      var3.a(null, this.bN);
      this.bO = new cN(gi.class);
      this.bO.a(var1x -> {
         gj var2x = (gj)this.bG.getSelectedItem();
         if (var2x != null) {
            var2x.ae(var1x);
         }
      });
      var3.a("Biome", this.bO);
      this.bP = new cN(gk.class);
      this.bP.a(var1x -> {
         gj var2x = (gj)this.bG.getSelectedItem();
         if (var2x != null) {
            var2x.af(var1x);
         }
      });
      var3.a("Type", this.bP);
      var3.Y();
      JPanel var4 = new JPanel();
      this.bQ = new JButton("Delete");
      this.bQ.addActionListener(new ai(this, var1));
      var4.add(this.bQ);
      this.bR = new JButton("Export");
      this.bR.addActionListener(new Z(this, var1));
      var4.add(this.bR);
      this.bS = new JButton("Import");
      this.bS.addActionListener(new aa(this, var1));
      var4.add(this.bS);
      var3.a(var4);
   }

   void a(gj[] var1) {
      this.bT = var1;
      if (var1.length == 0) {
         this.bG.setSelectedIndex(-1);
      } else {
         this.bG.setSelectedIndex(0);
      }

      this.bG.updateUI();
   }
}
